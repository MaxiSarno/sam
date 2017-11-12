package edu.uade.sam.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uade.sam.model.NumericAttribute;
import edu.uade.sam.model.SensoryEvaluationType;

/**
 * Atributos de las evaluaciones sensoriales hechas por los participantes.
 * 
 * @author maxi
 *
 */
@Service
public interface AttributesService {

	/**
	 * Guarda los atributos, duh
	 * 
	 * @param attributes
	 */
	public void save(List<NumericAttribute> attributes);

	/**
	 * Obtiene todos los atributos para un samId
	 * 
	 * @param samId
	 * @return
	 */
	public List<NumericAttribute> get(long samId);

	/**
	 * Devuelve un template para completar con el valor de los atributos de la
	 * evaluacion sensorial
	 * 
	 * @param type
	 * @param judges
	 * @param productList
	 * @param attributeList
	 * @return
	 */
	public String getTemplate(SensoryEvaluationType type, int judges, List<String> productList,
			List<String> attributeList);

	/**
	 * Borra los atributos
	 * 
	 * @param id
	 */
	@Transactional
	public void deleteBySamId(Long id);
}
