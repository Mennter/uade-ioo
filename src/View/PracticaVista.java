package View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import Controllers.PacienteController;
import Controllers.PracticaController;
import Model.Paciente;
import Model.Practica;
import Principal.Principal;
import TablaModel.PacienteTablaModel;
import TablaModel.PracticaTablaModel;


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
import javax.swing.UIManager;

public class PracticaVista extends JFrame {
	private JFrame frame;
	private JPanel contentPane;
	private JTextField txtPractica;
	private JTable table;
	private JTable tablePracticasDePractica;
	private PracticaTablaModel tablaModel;

	
	public void PantallaPractica() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PracticaVista window = new PracticaVista();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PracticaVista() {
		
		PracticaController coleccionDePracticas = new PracticaController();
		tablaModel = new PracticaTablaModel(coleccionDePracticas);
		initialize();
	}
	
	
	private void AltaPractica() {
		try {
			PracticaABMView dialog = new PracticaABMView(frame);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
			
			if (dialog.getModalResult() == ModalResult.OK) {
				tablaModel.agregar(dialog.getPractica());
				Practica unaPractica = new Practica();
				unaPractica = dialog.getPractica();				
				PracticaController practicaBusinessObject = new PracticaController();
				practicaBusinessObject.crearPractica(unaPractica.getIdPractica(), unaPractica.getNombrePractica(), unaPractica.getDuracionPractica(), unaPractica.getIsReservada(), unaPractica.getColeccionDePracticas());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
	
	
	private void EliminarPractica() {
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
	
	
	private void initialize() {
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
		
		JLabel lblNewLabel = new JLabel("ABM Practicas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		PanelTitulo.add(lblNewLabel);
		
		JPanel PanelBotones = new JPanel();
		contentPane.add(PanelBotones, BorderLayout.SOUTH);
		

		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaPractica();
			}
		});
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EliminarPractica();
			}
		});
		
		JButton btnQuitar = new JButton("Quitar");
		
		JButton btnAgregar = new JButton("Agregar");

		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal atras = new Principal();
				atras.setVisible(true);
				PracticaVista.this.dispose();	
			}
		});
		
		
		
		GroupLayout gl_PanelBotones = new GroupLayout(PanelBotones);
		gl_PanelBotones.setHorizontalGroup(
			gl_PanelBotones.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_PanelBotones.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAtras)
					.addPreferredGap(ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
					.addComponent(btnAlta)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEliminar)
					.addGap(273)
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
						.addComponent(btnEliminar)
						.addComponent(btnAlta)
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
		
		table = new JTable(tablaModel);
		/*
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					modificarPersona();
				}

			}
		});
		*/
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPanePracticas.setViewportView(table);
		
		JPanel PanelPractica = new JPanel();
		contentPane.add(PanelPractica, BorderLayout.EAST);
		PanelPractica.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPractica = new JLabel("Practica");
		lblPractica.setHorizontalAlignment(SwingConstants.CENTER);
		PanelPractica.add(lblPractica, BorderLayout.NORTH);
		
		JPanel panel_4 = new JPanel();
		PanelPractica.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		txtPractica = new JTextField();
		panel_4.add(txtPractica, BorderLayout.NORTH);
		txtPractica.setColumns(10);
		
		JScrollPane scrollPanePracticasDePractica = new JScrollPane();
		panel_4.add(scrollPanePracticasDePractica, BorderLayout.CENTER);
		
		//tablePracticasDePractica = new JTable();
		tablePracticasDePractica = new JTable();
		/*
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					modificarPersona();
				}

			}
		});
		*/
		tablePracticasDePractica.setAutoCreateRowSorter(true);
		tablePracticasDePractica.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);		
		scrollPanePracticasDePractica.setViewportView(tablePracticasDePractica);
		
		
	}
}
