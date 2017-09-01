package edu.uade.sam.messaging;

/**
 * @author msarno
 *
 */
public enum SamNotificationCatalog {

	INVALID_SENSORY_EVALUATION_TYPE(10, "Tipo de evaluación sensorial invalida"),
	INVALID_SENSORY_EVALUATION_SCALE(11, "Escala de evaluación sensorial invalida"),
	DESIGN_LABELS_OVERFLOW(20, "La cantidad de etiquetas supera el máximo disponible, use menos jueces o productos");
	
	int id;
	String description;
	
	SamNotificationCatalog(int id, String description) {
		this.id = id;
		this.description = description;
	}
}
