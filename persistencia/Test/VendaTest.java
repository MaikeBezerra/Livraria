package br.ufc.qxd.persistencia.Test;

import java.io.IOException;

import br.ufc.qxd.persistencia.Controller.VendaController;
import br.ufc.qxd.persistencia.Entity.Livro;

public class VendaTest {
	public static void main(String[] args) {
		VendaController vController = new VendaController();
		
		Livro l = new Livro();
		Livro l2 = new Livro();
		
		l.setIsbn(111);
		l.setNome("Qualquer");
		l.setQuant(10);
		l.setValor(10);
		
		l2.setIsbn(1112);
		l2.setNome("Qualquer versão dublada");
		l2.setQuant(12);
		l2.setValor(12);
		
		vController.addLivroAVenda(l);
		vController.addLivroAVenda(l2);
		try {
			vController.realizaVenda();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
