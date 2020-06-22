package View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import Controllers.PacienteController;
import Controllers.PeticionController;
import Controllers.PracticaController;
import Controllers.SucursalController;
import Model.ObraSocial;
import Model.Paciente;
import Model.Peticion;
import Model.Practica;
import Model.Sucursal;
import Principal.Principal;
import TablaModel.PacienteTablaModel;
import TablaModel.PeticionTablaModel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class PeticionVista extends JFrame {
	private JPanel contentPane;
	private JFrame frame;
	private JTable table;
	private PeticionController coleccionDePeticiones;
	private PeticionTablaModel tablaModel;
	private JTextField textField;
	private JTextField txtDNI;
	private JTextField txtIdSucursal;


	public void PantallaPeticion() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PeticionVista window = new PeticionVista();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PeticionVista() {
		PeticionController coleccionDePeticiones = new PeticionController();
		tablaModel = new PeticionTablaModel(coleccionDePeticiones);
		initialize();
	}
	
	private void AgregarPeticion() {
		try 
		{
			PacienteController coleccionDePacientes = new PacienteController();
			SucursalController coleccionDeSucursales = new SucursalController();
			Paciente unPaciente = new Paciente();
			unPaciente = coleccionDePacientes.getPacientePorDni(txtDNI.getText());
			Sucursal unaSucursal = new Sucursal();
			unaSucursal = coleccionDeSucursales.getSucursalPorID(txtIdSucursal.getText());
			if ((unPaciente == null) || (unaSucursal == null )) {
				JOptionPane.showMessageDialog(null, "DNI O SUCURSAL INEXISTENTE");
				
			}else {
				PeticionController coleccionDePeticiones = new PeticionController();	
				int idPeticion = buscarIDPeticion();
				coleccionDePeticiones.crearPeticion(idPeticion, unPaciente.getDni(), FechaDePeticion(), "", unaSucursal.getIdSucursal(), new ArrayList<Practica>());
				tablaModel.agregar(coleccionDePeticiones.obtenerPeticion(idPeticion));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}	
		
	private void EliminarPeticion() {
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
	
	private void ModificarPeticionPorDNI() {
		try 
		{

			
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}	
	
	private void BuscarPeticionesCriticas() {
		try 
		{

			
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}	
	
	private void BuscarPeticionesReservadas() {
		try 
		{

			
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}	
	
	
	private void AgregarPracticaAPeticion() {
		
		try {
			
			PeticionController coleccionDePeticiones = new PeticionController();
			Peticion unaPeticion = new Peticion();
			unaPeticion = coleccionDePeticiones.getPeticionObjeto(table.getSelectedRow());
			PeticionABMPractica ventana = new PeticionABMPractica(unaPeticion);
			
			if (table.getSelectedRow() == -1) {
				
			}
			else {
				
				unaPeticion = coleccionDePeticiones.getPeticionObjeto(table.getSelectedRow());
				ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				ventana.setVisible(true);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	
	private String FechaDePeticion() {  
    	Date myDate = new Date();
    	return new SimpleDateFormat("dd/MM/yyyy").format(myDate).toString();
    }
    
	private int buscarIDPeticion() {
		int p = 0001;
		PeticionController coleccionDePeticiones = new PeticionController();

		while (coleccionDePeticiones.obtenerPeticion(p) != null){
				p++;
		}
		return p;
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
		setBounds(100, 100, 575, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblDniUsuario = new JLabel("DNI Paciente:");
		
		JButton btnCriticas = new JButton("Criticas");
		btnCriticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BuscarPeticionesCriticas();
			}
		});
		
		JButton btnReservadas = new JButton("Reservadas");
		btnReservadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BuscarPeticionesReservadas();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("ID Sucursal:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		
		txtIdSucursal = new JTextField();
		txtIdSucursal.setColumns(10);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDniUsuario)
								.addComponent(lblNewLabel_1))
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtIdSucursal)
								.addComponent(txtDNI))
							.addGap(206)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnCriticas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnReservadas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(4)))
					.addGap(3))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDniUsuario)
						.addComponent(txtDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCriticas))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_1)
							.addComponent(btnReservadas))
						.addComponent(txtIdSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		

		table = new JTable(tablaModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					AgregarPracticaAPeticion();
				}

			}
		});
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(table);
		
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarPeticionPorDNI();
			}
		});
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EliminarPeticion();
			}
		});
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarPeticion();
			}
		});
		
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal atras = new Principal();
				atras.setVisible(true);
				PeticionVista.this.dispose();	
			}
		});
		

		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(btnAtras)
					.addPreferredGap(ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
					.addComponent(btnAgregar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEliminar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnModificar)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAtras)
						.addComponent(btnModificar)
						.addComponent(btnEliminar)
						.addComponent(btnAgregar))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("ABM PETICIONES");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel);
		contentPane.setLayout(gl_contentPane);
	}
}
