package edu.uade.sam.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import edu.uade.sam.model.Distribution;
import edu.uade.sam.model.NumericAttribute;
import edu.uade.sam.model.Result;
import edu.uade.sam.service.impl.ResultsServiceImpl;

public class ResultsServiceTest {

	private ResultsServiceImpl resultsService;
	private AttributesService attributesService;
	
	@Before
	public void init() {
		resultsService = new ResultsServiceImpl();
		attributesService = Mockito.mock(AttributesService.class);
		
		resultsService.setAttributesService(attributesService);
	}
	
	@Test
	public void chooseDistribution_oneSample() {
		Map<String, double[]> groups = new HashMap<String, double[]>();
		groups.put("one", new double[]{1,2,3});
		
		Distribution d = resultsService.chooseDistribution(groups);
		
		Assert.assertEquals("selected distribution does not match", Distribution.ANOVA, d);
	}
	
	@Test
	public void chooseDistribution_twoSample() {
		Map<String, double[]> groups = new HashMap<String, double[]>();
		groups.put("one", new double[]{1,2,3});
		groups.put("two", new double[]{1,2,3});
		
		Distribution d = resultsService.chooseDistribution(groups);
		
		Assert.assertEquals("selected distribution does not match", Distribution.STUDENT_T, d);
	}
	
	@Test
	public void chooseDistribution_threeSample() {
		Map<String, double[]> groups = new HashMap<String, double[]>();
		groups.put("one", new double[]{1,2,3});
		groups.put("two", new double[]{1,2,3});
		groups.put("three", new double[]{1,2,3});
		
		Distribution d = resultsService.chooseDistribution(groups);
		
		Assert.assertEquals("selected distribution does not match", Distribution.ANOVA, d);
	}
	
	@Test
	public void generate_anovaThreeGroups_ok() {
		List<NumericAttribute> value = new ArrayList<>();
		
		Mockito.when(attributesService.get(Mockito.anyInt())).thenReturn(value);
		
		Result r = resultsService.generate(1, 0.05f);
	}
	
	@Test
	public void generate_nivelDeAgradoDosProductos_ok() {
		Result result = resultsService.generate(1, 0.05f);
		Assert.assertNotNull(result);
	}
	
	

}
