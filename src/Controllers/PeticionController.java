package Controllers;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


import Model.Peticion;


public class PeticionController {
		
	//ATRIBUTO
	private ArrayList<Peticion> coleccionDePeticiones;
	
	Peticion peticion = new Peticion();
	
	//CONSTRUCTOR
	public PeticionController(){
		coleccionDePeticiones = leer();
	}
	

	//SINGLETON
	private static PeticionController instancia;
	public static PeticionController getInstancia()
	{
		if (instancia == null)
			instancia = new PeticionController();
		return instancia;
	}

	
	public ArrayList<Peticion> getPeticionList(){
		return coleccionDePeticiones;
	}
	
	public Peticion getPeticionObjeto(int index){
		return coleccionDePeticiones.get(index);
	}
	

	public void crearPeticion(int idPeticion, String dniPaciente, String fechaCarga, String fechaEntrega, String idSucursal, int cantPracticas){
		Peticion peticion= new Peticion(idPeticion, dniPaciente, fechaCarga, fechaEntrega, idSucursal, cantPracticas);
		coleccionDePeticiones.add(peticion);
	}

	//METODO ELIMINAR PETICION
	public void eliminarPeticion(Peticion peticion) {
		coleccionDePeticiones.remove(coleccionDePeticiones.indexOf(peticion));
		grabar();
	}
	
	
	//METODO QUE RETORNA PETICION USANDO ID
	public Peticion obtenerPeticion(int idPeticion) {
		int i=0;
		int select = -1;
		for (Peticion p: coleccionDePeticiones) {
			if (p.getIdPeticion() == idPeticion) {
				p = coleccionDePeticiones.get(i);
				select = i;
			}
			i++;

		}
		if (select == -1) {
			return null;
		}else {
			return coleccionDePeticiones.get(select);
		}
	}
	
		
	public void grabar() {
		File archivo = new File("./peticion.txt");
		FileWriter fileWriter; 
		BufferedWriter bwEscritor; 
		String texto;
		Gson g = new Gson();
		texto = g.toJson(coleccionDePeticiones);
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
	
	public ArrayList<Peticion> leer() {
    	ArrayList<Peticion> peticion = new ArrayList<Peticion>();
        String cadena;
        File archivo = new File("./peticion.txt");
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
    	        	peticion.add(g.fromJson(js, Peticion.class));
    	        b.close();
    	        return peticion;
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
        }
		return peticion;
    }
	
	
	
		
}
