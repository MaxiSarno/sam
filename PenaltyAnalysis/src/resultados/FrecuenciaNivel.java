package resultados;

import java.util.ArrayList;

public class FrecuenciaNivel {
	private String categoria;
	private String nivel;
	private Integer valor;
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	public FrecuenciaNivel(String categoria, String nivel, Integer valor) {
		super();
		this.categoria = categoria;
		this.nivel = nivel;
		this.valor = valor;
	}
	
}
