package Entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CifraDeslocamento {
	// Cria uma lista com as letras nas posições 0,1,2... até 25
	public static List<String> CriaListaCaracteres(){
		List<String> letras = new ArrayList<String>();
		letras.add("a");
		letras.add("b");
		letras.add("c");
		letras.add("d");
		letras.add("e");
		letras.add("f");
		letras.add("g");
		letras.add("h");
		letras.add("i");
		letras.add("j");
		letras.add("k");
		letras.add("l");
		letras.add("m");
		letras.add("n");
		letras.add("o");
		letras.add("p");
		letras.add("q");
		letras.add("r");
		letras.add("s");
		letras.add("t");
		letras.add("u");
		letras.add("v");
		letras.add("w");
		letras.add("x");
		letras.add("y");
		letras.add("z");
		return letras;
		
	}
	// Metódo para Cifrar uma mensagem com uma chave
	public static String Cifrar(String msg,Integer Key) {
		// Cria a lista usando o metódo descrito acima
		List<String> listaCaracteres = CriaListaCaracteres();
		// String para pegar a mensagem cifrada
		String msgCifrada="" ;
		// Remove os espaços da String
		msg =msg.replace(" ", "");
		// Cria uma lista de caracteres em String com base na mensagem
		List<String> listaMsg = new ArrayList<String>(Arrays.asList(msg.split("")));
		// Itera sobre a lista acima e para cada String de caracter da lista
		// pega o valor correspondente na lista letras adiciona o valor da chave
		// e divide por 26. Com base nisso, pega o index correspondente a posição da
		// letra para que a mensagem possa ser cifrada
		for(String c: listaMsg) {
			String ch =listaCaracteres.get((listaCaracteres.indexOf(c)+Key)%26);
			msgCifrada+=ch;
		}
		// Retorna a String
		return msgCifrada;
		
		
	}


}
