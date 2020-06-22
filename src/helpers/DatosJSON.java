package helpers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;



public class DatosJSON<T> {
	
	
	public List<T> lista = new ArrayList<T>();
	
	private final String filePath;
	private final Class<T> type;
	
	public DatosJSON(Class<T> type, String filePath) {
		this.type = type;
		this.filePath = filePath; 
	}
	
	
	
	private Gson g = new GsonBuilder()
            .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeJsonDeserializer())
            .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeJsonSerializer())
            .create();	
	
	
    public void guardar() {
    	File archivo = new File(filePath);
		FileWriter fileWriter; 
		BufferedWriter bwEscritor; 
		String texto;
		
		texto = g.toJson(lista);
		try{
			fileWriter = new FileWriter(archivo);
			fileWriter.write(texto);
			bwEscritor = new BufferedWriter(fileWriter);
			bwEscritor.close();		
		} catch(Exception ex) {
			ex.getStackTrace();
		}
		
    }
    
    public void leer() {
        String cadena;
        File archivo = new File(filePath);
        if (archivo.exists())
        {
            FileReader f;
    		try {
    			f = new FileReader(archivo);
    	        BufferedReader bufferedReader = new BufferedReader(f);
    	        cadena = bufferedReader.readLine();
    	        JsonParser parser = new JsonParser();
    	        JsonArray gsonArr = parser.parse(cadena).getAsJsonArray();
    	        
    	        for(JsonElement js : gsonArr)
    	        	lista.add(g.fromJson(js, type));
    	        
    	        bufferedReader.close();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
        }
    }
}
