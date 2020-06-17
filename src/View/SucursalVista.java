package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.util.ArrayList;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import Controllers.SucursalController;
import Model.Sucursal;
import Controllers.SucursalController;
import Principal.Principal;
import TablaModel.SucursalTablaModel;

public class SucursalVista extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTable table;
	private SucursalTablaModel tablaModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SucursalVista window = new SucursalVista();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SucursalVista() {
		SucursalController coleccionDeSucursales = new SucursalController();
		tablaModel = new SucursalTablaModel(coleccionDeSucursales);
		initialize();
	}
	
	private void agregarSucursal() {
		try {
			SucursalABMView dialog = new SucursalABMView(frame);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			if (dialog.getModalResult() == ModalResult.OK) {
				tablaModel.agregar(dialog.getSucursal());
				Sucursal unaSucursal = new Sucursal();
				unaSucursal = dialog.getSucursal();
				SucursalController sucursalBusinessObject = new SucursalController();
				sucursalBusinessObject.crearSucursal(unaSucursal.getIdSucursal(), unaSucursal.getDireccion(), unaSucursal.getResponsable());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
	
	private void modificarSucursal() {
		try {
			SucursalABMView dialog = new SucursalABMView(frame);
			SucursalController sucursalBusinessObject = new SucursalController();
			if (table.getSelectedRow() == -1) {
				//JOptionPane.showMessageDialog(null, "Debe seleccionar un registro.");
			}
			else {
				dialog.setSucursal(sucursalBusinessObject.getSucursalObjeto(table.getSelectedRow()));
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				if (dialog.getModalResult() == ModalResult.OK) {
					Sucursal unaSucursal = new Sucursal();
					unaSucursal = dialog.getSucursal();
					sucursalBusinessObject.modificarSucursal(unaSucursal, unaSucursal.getIdSucursal(), unaSucursal.getDireccion(), unaSucursal.getResponsable());
					
					
					
					//VILLEREADA (CORTA)
					Principal atras = new Principal();
					atras.setVisible(false);
					SucursalVista.this.dispose();
					SucursalVista nuevaVentana = new SucursalVista();
					nuevaVentana.setVisible(true);
					//
					
					//tablaModel.refresh();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	private void eliminarSucursal() {
		try {
			if (table.getSelectedRow() == -1) {
				//JOptionPane.showMessageDialog(null, "Debe seleccionar un registro.");
			}
			else {
				tablaModel.eliminar(table.getSelectedRow());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	/**
	 * Initialize the contents of the frame.
	 */
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
		
		JLabel lblAbmSucursales = new JLabel("ABM Sucursales");
		lblAbmSucursales.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblAbmSucursales);
		
		JPanel panelBotones = new JPanel();
		getContentPane().add(panelBotones, BorderLayout.SOUTH);
		
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarSucursal();
			}
		});
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarSucursal();
			}
		});
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarSucursal();
			}
			
		});
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal atras = new Principal();
				atras.setVisible(true);
				SucursalVista.this.dispose();	
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
					modificarSucursal();
				}

			}
		});
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(table);
	}

}
