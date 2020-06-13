package helpers;

import java.util.List;

public interface CRUDInterface<T> {
	
	public void eliminar(T entidad);
	
	public T modificar(T entidad);
	
	public List<T> obtenerTodos();
	
	
	public T obtenerPorId(Long id);
	
	
}
