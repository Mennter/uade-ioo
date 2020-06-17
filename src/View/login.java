package View;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Controllers.UsuarioController;
import Model.Usuario;
import Principal.Principal;
import javax.swing.JCheckBox;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;

public class login extends JFrame {

	private JPanel contentPane;
	
	private TextField usuarioField = new TextField();
	
	private JPasswordField passwordField = new JPasswordField();
	
	private KeyListener keyListener = new KeyListener(){

		@Override
		public void keyPressed(KeyEvent arg0) {
			if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
				acceder();
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	};

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
		setType(Type.UTILITY);
		setUndecorated(true);
		
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(16,30,46));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usuarioField.setBounds(117, 60, 190, 22);
		usuarioField.addKeyListener(this.keyListener);
		
		contentPane.add(usuarioField);
		passwordField.setEchoChar('*');
		passwordField.setBounds(117, 108, 190, 22);
		passwordField.addKeyListener(this.keyListener);

		
		
		contentPane.add(passwordField);
		
		Button button = new Button("Login");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				acceder();
			}
		});
		
		button.addKeyListener(this.keyListener);
		button.setBounds(117, 168, 190, 22);
		contentPane.add(button);
		
		JCheckBox chckbxPass = new JCheckBox("Ver contrase\u00F1a");
		chckbxPass.setBounds(117, 137, 128, 23);
		chckbxPass.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED) {
					passwordField.setEchoChar((char)0);			
				} else {
					passwordField.setEchoChar('*');
				}
				
			}
        });
		contentPane.add(chckbxPass);
	}
	
	
	
	private void acceder() {
		
		UsuarioController uController = new UsuarioController();
		Usuario usuario = uController.login(usuarioField.getText(), new String(passwordField.getPassword()));
		
		if (usuario == null) {
			JOptionPane.showMessageDialog(null, "Usuario y/o contrasena es incorrecto");
		} else {
			Principal nuevaVentana = new Principal(usuario);
			nuevaVentana.setVisible(true);
			login.this.dispose();
		}
		
		
	}
}
