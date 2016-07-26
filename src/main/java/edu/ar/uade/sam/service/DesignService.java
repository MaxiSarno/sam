package edu.ar.uade.sam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.ar.uade.sam.model.TestDesign;

//@Service
public interface DesignService {
	
	/**
	 * @param testId
	 * @param personnel
	 * @param samples
	 * @return
	 */
	public TestDesign createTestDesign(Integer testId, int personnel, List<String> samples);

}
