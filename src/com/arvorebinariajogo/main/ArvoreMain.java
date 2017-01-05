package com.arvorebinariajogo.main;

import javax.swing.JOptionPane;

import com.arvorebinariajogo.domain.NoArvoreBinaria;
import com.arvorebinariajogo.interfaces.AnimalInterface;

/**
 * @Autor: Diego Augusto
 * @Date: 05-01-2017
 **/
public class ArvoreMain implements AnimalInterface<NoArvoreBinaria> {

	public static int index = 1;
	public static NoArvoreBinaria raiz;

	/**
	 * Método getArvore, implementando a partir da interface AnimalInterface
	 * usando conceitos de Generics
	 */
	@Override
	public NoArvoreBinaria getArvore() {
		return raiz;
	}

	/**
	 * Método setArvore, implementando a partir da interface AnimalInterface
	 * usando conceitos de Generics
	 */
	@Override
	public void setArvore(NoArvoreBinaria arvore) {
		raiz = arvore;
	}

	/**
	 * Método inserirAnimal, implementando a partir da interface AnimalInterface
	 * usando conceitos de Generics
	 */
	@Override
	public void inserirAnimal(NoArvoreBinaria noArvore) {

		String animal = JOptionPane.showInputDialog(null, "Qual o animal que você pensou?");

		String oqueFaz = JOptionPane
				.showInputDialog("Um(a) " + animal + "______ mas um(a) " + noArvore.valor + " não.");

		String auxiliar = noArvore.valor;
		noArvore.valor = oqueFaz;
		noArvore.noDireito = new NoArvoreBinaria(++index, animal);
		noArvore.noEsquerdo = new NoArvoreBinaria(++index, auxiliar);
	}

	/**
	 * Método perguntar, implementando a partir da interface AnimalInterface
	 * usando conceitos de Generics
	 */
	@Override
	public void perguntar(NoArvoreBinaria noArvore) {
		// Faz a pergunta pra ver se o animal está correto
		int pergunta = JOptionPane.showConfirmDialog(null, "O animal que você pensou " + noArvore.valor, "Confirme",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		if (pergunta == 0) {
			// Se a resposta estiver correta
			if (noArvore.noDireito == null)
				JOptionPane.showMessageDialog(null, "Acertei de novo!");
			// Faz a nova pergunta pra verificar sé realmente é o animal pensado
			else {
			
				perguntar(noArvore.noDireito);
			}
			// Se resposta for não insere um novo animal caso o noEsquerdo
			// esteja vazio ou vai pra proxima pergunta
		} else {
			if (noArvore.noEsquerdo == null)
				inserirAnimal(noArvore);
			else {
				perguntar(noArvore.noEsquerdo);
			}
		}
	}

	public static void main(String[] args) {
		ArvoreMain main = new ArvoreMain();
		JOptionPane.showMessageDialog(null, "Pense em um Animal");

		// Verifica se arvore está está vazia para inicializar a mesma
		if (main.getArvore() == null) {
			main.setArvore(new NoArvoreBinaria(index, "vive na agua"));
			main.getArvore().noEsquerdo = new NoArvoreBinaria(++index, "Macaco");
			main.getArvore().noDireito = new NoArvoreBinaria(++index, "Tubarao");
		}
		int sair = 1;
		// Permanece no laço enquanto sair = 1.
		do {
			// Pergunta inicial
			int resposta = JOptionPane.showConfirmDialog(null, "O animal que você pensou " + main.getArvore().valor,
					"Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			// Se resposta for Sim entra no nó direito para fazer as perguntas,
			// caso contrário entra no noEsquerdo
			if (resposta == 0) {
				main.perguntar(main.getArvore().noDireito);
			} else {
				main.perguntar(main.getArvore().noEsquerdo);
			}
			// fecha o aplicativo
			if (resposta == JOptionPane.CLOSED_OPTION) {
				sair = 0;
			}

		} while (sair == 1);

	}

}
