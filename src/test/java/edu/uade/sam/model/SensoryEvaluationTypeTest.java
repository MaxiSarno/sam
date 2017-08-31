package edu.uade.sam.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SensoryEvaluationTypeTest {
	
	@Test
	public void fromString_hedonic() {
		String value = "hedonic";
		SensoryEvaluationType t = SensoryEvaluationType.fromString(value);
		
		assertEquals(SensoryEvaluationType.HEDONIC, t);
	}
	
	@Test
	public void fromString_consumer() {
		String value = "consumer";
		SensoryEvaluationType t = SensoryEvaluationType.fromString(value);
		
		assertEquals(SensoryEvaluationType.CONSUMER, t);
	}
	
	@Test
	public void fromString_null() {
		assertEquals(null, SensoryEvaluationType.fromString(null));
		assertEquals(null, SensoryEvaluationType.fromString("tuvieja"));
		assertEquals(null, SensoryEvaluationType.fromString("hedonico"));
		assertEquals(null, SensoryEvaluationType.fromString("consumidor"));
		assertEquals(null, SensoryEvaluationType.fromString("descriptiva"));
	}
	
	@Test
	public void fromString_descriptive() {
		String value = "descriptive";
		SensoryEvaluationType t = SensoryEvaluationType.fromString(value);
		
		assertEquals(SensoryEvaluationType.DESCRIPTIVE, t);
	}

}
