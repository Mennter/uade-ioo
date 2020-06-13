package Controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Model.Rol;
import Model.Usuario;
import helpers.CRUDInterface;
import helpers.DatosJSON;
import helpers.IdGenerator;
import helpers.SHA256Converter;

public class UsuarioController extends DatosJSON<Usuario> implements CRUDInterface<Usuario> {

	public UsuarioController() {
		super(Usuario.class, "./usuarios.txt");
		leer();
	}

    public Usuario crear(String username, String password, String nombre, String domicilio, String dni, ZonedDateTime fechaNacimiento, Rol rol) {
    	if(isUsuarioWithUsername(username) || isUsuarioWithDni(dni)) return null;
    	
        Usuario usuario =  new Usuario(
        		IdGenerator.get(),
        		username,
        		password,
        		nombre,
        		domicilio,
        		dni,
        		fechaNacimiento,
        		rol,
        		false
        		);
        lista.add(usuario);
        guardar();
        return usuario;
    }


    @Override
    public void eliminar(Usuario usuario) {
    	Usuario usuarioAEliminar = obtenerPorId(usuario.getIdUsuario());
    	
    	if (usuarioAEliminar != null) {
    		usuarioAEliminar.setBorrado(true);
        	guardar();
    	}
    	
    }
    
    
    public Usuario login(String username, String pass) {
    	Usuario usuario = getByUsername(username);
    	if(usuario == null || !usuario.getPassword().equals(SHA256Converter.toHash(pass))) {
    		return null;
    	}

    	return usuario;
    }
    
    private boolean isUsuarioWithUsername(String username) {
    	Usuario usuario = getByUsername(username);
    	return usuario != null;
    }
    
    private boolean isUsuarioWithDni(String dni) {
    	Usuario usuario = getByDni(dni);
    	return usuario != null;
    }
    
    private Usuario getByUsername(String username) {
    	return lista.stream()
        		.filter(usuario -> usuario.getUsername().toLowerCase().equals(username.toLowerCase()))
        		.findAny()
        		.orElse(null);
    }
    
    private Usuario getByDni(String dni) {
    	return lista.stream()
        		.filter(usuario -> usuario.getDni().equals(dni))
        		.findAny()
        		.orElse(null);
    }

    @Override
    public Usuario modificar(Usuario usuario) {
    	Usuario usuarioAModificar = obtenerPorId(usuario.getIdUsuario());
    	
    	if(usuarioAModificar != null) {
    		usuarioAModificar.setNombre(usuario.getNombre());
    		usuarioAModificar.setUsername(usuario.getUsername());
    		usuarioAModificar.setDomicilio(usuario.getDomicilio());
    		usuarioAModificar.setDni(usuario.getDni());
    		usuarioAModificar.setFechaNacimiento(usuario.getFechaNacimiento());
    		usuarioAModificar.setRol(usuario.getRol());
    		usuarioAModificar.setBorrado(usuario.getBorrado());
    		usuarioAModificar.setPassword(usuario.getPassword());
    		guardar();
    	}
        return usuarioAModificar;
    }


    @Override
    public List<Usuario> obtenerTodos() {
        return lista.stream().filter(usuario -> {
        	return !usuario.getBorrado();
        }).collect(Collectors.toList());
    }

    @Override
    public Usuario obtenerPorId(Long id) {
        return lista.stream()
        		.filter(usuario -> usuario.getIdUsuario().equals(id))
        		.findAny()
        		.orElse(null);
    }
    
}