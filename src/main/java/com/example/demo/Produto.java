package com.example.demo;

public class Produto {
	private String name;
	private String preco;
	
	public Produto(String name, String preco) {
		super();
		this.name = name;
		this.preco = preco;
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
