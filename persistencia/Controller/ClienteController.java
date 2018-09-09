/**
 * @author maike
 * @version 28/08/2018
 * 
 * */

package br.ufc.qxd.persistencia.Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

//Adicionar e remover clientes.
public class ClienteController {

	private static final String CLIENTES = "./repositorio/myClients.csv";
	
	// -Bug não está salvando o próximo cliente
	public void salvaCliente(String cpf, String nome,String dataNascimento, 
						String endereco){
		OutputStream os;
		try {
			os = new FileOutputStream(CLIENTES, true);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			bw.write(cpf + " , ");
			bw.write(nome + " , ");
			bw.write(dataNascimento + " , ");
			bw.write(endereco + "\n");
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso");
	}
	
	//Ler todo o arquivo, verificar se o cliente passado está no arquivo. 
	//E exclui-lo como eu faço :( 
	public void removeCliente(String cpf) {
		System.out.println(cpf);
		if (cpf != null) {
			File fil = new File(CLIENTES);
			
			try {
				FileReader fr = new FileReader(fil);
				BufferedReader br = new BufferedReader(fr);
				
				String linha = br.readLine();
				ArrayList<String> salvar = new ArrayList<String>();
			
				while (linha != null) {
					if (!linha.contains(cpf)) {
					System.out.println("Entrei aqui");
						salvar.add(linha);
					}
					
					linha = br.readLine();
				}
				
				fr.close();
				br.close();
				FileWriter fw2 = new FileWriter(fil, true);
				fw2.close();
				
				FileWriter fw = new FileWriter(fil);
				BufferedWriter bw = new BufferedWriter(fw);
				
				for (int i = 0; i < salvar.size(); i++) {
					bw.write(salvar.get(i));
					bw.newLine();
				}
				
				bw.close(); 
				fw.close();
				
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
//	public void sobrescreveCliente(String dadosCliente) throws IOException{
//		OutputStream os = new FileOutputStream(CLIENTES, true);
//		OutputStreamWriter osw = new OutputStreamWriter(os);
//		BufferedWriter bw = new BufferedWriter(osw);
//		
//		bw.write(dadosCliente + "\n");
//		bw.close();
//		
//	}
}
