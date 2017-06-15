package edu.uade.sam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.uade.sam.model.NumericAttribute;

/**
 * Atributos de las evaluaciones sensoriales hechas por los participantes.
 * 
 * @author maxi
 *
 */
@Service
public interface AttributesService {

	public void save(Integer evaluationId, List<NumericAttribute> attributes);
	
	public List<NumericAttribute> get(Integer evaluationId);
}
