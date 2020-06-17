package Controllers;
import java.util.List;

import Model.Peticion;
import helpers.DatosJSON;


public class PeticionController extends DatosJSON<Peticion> {
		
	//CONSTRUCTOR
	public PeticionController(){
		super(Peticion.class, "./peticion.txt");
		leer();
	}
	

	//SINGLETON
	private static PeticionController instancia;
	public static PeticionController getInstancia()
	{
		if (instancia == null)
			instancia = new PeticionController();
		return instancia;
	}

	
	public List<Peticion> getPeticionList(){
		return lista;
	}
	
	public Peticion getPeticionObjeto(int index){
		return lista.get(index);
	}
	

	public void crearPeticion(int idPeticion, String dniPaciente, String fechaCarga, String fechaEntrega, String idSucursal, int cantPracticas){
		Peticion peticion= new Peticion(idPeticion, dniPaciente, fechaCarga, fechaEntrega, idSucursal, cantPracticas);
		lista.add(peticion);
		guardar();
	}

	//METODO ELIMINAR PETICION
	public void eliminarPeticion(Peticion peticion) {
		lista.remove(lista.indexOf(peticion));
		guardar();
	}
	
	
	//METODO QUE RETORNA PETICION USANDO ID
	public Peticion obtenerPeticion(int idPeticion) {
		int i=0;
		int select = -1;
		for (Peticion p: lista) {
			if (p.getIdPeticion() == idPeticion) {
				p = lista.get(i);
				select = i;
			}
			i++;

		}
		if (select == -1) {
			return null;
		} else {
			return lista.get(select);
		}
	}
	
		
}
