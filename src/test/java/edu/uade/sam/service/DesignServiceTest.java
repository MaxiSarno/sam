package edu.uade.sam.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.uade.sam.dao.DesignRepository;
import edu.uade.sam.model.Design;
import edu.uade.sam.model.DesignSlot;
import edu.uade.sam.model.SensoryEvaluation;
import edu.uade.sam.service.impl.DesignServiceImpl;

/**
 * @author msarno
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DesignServiceTest {

	private static final List<String> SAMPLES = Arrays.asList("a", "b", "c");
	private static final int JUDGES = 10;
	
	@Autowired
	private DesignServiceImpl designService;
	
	@Before
	public void init() {
		SensoryEvaluationService sensoryEvaluationService = Mockito.mock(SensoryEvaluationService.class);
		Mockito.when(sensoryEvaluationService.get(Mockito.anyLong())).thenReturn(new SensoryEvaluation());
		designService.setSensoryEvaluationService(sensoryEvaluationService);
		
		DesignRepository designDao = Mockito.mock(DesignRepository.class);
		Mockito.when(designDao.save(Matchers.any(Design.class))).thenAnswer(new Answer<Object>() {
		    public Object answer(InvocationOnMock invocation) {
		        return invocation.getArguments()[0];
		    }
		});
		designService.setDesignDao(designDao);
	}

	@Test
	public void generateDesign_slotsAmount() {
		Design d = this.designService.generateDesign(1l, JUDGES, SAMPLES, false);
		Assert.assertEquals("Cantidad de DesignSlots generados", JUDGES, d.getDesignSlots().size());
	}

	@Test
	public void generateDesign_samplesInEachSlot() {
		Design d = this.designService.generateDesign(1l, JUDGES, SAMPLES, false);

		for (DesignSlot slot : d.getDesignSlots()) {
			Assert.assertEquals("Cantidad de samples en cada DesignSlots", SAMPLES.size(), slot.getLabels().size());
		}
	}

	@Test
	public void generateDesign_orderedSamples() {
		Design d = this.designService.generateDesign(1l, JUDGES, SAMPLES, false);

		for (DesignSlot slot : d.getDesignSlots()) {
			List<String> samples = slot.getLabels().stream().map(l -> l.getDescription()).collect(Collectors.toList());
			Assert.assertEquals("Samples ordenadas en cada DesignSlot", SAMPLES, samples);
		}
	}
	
	@Test
	public void generateDesignRandom_atLeastSomeDifferent() {
		Design d = this.designService.generateDesign(1l, JUDGES, SAMPLES, true);
		
		int unalteredSlots = 0;
		
		for (DesignSlot slot : d.getDesignSlots()) {
			List<String> samples = slot.getLabels().stream().map(l -> l.getDescription()).collect(Collectors.toList());
			unalteredSlots += samples.equals(SAMPLES) ? 1 : 0;
		}

		Assert.assertNotEquals("Cantidad de labels en cada DesignSlots", JUDGES, unalteredSlots);
	}

}
