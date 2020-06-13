package TablaModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Controllers.PacienteController;
import Model.Paciente;

public class PacienteTablaModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private ArrayList<Paciente> lista;
	
	protected String[] columnNames = new String[] { "DNI", "Nombre", "Apellido", "Domicilio", "Mail", "Sexo", "Fecha de Nacimiento", "Obra Social"}; 
	protected Class[] columnClasses = new Class[] { int.class, String.class, String.class, String.class, String.class, String.class,String.class,String.class}; 

	public String getColumnName(int col) { return columnNames[col]; } 
	public Class getColumnClass(int col) { return columnClasses[col]; } 
	
	public PacienteTablaModel(PacienteController coleccionDePacientes)
	{
		lista = coleccionDePacientes.getPacienteList();
		
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
			case 0: return lista.get(rowIndex).getDni(); 
			case 1: return lista.get(rowIndex).getNombre();
			case 2: return lista.get(rowIndex).getApellido();
			case 3: return lista.get(rowIndex).getDomicilio();
			case 4: return lista.get(rowIndex).getMail();
			case 5: return lista.get(rowIndex).getSexo();
			case 6: return lista.get(rowIndex).getFechaNacimiento();
			case 7: return lista.get(rowIndex).getObraSocial();
			default: return null; 
		}
	}
	
	public void agregar(Paciente paciente){
		lista.add(paciente);
		fireTableDataChanged();
	}
	
	public void refresh() {
		fireTableDataChanged();
	}
	
	public void eliminar(int fila){
		lista.remove(fila);
		PacienteController pacienteBusinessObject = new PacienteController();
		pacienteBusinessObject.eliminarPaciente(pacienteBusinessObject.getPacienteObjeto(fila));
		pacienteBusinessObject.grabar();
		fireTableDataChanged();
	}
	

}