package Entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CifraTransposicao {
	public static String transporMsg(String msg, String key) {
		List<List<String>> matrizCaracteres = new ArrayList<List<String>>();
		List<String> alfabeto = new ArrayList<>();
		List<String> linha = new ArrayList<String>();
	        for (char letra = 'a'; letra <= 'z'; letra++) {
	            alfabeto.add(String.valueOf(letra));
	        }
		msg = msg.replaceAll(" ","");
		for(char c : msg.toCharArray()) {
			if(linha.size() < key.length()) {
				linha.add(String.valueOf(c));
			
			}else {
			
			List<String> linhaCopia = new ArrayList<String>(linha);
			matrizCaracteres.add(linhaCopia);
			linha.clear();
			linha.add(String.valueOf(c));
			}}
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
		List<String> listaKey = new ArrayList<String>(Arrays.asList(key.split("")));
		Collections.sort(listaKey);
		String stringTransposta="";
		for (String ch : listaKey) {
			int indice = key.indexOf(ch);
			for(List<String> ls : matrizCaracteres) {
				stringTransposta+=ls.get(indice);
			}	
		}
		return stringTransposta;
		
	}
	public static String TransporMsg2(String msg) {
		List<String> lista_permutacoes=  new ArrayList<String>();
		PermutacoesPalavra.gerarPermutacoes("", msg, lista_permutacoes);
		Random random = new Random();
		int num  = random.nextInt(lista_permutacoes.size());
		return lista_permutacoes.get(num);
	
	}
}

