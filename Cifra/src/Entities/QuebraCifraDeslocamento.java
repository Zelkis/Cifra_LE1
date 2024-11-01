package Entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuebraCifraDeslocamento {
	private static int Key = 0;
	// Cria um Map em que as chaves são todas as letras do alfabeto
	// e os valores são as suas respectivas frequências
	public static  Map<String,Double> criaFrequenciaCaracter(){
		Map< String,Double> frequencia = new HashMap<String,Double>();
		frequencia.put("a",15.9);
		frequencia.put("b", 1.0);
		frequencia.put("c", 4.4);
		frequencia.put("d", 5.4);
		frequencia.put("e", 12.2);
		frequencia.put("f", 1.0);
		frequencia.put("g", 1.2);
		frequencia.put("h", 0.8);
		frequencia.put("i", 6.9);
		frequencia.put("j", 0.4);
		frequencia.put("k", 0.1);
		frequencia.put("l", 2.8);
		frequencia.put("m", 4.2);
		frequencia.put("n", 5.3);
		frequencia.put("o", 10.8);
		frequencia.put("p", 2.9);
		frequencia.put("q", 0.9);
		frequencia.put("r", 6.9);
		frequencia.put("s", 7.9);
		frequencia.put("t", 4.9);
		frequencia.put("u", 4.0);
		frequencia.put("v", 1.3);
		frequencia.put("w", 0.0);
		frequencia.put("x", 0.3);
		frequencia.put("y", 0.0);
		frequencia.put("z", 0.4);
		return frequencia;
		
	}
	// Esse metódo visa quebrar a mensagem analisando a distribuição de frequências da língua portuguesa
	public static String quebrarPorFrequencia(String msg) {
		//Cria um int de valor minímo
		int value = Integer.MIN_VALUE;
		// Cria uma String vazia
		String cifra ="";
		// Cria uma lista de caracteres em que as letras irão ocupar as posições de 0 até 25
		List<String> listaCaracteres=  CifraDeslocamento.CriaListaCaracteres();
		// Cria um array de caracteres em formato de String com a msg passada
		List<String> listaMensagem = new ArrayList<String>(Arrays.asList(msg.split("")));
		// Itera sobre todos os valores possíveis de chaves para a cifra de deslocamento
		for(int key= 0 ; key<26;key++) {
			String caracteres="";
			// Itera sobre a lista de caracteres da mensagem. Procura o index do caracter na lista de caracteres
			// subtrai da chave e adiciona 26 para não ter valores negativos e por fim, pega o resto da divisão por
			//26. Com isso, para cada chave, deciframos a mensagem de acordo com essa equação
			for(String ch:listaMensagem) {
				caracteres+=listaCaracteres.get((listaCaracteres.indexOf(ch)-key+26)%26);
			}
			// Usa a função calculaPontuacao para a string obtida acima
			int pontuacao= calculaPontuacao(caracteres);
			// Se a pontuação for maior que o valor declarado no início do metódo
			// o valor recebe essa pontuacao atrelada a string
			// O atributo chave recebe a chave que estava atrelada a pontuação
			// a cifra recebe a String
			if(pontuacao> value) {
				value = pontuacao;
				Key=key;
				cifra = caracteres;
				
			}
			
			
		}
		// Retorna a cifra
		return cifra;
		
		 
	}
	// Calcula a pontuação de uma string com base na distribuição de frequências da língua portuguesa
	public static int calculaPontuacao(String msg) {
		// Cria um map de acordo com o metódo no início da classe
		Map<String,Double> frequencia = criaFrequenciaCaracter();
		// Atribui pontuação 0 a variável
		int pontuacao=0;
		// Itera sobre a mensagem transformada em um array de caracteres
		for(char c : msg.toCharArray()) {
			// Soma a variável pontuação os valores das frequências obtidas de acordo com o Map criado
			pontuacao+=frequencia.get(String.valueOf(c));
			
		}
		// Retorna a pontuação
		return pontuacao;
		
	}
	// Metódo para retornar a chave
	public static int getKey() {
		return Key;
	}
	// Metódo para quebrar a cifra mediante o uso da força bruta
	public static void quebraForcaBruta(String msg) {
		// Cria uma lista de caracteres String em que as letras de a até z ocuparão as posições de 0 até 25
		List<String> listaCaracteres=  CifraDeslocamento.CriaListaCaracteres();
		// Cria uma lista de String com a mensagem passada
		List<String> listaMensagem = new ArrayList<String>(Arrays.asList(msg.split("")));
		// Itera sobre os valores de todas as chaves possíveis
		for(int key= 0 ; key<26;key++) {
			// Cria uma String vazia
			String caracteres="";
			// Itera sobre os caracteres da mensagem
			for(String ch:listaMensagem) {
				// Para cada caracter pega o índice dele na lista de caracteres, subtrai da chave
				// e adiciona 26, pega o resto da posição dele e pega o caracter deslocado pela
				// sua posição na lista de caracteres
				caracteres+=listaCaracteres.get((listaCaracteres.indexOf(ch)-key+26)%26);
				
			}
			// Printa na tela os valores de todas as chaves e a respectiva String associada a tentativa
			System.out.printf("chave : %d , tentativa : %s \n",key,caracteres);	
	}
}
}
