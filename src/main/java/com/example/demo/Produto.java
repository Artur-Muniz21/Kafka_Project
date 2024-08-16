package com.example.demo;

public class Produto {
	private String tipo;
	private String name;
	private String preco;
	
	public Produto(String tipo, String name, String preco) {
		this.tipo = tipo;
		this.name = name;
		this.preco = preco;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}
}
