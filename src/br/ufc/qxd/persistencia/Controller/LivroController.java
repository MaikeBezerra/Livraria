package br.ufc.qxd.persistencia.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import br.ufc.qxd.persistencia.Entity.Livro;

public class LivroController {

	
	
	public void serializaLivro(int isbn, String nome, int quant,
									double valor) throws IOException {
		
		Livro l = new Livro();
		l.setIsbn(isbn);
		l.setNome(nome);
		l.setQuant(quant);
		l.setValor(valor);
		
		try {
			FileOutputStream fileOut = new FileOutputStream("./repositorio/Livros/" + isbn + ".ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(l);
			out.close();
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public Livro deseliarizaLivro(String isbn) {
		
		try {
			if (isbn != null ) {
				
				File file = new File("/home/maike/Área de Trabalho/"
						+ "Livraria/"+ isbn + ".ser");
				if (file.exists()) {
					Livro l = new Livro();
					FileInputStream fileIn = new FileInputStream("/home/maike/Área de Trabalho/"
							+ "Livraria/"+ isbn + ".ser");
					ObjectInputStream in = new ObjectInputStream(fileIn);
					l = (Livro) in.readObject();
					in.close();
					fileIn.close();
					return l;
				} else {
					JOptionPane.showMessageDialog(null, "Livro não Encontrado!");
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
	public void excluiLivro(String isbn) {
		if (isbn != null) {
			File file = new File("/home/maike/Área de Trabalho/"
					+ "Livraria/"+ isbn + ".ser");
			if (file.exists()) {
				file.delete();
				JOptionPane.showMessageDialog(null, "Livro excuido com sucesso!");
			}
		} else
			JOptionPane.showMessageDialog(null, "Livro não Encontrado!");
		
	}
	
}
