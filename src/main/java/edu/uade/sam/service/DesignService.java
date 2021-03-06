package edu.uade.sam.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uade.sam.model.Design;

/**
 * Diseño de las pruebas a realizarse.
 * 
 * @author maxi
 *
 */
@Service
public interface DesignService {
	
	/**
	 * Crea el diseño de la prueba con etiquetas random, manteniendo el orden o dando un orden aleatorio a las muestras.
	 * 
	 * @param testId
	 * @param judges
	 * @param samples
	 * @param random
	 * @return
	 */
	public Design generateDesign(Long samId, Integer judges, List<String> samples, boolean random);
	
	/**
	 * @param testId
	 * @return
	 */
	public Design getDesign(Long samId);

	/**
	 * Borra el diseño
	 * 
	 * @param id
	 */
	@Transactional
	public void delete(Long id);

}
