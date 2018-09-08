package br.ufc.qxd.persistencia.Test;

import java.io.IOException;

import br.ufc.qxd.persistencia.Controller.LivroController;
import br.ufc.qxd.persistencia.Entity.Livro;

public class LivroTest {
	public static void main(String[] args) {
		
		LivroController lc = new LivroController();
		Livro l = new Livro();
//		l.setIsbn(234);
//		l.setNome("Aprendendo Inteligência");
//		l.setValor(45);
//		l.setQuant(10);
		
//		try {
//			System.out.println(lc.serializaLivro(l));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		try {
			l = lc.deseliarizaLivro(345);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(l.toString());
	}
}
