package Entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuebraCifraTransposicao {
	public static Map<String,Double> criaFrequencia(){
		//Cria um Map em que as chaves são os digramas e trigramas da língua portuguesa e os valores as suas respectivas frequências
		Map<String,Double> frequencias = new HashMap<String,Double>();
		frequencias.put("que", 72.29);
		frequencias.put("ent", 70.23);
		frequencias.put("nte", 55.08);
		frequencias.put("ado", 51.16);
		frequencias.put("ade", 50.04);
		frequencias.put("ode", 45.43);
		frequencias.put("ara", 45.37);
		frequencias.put("est", 43.90);
		frequencias.put("res", 43.08);
		frequencias.put("con", 41.73);
		frequencias.put("com", 40.95);
		frequencias.put("sta", 30.95);
		frequencias.put("dos", 38.08);
		frequencias.put("cao", 37.97);
		frequencias.put("par", 36.29);
		frequencias.put("aca", 35.55);
		frequencias.put("men", 34.65);
		frequencias.put("sde", 33.45);
		frequencias.put("ica", 33.05);
		frequencias.put("ese", 31.87);
		frequencias.put("aco", 31.54);
		frequencias.put("ada", 31.45);
		frequencias.put("por", 31.39);
		frequencias.put("nto", 31.14);
		frequencias.put("ose", 30.82);
		frequencias.put("des", 30.51);
		frequencias.put("ase", 27.76);
		frequencias.put("era", 27.18);
		frequencias.put("oes", 26.60);
		frequencias.put("uma", 25.73);
		frequencias.put("tra", 25.66);
		frequencias.put("ida", 25.55);
		frequencias.put("dad", 24.84);
		frequencias.put("ant", 24.54);
		frequencias.put("are", 24.30);
		frequencias.put("ont", 24.05);
		frequencias.put("pre", 24.04);
		frequencias.put("ist", 23.91);
		frequencias.put("ter", 23.89);
		frequencias.put("que", 23.37);
		frequencias.put("qu", 12.0);
        frequencias.put("ra", 8.6);
        frequencias.put("es", 8.5);
        frequencias.put("do", 8.3);
        frequencias.put("or", 8.0);
        frequencias.put("de", 7.8);
        frequencias.put("se", 7.5);
        frequencias.put("re", 7.2);
        frequencias.put("en", 7.0);
        frequencias.put("ta", 6.8);
        frequencias.put("er", 6.5);
        frequencias.put("ar", 6.4);
        frequencias.put("te", 6.3);
        frequencias.put("ma", 6.2);
        frequencias.put("os", 6.1);
        frequencias.put("da", 5.9);
        frequencias.put("ou", 5.8);
        frequencias.put("em", 5.6);
        frequencias.put("nt", 5.5);
        frequencias.put("ue", 5.4);
        frequencias.put("co",14.0);
        frequencias.put("va", 3.36);
        frequencias.put("mo",5.21);
        frequencias.put("ai", 5.11);
        frequencias.put("om", 7.79);
		
		return frequencias;
		
	}
	
	// Primeiro metódo de tentativa de quebra da msg
	public static String quebraCifra(String msg) {
		// Cria uma lista de Strings
		List<String> lista_permutacoes = new ArrayList<String>();
		// Pega o menor valor de um tipo double
		Double valor = Double.MIN_VALUE;
		// Cria uma String vazia
		String cifra="";
		// Gerar todas as permutações da mensagem passada no argumento e as armazenar na lista_permutacoes
		PermutacoesPalavra.gerarPermutacoes("",msg,lista_permutacoes);
		// Itera sobre a lista_permutacoes
		for(String per: lista_permutacoes) {
			// Calcula a pontuacao de cada String da lista
			Double pontuacao= calculaPontuacao(per);
			// Se essa pontuação for mairo que o valor atribui o valor a pontuação e a cifra a string permutada
			if(pontuacao > valor) {
				valor = pontuacao;
				cifra = per;
			}
			
		}
		// Retorna a cifra
		return cifra;
		
		
	}
	// Metódo para calcular a pontuação da mensagem
	public static Double calculaPontuacao(String msg) {
		// Cria uma lista de strings com os caracteres da mensagem
		List<String> lista_caracteres = new ArrayList<String>(Arrays.asList(msg.split("")));
		// Cria um Map de acordo com o metódo no início da classe
		Map<String,Double> frequencias = criaFrequencia();
		// Cria uma String vazia
		String aux ="";
		// Cria um Double vazio
		Double pontuacao = 0.0;
		// Itera sobre a lista de caracteres
		for(int i = 0; i<lista_caracteres.size();i++) {
			// se a soma do valor atual da iteração + 1 for maior do que o tamanho da lista-1 a variável aux recebe a soma dos elementos
			// Pegados pelo índice de acordo com a equação abaixo
			if (i+1 > lista_caracteres.size()-1) {
				 aux = lista_caracteres.get(i-2) + lista_caracteres.get(i-1) + lista_caracteres.get(i);
				 // Verifica se o trigrama existe no Map
				 if(frequencias.get(aux) != null) {
					 // Se existir adiciona a pontuacao a frequencia e quebra o looping
				pontuacao+=frequencias.get(aux);}
				 break;
			} 
			// Se a soma do valor atual da iteração + 2 for maior do que o tamanho da lista-1 a variável aux recebe a soma dos elementos
			// pegados pelo índice de acordo com a equação abaixo
			else if(i+2 > lista_caracteres.size()-1) {
				 aux = lista_caracteres.get(i-1) + lista_caracteres.get(i) + lista_caracteres.get(i+1);
				 // Verifica se o trigrama existe no Map
				 if(frequencias.get(aux) != null) {
					 // Se existir adicioana a variável pontuacao a frequencia quebra o looping
				 pontuacao+= frequencias.get(aux);}
				 break;
			}else {
				// Se não ocorrer nenhum dos casos acima então os trigramas serão obtidos de acordo com a equação abaixo
				aux = lista_caracteres.get(i) + lista_caracteres.get(i+1) + lista_caracteres.get(i+2);
				// Verifica se o trigrama existe no Map
				if(frequencias.get(aux) != null) {
					// Se existir adiciona a variável pontuacao a frequencia
				pontuacao+=frequencias.get(aux);}
			}
		}
		// Itera sobre a lista_caracteres
		for(int i = 0; i< lista_caracteres.size();i++) {
			// Se a soma do valor atual +1 for menor que o tamanho da lista-1 então a variável aux recebe a soma dos elementos String 
			// pegos pelo índice de acordo com a equação abaixo
			if(i+1 > lista_caracteres.size()-1) {
				aux = lista_caracteres.get(i-1) + lista_caracteres.get(i);
				// Verfica se o digrama existe no Map
				if(frequencias.get(aux)!= null) {
					// Adiciona a variável pontuacao a respectiva frequencia e quebra o looping
					pontuacao+=frequencias.get(aux);
				} break;
				}
				else {
					// Se não for a opção acima a variável aux recebe a soma de Strings pegas pelo índice de acordo com a equação abaixo
					aux = lista_caracteres.get(i) + lista_caracteres.get(i+1);
					// Verfica se o digrama existe no Map
					if(frequencias.get(aux)!= null) {
						// Se existir adiciona a variável pontuacao sua respectiva frequência
						pontuacao+=frequencias.get(aux);
					}
				}
			}
		// Retorna a pontuação
		
		return pontuacao;
	}

}
