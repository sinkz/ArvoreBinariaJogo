package com.arvorebinariajogo.domain;

/**
 * @Autor: Diego Augusto
 * @Date: 05-01-2017
 **/

/** Entidade que representa um nó da arvore binária */
public class NoArvoreBinaria {

	public int elemento;
	public NoArvoreBinaria noEsquerdo;
	public NoArvoreBinaria noDireito;
	public String valor;

	/** Construtor que seta os valores da arvore */
	public NoArvoreBinaria(int elemento, String valor) {
		System.out.println(elemento + " - " + valor);
		this.elemento = elemento;
		this.valor = valor;
	}

	public NoArvoreBinaria() {

	}

}
