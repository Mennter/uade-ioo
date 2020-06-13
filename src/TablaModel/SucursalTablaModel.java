package TablaModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import Controllers.SucursalController;
import Model.Sucursal;

public class SucursalTablaModel  extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Sucursal> lista;
	
	protected String[] columnNames = new String[] { "ID Sucursal", "Direccion", "Responsable" }; 
	protected Class[] columnClasses = new Class[] { int.class, String.class, String.class }; 

	public String getColumnName(int col) { return columnNames[col]; } 
	public Class getColumnClass(int col) { return columnClasses[col]; } 
	
	public SucursalTablaModel(SucursalController coleccionDeSucursales) {
		lista = coleccionDeSucursales.getSucursalList();
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) { 
			case 0: return lista.get(rowIndex).getIdSucursal(); 
			case 1: return lista.get(rowIndex).getDireccion();
			case 2: return lista.get(rowIndex).getResponsable();
			default: return null; 
		}
	}
	
	public void agregar(Sucursal sucursal){
		lista.add(sucursal);
		fireTableDataChanged();
	}
	
	public void refresh() {
		fireTableDataChanged();
	}
	
	public void eliminar(int fila){
		lista.remove(fila);
		SucursalController sucursalBusinessObject = new SucursalController();
		sucursalBusinessObject.eliminarSucursal(sucursalBusinessObject.getSucursalObjeto(fila));
		sucursalBusinessObject.grabar();
		fireTableDataChanged();
	}

}
