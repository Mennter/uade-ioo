package Model;
import java.util.ArrayList;
public class Practica {
	
	//ATRIBUTOS
	private int idPractica;
	private String nombrePractica;
	private int duracionPractica;
	private Boolean isReservada;
	private ArrayList<Practica> coleccionDePracticas;
	
	
	//METODO CONSTRUCTOR
	public Practica(int idPractica, String nombrePractica, int duracionPractica, Boolean isReservada, ArrayList<Practica> coleccionDePracticas) {
		this.idPractica = idPractica;
		this.nombrePractica = nombrePractica;
		this.duracionPractica = duracionPractica;
		this.isReservada = isReservada;
		this.coleccionDePracticas = coleccionDePracticas;
	}
	
	public Practica() {
	}
		

	public int getIdPractica() {
		return idPractica;
	}

	public String getNombrePractica() {
		return nombrePractica;
	}

	public int getDuracionPractica() {
		return duracionPractica;
	}

	public Boolean getIsReservada() {
		return isReservada;
	}

	public ArrayList<Practica> getColeccionDePracticas() {
		return coleccionDePracticas;
	}

	public void setIdPractica(int idPractica) {
		this.idPractica = idPractica;
	}

	public void setNombrePractica(String nombrePractica) {
		this.nombrePractica = nombrePractica;
	}

	public void setDuracionPractica(int duracionPractica) {
		this.duracionPractica = duracionPractica;
	}

	public void setIsReservada(Boolean isReservada) {
		this.isReservada = isReservada;
	}

	public void setColeccionDePracticas(ArrayList<Practica> coleccionDePracticas) {
		this.coleccionDePracticas = coleccionDePracticas;
	}
	

	
}