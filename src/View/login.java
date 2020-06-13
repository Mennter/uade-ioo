package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.UsuarioController;
import Model.Usuario;
import Principal.Principal;

import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login extends JFrame {

	private JPanel contentPane;
	
	private TextField usuarioField = new TextField();
	
	private TextField passwordField = new TextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		TextField textField = new TextField();
		usuarioField.setBounds(117, 60, 190, 22);
		contentPane.add(usuarioField);
//		
//		TextField textField_1 = new TextField();
		passwordField.setBounds(117, 108, 190, 22);
		contentPane.add(passwordField);
		
		Button button = new Button("Login");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				acceder();
			}
		});
		button.setBounds(115, 148, 192, 22);
		contentPane.add(button);
	}
	
	
	
	private void acceder() {
		
		UsuarioController uController = new UsuarioController();
		Usuario usuario = uController.login(usuarioField.getText(), passwordField.getText());
		
		if (usuario == null) {
			JOptionPane.showMessageDialog(null, "Usuario y/o contrasena es incorrecto");
		} else {
			//JOptionPane.showMessageDialog(null, "Has logeado exitosamente ");
			
					//SJacobson
			
					Principal nuevaVentana = new Principal(usuario);
					nuevaVentana.setVisible(true);
					
					
					login.this.dispose();
				
		
			
		}
		
		
	}
	
	
	
}
