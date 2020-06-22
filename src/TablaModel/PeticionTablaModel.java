package TablaModel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import Controllers.PacienteController;
import Controllers.PeticionController;
import Model.ObraSocial;
import Model.Paciente;
import Model.Peticion;
import Model.Sucursal;

public class PeticionTablaModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;

	
	private List<Peticion> lista;
	
	protected String[] columnNames = new String[] { "ID Peticion", "DNI Paciente", "Fecha carga", "Fecha Entrega", "ID Sucursal", "Practicas"}; 
	protected Class[] columnClasses = new Class[] { int.class, String.class, String.class, String.class, String.class, String.class, ArrayList.class}; 

	public String getColumnName(int col) { return columnNames[col]; } 
	public Class getColumnClass(int col) { return columnClasses[col]; } 
	
	public PeticionTablaModel(PeticionController coleccionDePeticiones)
	{
		lista = coleccionDePeticiones.getPeticionList();
		
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	@Override
	public int getRowCount() {
		return lista.size();

	}
    @Override
    public boolean isCellEditable(int row, int column){
    	return false;
    }
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) 
		{ 

		
			case 0: return lista.get(rowIndex).getIdPeticion(); 
			case 1: return lista.get(rowIndex).getUnPaciente();
			case 2: return lista.get(rowIndex).getFechaCarga();
			case 3: return lista.get(rowIndex).getFechaEntrega();
			case 4: return lista.get(rowIndex).getUnaSucursal();
			case 5: return lista.get(rowIndex).getColeccionDePracticas().size();
			default: return null; 
		}
	}
	
	public void agregar(Peticion peticion){
		lista.add(peticion);
		fireTableDataChanged();
	}
	
	public void refresh() {
		fireTableDataChanged();
	}
	
	public void eliminar(int fila){
		lista.remove(fila);
		PeticionController peticionBusinessObject = new PeticionController();
		peticionBusinessObject.eliminarPeticion(peticionBusinessObject.getPeticionObjeto(fila));
		fireTableDataChanged();
	}
	


}
