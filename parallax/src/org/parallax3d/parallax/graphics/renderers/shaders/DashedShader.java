/*
 * Copyright 2012 Alex Usachev, thothbot@gmail.com
 * 
 * This file is part of Parallax project.
 * 
 * Parallax is free software: you can redistribute it and/or modify it 
 * under the terms of the Creative Commons Attribution 3.0 Unported License.
 * 
 * Parallax is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE. See the Creative Commons Attribution 
 * 3.0 Unported License. for more details.
 * 
 * You should have received a copy of the the Creative Commons Attribution 
 * 3.0 Unported License along with Parallax. 
 * If not, see http://creativecommons.org/licenses/by/3.0/.
 */

package org.parallax3d.parallax.graphics.renderers.shaders;

import java.util.Arrays;
import java.util.List;

import org.parallax3d.parallax.system.ClassUtils;
import org.parallax3d.parallax.system.SourceTextResource;

public class DashedShader extends Shader 
{

	interface Resources extends DefaultResources
	{
		Resources INSTANCE = ClassUtils.newProxyInstance(Resources.class);

		@Source("source/dashed.vs.glsl")
		SourceTextResource getVertexShader();

		@Source("source/dashed.fs.glsl")
		SourceTextResource getFragmentShader();
	}

	public DashedShader()
	{
		super(Resources.INSTANCE);
	}

	@Override
	protected void initUniforms()
	{
		this.setUniforms(UniformsLib.getCommon());
		this.setUniforms(UniformsLib.getFog());
		this.addUniform("scale",     new Uniform(Uniform.TYPE.F, 1.0f ));
		this.addUniform("dashSize",  new Uniform(Uniform.TYPE.F, 1.0f ));
		this.addUniform("totalSize", new Uniform(Uniform.TYPE.F, 2.0f ));
	}
	
	@Override
	protected void updateVertexSource(String src)
	{
		List<String> vars = Arrays.asList(
			ChunksVertexShader.COLOR_PARS,
			ChunksVertexShader.LOGDEPTHBUF_PAR
		);
		
		List<String> main1 = Arrays.asList(
			ChunksVertexShader.COLOR
		);
		
		List<String> main2 = Arrays.asList(
			ChunksVertexShader.LOGDEPTHBUF
		);
		
		super.updateVertexSource(Shader.updateShaderSource(src, vars, main1, main2));	
	}
	
	@Override
	protected void updateFragmentSource(String src)
	{
		List<String> vars = Arrays.asList(
			ChunksFragmentShader.COLOR_PARS,
			ChunksFragmentShader.FOG_PARS,
			ChunksFragmentShader.LOGDEPTHBUF_PAR
		);
			
		List<String> main = Arrays.asList(
			ChunksFragmentShader.LOGDEPTHBUF,
			ChunksFragmentShader.COLOR,
			ChunksFragmentShader.FOG
		);
			
		super.updateFragmentSource(Shader.updateShaderSource(src, vars, main));	
	}
}
