package View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import Controllers.PacienteController;
import Controllers.PeticionController;
import Controllers.PracticaController;
import Model.Paciente;
import Model.Peticion;
import Model.Practica;
import Principal.Principal;
import TablaModel.PacienteTablaModel;
import TablaModel.PracticaTablaModel;
import TablaModel.PracticasDePeticionTablaModel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class PeticionABMPractica extends JFrame {
	private JFrame frame;
	private JPanel contentPane;
	private JTextField txtPeticion;
	private JTable table;
	private JTable tablePracticasDePractica;
	private PracticaTablaModel tablaModel;
	private PracticasDePeticionTablaModel tablaModelDePractica;

	

	
	public void PantallaPractica() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Peticion unaPeticion = new Peticion();
					PeticionABMPractica window = new PeticionABMPractica(unaPeticion);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PeticionABMPractica(Peticion unaPeticion) {
		
		PracticaController coleccionDePracticas = new PracticaController();
		tablaModel = new PracticaTablaModel(coleccionDePracticas);
		
		initialize(unaPeticion);
	}
	

	
	private void quitarPracticaDePeticion() {
		try {
			


		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	

	
	private void agregarPracticaAPeticion(Peticion unaPeticion) {
		try {
			PeticionController PeticionBO = new PeticionController();
			if (table.getSelectedRow() == -1) {
			}
			else {

				Practica unaPractica = new Practica();
				PracticaController coleccionDePracticas = new PracticaController();
				unaPractica= coleccionDePracticas.getPracticaObjeto(table.getSelectedRow());
				
				PeticionBO.agregarPracticaAPeticion(unaPeticion, unaPractica);
				
				tablaModelDePractica.agregar(unaPractica);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	
	
	

	
	
	public void resizeColumnWidth(JTable table) {
	    final TableColumnModel columnModel = table.getColumnModel();
	    for (int column = 0; column < table.getColumnCount(); column++) {
	        int width = 15;
	        for (int row = 0; row < table.getRowCount(); row++) {
	            TableCellRenderer renderer = table.getCellRenderer(row, column);
	            Component comp = table.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1 , width);
	        }
	        if(width > 300)
	            width=300;
	        columnModel.getColumn(column).setPreferredWidth(width);
	    }
	}
	
	
	private void initialize(Peticion unaPeticion) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}	
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 922, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel PanelTitulo = new JPanel();
		contentPane.add(PanelTitulo, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Asociar Practica a Petición");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		PanelTitulo.add(lblNewLabel);
		
		JPanel PanelBotones = new JPanel();
		contentPane.add(PanelBotones, BorderLayout.SOUTH);
		
		
		
		JButton btnQuitar = new JButton("Quitar");
		btnQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				quitarPracticaDePeticion();
			}
		});
		
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PeticionController ColeccionDePeticiones = new PeticionController();
				Peticion unaPeticion  = new Peticion();
				unaPeticion = ColeccionDePeticiones.obtenerPeticion(Integer.parseInt(txtPeticion.getText()));
				agregarPracticaAPeticion(unaPeticion);
			}
		});

		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal atras = new Principal();
				atras.setVisible(true);
				PeticionABMPractica.this.dispose();	
			}
		});
		
		
		
		GroupLayout gl_PanelBotones = new GroupLayout(PanelBotones);
		gl_PanelBotones.setHorizontalGroup(
			gl_PanelBotones.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_PanelBotones.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAtras)
					.addPreferredGap(ComponentPlacement.RELATED, 641, Short.MAX_VALUE)
					.addComponent(btnAgregar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnQuitar)
					.addContainerGap())
		);
		gl_PanelBotones.setVerticalGroup(
			gl_PanelBotones.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_PanelBotones.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_PanelBotones.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAtras)
						.addComponent(btnQuitar)
						.addComponent(btnAgregar))
					.addContainerGap())
		);
		PanelBotones.setLayout(gl_PanelBotones);
		
		JPanel PanelPracticas = new JPanel();
		contentPane.add(PanelPracticas, BorderLayout.WEST);
		PanelPracticas.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPracticas = new JLabel("Listado de Practicas");
		lblPracticas.setHorizontalAlignment(SwingConstants.CENTER);
		PanelPracticas.add(lblPracticas, BorderLayout.NORTH);
		
		JScrollPane scrollPanePracticas = new JScrollPane();
		PanelPracticas.add(scrollPanePracticas, BorderLayout.CENTER);
		
		
		
		tablaModelDePractica = new PracticasDePeticionTablaModel(unaPeticion.getColeccionDePracticas());
		table = new JTable(tablaModel);

		
		
		
		
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPanePracticas.setViewportView(table);
		
		
		
		
		
		
		JPanel PanelPractica = new JPanel();
		contentPane.add(PanelPractica, BorderLayout.EAST);
		PanelPractica.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPeticion = new JLabel("ID Petición");
		lblPeticion.setHorizontalAlignment(SwingConstants.CENTER);
		PanelPractica.add(lblPeticion, BorderLayout.NORTH);
		
		JPanel panel_4 = new JPanel();
		PanelPractica.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		txtPeticion = new JTextField();
		txtPeticion.setEditable(false);
		panel_4.add(txtPeticion, BorderLayout.NORTH);
		txtPeticion.setText(Integer.toString(unaPeticion.getIdPeticion()));
		txtPeticion.setColumns(10);
		
		JScrollPane scrollPanePracticasDePractica = new JScrollPane();
		panel_4.add(scrollPanePracticasDePractica, BorderLayout.CENTER);
		

		tablePracticasDePractica = new JTable(tablaModelDePractica);

		
		
		tablePracticasDePractica.setAutoCreateRowSorter(true);
		tablePracticasDePractica.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);		
		scrollPanePracticasDePractica.setViewportView(tablePracticasDePractica);
		
		
	}
	

}

