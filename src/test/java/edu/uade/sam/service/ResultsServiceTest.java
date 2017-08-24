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
import edu.uade.sam.model.PartialResult;
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
	
	private static List<NumericAttribute> ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3;
	
	@BeforeClass
	public static void init() {
		NumericAttribute a11 = new NumericAttribute(1,"p1", "a1", 2);
		NumericAttribute a12 = new NumericAttribute(1,"p1", "a1", 2);
		NumericAttribute a13 = new NumericAttribute(1,"p2", "a1", 3);
		NumericAttribute a14 = new NumericAttribute(1,"p2", "a1", 3);
		NumericAttribute a15 = new NumericAttribute(1,"p3", "a1", 4);
		NumericAttribute a16 = new NumericAttribute(1,"p3", "a1", 4);
		ATTRIBUTE1 = Arrays.asList(a11, a12, a13, a14, a15, a16);

		NumericAttribute a21 = new NumericAttribute(1,"p1", "a2", 2);
		NumericAttribute a22 = new NumericAttribute(1,"p1", "a2", 2);
		NumericAttribute a23 = new NumericAttribute(1,"p2", "a2", 3);
		NumericAttribute a24 = new NumericAttribute(1,"p2", "a2", 3);
		NumericAttribute a25 = new NumericAttribute(1,"p3", "a2", 4);
		NumericAttribute a26 = new NumericAttribute(1,"p3", "a2", 4);
		ATTRIBUTE2 = Arrays.asList(a21, a22, a23, a24, a25, a26);

		NumericAttribute a31 = new NumericAttribute(1,"p1", "a3", 2);
		NumericAttribute a32 = new NumericAttribute(1,"p1", "a3", 2);
		NumericAttribute a33 = new NumericAttribute(1,"p2", "a3", 3);
		NumericAttribute a34 = new NumericAttribute(1,"p2", "a3", 3);
		NumericAttribute a35 = new NumericAttribute(1,"p3", "a3", 4);
		NumericAttribute a36 = new NumericAttribute(1,"p3", "a3", 4);
		ATTRIBUTE3 = Arrays.asList(a31, a32, a33, a34, a35, a36);
		
	}

	@Before
	public void initTest() {
		attributesService = Mockito.mock(AttributesService.class);
		resultsService.setAttributesService(attributesService);
		
		SensoryEvaluationService sensoryEvaluationService = Mockito.mock(SensoryEvaluationService.class);
		Mockito.when(sensoryEvaluationService.get(Mockito.anyLong())).thenReturn(new SensoryEvaluation());
	}
	

	public void generate_oneAttribute_onePartialResult() {
		Mockito.when(attributesService.get(Mockito.anyInt())).thenReturn(ATTRIBUTE1);
		Result r = resultsService.generate(1, 0.05f);

		Assert.assertEquals("Al testear un atributo tengo un solo PartialResult", 1, r.getPartialResults().size());
	}
	
	@Test
	public void generate_twoAttributes_twoPartialResults() {
		List<NumericAttribute> values = new LinkedList<>();
		values.addAll(ATTRIBUTE1);
		values.addAll(ATTRIBUTE2);
		
		Mockito.when(attributesService.get(Mockito.anyInt())).thenReturn(values);
		Result r = resultsService.generate(1, 0.05f);

		Assert.assertEquals("Al testear 2 atributos tengo 2 PartialResult", 2, r.getPartialResults().size());
	}

	@Test
	public void generate_threeAttributes_threePartialResults() {
		List<NumericAttribute> values = new LinkedList<>();
		values.addAll(ATTRIBUTE1);
		values.addAll(ATTRIBUTE2);
		values.addAll(ATTRIBUTE3);
		
		Mockito.when(attributesService.get(Mockito.anyInt())).thenReturn(values);
		Result r = resultsService.generate(1, 0.05f);

		Assert.assertEquals("Al testear 3 atributos tengo 3 PartialResult", 3, r.getPartialResults().size());
	}

	@Test
	public void generate_oneAttribute_onePartialResult_threeSummaries() {
		Mockito.when(attributesService.get(Mockito.anyInt())).thenReturn(ATTRIBUTE1);
		Result r = resultsService.generate(1, 0.05f);

		Assert.assertEquals("PartialResult con 3 summaries", 3, r.getPartialResults().get(0).getSummaries().size());
	}
	
	@Test
	public void generate_twoAttributes_twoPartialResults_threeSummaries() {
		List<NumericAttribute> values = new LinkedList<>();
		values.addAll(ATTRIBUTE1);
		values.addAll(ATTRIBUTE2);
		
		Mockito.when(attributesService.get(Mockito.anyInt())).thenReturn(values);
		Result r = resultsService.generate(1, 0.05f);
		
		for (PartialResult partial : r.getPartialResults()) {
			Assert.assertEquals("PartialResult con 3 summaries", 3, partial.getSummaries().size());
		}
	}

	@Test
	public void generate_threeAttributes_threePartialResults_threeSummaries() {
		List<NumericAttribute> values = new LinkedList<>();
		values.addAll(ATTRIBUTE1);
		values.addAll(ATTRIBUTE2);
		values.addAll(ATTRIBUTE3);
		
		Mockito.when(attributesService.get(Mockito.anyInt())).thenReturn(values);
		Result r = resultsService.generate(1, 0.05f);
		
		for (PartialResult partial : r.getPartialResults()) {
			Assert.assertEquals("PartialResult con 3 summaries", 3, partial.getSummaries().size());
		}

	}

	@Test
	public void generate_nivelDeAgradoDosProductos_ok() {
		Result result = resultsService.generate(1, 0.05f);
		Assert.assertNotNull(result);
	}

}
