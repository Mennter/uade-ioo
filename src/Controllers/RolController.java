package Controllers;


import java.util.List;

import Model.Rol;
import helpers.CRUDInterface;
import helpers.DatosJSON;
import helpers.IdGenerator;

public class RolController  extends DatosJSON<Rol> implements CRUDInterface<Rol> {

	public RolController() {
		super(Rol.class, "./roles.txt");
		leer();
	}

	public Rol crear(String nombreRol, List<String> acciones) {
		Rol rol = new Rol(IdGenerator.get(), nombreRol, acciones);
		lista.add(rol);
		guardar();
		return rol;
	}

	@Override
	public void eliminar(Rol rol) {
		Rol rolBorrar = obtenerPorId(rol.getIdRol());
		if (rolBorrar != null) {
			lista.remove(rol);
		}
	}

	@Override
	public Rol modificar(Rol entidad) {
		Rol rol = obtenerPorId(entidad.getIdRol());
		if (rol != null)  {
			rol.setNombreRol(entidad.getNombreRol());
			rol.setAcciones(entidad.getAcciones());
		}
		return rol;
	}

	@Override
	public List<Rol> obtenerTodos() {
		return lista;
	}

	@Override
	public Rol obtenerPorId(Long id) {
		return lista.stream()
		.filter(rol -> rol.getIdRol().equals(id))
		.findAny()
		.orElse(null);
	}
	
	

}
