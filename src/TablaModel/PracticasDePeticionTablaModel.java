package TablaModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Controllers.PracticaController;
import Model.Practica;

public class PracticasDePeticionTablaModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;


	private ArrayList<Practica> lista;
	
	
	
	protected String[] columnNames = new String[] { "ID Practica", "Nombre", "Duracion"}; 
	protected Class[] columnClasses = new Class[] { int.class, String.class, int.class}; 

	public String getColumnName(int col) { return columnNames[col]; } 
	public Class getColumnClass(int col) { return columnClasses[col]; } 
	
	private Practica practica;
	
	public PracticasDePeticionTablaModel(Practica practica)
	{
		PracticaController PracticaBO = new PracticaController();
		lista = PracticaBO.getPracticasDePractica(practica.getIdPractica()); 
		refresh();
		
	}
	
	public PracticasDePeticionTablaModel(){
		lista = new ArrayList<Practica>();
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
	
	public void setPracticaMadre(Practica practica) {
		borrarTodo();
		this.practica = practica;
		ArrayList<Practica> practicas = this.practica.getColeccionDePracticas();
		
		
		for (Practica p: practicas) {
			agregar(p);
		}	
		
	}
	
	public void eliminar(int fila){
		
		lista.remove(fila);
		

		
		this.practica.setColeccionDePracticas(lista);

		modificarPractica();
		
		fireTableDataChanged();
	}
	
	private void borrarTodo() {
		lista.clear();
		fireTableDataChanged();
	}
	
	
	private void modificarPractica() {
		PracticaController practicaBusinessObject = new PracticaController();
		practicaBusinessObject.modificarPractica(this.practica.getIdPractica(), 
				this.practica.getNombrePractica(), 
				this.practica.getDuracionPractica(), 
				false,
				this.practica.getColeccionDePracticas());
	}

}