package Entities;


import java.util.List;
// Gera todas as permutações de uma palavra por recursão
public class PermutacoesPalavra {
	// Metódo que recebe um prefixo, um sufico e uma lista para guardar as permutações geradas
	 public static void gerarPermutacoes(String prefixo, String sufixo, List<String> resultado) {
		 // Pega o tamanho do sufixo
	        int n = sufixo.length();
	        // Cria o caso base da recursão
	        if (n == 0) {
	            resultado.add(prefixo);
	            
	        } 
	        else {
	        	// Itera com os valores do sufixo que no caso seria a mensagem
	            for (int i = 0; i < n; i++) {
	            	// Chama a função com o prefixo somado ao caracter atual da iteração
	            	// o caracter atual é subtraído da posição e somado com o restante
	            	// o Resulatado será adicionado a lista passada
	                gerarPermutacoes(prefixo + sufixo.charAt(i), 
	                                 sufixo.substring(0, i) + sufixo.substring(i + 1, n), 
	                                 resultado);
	            }
	        }
	    }
	
}
