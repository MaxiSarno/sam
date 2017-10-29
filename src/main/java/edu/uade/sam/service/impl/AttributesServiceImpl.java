package edu.uade.sam.service.impl;

import static edu.uade.sam.model.SensoryEvaluationType.CONSUMER;
import static edu.uade.sam.model.SensoryEvaluationType.HEDONIC;
import static edu.uade.sam.model.SensoryEvaluationType.DESCRIPTIVE;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import edu.uade.sam.dao.AttributeRepository;
import edu.uade.sam.model.NumericAttribute;
import edu.uade.sam.model.SensoryEvaluationType;
import edu.uade.sam.service.AttributesService;

@Component
public class AttributesServiceImpl implements AttributesService {

	private static final String PANELISTA = "panelista ";
	private static final String AGRADO = "Nivel de agrado";

	@Inject
	private AttributeRepository dao;

	@Override
	public void save(List<NumericAttribute> attributes) {
		dao.save(attributes);
	}

	@Override
	public List<NumericAttribute> get(long samId) {
		return dao.findBySamId(samId);
	}

	@Override
	public String getTemplate(SensoryEvaluationType type, int judges, List<String> products, List<String> attributes) {

		if (CONSUMER.equals(type)) {
			return this.getConsumerTemplate(judges, products);
		} else if (HEDONIC.equals(type)) {
			return this.getHedonicTemplate(judges, products, attributes);
		} else if (DESCRIPTIVE.equals(type)) {
			return this.getPreferenceTemplate(judges, products);
		}

		return null;
	}

	private String getPreferenceTemplate(int judges, List<String> products) {
		StringBuilder sb = new StringBuilder();

		sb.append(this.templateHeaderProducts(products)).append("\n");
		sb.append(this.templateHeaderJudges(judges));

		return sb.toString();
	}

	private String getHedonicTemplate(int judges, List<String> products, List<String> attributes) {
		StringBuilder sb = new StringBuilder();
		StringBuilder aHeader = new StringBuilder();
		StringBuilder pHeader = new StringBuilder();

		for (String a : attributes) {
			for (String p : products) {
				aHeader.append(",").append(a);
				pHeader.append(",").append(p);
			}
		}

		sb.append(aHeader).append("\n");
		sb.append(pHeader).append("\n");
		sb.append(this.templateHeaderJudges(judges));

		return sb.toString();
	}

	private String getConsumerTemplate(int judges, List<String> products) {
		StringBuilder sb = new StringBuilder();

		sb.append(this.templateHeaderConsumer(products.size())).append("\n");
		sb.append(this.templateHeaderProducts(products)).append("\n");
		sb.append(this.templateHeaderJudges(judges));

		return sb.toString();
	}

	private String templateHeaderConsumer(int size) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < size; i++) {
			sb.append(",").append(AGRADO);
		}

		return sb.toString();
	}

	private String templateHeaderProducts(List<String> products) {
		StringBuilder sb = new StringBuilder();

		for (String p : products) {
			sb.append(",").append(p);
		}

		return sb.toString();
	}

	private String templateHeaderJudges(int judges) {
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= judges; i++) {
			sb.append(PANELISTA + i).append(",").append("\n");
		}

		return sb.toString();
	}

	@Override
	public void deleteBySamId(Long samId) {
		this.dao.deleteBySamId(samId);
	}

}
