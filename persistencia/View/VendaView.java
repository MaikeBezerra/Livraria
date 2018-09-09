package br.ufc.qxd.persistencia.View;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import br.ufc.qxd.persistencia.Controller.LivroController;
import br.ufc.qxd.persistencia.Controller.VendaController;
import br.ufc.qxd.persistencia.Entity.Livro;

public class VendaView {
	private LivroController livroController = new LivroController();
	private VendaController vendaController = new VendaController();
	
	private JFrame frmVendas;
	private JTextField txtIsbn;
	private final JButton btnBuscar = new JButton("");
	private JTextField txtTotal;
	private JTextField txtNome;
	private JTextField txtQuant;
	private JTextField txtValor;

	private JList<Livro> list;
	/**
	 * Launch the application.
	 */
	public void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VendaView window = new VendaView();
					window.frmVendas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VendaView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVendas = new JFrame();
		frmVendas.setTitle("Vendas");
		frmVendas.setBounds(100, 100, 566, 470);
		frmVendas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmVendas.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("ISBN");
		label.setBounds(28, 26, 70, 15);
		frmVendas.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Nome:");
		label_1.setBounds(28, 65, 51, 15);
		frmVendas.getContentPane().add(label_1);
		
		txtIsbn = new JTextField();
		txtIsbn.setBounds(79, 24, 345, 17);
		txtIsbn.setColumns(10);
		frmVendas.getContentPane().add(txtIsbn);
		
		btnBuscar.setBounds(457, 18, 30, 25);
		btnBuscar.setIcon(new ImageIcon("./images/icons/magnifier (1).png"));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Livro livro = livroController.deseliarizaLivro(txtIsbn.getText());
				if (livro != null) {
					txtNome.setText(livro.getNome());
					txtQuant.setText(String.valueOf(livro.getQuant()));
					txtValor.setText(String.valueOf(livro.getValor()));
				}
				
			}
		});
		frmVendas.getContentPane().add(btnBuscar);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(470, 389, 59, 25);
		txtTotal.setEditable(false);
		txtTotal.setText(String.valueOf(vendaController.total));
		frmVendas.getContentPane().add(txtTotal);
		txtTotal.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setBounds(79, 61, 345, 19);
		txtNome.setColumns(10);
		frmVendas.getContentPane().add(txtNome);
		
		JButton btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Livro livro = livroController.deseliarizaLivro(txtIsbn.getText());
				if (livro != null) {
					vendaController.addLivroAVenda(livro);
					txtTotal.setText(String.valueOf(vendaController.total));
					list.setModel(vendaController.lista());
				}
				
			}
		});
		btnAdicionar.setBounds(457, 55, 30, 25);
		btnAdicionar.setIcon(new ImageIcon("./images/icons/plus (2).png"));
		frmVendas.getContentPane().add(btnAdicionar);
		
		JButton btnFechaVenda = new JButton("Fechar Venda");
		btnFechaVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					vendaController.realizaVenda();
					txtTotal.setText("0.0");
					list.removeAll();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnFechaVenda.setBounds(327, 389, 131, 25);
		frmVendas.getContentPane().add(btnFechaVenda);
		
		JButton btnExcluir = new JButton("Excluir Item");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex() >= 0) {
					 
					vendaController.removeItem(list.getSelectedIndex());
					list.setModel(vendaController.lista());
					txtTotal.setText(String.valueOf(vendaController.total));
				}
			}
		});
		btnExcluir.setBounds(28, 389, 128, 25);
		frmVendas.getContentPane().add(btnExcluir);
		
		JLabel label_2 = new JLabel("Quant.");
		label_2.setBounds(28, 94, 70, 15);
		frmVendas.getContentPane().add(label_2);
		
		txtQuant = new JTextField();
		txtQuant.setEditable(false);
		txtQuant.setEnabled(false);
		txtQuant.setColumns(10);
		txtQuant.setBounds(79, 92, 77, 19);
		frmVendas.getContentPane().add(txtQuant);
		
		JLabel label_3 = new JLabel("Valor");
		label_3.setBounds(275, 94, 70, 15);
		frmVendas.getContentPane().add(label_3);
		
		txtValor = new JTextField();
		txtValor.setEditable(false);
		txtValor.setEnabled(false);
		txtValor.setColumns(10);
		txtValor.setBounds(334, 92, 90, 19);
		frmVendas.getContentPane().add(txtValor);
		
		list = new JList<Livro>();
		list.setBounds(28, 143, 501, 234);
		frmVendas.getContentPane().add(list);
		frmVendas.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frmVendas.getContentPane(), txtIsbn, btnBuscar, btnAdicionar, btnFechaVenda}));
	}
}
