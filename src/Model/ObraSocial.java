package Model;



public class ObraSocial {
	
	//ATRIBUTOS
	private int idObraSocial;
	private String nombreObraSocial;
	
	//METODO CONSTRUCTOR
	public ObraSocial(int idObraSocial, String nombreObraSocial) {
		this.idObraSocial = idObraSocial;
		this.nombreObraSocial = nombreObraSocial;
	}
	
	public ObraSocial() {
	}
	public int getIdObraSocial() {
		return idObraSocial;
	}
	public String getNombreObraSocial() {
		return nombreObraSocial;
	}
	public void setIdObraSocial(int idObraSocial) {
		this.idObraSocial = idObraSocial;
	}
	public void setNombreObraSocial(String nombreObraSocial) {
		this.nombreObraSocial = nombreObraSocial;
	}
	
}
