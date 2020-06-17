package TablaModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Controllers.PracticaController;
import Model.Practica;

public class PracticaTablaModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;


	private List<Practica> lista;
	
	
	
	protected String[] columnNames = new String[] { "ID Practica", "Nombre", "Duracion", "Reservada", "Asociadas"}; 
	protected Class[] columnClasses = new Class[] { int.class, String.class, int.class, Boolean.class, ArrayList.class}; 

	public String getColumnName(int col) { return columnNames[col]; } 
	public Class getColumnClass(int col) { return columnClasses[col]; } 
	
	public PracticaTablaModel(PracticaController coleccionDePracticas)
	{
		lista = coleccionDePracticas.getPracticaList();
		
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
			case 0: return lista.get(rowIndex).getIdPractica();
			case 1: return lista.get(rowIndex).getNombrePractica();
			case 2: return lista.get(rowIndex).getDuracionPractica();
			case 3: return lista.get(rowIndex).getIsReservada();
			case 4: return lista.get(rowIndex).getColeccionDePracticas();
			default: return null; 
		}
	}
	
	public void agregar(Practica practica){
		lista.add(practica);
		fireTableDataChanged();
	}
	
	public void refresh() {
		fireTableDataChanged();
	}
	
	public void eliminar(int fila){
		lista.remove(fila);
		PracticaController practicaBusinessObject = new PracticaController();
		practicaBusinessObject.eliminarPractica(practicaBusinessObject.getPracticaObjeto(fila));
		fireTableDataChanged();
	}
	

}