package Entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CifraTransposicao {
	public static String transporMsg(String msg, String key) {
		// Cria uma lista de listas que contem Strings como elementos
		List<List<String>> matrizCaracteres = new ArrayList<List<String>>();
		// Cria uma lista com as letras do alfabeto
		List<String> alfabeto = new ArrayList<>();
		// Cria uma lista em que os elementos são Strings
		List<String> linha = new ArrayList<String>();
		// Adiciona todas as letras do alfabeto na lista alfabeto
	        for (char letra = 'a'; letra <= 'z'; letra++) {
	            alfabeto.add(String.valueOf(letra));
	        }
	     //Remove os espaçoes da String
		msg = msg.replaceAll(" ","");
		// Itera sobre a mensagem passada, transformando-a em um array de caracteres
		// enquanto a lista da linha for menor que o tamanho da chave passada
		// adiciona os elementos da mensagem na lista
		for(char c : msg.toCharArray()) {
			if(linha.size() < key.length()) {
				linha.add(String.valueOf(c));
			
			}else {
				
			// Cria uma cópia da linha acima
			List<String> linhaCopia = new ArrayList<String>(linha);
			// Adiciona essa linha na matrizCaracteres criada acima
			matrizCaracteres.add(linhaCopia);
			// Limpa a lista
			linha.clear();
			// Adiciona o último caracter contido na iteração para que ele não seja descartado
			linha.add(String.valueOf(c));
			}}
		// Se o tamanho da mensagem não for divisível pelo tamanho da chave, então
		// a última linha não será adicionada a matriz de caracteres.
		//Portanto, faz-se necessário essa condicional para preencher
		// a linha com as letras do alfabeto em ordem alfabética e
		// adicona-la a matriz
		// Um outro cenário possível, seria se a linha fosse toda preenchida, porém não
		// fosse adicionada  a matriz. Desse modo, a outra condição da garantia de que
		// a linha será adicionada a matriz de caracteres
		if(linha.size()!=key.length()) {
			for(String letra: alfabeto) {
				if(linha.size()!=key.length()) {
					linha.add(letra);
				}else {break;}
			}
			List<String> linhaCopia = new ArrayList<String>(linha);
			matrizCaracteres.add(linhaCopia);
		}else {
			List<String> linhaCopia = new ArrayList<String>(linha);
			matrizCaracteres.add(linhaCopia);
		}
		// Cria uma lista com base na chave passada no metódo
		List<String> listaKey = new ArrayList<String>(Arrays.asList(key.split("")));
		// Ordena essa lista em ordem alfabética
		Collections.sort(listaKey);
		//Cria uma String que será responsável por dar a string transposta
		String stringTransposta="";
		// Itera sobre a lista ordenada da chave
		for (String ch : listaKey) {
			// pega o indíce do elemento
			int indice = key.indexOf(ch);
			// Itera sobre a matriz de matrizes de caracteres
			for(List<String> ls : matrizCaracteres) {
				// Adiciona os elemntos com base no índice do elemento pego acima
				// Dessa forma pegamos as colunas em ordem alfabética
				stringTransposta+=ls.get(indice);
			}	
		}
		// Retorna a String
		return stringTransposta;
		
	}
	// Outra tentativa de transpor a mensagem sem ser por transposição de colunas
	public static String TransporMsg2(String msg) {
		// Cria uma lista de Strings
		List<String> lista_permutacoes=  new ArrayList<String>();
		// Gera todas as permutações das palavras e as adiciona na lista
		PermutacoesPalavra.gerarPermutacoes("", msg, lista_permutacoes);
		// Cria um objeto de uma classe responsável por selecionar elementos aleatórios
		Random random = new Random();
		// Sorteia um número aleátorio dentro do range da lista
		int num  = random.nextInt(lista_permutacoes.size());
		// Retorna a palavra
		return lista_permutacoes.get(num);
	
	}
}

