package edu.uade.sam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.uade.sam.model.TestDesign;

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
	public TestDesign createTestDesign(Integer testId, int judges, List<String> samples);
	
	/**
	 * Crea el diseño de la prueba con etiquetas random, dando un orden aleatorio a las muestras.
	 * 
	 * @param testId
	 * @param judges
	 * @param samples
	 * @return
	 */
	public TestDesign createTestDesignRandom(Integer testId, int judges, List<String> samples);

	public String alala();

}
