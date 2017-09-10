package edu.uade.sam.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SensoryEvaluationTypeTest {
	
	@Test
	public void fromString_hedonic() {
		String value = "hedonica";
		SensoryEvaluationType t = SensoryEvaluationType.fromString(value);
		
		assertEquals(SensoryEvaluationType.HEDONIC, t);
	}
	
	@Test
	public void fromString_consumer() {
		String value = "consumidor";
		SensoryEvaluationType t = SensoryEvaluationType.fromString(value);
		
		assertEquals(SensoryEvaluationType.CONSUMER, t);
	}
	
	@Test
	public void fromString_null() {
		assertEquals(null, SensoryEvaluationType.fromString(null));
		assertEquals(null, SensoryEvaluationType.fromString("tuvieja"));
		assertEquals(null, SensoryEvaluationType.fromString("hedonic"));
		assertEquals(null, SensoryEvaluationType.fromString("consumer"));
		assertEquals(null, SensoryEvaluationType.fromString("descriptive"));
	}
	
	@Test
	public void fromString_descriptive() {
		String value = "descriptiva";
		SensoryEvaluationType t = SensoryEvaluationType.fromString(value);
		
		assertEquals(SensoryEvaluationType.DESCRIPTIVE, t);
	}

}
