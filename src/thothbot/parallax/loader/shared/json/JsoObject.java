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

package thothbot.parallax.loader.shared.json;

import java.util.List;

public interface JsoObject 
{
	JsoMetadata getMetadata();
	
	int getInfluencesPerVertex();
	double getScale();
	
	List<JsoMaterial> getMaterials();
	
	List<Double> getVertices();
	
	List<JsoMorphTargets> getMorphTargets();
	
	List<JsoMorphColors> getMorphColors();
	
	List<Double> getNormals();
	
	/**
	 * Hex color values
	 */
	List<Integer> getColors();
	
	List<List<Double>> getUvs();
	
	List<Integer> getFaces();
	
	List<Double> getSkinWeights();
	
	List<Integer> getSkinIndices();

}
