package edu.uade.sam.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.uade.sam.model.NumericAttribute;
import edu.uade.sam.model.Result;
import edu.uade.sam.model.SensoryEvaluation;
import edu.uade.sam.service.impl.ResultsServiceImpl;

/**
 * @author msarno
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ResultsServiceTest {

	@Autowired
	private ResultsServiceImpl resultsService;
	private AttributesService attributesService;
	
	private static List<NumericAttribute> GROUP1, GROUP2, GROUP3;
	
	@BeforeClass
	public static void init() {
		NumericAttribute a11 = new NumericAttribute(1,"p1", "a1", 2);
		NumericAttribute a12 = new NumericAttribute(1,"p1", "a1", 2);
		NumericAttribute a13 = new NumericAttribute(1,"p2", "a1", 3);
		NumericAttribute a14 = new NumericAttribute(1,"p2", "a1", 3);
		NumericAttribute a15 = new NumericAttribute(1,"p3", "a1", 4);
		NumericAttribute a16 = new NumericAttribute(1,"p3", "a1", 4);
		GROUP1 = Arrays.asList(a11, a12, a13, a14, a15, a16);

		NumericAttribute a21 = new NumericAttribute(1,"p1", "a2", 2);
		NumericAttribute a22 = new NumericAttribute(1,"p1", "a2", 2);
		NumericAttribute a23 = new NumericAttribute(1,"p2", "a2", 3);
		NumericAttribute a24 = new NumericAttribute(1,"p2", "a2", 3);
		NumericAttribute a25 = new NumericAttribute(1,"p3", "a2", 4);
		NumericAttribute a26 = new NumericAttribute(1,"p3", "a2", 4);
		GROUP2 = Arrays.asList(a21, a22, a23, a24, a25, a26);

		NumericAttribute a31 = new NumericAttribute(1,"p1", "a3", 2);
		NumericAttribute a32 = new NumericAttribute(1,"p1", "a3", 2);
		NumericAttribute a33 = new NumericAttribute(1,"p2", "a3", 3);
		NumericAttribute a34 = new NumericAttribute(1,"p2", "a3", 3);
		NumericAttribute a35 = new NumericAttribute(1,"p3", "a3", 4);
		NumericAttribute a36 = new NumericAttribute(1,"p3", "a3", 4);
		GROUP3 = Arrays.asList(a31, a32, a33, a34, a35, a36);
		
	}

	@Before
	public void initTest() {
		attributesService = Mockito.mock(AttributesService.class);
		resultsService.setAttributesService(attributesService);
		
		SensoryEvaluationService sensoryEvaluationService = Mockito.mock(SensoryEvaluationService.class);
		Mockito.when(sensoryEvaluationService.get(Mockito.anyLong())).thenReturn(new SensoryEvaluation());
	}

	@Test
	public void generate_oneGroup_ok() {
		Mockito.when(attributesService.get(Mockito.anyInt())).thenReturn(GROUP1);
		Result r = resultsService.generate(1, 0.05f);

		Assert.assertEquals("Al testear un atributo tengo un solo PartialResult", 1, r.getPartialResults().size());
	}
	
	@Test
	public void generate_twoGroups_ok() {
		List<NumericAttribute> values = new LinkedList<>();
		values.addAll(GROUP1);
		values.addAll(GROUP2);
		
		Mockito.when(attributesService.get(Mockito.anyInt())).thenReturn(values);
		Result r = resultsService.generate(1, 0.05f);

		Assert.assertEquals("Al testear un atributo tengo un solo PartialResult", 2, r.getPartialResults().size());
	}

	@Test
	public void generate_threeGroups_ok() {
		List<NumericAttribute> values = new LinkedList<>();
		values.addAll(GROUP1);
		values.addAll(GROUP2);
		values.addAll(GROUP3);
		
		Mockito.when(attributesService.get(Mockito.anyInt())).thenReturn(values);
		Result r = resultsService.generate(1, 0.05f);

		Assert.assertEquals("Al testear un atributo tengo un solo PartialResult", 3, r.getPartialResults().size());
	}

	@Test
	public void generate_nivelDeAgradoDosProductos_ok() {
		Result result = resultsService.generate(1, 0.05f);
		Assert.assertNotNull(result);
	}

}
