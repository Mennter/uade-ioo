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


import Model.Sucursal;

public class SucursalController {
	
	//ATRIBUTOS	
	private ArrayList<Sucursal> coleccionDeSucursales;
	
	Sucursal sucursal = new Sucursal();
	
	//CONSTRUCTOR
	public SucursalController(){
		coleccionDeSucursales = leer();
	}
		
	//SINGLETON
	private static SucursalController instancia;
	private static SucursalController getInstancia()
	{
		if (instancia == null)
			instancia = new SucursalController();
		return instancia;
	}
	
	//METODOS
	public ArrayList<Sucursal> getSucursalList(){
		return coleccionDeSucursales;
	}
	
	public Sucursal getSucursalObjeto(int index){
		return coleccionDeSucursales.get(index);
	}
	
	public Sucursal getSucursalPorID(String id){
		int i=0;
		int select = -1;
		for (Sucursal sucursal: coleccionDeSucursales) {
			if (id.equals(sucursal.getIdSucursal())) {
				sucursal = coleccionDeSucursales.get(i);
				select = i;
			}
			i++;
		}
		
		if (select == -1) {
			return null;
		}else {
			return coleccionDeSucursales.get(select);
		}
	}
	
	
	public void crearSucursal(String idSucursal, String direccion, String responsable) {
		Sucursal sucursal = new Sucursal(idSucursal, direccion, responsable);
		coleccionDeSucursales.add(sucursal);
	}
	
	public void modificarSucursal(Sucursal sucursal, String idSucursal, String direccion, String responsable) {
		sucursal.setDireccion(direccion);
		sucursal.setResponsable(responsable);
	}
	
	public void eliminarSucursal(Sucursal sucursal) {
		coleccionDeSucursales.remove(coleccionDeSucursales.indexOf(sucursal));
		grabar();
	}
	
	public ArrayList<Sucursal> obtenerTodos(){
		return coleccionDeSucursales;
	}
	
	public Sucursal obtenerSucursal(String idSucursal) {
		int i = 0;
		int select = -1;
		for (Sucursal s: coleccionDeSucursales) {
			if (s.getIdSucursal() == idSucursal) {
				s = coleccionDeSucursales.get(i);
				select = i;
			}
			i ++;
		}
		return coleccionDeSucursales.get(select);
	}
	
	public void grabar() {
		File archivo = new File("./sucursal.txt");
		FileWriter fileWriter; 
		BufferedWriter bwEscritor; 
		String texto;
		Gson g = new Gson();
		texto = g.toJson(coleccionDeSucursales);
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
	
	public ArrayList<Sucursal> leer() {
    	ArrayList<Sucursal> sucursal = new ArrayList<Sucursal>();
        String cadena;
        File archivo = new File("./sucursal.txt");
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
    	        	sucursal.add(g.fromJson(js, Sucursal.class));
    	        b.close();
    	        return sucursal;
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
        }
		return sucursal;
    }
	
	
}
