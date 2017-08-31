package edu.uade.sam.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class SensoryEvaluationScaleTest {
	
	@Test
	public void fromString_nine() {
		String value = "nine";
		SensoryEvaluationScale t = SensoryEvaluationScale.fromString(value);
		
		assertEquals(SensoryEvaluationScale.NINE, t);
	}
	
	@Test
	public void fromString_five() {
		String value = "five";
		SensoryEvaluationScale t = SensoryEvaluationScale.fromString(value);
		
		assertEquals(SensoryEvaluationScale.FIVE, t);
	}
	
	@Test
	public void fromString_null() {
		assertEquals(null, SensoryEvaluationScale.fromString(null));
		assertEquals(null, SensoryEvaluationScale.fromString("tuvieja"));
		assertEquals(null, SensoryEvaluationScale.fromString("cinco"));
		assertEquals(null, SensoryEvaluationScale.fromString("nueve"));
	}
	
	@Test
	public void fiveContains_ok() {
		assertTrue(SensoryEvaluationScale.FIVE.contains(1));
		assertTrue(SensoryEvaluationScale.FIVE.contains(2));
		assertTrue(SensoryEvaluationScale.FIVE.contains(3));
		assertTrue(SensoryEvaluationScale.FIVE.contains(4));
		assertTrue(SensoryEvaluationScale.FIVE.contains(5));
	}
	
	@Test
	public void fiveContains_notOk() {
		assertFalse(SensoryEvaluationScale.FIVE.contains(0));
		assertFalse(SensoryEvaluationScale.FIVE.contains(6));
		assertFalse(SensoryEvaluationScale.FIVE.contains(10));
		assertFalse(SensoryEvaluationScale.FIVE.contains(-5));
		assertFalse(SensoryEvaluationScale.FIVE.contains(null));
	}
	
	@Test
	public void nineContains_ok() {
		assertTrue(SensoryEvaluationScale.NINE.contains(1));
		assertTrue(SensoryEvaluationScale.NINE.contains(2));
		assertTrue(SensoryEvaluationScale.NINE.contains(3));
		assertTrue(SensoryEvaluationScale.NINE.contains(4));
		assertTrue(SensoryEvaluationScale.NINE.contains(5));
		assertTrue(SensoryEvaluationScale.NINE.contains(6));
		assertTrue(SensoryEvaluationScale.NINE.contains(7));
		assertTrue(SensoryEvaluationScale.NINE.contains(8));
		assertTrue(SensoryEvaluationScale.NINE.contains(9));
	}
	
	@Test
	public void nineContains_notOk() {
		assertFalse(SensoryEvaluationScale.NINE.contains(0));
		assertFalse(SensoryEvaluationScale.NINE.contains(10));
		assertFalse(SensoryEvaluationScale.NINE.contains(-5));
		assertFalse(SensoryEvaluationScale.NINE.contains(null));
	}

}
