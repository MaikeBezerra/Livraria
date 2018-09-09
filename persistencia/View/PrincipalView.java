package br.ufc.qxd.persistencia.View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PrincipalView {

	private JFrame frmLivraria;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalView window = new PrincipalView();
					window.frmLivraria.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrincipalView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLivraria = new JFrame();
		frmLivraria.getContentPane().setBackground(Color.CYAN);
		frmLivraria.setTitle("Livraria");
		frmLivraria.setBounds(100, 100, 487, 300);
		frmLivraria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		frmLivraria.setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteView cv = new ClienteView();
				cv.open();
			}
		});
		
		mnCadastro.add(mntmCliente);
		
		JMenuItem mntmLivro = new JMenuItem("Livro");
		mntmLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LivroView livroView = new LivroView();
				livroView.open();
			}
		});
		mnCadastro.add(mntmLivro);
		
		JMenu mnFinanceiro = new JMenu("Financeiro");
		menuBar.add(mnFinanceiro);
		
		JMenuItem mntmVenda = new JMenuItem("Venda");
		mntmVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VendaView vendaView = new VendaView();
				vendaView.open();
			}
		});
		mnFinanceiro.add(mntmVenda);
		
		JMenuItem mntmCompra = new JMenuItem("Compra");
		mntmCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompraView compraView = new CompraView();
				compraView.open();
			}
		});
		mnFinanceiro.add(mntmCompra);
		
		JMenu mnRelatorios = new JMenu("Relatorios");
		menuBar.add(mnRelatorios);
		
		JMenuItem mntmEstoque = new JMenuItem("Estoque");
		mntmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					EstoqueView estoqueView = new EstoqueView();
					estoqueView.open();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				//File f = new File("/home/maike/Área de Trabalho/estoque.txt");
			
			}
		});
		mnRelatorios.add(mntmEstoque);
		frmLivraria.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("./images/01.jpg"));
		label.setBounds(0, 0, 481, 248);
		frmLivraria.getContentPane().add(label);
	}
	
}
