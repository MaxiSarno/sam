package edu.uade.service;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.uade.model.TestDesign;
import edu.uade.service.impl.DesignServiceImpl;
import edu.uade.service.impl.LabelServiceImpl;

public class DesignServiceTest {
	
	private DesignServiceImpl designService;
	
	@Before
	public void setup() {
		this.designService = new DesignServiceImpl();
		this.designService.setLabelService(new LabelServiceImpl());
	}
	
	@Test
	public void testCreateTestDesign() {
		TestDesign a = this.designService.createTestDesign(1, 10, Arrays.asList("a", "b", "c"));
		Assert.assertNotNull(a);
	}

}
