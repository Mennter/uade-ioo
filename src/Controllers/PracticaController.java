package Controllers;
import java.util.ArrayList;
import java.util.List;

import Model.Practica;
import helpers.DatosJSON;

public class PracticaController extends DatosJSON<Practica> {
	
	//SINGLETON
	private static PracticaController instancia;
	
	public static PracticaController getInstancia()
	{
		if (instancia == null)
			instancia = new PracticaController();
		return instancia;
	}
	

	Practica practica = new Practica();
	
	public PracticaController(){
		super(Practica.class, "./practica.txt");
		leer();
	}
	
	public List<Practica> getPracticaList(){
		return lista;
	}
	
	public Practica getPracticaObjeto(int index){
		return lista.get(index);
	}
	
	public Practica getPractica(int idPractica){
		int i=0;
		int select = -1;
		for (Practica practica: lista) {
			if (idPractica == practica.getIdPractica()) {
				practica = lista.get(i);
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
	
	 
	public void crearPractica(int idPractica, String nombrePractica, int duracionPractica, Boolean isReservada, ArrayList<Practica> Practicas) {
		Practica practica= new Practica(idPractica, nombrePractica, duracionPractica, isReservada,  Practicas);

		lista.add(practica);
		guardar();
	}

	public void modificarPractica(int idPractica, String nombrePractica, int duracionPractica, Boolean isReservada, ArrayList<Practica> coleccionDePracticas) {
		practica.setIdPractica(idPractica);
		practica.setNombrePractica(nombrePractica);
		practica.setDuracionPractica(duracionPractica);
		practica.setIsReservada(isReservada);
		practica.setColeccionDePracticas(coleccionDePracticas);

	}
	
	public void eliminarPractica(Practica practica) {
		lista.remove(lista.indexOf(practica));
		guardar();
	}
	
	public List<Practica> obtenerColeccionDePracticas(){
		return lista;
	}
	
	public Practica obtenerPractica(int idPractica) {
		int i=0;
		int select = -1;
		for (Practica p: lista) {
			if (p.getIdPractica() == idPractica) {
				p = lista.get(i);
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
		
}