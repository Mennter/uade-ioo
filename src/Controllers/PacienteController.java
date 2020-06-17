package Controllers;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


import Model.Paciente;
import helpers.DatosJSON;

public class PacienteController extends DatosJSON<Paciente> {
	
	//SINGLETON
	private static PacienteController instancia;
	
	public static PacienteController getInstancia()
	{
		if (instancia == null)
			instancia = new PacienteController();
		return instancia;
	}
		
	public PacienteController(){
		super(Paciente.class, "./paciente.txt");
		leer();
	}
	
	public List<Paciente> getPacienteList(){
		return lista;
	}
	
	public Paciente getPacienteObjeto(int index){
		return lista.get(index);
	}
	
	public Paciente getPacientePorDni(String dni){
		int i=0;
		int select = -1;
		for (Paciente paciente: lista) {
			if (dni.equals(paciente.getDni())) {
				paciente = lista.get(i);
				select = i;
			}
			i++;
		}
		if (select == -1) {
			return null;
		}else {
			return lista.get(select);
		}
	}
	
	 
	public void crearPaciente(String dni, String nombre, String apellido, String domicilio, String mail, String sexo, String fechaNacimiento, String ObraSocial) {
		Paciente paciente= new Paciente(dni, nombre, apellido, domicilio,  mail, sexo, fechaNacimiento, ObraSocial);
		lista.add(paciente);
		guardar();
	}

	public void modificarPaciente(Paciente paciente, String dni, String nombre, String apellido, String domicilio, String mail, String sexo, String fechaNacimiento, String ObraSocial) {
			paciente.setDni(dni);
			paciente.setNombre(nombre);
			paciente.setApellido(apellido);
			paciente.setDomicilio(domicilio);
			paciente.setMail(mail);
			paciente.setSexo(sexo);
			paciente.setFechaNacimiento(fechaNacimiento);
			paciente.setObraSocial(ObraSocial);
			guardar();
	}
	
	public void eliminarPaciente(Paciente paciente) {
		lista.remove(lista.indexOf(paciente));
		guardar();
	}
	
	public List<Paciente> obtenerColeccionDePacientes(){
		return lista;
	}
}
