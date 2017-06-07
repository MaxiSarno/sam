import java.util.ArrayList;
import java.util.List;

public class Categoria {
	private String nombre;
	private ArrayList<Integer> valores;
	private ArrayList<Frecuencia> frecuencias;
	private ArrayList<Frecuencia> frecuenciasParaNivelesAgregados;
	
	public Categoria(String nombre, ArrayList<Integer> valores) {
		super();
		this.nombre = nombre;
		this.valores = valores;
		this.frecuencias = new ArrayList<Frecuencia>();
		this.frecuenciasParaNivelesAgregados = new ArrayList<Frecuencia>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Integer> getValores() {
		return valores;
	}
	public void setValores(ArrayList<Integer> valores) {
		this.valores = valores;
	}
	public ArrayList<Frecuencia> getFrecuencias() {
		return frecuencias;
	}
	public void setFrecuencias(ArrayList<Frecuencia> frecuencias) {
		this.frecuencias = frecuencias;
	}
	public ArrayList<Frecuencia> getFrecuenciasParaNivelesAgregados() {
		return frecuenciasParaNivelesAgregados;
	}
	public void setFrecuenciasParaNivelesAgregados(ArrayList<Frecuencia> frecuenciasParaNivelesAgregados) {
		this.frecuenciasParaNivelesAgregados = frecuenciasParaNivelesAgregados;
	}
	
}
