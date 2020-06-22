package Model;

import java.util.ArrayList;
import java.util.Date;


public class Peticion {
	
	//ATRIBUTOS
	private int idPeticion;
	private String dniPaciente;
	private String fechaCarga;
	private String fechaEntrega;
	private String idSucursal;	
	private int cantPracticas;
	private ArrayList<Resultado> coleccionDeResultados;
	private ArrayList<Practica> coleccionDePracticas;


	
	
	//METODO CONSTRUCTOR
	public Peticion(int idPeticion, String dniPaciente, String fechaCarga, String fechaEntrega, String idSucursal, ArrayList<Practica> coleccionDePracticas) {
		this.idPeticion = idPeticion;
		this.dniPaciente = dniPaciente;
		this.fechaCarga = fechaCarga;
		this.fechaEntrega = fechaEntrega;
		this.idSucursal = idSucursal;
		this.coleccionDePracticas = coleccionDePracticas;
	}
	
	public Peticion() {
	}
	
	public int getIdPeticion() {
		return idPeticion;
	}
	public String getUnPaciente() {
		return dniPaciente;
	}

	public String getFechaCarga() {
		return fechaCarga;
	}
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	public String getUnaSucursal() {
		return idSucursal;
	}
	public int getCantPracticas() {
		return cantPracticas;
	}
	public ArrayList<Resultado> getColeccionDeResultados() {
		return coleccionDeResultados;
	}
	public ArrayList<Practica> getColeccionDePracticas() {
		return coleccionDePracticas;
	}

	public void setIdPeticion(int idPeticion) {
		this.idPeticion = idPeticion;
	}
	public void setUnPaciente(String unPaciente) {
		this.dniPaciente = unPaciente;
	}
	public void setFechaCarga(String fechaCarga) {
		this.fechaCarga = fechaCarga;
	}
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public void setUnaSucursal(String unaSucursal) {
		this.idSucursal = unaSucursal;
	}
	public void cantPracticas(int cantPracticas) {
		this.cantPracticas = cantPracticas;
	}
	public void setColeccionDeResultados(ArrayList<Resultado> coleccionDeResultados) {
		this.coleccionDeResultados = coleccionDeResultados;
	}
	public void setColeccionDePracticas(ArrayList<Practica> coleccionDePracticas) {
		this.coleccionDePracticas = coleccionDePracticas;
	}
	
}
