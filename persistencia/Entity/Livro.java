package br.ufc.qxd.persistencia.Entity;

//Persistir em serializable os livros salvos...

public class Livro implements java.io.Serializable{
	
	private int isbn;
	private String nome;
	private double valor;
	private int quant;
	
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}
	
	public String toString() {
		return  this.isbn + " " + this.nome + " R$: " +
				this.valor + "\n";
	}
}
