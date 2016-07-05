package edu.ar.uade.sam.service;

import java.util.List;

import edu.ar.uade.sam.model.TestDesign;

public interface DesignService {
	
	/**
	 * @param testId
	 * @param personnel
	 * @param samples
	 * @return
	 */
	public TestDesign createTestDesign(Integer testId, int personnel, List<String> samples);

}
