package edu.uade.sam.service;

import java.util.Collection;

import edu.uade.sam.model.Result;


public interface CalculatorService {

	Result performOneWayAnova(Collection<double[]> data);

}
