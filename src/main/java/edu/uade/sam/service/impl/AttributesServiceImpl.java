package edu.uade.sam.service.impl;

import static edu.uade.sam.model.SensoryEvaluationType.CONSUMER;
import static edu.uade.sam.model.SensoryEvaluationType.HEDONIC;
import static edu.uade.sam.model.SensoryEvaluationType.PREFERENCE;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import edu.uade.sam.dao.AttributeRepository;
import edu.uade.sam.model.NumericAttribute;
import edu.uade.sam.model.SensoryEvaluationType;
import edu.uade.sam.service.AttributesService;

@Component
public class AttributesServiceImpl implements AttributesService {

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
		} else if (PREFERENCE.equals(type)) {
			return this.getPreferenceTemplate(judges, products);
		}

		return null;
	}

	private String getPreferenceTemplate(int judges, List<String> products) {
		StringBuilder sb = new StringBuilder();

		sb.append(this.productsTemplate(products)).append("\n");
		sb.append(this.judgesTemplate(judges));

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
		sb.append(this.judgesTemplate(judges));

		return sb.toString();
	}

	private String getConsumerTemplate(int judges, List<String> products) {
		StringBuilder sb = new StringBuilder();

		sb.append(this.productsTemplate(products)).append("\n");
		sb.append(this.judgesTemplate(judges));

		return sb.toString();
	}

	private String productsTemplate(List<String> products) {
		StringBuilder sb = new StringBuilder();

		for (String p : products) {
			sb.append(",").append(p);
		}

		return sb.toString();
	}

	private String judgesTemplate(int judges) {
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= judges; i++) {
			sb.append("judge " + i).append(",").append("\n");
		}

		return sb.toString();
	}

}
