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
		Practica practica = getPractica(idPractica);
		
		practica.setIdPractica(idPractica);
		practica.setNombrePractica(nombrePractica);
		practica.setDuracionPractica(duracionPractica);
		practica.setIsReservada(isReservada);
		practica.setColeccionDePracticas(coleccionDePracticas);
		guardar();
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

	public int getIdPracticaPorNombre(String text) {
		return lista.stream()
        		.filter(practica -> practica.getNombrePractica().equals(text))
        		.map(practica -> practica.getIdPractica())
        		.findAny()
        		.orElse(null);
	}

	public void agregarPracticaAPractica(Practica practicaMadre, Practica practicaHija) {
		Practica practica = getPractica(practicaMadre.getIdPractica());
		practica.getColeccionDePracticas().add(practicaHija);
		guardar();
	}

	public ArrayList<Practica> getPracticasDePractica(int idPractica) {
		Practica practica = this.getPractica(idPractica);
		
		return practica.getColeccionDePracticas();
	}
		
}