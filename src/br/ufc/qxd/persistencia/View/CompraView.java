package br.ufc.qxd.persistencia.View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.ufc.qxd.persistencia.Controller.CompraController;
import br.ufc.qxd.persistencia.Controller.LivroController;
import br.ufc.qxd.persistencia.Entity.Livro;

public class CompraView {

	private LivroController livroController = new LivroController();
	private CompraController compraController = new CompraController();
	
	private JFrame frmCompras;
	private JTextField txtIsbn;
	private JTextField txtNome;
	private JTextField txtQuant;
	private JTextField txtValor;
	private JTextField txtUndCompras;
	
	

	/**
	 * Launch the application.
	 */
	public void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompraView window = new CompraView();
					window.frmCompras.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CompraView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCompras = new JFrame();
		frmCompras.setTitle("Compras");
		frmCompras.setBounds(100, 100, 450, 300);
		frmCompras.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCompras.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("ISBN");
		label.setBounds(46, 32, 70, 15);
		frmCompras.getContentPane().add(label);
		
		txtIsbn = new JTextField();
		txtIsbn.setColumns(10);
		txtIsbn.setBounds(97, 30, 255, 17);
		frmCompras.getContentPane().add(txtIsbn);
				
		JLabel label_1 = new JLabel("Nome:");
		label_1.setBounds(46, 71, 51, 15);
		frmCompras.getContentPane().add(label_1);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setColumns(10);
		txtNome.setBounds(97, 67, 255, 19);
		frmCompras.getContentPane().add(txtNome);
		
		JLabel label_2 = new JLabel("Quant.");
		label_2.setBounds(46, 100, 70, 15);
		frmCompras.getContentPane().add(label_2);
		
		txtQuant = new JTextField();
		txtQuant.setEnabled(false);
		txtQuant.setEditable(false);
		txtQuant.setColumns(10);
		txtQuant.setBounds(97, 98, 77, 19);
		frmCompras.getContentPane().add(txtQuant);
		
		JLabel label_3 = new JLabel("Valor");
		label_3.setBounds(203, 100, 70, 15);
		frmCompras.getContentPane().add(label_3);
		
		txtValor = new JTextField();
		txtValor.setEnabled(false);
		txtValor.setEditable(false);
		txtValor.setColumns(10);
		txtValor.setBounds(262, 98, 90, 19);
		frmCompras.getContentPane().add(txtValor);
		
		JButton btnFecharCompra = new JButton("Fechar Compra");
		btnFecharCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				compraController.compraProduto(txtIsbn.getText(), txtUndCompras.getText());
			}
		});
		btnFecharCompra.setBounds(225, 217, 145, 25);
		frmCompras.getContentPane().add(btnFecharCompra);
		
		txtUndCompras = new JTextField();
		txtUndCompras.setEditable(false);
		txtUndCompras.setBounds(119, 219, 84, 22);
		frmCompras.getContentPane().add(txtUndCompras);
		txtUndCompras.setColumns(10);
		
		JLabel lblAddUnidades = new JLabel("Add. Unidades");
		lblAddUnidades.setBounds(106, 192, 117, 15);
		frmCompras.getContentPane().add(lblAddUnidades);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				Livro livro = livroController.deseliarizaLivro(txtIsbn.getText());
				if (livro != null) {
					txtUndCompras.setEditable(true);
					txtNome.setText(livro.getNome());
					txtQuant.setText(String.valueOf(livro.getQuant()));
					txtValor.setText(String.valueOf(livro.getValor()));
				} else {
					txtUndCompras.setEditable(false);
					txtNome.setText("");
					txtQuant.setText("");
					txtValor.setText("");
				}
				
			}
		});
		btnBuscar.setIcon(new ImageIcon("/home/maike/Downloads/magnifier (1).png"));
		btnBuscar.setBounds(364, 22, 30, 25);
		frmCompras.getContentPane().add(btnBuscar);
	}
}
