package resultados;

import java.util.ArrayList;

public class EfectoSobreLaMediaVsPorcentaje {
	private String nivel;
	private Float porcentaje;
	private Integer efectoSobreLaMedia;
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public Float getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(Float porcentaje) {
		this.porcentaje = porcentaje;
	}
	public Integer getEfectoSobreLaMedia() {
		return efectoSobreLaMedia;
	}
	public void setEfectoSobreLaMedia(Integer efectoSobreLaMedia) {
		this.efectoSobreLaMedia = efectoSobreLaMedia;
	}
	public EfectoSobreLaMediaVsPorcentaje(String nivel, Float porcentaje, Integer efectoSobreLaMedia) {
		super();
		this.nivel = nivel;
		this.porcentaje = porcentaje;
		this.efectoSobreLaMedia = efectoSobreLaMedia;
	}
	
}
