package br.ufc.qxd.persistencia.Controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import br.ufc.qxd.persistencia.Entity.Livro;

public class CompraController {
	
	LivroController livroController = new LivroController();
	
	public void compraProduto(String isbn, String uniCompra) {
		if (isbn != null && isbn != "" && Integer.parseInt(uniCompra) > 0) {
			try {
				Livro l = livroController.deseliarizaLivro(isbn);
				if (l != null) {
					livroController.serializaLivro(l.getIsbn(), l.getNome(),
									l.getQuant() + Integer.parseInt(uniCompra), l.getValor());
					
					JOptionPane.showMessageDialog(null, "Estoque Atualizado");
				}
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		} else
			JOptionPane.showMessageDialog(null, "Erro nos dodos");
		
	}
}
