package edu.uade.sam.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
	 * Crea el diseño de la prueba con etiquetas random, manteniendo el orden de las muestras.
	 * 
	 * @param testId
	 * @param judges
	 * @param samples
	 * @return
	 */
	public Design generateDesign(Integer testId, Integer judges, List<String> samples);
	
	/**
	 * Crea el diseño de la prueba con etiquetas random, dando un orden aleatorio a las muestras.
	 * 
	 * @param testId
	 * @param judges
	 * @param samples
	 * @return
	 */
	public Design generateDesignRandom(Integer testId, Integer judges, List<String> samples);
	
	public Design getTestDesign(Integer testId);

}
