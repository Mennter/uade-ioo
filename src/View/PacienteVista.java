package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import java.awt.Rectangle;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import Controllers.PacienteController;
import Model.Paciente;
import Principal.Principal;
import TablaModel.PacienteTablaModel;


import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PacienteVista extends JFrame {
	private JTable table;
	private JFrame frame;
	private PacienteController coleccionDePacientes;
	private PacienteTablaModel tablaModel;

	

	public void PantallaPaciente() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PacienteVista window = new PacienteVista();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public PacienteVista() {
		
		PacienteController coleccionDePacientes = new PacienteController();
		tablaModel = new PacienteTablaModel(coleccionDePacientes);
		initialize();
	}
	
	private void agregarPersona() {
		try {
			PacienteABMView dialog = new PacienteABMView(frame);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			if (dialog.getModalResult() == ModalResult.OK) {
				tablaModel.agregar(dialog.getPaciente());
				Paciente unPaciente = new Paciente();
				unPaciente = dialog.getPaciente();
				PacienteController pacienteBusinessObject = new PacienteController();
				pacienteBusinessObject.crearPaciente(unPaciente.getDni(), unPaciente.getNombre(), unPaciente.getApellido(), unPaciente.getDomicilio(), unPaciente.getMail(), unPaciente.getSexo(), unPaciente.getFechaNacimiento(), unPaciente.getObraSocial());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
	
	private void modificarPersona() {
		try {
			PacienteABMView dialog = new PacienteABMView(frame);
			PacienteController pacienteBusinessObject = new PacienteController();
			if (table.getSelectedRow() == -1) {
				
			}
			else {
				dialog.setPaciente(pacienteBusinessObject.getPacienteObjeto(table.getSelectedRow()));
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				if (dialog.getModalResult() == ModalResult.OK) {
					Paciente unPaciente = new Paciente();
					unPaciente = dialog.getPaciente();
					pacienteBusinessObject.modificarPaciente(unPaciente, unPaciente.getDni(), unPaciente.getNombre(), unPaciente.getApellido(), unPaciente.getDomicilio(), unPaciente.getMail(), unPaciente.getSexo(), unPaciente.getFechaNacimiento(), unPaciente.getObraSocial());					
					
					
					//ALTA NEGRADA
					
					Principal atras = new Principal();
					atras.setVisible(false);
					PacienteVista.this.dispose();
					PacienteVista nuevaVentana = new PacienteVista();
					nuevaVentana.setVisible(true);
					
					
					//tablaModel.fireTableDataChanged();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	private void eliminarPersona() {
		try {
			if (table.getSelectedRow() == -1) {
			}
			else {
				tablaModel.eliminar(table.getSelectedRow());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void resizeColumnWidth(JTable table) {
	    final TableColumnModel columnModel = table.getColumnModel();
	    for (int column = 0; column < table.getColumnCount(); column++) {
	        int width = 15; // Min width
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
	
	private void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 330);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblAbmPacientes = new JLabel("ABM Pacientes");
		lblAbmPacientes.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblAbmPacientes);
		
		JPanel panelBotones = new JPanel();
		getContentPane().add(panelBotones, BorderLayout.SOUTH);
		
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarPersona();
			}
		});
		
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarPersona();
			}
		});
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarPersona();
				

			}
			
		});
		
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal atras = new Principal();
				atras.setVisible(true);
				PacienteVista.this.dispose();	
			}
		});
		
		
		
		
		
		GroupLayout gl_panelBotones = new GroupLayout(panelBotones);
		gl_panelBotones.setHorizontalGroup(
			gl_panelBotones.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelBotones.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAtras)
					.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
					.addComponent(btnAgregar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnModificar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEliminar)
					.addContainerGap())
		);
		gl_panelBotones.setVerticalGroup(
			gl_panelBotones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBotones.createSequentialGroup()
					.addGroup(gl_panelBotones.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEliminar)
						.addComponent(btnModificar)
						.addComponent(btnAgregar)
						.addComponent(btnAtras))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelBotones.setLayout(gl_panelBotones);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		
		table = new JTable(tablaModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					modificarPersona();
				}

			}
		});
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(table);

	}

}
