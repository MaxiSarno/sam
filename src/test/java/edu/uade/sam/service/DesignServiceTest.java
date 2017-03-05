package edu.uade.sam.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.uade.sam.model.Design;
import edu.uade.sam.model.DesignSlot;
import edu.uade.sam.service.impl.DesignServiceImpl;
import edu.uade.sam.service.impl.LabelServiceImpl;

public class DesignServiceTest {
	
	private DesignServiceImpl designService;
	
	@Before
	public void setup() {
		this.designService = new DesignServiceImpl();
		this.designService.setLabelService(new LabelServiceImpl());
	}
	
	@Test
	public void testCreateTestDesign() {
		Design d = this.designService.generateDesign("1", 10, Arrays.asList("a", "b", "c"));
		Assert.assertNotNull(d);
	}
	
	@Test
	public void testDesignSlots() {
		int participants = 10;
		Design d = this.designService.generateDesign("1", participants, Arrays.asList("a", "b", "c"));
		Assert.assertEquals("Cantidad de DesignSlots generados", participants, d.getDesignSlots().size());
	}
	
	@Test
	public void testDesignSlotLabels() {
		List<String> labels = Arrays.asList("a", "b", "c");
		Design d = this.designService.generateDesign("1", 10, labels);
		
		for (DesignSlot slot : d.getDesignSlots()) {
			Assert.assertEquals("Cantidad de labels en cada DesignSlots", labels.size(), slot.getLabels().size());
		}
	}

}
