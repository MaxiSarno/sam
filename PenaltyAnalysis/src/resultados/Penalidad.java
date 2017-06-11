package resultados;

public class Penalidad {
	private String categoria;
	private String nivel;
	private Integer frecuencia;
	private Float porcentaje;
	private Integer sumOpinionGeneral;
	private Float mediaOpinionGeneral;
	private Float opinionSobreLaMedia;
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
	public Integer getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(Integer frecuencia) {
		this.frecuencia = frecuencia;
	}
	public Float getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(Float porcentaje) {
		this.porcentaje = porcentaje;
	}
	public Integer getSumOpinionGeneral() {
		return sumOpinionGeneral;
	}
	public void setSumOpinionGeneral(Integer sumOpinionGeneral) {
		this.sumOpinionGeneral = sumOpinionGeneral;
	}
	public Float getMediaOpinionGeneral() {
		return mediaOpinionGeneral;
	}
	public void setMediaOpinionGeneral(Float mediaOpinionGeneral) {
		this.mediaOpinionGeneral = mediaOpinionGeneral;
	}
	public Float getOpinionSobreLaMedia() {
		return opinionSobreLaMedia;
	}
	public void setOpinionSobreLaMedia(Float opinionSobreLaMedia) {
		this.opinionSobreLaMedia = opinionSobreLaMedia;
	}
	public Penalidad(String categoria, String nivel, Integer frecuencia, Float porcentaje, Integer sumOpinionGeneral,
			Float mediaOpinionGeneral, Float opinionSobreLaMedia) {
		super();
		this.categoria = categoria;
		this.nivel = nivel;
		this.frecuencia = frecuencia;
		this.porcentaje = porcentaje;
		this.sumOpinionGeneral = sumOpinionGeneral;
		this.mediaOpinionGeneral = mediaOpinionGeneral;
		this.opinionSobreLaMedia = opinionSobreLaMedia;
	}
	
	
}
