package edu.uade.sam.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.uade.sam.messaging.SamNotification;
import edu.uade.sam.messaging.SamNotificationCatalog;
import edu.uade.sam.messaging.SamResponse;
import edu.uade.sam.model.Design;
import edu.uade.sam.model.Label;
import edu.uade.sam.service.DesignService;
import edu.uade.sam.service.impl.LabelServiceImpl;

/**
 * @author msarno
 *
 */
@RestController
@RequestMapping("/evaluation/{id}/design")
public class DesignController {

	private static final String TEMPLATE_NAME = "diseño-sam-";
	@Inject
	private DesignService designService;

	@RequestMapping(method = RequestMethod.GET)
	public Design getDesign(@PathVariable(value = "id") Long id) {
		return designService.getDesign(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<SamResponse> createDesign(@PathVariable(value = "id") Long id,
			@RequestParam(value = "judges", required = true) Integer judges,
			@RequestParam(value = "samples", required = true) String samples,
			@RequestParam(value = "random", required = false, defaultValue = "true") boolean random) {

		List<String> sampleList = Arrays.asList(samples.split(","));
		SamNotification notification = this.validDesignCreation(id, judges, sampleList, random);

		if (notification != null) {
			return ResponseEntity.badRequest().body(new SamResponse(null, notification));
		}

		Design d = this.designService.generateDesign(id, judges, sampleList, random);

		return ResponseEntity.ok().body(new SamResponse(d, null));
	}

	private SamNotification validDesignCreation(Long id, Integer judges, List<String> sampleList, boolean random) {
		if (LabelServiceImpl.LABEL_MAX_VALUE < judges * sampleList.size()) {
			return SamNotification.fromCatalog(SamNotificationCatalog.DESIGN_LABELS_OVERFLOW);
		}

		return null;
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public String deleteDesign(@PathVariable(value = "id") Integer id) {
		return "delete design not implemented";
	}

	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public void getDesignCsv(@PathVariable(value = "id") Long id,
			@RequestParam(name = "type", defaultValue = "csv") String type,
			@RequestParam(name = "judges") Integer judges,
			@RequestParam(name = "samples") String samples, 
			@RequestParam(value = "random", required = false, defaultValue = "true") boolean random,
			HttpServletResponse response)
			throws IOException {
		
		this.createDesign(id, judges, samples, random);
		
		Design design = designService.getDesign(id);
		String csv = this.writeDesign(design, type);

		response.setContentLength((int) csv.length());
		response.setContentType("application/octet-stream");
		response.setContentType("application/force-download");
		response.setHeader("Content-Disposition", "attachment; filename=" + TEMPLATE_NAME + id + ".csv");
		response.getWriter().print(csv);
	}

	private String writeDesign(Design design, String type) {
		return design.getDesignSlots().stream()
				.map(s -> "panelista " + s.getJudge() + writeLabels(s.getLabels(), type) + "\n")
				.reduce(new String(), (a, b) -> a + b);
	}

	private String writeLabels(List<Label> labels, String type) {
		String separator = type.equals("csv") ? "," : "\t";

		return labels.stream().map(l -> separator + l.getLabelNumber() + "(" + l.getDescription() + ")")
				.reduce(new String(), (a, b) -> a + b);
	}

}
