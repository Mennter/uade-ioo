package Model;

public class Sucursal {
	
	//ATRIBUTOS
	private String idSucursal;
	private String direccion;
	private String responsable;

	
	//METODO CONSTRUCTOR
	public Sucursal(String idSucursal, String direccion, String responsable) {
		this.idSucursal = idSucursal;
		this.direccion = direccion;
		this.responsable = responsable;
	}
	
	// øQue es esto?
	public Sucursal() {
		
	}
	
	//METODOS SETTERS
	public void setIdSucursal(String string) {
		this.idSucursal = string;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	//METODOS GETTERS
	public String getIdSucursal() {
		return idSucursal;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getResponsable() {
		return responsable;
	}

	//METODO TO STRING
	@Override
	public String toString() {
		return this.getIdSucursal() + " " + this.getDireccion() + " " + this.getResponsable()+ " ";
	}

}
