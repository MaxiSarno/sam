import java.util.ArrayList;
import java.util.List;

public class Datos {
	private String label;
	private ArrayList<Integer> opiniones;
	private ArrayList<Categoria> categorias;
	public Datos(String label, ArrayList<Integer> opiniones, ArrayList<Categoria> categorias) {
		super();
		this.label = label;
		this.opiniones = opiniones;
		this.categorias = categorias;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public ArrayList<Integer> getOpiniones() {
		return opiniones;
	}
	public void setOpiniones(ArrayList<Integer> opiniones) {
		this.opiniones = opiniones;
	}
	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(ArrayList<Categoria> categorias) {
		this.categorias = categorias;
	}
	
}
