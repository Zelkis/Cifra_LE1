package Entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CifraDeslocamento {
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
	public static String Cifrar(String msg,Integer Key) {
		List<String> listaCaracteres = CriaListaCaracteres();
		String msgCifrada="" ;
		msg =msg.replace(" ", "");
		List<String> listaMsg = new ArrayList<String>(Arrays.asList(msg.split("")));
		for(String c: listaMsg) {
			String ch =listaCaracteres.get((listaCaracteres.indexOf(c)+Key)%26);
			msgCifrada+=ch;
		}
		return msgCifrada;
		
		
	}


}
