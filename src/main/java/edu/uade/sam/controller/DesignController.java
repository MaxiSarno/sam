package edu.uade.sam.controller;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.uade.sam.model.Design;
import edu.uade.sam.model.Label;
import edu.uade.sam.service.DesignService;

/**
 * @author msarno
 *
 */
@RestController
@RequestMapping("/evaluation/{id}/design")
public class DesignController {

	@Inject
	private DesignService designService;

	@RequestMapping(method = RequestMethod.GET)
	public Design getDesign(@PathVariable(value = "id") Integer id) {
		return designService.getTestDesign(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Design createDesign(@PathVariable(value = "id") Integer id,
			@RequestParam(value = "judges", required = true) Integer judges,
			@RequestParam(value = "samples", required = true) String samples) {
		// FIXME validar que exista la SensoryEvaluation
		return this.designService.generateDesign(id, judges,
				Arrays.asList(samples.split(",")));
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public String deleteDesign(@PathVariable(value = "id") Integer id) {
		return "delete design not implemented";
	}

	@RequestMapping(value = "/csv", method = RequestMethod.GET)
	public String getDesignCsv(@PathVariable(value = "id") Integer id) {
		Design design = designService.getTestDesign(id);
		return this.writeDesign(design);
	}

	private String writeDesign(Design design) {
		return design
				.getDesignSlots()
				.stream()
				.map(s -> "judge:" + s.getJudge() + writeLabels(s.getLabels()) + "\n")
				.reduce(new String(), (a, b) -> a + b);
	}

	private String writeLabels(List<Label> labels) {
		return labels
				.stream()
				.map(l -> "\t" + l.getLabelNumber() + "(" + l.getDescription()+ ") ")
				.reduce(new String(), (a, b) -> a + b);
	}

}
