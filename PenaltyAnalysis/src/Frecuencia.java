
public class Frecuencia {
	private String nivel;
	private Integer valor;
	private Integer opinionAcumulada;
	private float mediaOpinion;
	private float porcentajeNivelJAR;
	private float efectoSobreLaMedia;
	
	
	public Frecuencia(String nivel, Integer valor, Integer opinionAcumulada,Integer cantEncuentas) {
		super();
		this.nivel = nivel;
		this.valor = valor;
		this.opinionAcumulada = opinionAcumulada;
		this.porcentajeNivelJAR = Float.valueOf(valor)/Float.valueOf(cantEncuentas);
		this.mediaOpinion = Float.valueOf(opinionAcumulada)/Float.valueOf(valor);
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
	public float getPorcentajeNivelJAR() {
		return porcentajeNivelJAR;
	}
	public void setPorcentajeNivelJAR(float porcentajeNivelJAR) {
		this.porcentajeNivelJAR = porcentajeNivelJAR;
	}
	public Integer getOpinionAcumulada() {
		return opinionAcumulada;
	}
	public void setOpinionAcumulada(Integer opinionAcumulada) {
		this.opinionAcumulada = opinionAcumulada;
	}
	public float getMediaOpinion() {
		return mediaOpinion;
	}
	public void setMediaOpinion(float mediaOpinion) {
		this.mediaOpinion = mediaOpinion;
	}
	public float getEfectoSobreLaMedia() {
		return efectoSobreLaMedia;
	}
	public void setEfectoSobreLaMedia(float efectoSobreLaMedia) {
		this.efectoSobreLaMedia = efectoSobreLaMedia;
	}
	
	
	
}
