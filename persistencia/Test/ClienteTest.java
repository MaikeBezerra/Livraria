package br.ufc.qxd.persistencia.Test;

import java.io.IOException;

import br.ufc.qxd.persistencia.Controller.ClienteController;
import br.ufc.qxd.persistencia.Entity.Cliente;

public class ClienteTest {

	public static void main(String[] args) throws IOException {
		
		adicionaCliente();
		//removeCliente();
	}
	
	public static void removeCliente() throws IOException {
		ClienteController cc = new ClienteController();
		cc.removeCliente("05438836396");
	}
	
	public static void adicionaCliente() throws IOException {
		Cliente c1 = new Cliente();
		Cliente c2 = new Cliente();
		ClienteController cc = new ClienteController();
		
		c1.setNome("Maik");
		c1.setCpf("05438836396");
		c1.setEndereco("Rua y");
		
		c2.setNome("Raul");
		c2.setCpf("05438836397");
		c2.setEndereco("Rua x");
		
		
		System.out.println(cc.salvaCliente(c1));
		cc.salvaCliente(c2);
	}
}
