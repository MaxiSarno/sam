import java.util.*;

public class PenaltyAnalysis {
	private Datos d;
	private Integer valorJar;

	public PenaltyAnalysis(Datos d, Integer valorJar) {
		super();
		this.d = d;
		this.valorJar = valorJar;
	}
	
	public void calcular(){
		int cantEncuestas = d.getCategorias().get(0).getValores().size();
		for(Categoria c : d.getCategorias()){
			int maxVal = 0;
			for(Integer i : c.getValores()){
				if(i>maxVal){
					maxVal = i;
				}
			}
			ArrayList<Frecuencia> frecuenciasAux = new ArrayList<Frecuencia>();
			int frecNivelMinimoAux = 0;
			int frecNivelMedioAux = 0;
			int frecNivelMaximoAux = 0;
			int opinNivelMinimoAux = 0;
			int opinNivelMedioAux = 0;
			int opinNivelMaximoAux = 0;
			int times= 0;
			for(Dupla d : this.agrupar(c.getValores(),d.getOpiniones(),maxVal)){
				frecuenciasAux.add(new Frecuencia(d.getValor().toString(),d.getFrec(),d.getOpinionAcum(),cantEncuestas));
				
				if(d.getValor().intValue() < valorJar){
					frecNivelMinimoAux = frecNivelMinimoAux = d.getFrec();
					opinNivelMinimoAux = opinNivelMinimoAux + d.getOpinionAcum();
				}
				if(d.getValor().intValue() == valorJar){
					frecNivelMedioAux = frecNivelMedioAux = d.getFrec();
					opinNivelMedioAux = opinNivelMedioAux + d.getOpinionAcum();
				}
				if(d.getValor().intValue() > valorJar){
					frecNivelMaximoAux = frecNivelMaximoAux = d.getFrec();
					opinNivelMaximoAux = opinNivelMaximoAux + d.getOpinionAcum();
				}
			}
			c.setFrecuencias(frecuenciasAux);
			
			//Tiene que ser el modulo el efecto sobre la media????
			ArrayList<Frecuencia> frecNiveles = new ArrayList<Frecuencia>();
			Frecuencia frecNivelMedio = new Frecuencia("JAR",frecNivelMedioAux,opinNivelMedioAux,cantEncuestas);
			Frecuencia frecNivelMinimo = new Frecuencia("Demasiado poco",frecNivelMinimoAux,opinNivelMinimoAux,cantEncuestas);
			frecNivelMinimo.setEfectoSobreLaMedia(frecNivelMedio.getMediaOpinion()-frecNivelMinimo.getMediaOpinion());
			Frecuencia frecNivelMaximo = new Frecuencia("Demasiado",frecNivelMedioAux,opinNivelMaximoAux,cantEncuestas);
			frecNivelMaximo.setEfectoSobreLaMedia(frecNivelMedio.getMediaOpinion()-frecNivelMaximo.getMediaOpinion());
			frecNiveles.add(frecNivelMinimo);
			frecNiveles.add(frecNivelMedio);
			frecNiveles.add(frecNivelMaximo);
			c.setFrecuenciasParaNivelesAgregados(frecNiveles);	
		}
		System.out.println(d.getCategorias().get(0).getFrecuenciasParaNivelesAgregados().get(0).getEfectoSobreLaMedia());
	}
	public ArrayList<Dupla> agrupar(ArrayList<Integer> vals, ArrayList<Integer> opiniones,Integer cantValores){
		int posicionEnOpinion = 0;
		ArrayList<Dupla> frecuencias = new ArrayList<Dupla>();
		for(int j=1;j<=cantValores;j++){
			Integer acumFrec= 0;
			Integer acumOpin= 0;
			for(Integer i : vals){
				if(i==j){
					acumFrec++;
					acumOpin = acumOpin + opiniones.get(posicionEnOpinion);
				}
				posicionEnOpinion++;
			}
			frecuencias.add(new Dupla(j,acumFrec,acumOpin));
			acumFrec = 0;
			acumOpin = 0;
			posicionEnOpinion = 0;
		}
		return frecuencias;
	}

	public Datos getD() {
		return d;
	}

	public void setD(Datos d) {
		this.d = d;
	}
	
	 
}
