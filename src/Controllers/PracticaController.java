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
import Model.Practica;

public class PracticaController {
	
	//SINGLETON
	private static PracticaController instancia;
	public static PracticaController getInstancia()
	{
		if (instancia == null)
			instancia = new PracticaController();
		return instancia;
	}
	

	private ArrayList<Practica> coleccionDePracticas;
	Practica practica = new Practica();
	
	public PracticaController(){
		coleccionDePracticas = leer();
	}
	
	public ArrayList<Practica> getPracticaList(){
		return coleccionDePracticas;
	}
	
	public Practica getPracticaObjeto(int index){
		return coleccionDePracticas.get(index);
	}
	
	public Practica getPractica(int idPractica){
		int i=0;
		int select = -1;
		for (Practica practica: coleccionDePracticas) {
			if (idPractica == practica.getIdPractica()) {
				practica = coleccionDePracticas.get(i);
				select = i;
			}
			i++;
		}
		if (select == -1) {
			return null;
		}else {
			return coleccionDePracticas.get(select);
		}
	}
	
	 
	public void crearPractica(int idPractica, String nombrePractica, int duracionPractica, Boolean isReservada, ArrayList<Practica> Practicas) {
		Practica practica= new Practica(idPractica, nombrePractica, duracionPractica, isReservada,  Practicas);

		coleccionDePracticas.add(practica);
	}

	public void modificarPractica(int idPractica, String nombrePractica, int duracionPractica, Boolean isReservada, ArrayList<Practica> coleccionDePracticas) {
		practica.setIdPractica(idPractica);
		practica.setNombrePractica(nombrePractica);
		practica.setDuracionPractica(duracionPractica);
		practica.setIsReservada(isReservada);
		practica.setColeccionDePracticas(coleccionDePracticas);

	}
	
	public void eliminarPractica(Practica practica) {
		coleccionDePracticas.remove(coleccionDePracticas.indexOf(practica));
		grabar();
	}
	
	public List<Practica> obtenerColeccionDePracticas(){
		return coleccionDePracticas;
	}
	
	public Practica obtenerPractica(int idPractica) {
		int i=0;
		int select = -1;
		for (Practica p: coleccionDePracticas) {
			if (p.getIdPractica() == idPractica) {
				p = coleccionDePracticas.get(i);
				select = i;
			}
			i++;

		}
		if (select == -1) {
			return null;
		}else {
			return coleccionDePracticas.get(select);
		}
		
	}
	
	public void grabar() {
		File archivo = new File("./practica.txt");
		FileWriter fileWriter; 
		BufferedWriter bwEscritor; 
		String texto;
		Gson g = new Gson();
		texto = g.toJson(coleccionDePracticas);
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
	
	public ArrayList<Practica> leer() {
    	ArrayList<Practica> practica = new ArrayList<Practica>();
        String cadena;
        File archivo = new File("./practica.txt");
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
    	        	practica.add(g.fromJson(js, Practica.class));
    	        b.close();
    	        return practica;
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
        }
		return practica;
    }
	
		
}