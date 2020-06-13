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

public class PacienteController {
	
	//SINGLETON
	private static PacienteController instancia;
	public static PacienteController getInstancia()
	{
		if (instancia == null)
			instancia = new PacienteController();
		return instancia;
	}
	

	private ArrayList<Paciente> coleccionDePacientes;
	Paciente paciente = new Paciente();
	
	public PacienteController(){
		coleccionDePacientes = leer();
	}
	
	public ArrayList<Paciente> getPacienteList(){
		return coleccionDePacientes;
	}
	
	public Paciente getPacienteObjeto(int index){
		return coleccionDePacientes.get(index);
	}
	
	public Paciente getPacientePorDni(String dni){
		int i=0;
		int select = -1;
		for (Paciente paciente: coleccionDePacientes) {
			if (dni.equals(paciente.getDni())) {
				paciente = coleccionDePacientes.get(i);
				select = i;
			}
			i++;
		}
		if (select == -1) {
			return null;
		}else {
			return coleccionDePacientes.get(select);
		}
	}
	
	 
	public void crearPaciente(String dni, String nombre, String apellido, String domicilio, String mail, String sexo, String fechaNacimiento, String ObraSocial) {
		Paciente paciente= new Paciente(dni, nombre, apellido, domicilio,  mail, sexo, fechaNacimiento, ObraSocial);
		coleccionDePacientes.add(paciente);
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
	}
	
	public void eliminarPaciente(Paciente paciente) {
		coleccionDePacientes.remove(coleccionDePacientes.indexOf(paciente));
		grabar();
	}
	
	public List<Paciente> obtenerColeccionDePacientes(){
		return coleccionDePacientes;
	}
	
	public void grabar() {
		File archivo = new File("./paciente.txt");
		FileWriter fileWriter; 
		BufferedWriter bwEscritor; 
		String texto;
		Gson g = new Gson();
		texto = g.toJson(coleccionDePacientes);
		try{
			fileWriter = new FileWriter(archivo);
			fileWriter.write(texto);
			bwEscritor = new BufferedWriter(fileWriter);
			bwEscritor.close();		
		}catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
	}
	
	public ArrayList<Paciente> leer() {
    	ArrayList<Paciente> paciente = new ArrayList<Paciente>();
        String cadena;
        File archivo = new File("./paciente.txt");
        if (archivo.exists())
        {
            FileReader f;
    		try {
    			f = new FileReader(archivo);
    	        BufferedReader b = new BufferedReader(f);
    	        cadena = b.readLine();
    	        JsonParser parser = new JsonParser();
    	        JsonArray gsonArr = parser.parse(cadena).getAsJsonArray();
    	        Gson g = new Gson();
    	        for(JsonElement js : gsonArr)
    	        	paciente.add(g.fromJson(js, Paciente.class));
    	        b.close();
    	        return paciente;
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
        }
		return paciente;
    }
	
		
}
