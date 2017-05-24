package edu.uade.sam.service;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;


public interface CalculatorService {

	void performAnova(SummaryStatistics... s);

}
