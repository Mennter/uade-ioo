package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import Controllers.PacienteController;
import Model.Paciente;
import javax.swing.JRadioButton;

public class PacienteABMView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDNI;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JFormattedTextField txtFNacimiento;
	private JTextField txtDomicilio;
	private JTextField txtEmail;
	private JTextField txtSexo;
	private JTextField txtObraSocial;
	private Paciente paciente = new Paciente(); 
	private ModalResult modalResult;
	
	PacienteController pacienteBusinessObject = new PacienteController();
	//Paciente Paciente = new Paciente();

	
	
	private void inicializarControles() {
		setBounds(100, 100, 464, 298);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("DNI");
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Apellido");
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nacimiento");
		txtFNacimiento = new JFormattedTextField();
		
		JLabel lblNewLabel_3 = new JLabel("E-Mail");
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Domicilio");
		txtDomicilio = new JTextField();
		txtDomicilio.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Sexo");
		txtSexo = new JTextField();
		txtSexo.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Obra Social");
		txtObraSocial = new JTextField();
		txtObraSocial.setColumns(10);
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.UNRELATED))
									.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(lblNewLabel_3)
										.addGap(43))
									.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(lblNombre, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(lblNewLabel)
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addGap(23)))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtDomicilio, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
						.addComponent(txtApellido, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(txtDNI, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtNombre, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
								.addComponent(txtFNacimiento, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
								.addGap(12)
								.addComponent(lblNewLabel_5)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtSexo, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(lblNewLabel_6)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtObraSocial, 0, 0, Short.MAX_VALUE))
							.addComponent(txtEmail, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(txtDomicilio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(txtFNacimiento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(lblNewLabel_6)
						.addComponent(txtObraSocial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						asignarDatosEntidad();
						modalResult = ModalResult.OK;
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						modalResult = ModalResult.CANCELL;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}
	
	private void asignarFormato() {
		try {
			try {
				txtFNacimiento.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
		}
		catch (Exception e) {e.printStackTrace();}		
	}
	
	public PacienteABMView(JFrame frame) {
		super(frame, "Persona", true);
		setLocationRelativeTo(frame);
		inicializarControles();
		asignarFormato();
	}

	public Paciente getPaciente() {
		return paciente;
	}

	private void asignarDatosEntidad() {
		paciente.setDni(txtDNI.getText());
		paciente.setNombre(txtNombre.getText());
		paciente.setApellido(txtApellido.getText());
		paciente.setFechaNacimiento(txtFNacimiento.getText());
		paciente.setMail(txtEmail.getText());
		paciente.setDomicilio(txtDomicilio.getText());
		paciente.setSexo(txtSexo.getText());
		paciente.setObraSocial(txtObraSocial.getText());
	}
	
	
	private void asignarDatosForm(Paciente paciente){
		txtDNI.setText(paciente.getDni());
		txtNombre.setText(paciente.getNombre());
		txtApellido.setText(paciente.getApellido());
		txtFNacimiento.setText(paciente.getFechaNacimiento());
		txtEmail.setText(paciente.getMail());
		txtDomicilio.setText(paciente.getDomicilio());
		txtSexo.setText(paciente.getSexo());
		txtObraSocial.setText(paciente.getObraSocial());
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
		asignarDatosForm(paciente);
	}
	

	public ModalResult getModalResult() {
		return modalResult;
	}
}
