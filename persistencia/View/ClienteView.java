package br.ufc.qxd.persistencia.View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.ufc.qxd.persistencia.Controller.ClienteController;

public class ClienteView {

	private JFrame frmCliente;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtDtNasc;
	private JTextField txtEndereco;
	private JButton btnAdicionar;
	private JButton btnExcuir;
	
	private ClienteController clienteController = new ClienteController();

	/**
	 * Launch the application.
	 */
	
	public void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteView window = new ClienteView();
					window.frmCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClienteView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCliente = new JFrame();
		frmCliente.setTitle("Cliente");
		frmCliente.setBounds(100, 100, 450, 261);
		frmCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCliente.getContentPane().setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setBounds(115, 26, 305, 19);
		frmCliente.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(115, 57, 305, 19);
		frmCliente.getContentPane().add(txtEndereco);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(115, 90, 114, 19);
		frmCliente.getContentPane().add(txtCpf);
		
		txtDtNasc = new JTextField();
		txtDtNasc.setColumns(10);
		txtDtNasc.setBounds(329, 90, 90, 19);
		frmCliente.getContentPane().add(txtDtNasc);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(27, 28, 70, 15);
		frmCliente.getContentPane().add(lblNewLabel);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(27, 92, 70, 15);
		frmCliente.getContentPane().add(lblCpf);
		
		JLabel lblDtNasc = new JLabel("DT. Nasc.");
		lblDtNasc.setBounds(241, 92, 70, 15);
		frmCliente.getContentPane().add(lblDtNasc);
		
		JLabel lblEndereco = new JLabel("Endereco:");
		lblEndereco.setBounds(27, 59, 80, 19);
		frmCliente.getContentPane().add(lblEndereco);
		
		btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clienteController.salvaCliente(txtCpf.getText(), txtNome.getText(), 
											txtDtNasc.getText() , txtEndereco.getText());
				resetaValores();
			
			}
		});
		btnAdicionar.setIcon(new ImageIcon("./images/icons/plus (1).png"));
		btnAdicionar.setBackground(Color.WHITE);
		btnAdicionar.setBounds(174, 158, 55, 48);
		frmCliente.getContentPane().add(btnAdicionar);
		
		btnExcuir = new JButton("");
		btnExcuir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clienteController.removeCliente(txtCpf.getText());
			}
		});
		btnExcuir.setIcon(new ImageIcon("./images/icons/cancel.png"));
		btnExcuir.setBackground(Color.WHITE);
		btnExcuir.setBounds(244, 158, 55, 48);
		frmCliente.getContentPane().add(btnExcuir);
	}
	
	public void resetaValores() {
		txtCpf.setText("");
		txtNome.setText("");
		txtDtNasc.setText("");
		txtEndereco.setText("");
	}
}
