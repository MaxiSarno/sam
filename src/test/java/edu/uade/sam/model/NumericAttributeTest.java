package edu.uade.sam.model;

import org.junit.Assert;
import org.junit.Test;

public class NumericAttributeTest {
	
	@Test
	public void testHashCode() {
		NumericAttribute a = new NumericAttribute(1, "tang", "sabor", 5);
		NumericAttribute b = new NumericAttribute(1, "tang", "sabor", 5);
		
		Assert.assertEquals(a.hashCode(), b.hashCode());
	}
	
	@Test
	public void testEquals() {
		NumericAttribute a = new NumericAttribute(1, "tang", "sabor", 5);
		NumericAttribute b = new NumericAttribute(1, "tang", "sabor", 5);
		
		Assert.assertTrue(a.equals(b));
	}
	
	@Test
	public void testToString() {
		NumericAttribute a = new NumericAttribute(1, "tang", "sabor", 5);
		
		Assert.assertNotNull(a.toString());
	}

}
