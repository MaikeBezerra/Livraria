package br.ufc.qxd.persistencia.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.ufc.qxd.persistencia.Entity.Livro;

// Venda e Compra de livros...
public class EstoqueController extends AbstractTableModel{
	
	private static File file = new File("./repositorio/Livros");
	private static ArrayList<Livro> livrosEstoque;
	private static EstoqueController instance;
	
	
	private EstoqueController() {
		livrosEstoque = livrosEstoque();
	}
	
	public static synchronized EstoqueController getInstance() {
		if (instance == null) {
			instance = new EstoqueController();
		}
		
		return instance;
	}
	
	
	public ArrayList<Livro> livrosEstoque() {
		ArrayList<Livro> livros = new ArrayList<Livro>();
		Livro l = new Livro();
        if(file.isDirectory()){ 
        	for(File file : file.listFiles()){ 
                if(file.isFile()){ 
    				FileInputStream fileIn;
    				ObjectInputStream in;
					try {
						fileIn = new FileInputStream(file);
						in = new ObjectInputStream(fileIn);
						l = (Livro) in.readObject();
	    				livros.add(l);
	    				fileIn.close();
	    				in.close();
						
					} catch (IOException | ClassNotFoundException e) {
						e.printStackTrace();
					}	
               	} 	
        	}
        }
        return livros;
     
	}

	@Override
	public int getRowCount() {
		return livrosEstoque.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return livrosEstoque.get(rowIndex).getIsbn();
		} else if (columnIndex == 1) {
			return livrosEstoque.get(rowIndex).getNome();
		} else if (columnIndex == 2) {
			return livrosEstoque.get(rowIndex).getQuant();
		} else
			return livrosEstoque.get(rowIndex).getValor();
	
	}

}
