package Model;
import java.util.ArrayList;
import java.util.List;


public class Paciente {

		//ATRIBUTOS
		private String dni;
		private String nombre;
		private String apellido;
		private String domicilio;
		private String mail;
		private String sexo;
		private String fechaNacimiento;
		private String ObraSocial;

		
		//METODO CONSTRUCTOR
		public Paciente(String dni, String nombre, String apellido, String domicilio, String mail, String sexo, String fechaNacimiento, String ObraSocial) {
			this.dni = dni;
			this.nombre = nombre;
			this.apellido = apellido;
			this.domicilio = domicilio;
			this.mail = mail;
			this.sexo = sexo;
			this.fechaNacimiento = fechaNacimiento;
			this.ObraSocial = ObraSocial;
		}
		



		public Paciente() {

		}




		//METODOS SETTERS
		public void setDni(String dni) {
			this.dni = dni;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		public void setDomicilio(String domicilio) {
			this.domicilio = domicilio;
		}
		public void setMail(String mail) {
			this.mail = mail;
		}
		public void setSexo(String sexo) {
			this.sexo = sexo;
		}
		public void setFechaNacimiento(String fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
		}
		public void setObraSocial(String ObraSocial) {
			this.ObraSocial = ObraSocial;
		}
		
		
		
		//METODOS GETTERS
		public String getDni() {
			return dni;
		}
		public String getNombre() {
			return nombre;
		}
		public String getApellido() {
			return apellido;
		}
		public String getDomicilio() {
			return domicilio;
		}
		public String getMail() {
			return mail;
		}
		public String getSexo() {
			return sexo;
		}
		public String getFechaNacimiento() {
			return fechaNacimiento;
		}
		public String getObraSocial() {
			return ObraSocial;
		}


		//METODO TO STRING
		@Override
		public String toString() {
			return this.getDni() + " " + this.getNombre() + " " + this.getApellido() + " " + this.getDomicilio() + " " + this.getMail() + " " + this.getSexo() + " " + this.getFechaNacimiento()+ " "+ this.getObraSocial();
		}


		
		
			
}
