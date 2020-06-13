package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import Controllers.SucursalController;
import Model.Sucursal;


public class SucursalABMView extends JDialog {


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdSucursal;
	private JTextField txtDireccion;
	private JTextField txtResponsable;
	private Sucursal sucursal = new Sucursal();
	private ModalResult modalResult;

	
	SucursalController sucursalBusinessObject = new SucursalController();
	Sucursal Sucursal = new Sucursal();
	
	
	private void inicializarControles() {
		setBounds(100, 100, 251, 183);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("ID Sucursal");
		
		txtIdSucursal = new JTextField();
		txtIdSucursal.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Direccion");
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		
		JLabel lblNombre = new JLabel("Responsable");
		
		txtResponsable = new JTextField();
		txtResponsable.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombre, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtResponsable)
						.addComponent(txtDireccion)
						.addComponent(txtIdSucursal, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtIdSucursal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtResponsable, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre))
					.addContainerGap(18, Short.MAX_VALUE))
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
				okButton.setActionCommand("Aceptar");
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
				cancelButton.setActionCommand("Cancelar");
				buttonPane.add(cancelButton);
			}
		}
		
	}
	
	private void asignarFormato() {
		try {
			try {
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
		}
		catch (Exception e) {e.printStackTrace();}		
	}
	
	public SucursalABMView(JFrame frame) {
		super(frame, "Persona", true);
		setTitle("Sucursal");
		setLocationRelativeTo(frame);
		inicializarControles();
		asignarFormato();
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	private void asignarDatosEntidad() {
		sucursal.setIdSucursal(txtIdSucursal.getText());
		sucursal.setDireccion(txtDireccion.getText());
		sucursal.setResponsable(txtResponsable.getText());
	}
	
	
	private void asignarDatosForm(Sucursal sucursal){
		txtIdSucursal.setText(sucursal.getIdSucursal());
		txtDireccion.setText(sucursal.getDireccion());
		txtResponsable.setText(sucursal.getResponsable());
	}
	
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
		asignarDatosForm(sucursal);
	}
	

	public ModalResult getModalResult() {
		return modalResult;
	}
}
