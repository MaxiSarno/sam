package edu.uade.sam.model;

/**
 * Evaluaciones Hedonicas Escala 1 al 5
 * 
 * @author maxi
 *
 */
public class NumericAttribute implements Attribute {

	private String product;
	private String attribute;
	private Integer value;
	//vincular el atributo con el producto 
	//vincular el atributo el participante?
	//mandarlo a la superclass

	public NumericAttribute(String product, String attribute, Integer value) {
		super();
		this.product = product;
		this.attribute = attribute;
		this.value = value;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "HedonicAttribute [product=" + product + ", attribute="
				+ attribute + ", value=" + value + "]";
	}

}
