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
		frequencias.put("de", 20.33);
        frequencias.put("es", 20.71);
        frequencias.put("do", 14.45);
        frequencias.put("da", 11.92);
        frequencias.put("os", 18.26);
        frequencias.put("em", 10.92);
        frequencias.put("se", 13.47);
        frequencias.put("as", 16.41);
        frequencias.put("ou", 4.06);
        frequencias.put("ar", 14.89);
        frequencias.put("ra", 17.43);
        frequencias.put("re", 14.16);
        frequencias.put("er", 13.33);
        frequencias.put("to", 9.33);
        frequencias.put("me", 8.13);
        frequencias.put("an", 11.62);
        frequencias.put("te", 12.72);
        frequencias.put("co", 14.45);
        frequencias.put("na", 8.65);
        frequencias.put("di", 4.96);
        frequencias.put("qu", 9.38);
        frequencias.put("la", 4.93);
        frequencias.put("in", 8.22);
        frequencias.put("no", 6.13);
        frequencias.put("po", 7.46);
        frequencias.put("pe", 5.23);
        frequencias.put("pa", 6.74);
        frequencias.put("al", 9.03);
        frequencias.put("so", 5.20);
        frequencias.put("sa", 9.19);
        frequencias.put("ai",5.11);
        frequencias.put("ve", 4.75);
        frequencias.put("ma", 11.35);
        frequencias.put("li", 5.22);
        frequencias.put("ba", 2.35);
        frequencias.put("te", 12.72);
        frequencias.put("ga", 2.6);
        frequencias.put("le", 3.96);
        frequencias.put("va", 3.36);
        frequencias.put("um", 3.20);
        frequencias.put("go", 2.05);
        frequencias.put("fa", 1.56);
        frequencias.put("fi", 2.64);
        frequencias.put("si", 4.72);
        frequencias.put("de", 20.33);
        frequencias.put("ou", 4.06);
        frequencias.put("be", 1.90);
        frequencias.put("vo", 1.75);
        frequencias.put("cl", 0.80);
        frequencias.put("la", 4.93);
        frequencias.put("os", 18.26);
        frequencias.put("ro", 8.11);
        frequencias.put("ce", 3.78);
        frequencias.put("te", 12.72);
        frequencias.put("en", 14.94);
        frequencias.put("to", 9.33);


		
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
	// Outro metódo para quebrar a cifra por transposição que usa além da mensagem cifrada, uma estimativa do tamanho da chave
	public static String quebraCifra2(String msg,Integer keyLenght) {
		// Cria uma lista com os caracteres da mensagem
		List<String> lista_caracteres_msg = new ArrayList<String>(Arrays.asList(msg.split("")));
		// String vazia que retornará a mensagem decifrada
		String stringDecifrada = "";
		// Cria um valor minímo 
		Double valor = Double.MIN_VALUE;
		// Cria uma lista de listas para armazenar as colunas
		List<List<String>> listaCaracteres = new ArrayList<List<String>>();
		// Cria uma lista de Strings
		List<String> caracteres = new ArrayList<String>();
		// Itera sobre os caracteres da mensagem
		for(String ch: lista_caracteres_msg) {
			// Pega as colunas da mensagem transposta. A divisão do tamanho da mensagem pela chave dá o tamanho de cada coluna
			if(caracteres.size() < Integer.valueOf(msg.length()/keyLenght)) {
				caracteres.add(ch);
		
			}else {
				// Cria uma copia da lista das colunas
				List<String> caracteresCopia = new ArrayList<String>(caracteres);
				caracteres.clear();
				// Adiciona na lista de colunas
				listaCaracteres.add(caracteresCopia);
				// Adiciona o primeiro caracter
				caracteres.add(ch);
				}
			}
		// Adiciona eventuais colunas que não foram adicionadas na iteração acima
		listaCaracteres.add(caracteres);
		String numeros ="";
		// Cria uma String para numerar as colunas de 0 até o tamanho da chave
		for(int j = 0; j< keyLenght;j++) {
			numeros+=String.valueOf(j);
					
			}
		//Cria uma lista de strings que conterá todas as permutações possíveis das colunas
		List<String> lista_permutacoes = new ArrayList<String>();
		// Preenche a lista com essas permutações
		PermutacoesPalavra.gerarPermutacoes("", numeros, lista_permutacoes);
		// Itera sobre a lista de permutações
		for(String per: lista_permutacoes) {
			// Cria uma string de tentativa
			String tentativa = "";
			int cont = 0 ;
			// Enquanto a tentativa não tiver o tamanho da mensagem pega-se os caracteres do array de acordo com a ordem da permutação
			// Por exemplo para a combinação 012 supondo a lista [[s,d,s],[d,j,h],[i,o,p]] pega-se primeiro o caracter s, depois o j, depois i
			// depois pega-se o d, j e depois o o e assim por diante. Ao final teremos uma das possibilidades possíveis de transposição
			while (tentativa.length()!=msg.length()) {
				for(char c: per.toCharArray()) {
					tentativa+=listaCaracteres.get(Integer.valueOf(String.valueOf(c))).get(cont);
				}
				cont++;
			
			}
			// Calcula-se a pontuacao da tentativa usando a distribuição de frequencias da língua portuguesa
			Double pontuacao = calculaPontuacao(tentativa);
			if(pontuacao> valor) {
				valor = pontuacao;
				stringDecifrada = tentativa;
			}
			
		}
		// Retorna a mensagem decifrada
		return stringDecifrada;
	
	}


}
