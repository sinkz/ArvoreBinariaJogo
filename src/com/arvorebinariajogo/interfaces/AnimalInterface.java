package com.arvorebinariajogo.interfaces;

/**
 * @Autor: Diego Augusto
 * @Date: 05-01-2017
 **/

/** Interface com os métodos necessários para o funcionamento da arvore */
public interface AnimalInterface<T> {

	public void inserirAnimal(T e);

	public void perguntar(T e);

	public T getArvore();

	public void setArvore(T e);

}
