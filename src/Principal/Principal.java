package Principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import View.PacienteVista;
import View.PeticionVista;
import View.PracticaVista;
import View.SucursalVista;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import Model.Usuario;

import java.awt.Color;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JTextField txtNombre;
	private JTextField txtDomicilio;
	private JTextField txtRol;



	public static Usuario usuario;


	public Principal(Usuario usuario) {
		
		this.usuario = usuario;

		
		txtUserName = new JTextField();
		txtUserName.setText(usuario.getUsername());
		txtUserName.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setText(usuario.getNombre());
		txtNombre.setColumns(10);
		
		txtDomicilio = new JTextField();
		txtDomicilio.setText(usuario.getDomicilio());
		txtDomicilio.setColumns(10);
		
		txtRol = new JTextField();
		txtRol.setText("Administrador");
		txtRol.setText(usuario.getRol().getNombreRol());
		
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JButton btnPaciente = new JButton("PACIENTES");
		btnPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PacienteVista nuevaVentana = new PacienteVista();
				nuevaVentana.setVisible(true);
				Principal.this.dispose();
			}
		});
		
		JButton btnSucursal = new JButton("SUCURSALES");
		btnSucursal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SucursalVista Sucursal = new SucursalVista();
				Sucursal.setVisible(true);
				Principal.this.dispose();
			}
		});
		
		JButton btnPeticion = new JButton("PETICIONES");
		btnPeticion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PeticionVista Peticion = new PeticionVista();
				Peticion.setVisible(true);
				Principal.this.dispose();
			}
		});
		
		JButton btnPractica = new JButton("PRACTICAS");
		btnPractica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PracticaVista Practica = new PracticaVista();
				Practica.setVisible(true);
				Principal.this.dispose();
			}
		});
		
		
		JButton btnResultado = new JButton("RESULTADOS");
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSucursal, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
								.addComponent(btnPeticion, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
								.addComponent(btnPractica, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
								.addComponent(btnResultado, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
								.addComponent(btnPaciente, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnPaciente)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSucursal)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnPeticion)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnPractica)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnResultado))
						.addComponent(panel_1, 0, 0, Short.MAX_VALUE))
					.addGap(22))
		);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("USUARIO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_2 = new JLabel("Nombre de Usuario:");
		
		JLabel lblNewLabel_3 = new JLabel("Nombre:");
		
		JLabel lblNewLabel_4 = new JLabel("Domicilio:");
		
		JLabel lblNewLabel_5 = new JLabel("Rol:");
		

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(106)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtUserName, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addGap(18)
									.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_5))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(txtRol, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
								.addComponent(txtDomicilio, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(txtUserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(txtDomicilio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(txtRol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		

		JLabel lblNewLabel = new JLabel("SISTEMA CLINICA");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	public Principal() {
		

		txtUserName = new JTextField();
		txtUserName.setText(usuario.getUsername());
		txtUserName.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setText(usuario.getNombre());
		txtNombre.setColumns(10);
		
		txtDomicilio = new JTextField();
		txtDomicilio.setText(usuario.getDomicilio());
		txtDomicilio.setColumns(10);
		
		txtRol = new JTextField();
		txtRol.setText("Administrador");
		txtRol.setText(usuario.getRol().getNombreRol());
		
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JButton btnPaciente = new JButton("PACIENTES");
		btnPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PacienteVista nuevaVentana = new PacienteVista();
				nuevaVentana.setVisible(true);
				Principal.this.dispose();
			}
		});
		
		JButton btnSucursal = new JButton("SUCURSALES");
		btnSucursal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SucursalVista Sucursal = new SucursalVista();
				Sucursal.setVisible(true);
				Principal.this.dispose();
			}
		});
		
		JButton btnPeticion = new JButton("PETICIONES");
		btnPeticion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PeticionVista Peticion = new PeticionVista();
				Peticion.setVisible(true);
				Principal.this.dispose();
			}
		});
		
		JButton btnPractica = new JButton("PRACTICAS");
		btnPractica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PracticaVista Practica = new PracticaVista();
				Practica.setVisible(true);
				Principal.this.dispose();
			}
		});
		
		
		JButton btnResultado = new JButton("RESULTADOS");
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSucursal, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
								.addComponent(btnPeticion, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
								.addComponent(btnPractica, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
								.addComponent(btnResultado, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
								.addComponent(btnPaciente, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnPaciente)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSucursal)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnPeticion)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnPractica)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnResultado))
						.addComponent(panel_1, 0, 0, Short.MAX_VALUE))
					.addGap(22))
		);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("USUARIO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_2 = new JLabel("Nombre de Usuario:");
		
		JLabel lblNewLabel_3 = new JLabel("Nombre:");
		
		JLabel lblNewLabel_4 = new JLabel("Domicilio:");
		
		JLabel lblNewLabel_5 = new JLabel("Rol:");
		

		
		
		

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(106)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtUserName, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addGap(18)
									.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_5))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(txtRol, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
								.addComponent(txtDomicilio, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(txtUserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(txtDomicilio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(txtRol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		

		JLabel lblNewLabel = new JLabel("SISTEMA CLINICA");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	
}
