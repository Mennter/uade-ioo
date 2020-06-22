package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.UsuarioController;
import Model.Usuario;
import Principal.Principal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class Loginapp extends JFrame {

private JPanel contentPane;
	
	private JTextField usuarioField = new JTextField();
	
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
					Loginapp frame = new Loginapp();
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
	public Loginapp() {		
		
		JFrame myFrame = new JFrame();
		myFrame.setLocation(100, 100);
		myFrame.setSize(new Dimension(450, 300));

		GridLayout layout = new GridLayout(1, 2);
		myFrame.getContentPane().setLayout(layout);

		JPanel jp = new JPanel();
		jp.setBackground(new Color(16,30,46));

		JPanel jp2 = new JPanel();
		

		myFrame.getContentPane().add(jp);
		myFrame.getContentPane().add(jp2);
		
		usuarioField = new JTextField();
		usuarioField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Ver contrase\u00F1a");
		
		chckbxNewCheckBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED) {
					passwordField.setEchoChar((char)0);			
				} else {
					passwordField.setEchoChar('*');
				}
				
			}
        });
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				acceder();
			}
		});
		
		JLabel lblNewLabel = new JLabel("UADE Laboratorio");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		GroupLayout gl_jp2 = new GroupLayout(jp2);
		gl_jp2.setHorizontalGroup(
			gl_jp2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jp2.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_jp2.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxNewCheckBox, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
						.addGroup(gl_jp2.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(usuarioField, Alignment.LEADING)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(passwordField, Alignment.LEADING))
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_jp2.setVerticalGroup(
			gl_jp2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jp2.createSequentialGroup()
					.addGap(40)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(usuarioField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxNewCheckBox)
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap(58, Short.MAX_VALUE))
		);
		jp2.setLayout(gl_jp2);

		myFrame.setVisible(true);
		
	}
	
	
	private void acceder() {
		
		UsuarioController uController = new UsuarioController();
		Usuario usuario = uController.login(usuarioField.getText(), new String(passwordField.getPassword()));
		
		if (usuario == null) {
			JOptionPane.showMessageDialog(null, "Usuario y/o contrasena es incorrecto");
		} else {
			Principal nuevaVentana = new Principal(usuario);
			nuevaVentana.setVisible(true);
			Loginapp.this.dispose();
		}
		
		
	}
}
