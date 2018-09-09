package br.ufc.qxd.persistencia.Controller;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Calendar;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import br.ufc.qxd.persistencia.Entity.Livro;

public class VendaController {
	
	private LivroController livroController = new LivroController();
	private DefaultListModel<Livro> dlm = new DefaultListModel<Livro>();
	private static final String Historico = "./repositorio/historico.txt";
	public double total = 0;
	
	
	public void realizaVenda() throws FileNotFoundException {
		
		try {
			if (!dlm.isEmpty()) {
				OutputStream os = new FileOutputStream(Historico, true);
				OutputStreamWriter osw = new OutputStreamWriter(os);
				BufferedWriter bw = new BufferedWriter(osw);
				Calendar dataVenda = Calendar.getInstance();
				String venda = "------------" + (dataVenda.get(5)) + 
								"/" + (dataVenda.get(2) +1) + 
								"/" + dataVenda.get(1) + "-----------\n";
				for (int i = 0; i < dlm.getSize(); i++) {
					venda += dlm.get(i).getIsbn() + " , " + dlm.get(i).getNome() + "\n";
				}
				venda += "--------------------------------\n";
				
				total = 0;
				dlm.removeAllElements();
				JOptionPane.showMessageDialog(null, "Venda realizada com sucesso");
				
				bw.write(venda);
				bw.close();
				
			} else
				JOptionPane.showMessageDialog(null, "Lista de items Vazia!");
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void addLivroAVenda(Livro livro) {
		
		if (livro.getQuant() > 0) {
			dlm.addElement(livro);
			total += livro.getValor();
			
			livro.setQuant(livro.getQuant() - 1);
			
			try {
				livroController.serializaLivro(livro.getIsbn(), 
						livro.getNome(), livro.getQuant(), 
						livro.getValor());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else
			JOptionPane.showMessageDialog(null, "Livro indisponivel no estoque!");
	}
	
	public void removeItem(int index) {
		if (dlm.getElementAt(index) != null) {
			total -= dlm.get(index).getValor();
			
			dlm.get(index).setQuant(dlm.get(index).getQuant() + 1);
			
			try {
				livroController.serializaLivro(dlm.get(index).getIsbn(), 
						dlm.get(index).getNome(), dlm.get(index).getQuant(), 
						dlm.get(index).getValor());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			dlm.remove(index);
		}
			
	}
	
	public DefaultListModel<Livro> lista() {
		return this.dlm;
	}
	
	
	
}
