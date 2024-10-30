package Entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuebraCifraTransposicao {
	public static Map<String,Double> criaFrequencia(){
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
	
	
	public static String quebraCifra(String msg) {
		List<String> lista_permutacoes = new ArrayList<String>();
		Double valor = Double.MIN_VALUE;
		String cifra="";
		PermutacoesPalavra.gerarPermutacoes("",msg,lista_permutacoes);
		for(String per: lista_permutacoes) {
			Double pontuacao= calculaPontuacao(per);
			if(pontuacao > valor) {
				valor = pontuacao;
				cifra = per;
			}
			
		}
		return cifra;
		
		
	}
	public static Double calculaPontuacao(String msg) {
		List<String> lista_caracteres = new ArrayList<String>(Arrays.asList(msg.split("")));
		Map<String,Double> frequencias = criaFrequencia();
		String aux ="";
		Double pontuacao = 0.0;
		for(int i = 0; i<lista_caracteres.size();i++) {
			if (i+1 > lista_caracteres.size()-1) {
				 aux = lista_caracteres.get(i-2) + lista_caracteres.get(i-1) + lista_caracteres.get(i);
				 if(frequencias.get(aux) != null) {
				pontuacao+=frequencias.get(aux);}
				 break;
			} else if(i+2 > lista_caracteres.size()-1) {
				 aux = lista_caracteres.get(i-1) + lista_caracteres.get(i) + lista_caracteres.get(i+1);
				 if(frequencias.get(aux) != null) {
				 pontuacao+= frequencias.get(aux);}
				 break;
			}else {
				aux = lista_caracteres.get(i) + lista_caracteres.get(i+1) + lista_caracteres.get(i+2);
				if(frequencias.get(aux) != null) {
				pontuacao+=frequencias.get(aux);}
			}
		}
		for(int i = 0; i< lista_caracteres.size();i++) {
			if(i+1 > lista_caracteres.size()-1) {
				aux = lista_caracteres.get(i-1) + lista_caracteres.get(i);
				if(frequencias.get(aux)!= null) {
					pontuacao+=frequencias.get(aux);
				} break;
				}
				else {
					aux = lista_caracteres.get(i) + lista_caracteres.get(i+1);
					if(frequencias.get(aux)!= null) {
						pontuacao+=frequencias.get(aux);
					}
				}
			}
		
		return pontuacao;
	}

}