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


import Model.Sucursal;
import helpers.DatosJSON;

public class SucursalController extends DatosJSON<Sucursal> {
	

	//CONSTRUCTOR
	public SucursalController() {
		super(Sucursal.class, "./sucursal.txt");
		leer();
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
	public List<Sucursal> getSucursalList(){
		return lista;
	}
	
	public Sucursal getSucursalObjeto(int index){
		return lista.get(index);
	}
	
	public Sucursal getSucursalPorID(String id){
		int i=0;
		int select = -1;
		for (Sucursal sucursal: lista) {
			if (id.equals(sucursal.getIdSucursal())) {
				sucursal = lista.get(i);
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
	
	
	public void crearSucursal(String idSucursal, String direccion, String responsable) {
		Sucursal sucursal = new Sucursal(idSucursal, direccion, responsable);
		lista.add(sucursal);
		guardar();
	}
	
	public void modificarSucursal(Sucursal sucursal, String idSucursal, String direccion, String responsable) {
		sucursal.setDireccion(direccion);
		sucursal.setResponsable(responsable);
		guardar();
	}
	
	public void eliminarSucursal(Sucursal sucursal) {
		lista.remove(lista.indexOf(sucursal));
		guardar();
	}
	
	public List<Sucursal> obtenerTodos(){
		return lista;
	}
	
	public Sucursal obtenerSucursal(String idSucursal) {
		int i = 0;
		int select = -1;
		for (Sucursal s: lista) {
			if (s.getIdSucursal() == idSucursal) {
				s = lista.get(i);
				select = i;
			}
			i ++;
		}
		return lista.get(select);
	}
	

}
