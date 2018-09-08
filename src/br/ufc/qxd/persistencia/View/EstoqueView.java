package br.ufc.qxd.persistencia.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;

import br.ufc.qxd.persistencia.Controller.EstoqueController;
import javax.swing.table.DefaultTableModel;

public class EstoqueView {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstoqueView window = new EstoqueView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EstoqueView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		table = new JTable();
		frame.getContentPane().add(table, BorderLayout.CENTER);
		table.setModel(EstoqueController.getInstance());
	}

}
