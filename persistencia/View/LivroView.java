package br.ufc.qxd.persistencia.View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.ufc.qxd.persistencia.Controller.LivroController;
import br.ufc.qxd.persistencia.Entity.Livro;

public class LivroView {

	private JFrame frmCadastroDeLivros;
	private JTextField txtIsbn;
	private JTextField txtNome;
	private JTextField txtQuantidade;
	private JTextField txtValor;
	
	private JButton btnSalvar;
	private JButton btnEditar;
	private JButton btnBuscar;

	private LivroController livroController = new LivroController();
	private JLabel lblQuant;
	private JLabel lblValor;
	private JButton btnCancelar;
	
	/**
	 * Launch the application.
	 */
	public void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LivroView window = new LivroView();
					window.frmCadastroDeLivros.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LivroView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeLivros = new JFrame();
		frmCadastroDeLivros.getContentPane().setEnabled(false);
		frmCadastroDeLivros.setTitle("Cadastro de Livros");
		frmCadastroDeLivros.setBounds(100, 100, 462, 321);
		frmCadastroDeLivros.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroDeLivros.getContentPane().setLayout(null);
		
		txtIsbn = new JTextField();
		txtIsbn.setEnabled(false);
		txtIsbn.setBounds(166, 92, 255, 19);
		frmCadastroDeLivros.getContentPane().add(txtIsbn);
		txtIsbn.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setColumns(10);
		txtNome.setBounds(166, 117, 255, 19);
		frmCadastroDeLivros.getContentPane().add(txtNome);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setEnabled(false);
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(166, 141, 55, 19);
		frmCadastroDeLivros.getContentPane().add(txtQuantidade);
		
		txtValor = new JTextField();
		txtValor.setEnabled(false);
		txtValor.setColumns(10);
		txtValor.setBounds(307, 141, 114, 19);
		frmCadastroDeLivros.getContentPane().add(txtValor);
		
		JLabel lblNome = new JLabel("ISBN");
		lblNome.setBounds(91, 94, 70, 15);
		frmCadastroDeLivros.getContentPane().add(lblNome);
		
		JLabel label = new JLabel("Nome:");
		label.setBounds(91, 119, 70, 15);
		frmCadastroDeLivros.getContentPane().add(label);
		
		lblQuant = new JLabel("Quant.");
		lblQuant.setBounds(91, 143, 70, 15);
		frmCadastroDeLivros.getContentPane().add(lblQuant);
		
		lblValor = new JLabel("Valor");
		lblValor.setBounds(248, 143, 70, 15);
		frmCadastroDeLivros.getContentPane().add(lblValor);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				livroController.excluiLivro(txtIsbn.getText());
				resetaValoresCampos();
				btnExcluir.setEnabled(false);
				btnEditar.setEnabled(false);
			}
		});
		btnExcluir.setIcon(new ImageIcon("./images/icons/cancel.png"));
		btnExcluir.setBackground(Color.WHITE);
		btnExcluir.setBounds(12, 80, 55, 48);
		frmCadastroDeLivros.getContentPane().add(btnExcluir);
		
		JButton btnAdicionar = new JButton("");
		btnAdicionar.setBackground(Color.WHITE);
		btnAdicionar.setIcon(new ImageIcon("./images/icons/plus (1).png"));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdicionar.setEnabled(false);
				abilitaTodosOsCampos();
				btnCancelar.setEnabled(true);
				btnSalvar.setEnabled(true);
				btnExcluir.setEnabled(false);
				btnEditar.setEnabled(false);
				btnBuscar.setEnabled(false);
			}
		});
		btnAdicionar.setBounds(12, 26, 55, 48);
		frmCadastroDeLivros.getContentPane().add(btnAdicionar);
		
		
		btnEditar = new JButton("");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExcluir.setEnabled(false);
				btnAdicionar.setEnabled(false);
				btnSalvar.setEnabled(true);
				btnCancelar.setEnabled(true);
				abilitaTodosOsCampos();
				txtIsbn.setEnabled(false);
			}
		});
		btnEditar.setEnabled(false);
		btnEditar.setIcon(new ImageIcon("./images/icons/edit.png"));
		btnEditar.setBackground(Color.WHITE);
		btnEditar.setBounds(12, 189, 55, 48);
		frmCadastroDeLivros.getContentPane().add(btnEditar);
		
		btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtIsbn.isEnabled()) {
					btnExcluir.setEnabled(false);
					btnEditar.setEnabled(false);
					btnSalvar.setEnabled(false);
					btnCancelar.setEnabled(false);
					btnAdicionar.setEnabled(false);
					
					Livro livro = livroController.deseliarizaLivro(txtIsbn.getText());
					if (livro != null) {
						txtNome.setText(livro.getNome());
						txtQuantidade.setText(Integer.toString(livro.getQuant()));
						txtValor.setText(Double.toString(livro.getValor()));
						desabilitaTodosOsCampos();
						btnExcluir.setEnabled(true);
						btnAdicionar.setEnabled(true);
						btnEditar.setEnabled(true);
						
					}
					else {
						txtIsbn.setEnabled(false);
						btnAdicionar.setEnabled(true);
						btnExcluir.setEnabled(false);
						btnEditar.setEnabled(false);
						resetaValoresCampos();
					}
						
					
				} else {
					txtIsbn.setEnabled(true);
					btnAdicionar.setEnabled(false);
				}
			}
		});
		btnBuscar.setIcon(new ImageIcon("./images/icons/magnifier.png"));
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setBounds(12, 135, 55, 48);
		frmCadastroDeLivros.getContentPane().add(btnBuscar);
		
		
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setEnabled(false);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int isbn = Integer.valueOf(txtIsbn.getText());
				int quant = Integer.valueOf(txtQuantidade.getText());
				double preco = Double.parseDouble(txtValor.getText());
				try {
					livroController.serializaLivro(isbn , txtNome.getText(),
							quant, preco);	
					desabilitaTodosOsCampos();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				resetaValoresCampos();
				btnAdicionar.setEnabled(true);
				btnBuscar.setEnabled(true);
				btnEditar.setEnabled(false);
				btnExcluir.setEnabled(false);
				btnSalvar.setEnabled(false);
				btnCancelar.setEnabled(false);
			}
		});
		btnSalvar.setBounds(189, 189, 96, 25);
		frmCadastroDeLivros.getContentPane().add(btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desabilitaTodosOsCampos();
				resetaValoresCampos();
				btnAdicionar.setEnabled(true);
				btnBuscar.setEnabled(true);
				btnEditar.setEnabled(false);
				btnExcluir.setEnabled(false);
				btnCancelar.setEnabled(false);
				btnSalvar.setEnabled(false);
			}
		});
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(303, 189, 96, 25);
		frmCadastroDeLivros.getContentPane().add(btnCancelar);
	}
	
	public void resetaValoresCampos() {
		txtIsbn.setText("");
		txtNome.setText("");
		txtQuantidade.setText("");
		txtValor.setText("");
	}
	
	public void abilitaTodosOsCampos() {
		txtIsbn.setEnabled(true);
		txtNome.setEnabled(true);
		txtQuantidade.setEnabled(true);
		txtValor.setEnabled(true);
	}
	
	public void desabilitaTodosOsCampos() {
		txtIsbn.setEnabled(false);
		txtNome.setEnabled(false);
		txtQuantidade.setEnabled(false);
		txtValor.setEnabled(false);
	}
}
