package main;

import Entities.CifraDeslocamento;
import Entities.CifraTransposicao;
import Entities.QuebraCifraDeslocamento;
import Entities.QuebraCifraTransposicao;


public class Main {

	public static void main(String[] args) {
		// mensagem de teste
		String msg = "ola tudo bem";
		// exemplo cifrando a mensagem de acordo com a cifra de César
		String msgCifrada =CifraDeslocamento.Cifrar(msg, 3);
		System.out.printf("Mensagem Cifrada: %s ",msgCifrada);
		System.out.println("");
		// Quebra a cifra baseando-se na distribuição de frequências da língua portuguesa
		String quebra = QuebraCifraDeslocamento.quebrarPorFrequencia(msgCifrada);
		System.out.printf("Mensagem quebrada: %s",quebra);
		System.out.println("");
		// Retorna a chave da quebra acima
		System.out.printf("Chave : %d",QuebraCifraDeslocamento.getKey());
		System.out.println("");
		// Quebra a cifra na força bruta
		QuebraCifraDeslocamento.quebraForcaBruta(msgCifrada);
		// Exemplo de mensagem cifrada por transposição por colunas utilizando a chave megabuck
		// Exemplo de mensagem cifrada por transposição por colunas utilizando a chave megabuck
		String msg2 = "pleasetransferonemilliondollarstomyswissbankaccountsixtwotwo";
		String key2 = "megabuck";
		String msgTransposta=CifraTransposicao.transporMsg(msg2, key2);
		System.out.printf("Mensagem em texto plano do slide: %s", msg2);
		System.out.println("");
		System.out.printf("Exemplo do slide transposto pelo algoritmo: %s",msgTransposta);
		System.out.println("");
		// Tentativa de quebra da cifra de transposição por colunas usando outra mensagem em portugues
		String msg3 = "olatudobem";
		String key3 = "ola";
		String msgTransposta3 = CifraTransposicao.transporMsg(msg3, key3);
		System.out.printf("Mensagem em texto plano : %s",msg3);
		System.out.println("");
		System.out.printf("Mensagem Transposta  : %s",msgTransposta3);
		System.out.println("");
		//
		//System.out.println("");
		//String quebraTransposicao = QuebraCifraTransposicao.quebraCifra(msgTransposta2);
		//System.out.printf("Tentativa de quebra 1 : %s",quebraTransposicao);
		//System.out.println("");
		// Outro metódo de transposição criado
		//String msgTransposta3 = CifraTransposicao.TransporMsg2(msg3);
		//System.out.printf("Mensagem Transposta 2: %s",msgTransposta3);
		//System.out.println(""); 
		//
		String quebraTransposicao3 = QuebraCifraTransposicao.quebraCifra2(msgTransposta3,3);
		System.out.printf("Tentativa de quebra : %s",quebraTransposicao3);
		System.out.println("");
		// Exemplo utilizando outra mensagem
		String msg4 = "comovaivoce";
		String key4 ="dia";
		String msgTransposta4 =CifraTransposicao.transporMsg(msg4, key4);
		System.out.printf("Mensagem em texto plano : %s",msg4);
		System.out.println("");
		System.out.printf("Mensagem Transposta : %s" ,msgTransposta4);
		String quebraTransposicao4 = QuebraCifraTransposicao.quebraCifra2(msgTransposta4, 3);
		System.out.println("");
		System.out.printf("Tentativa de quebra : %s",quebraTransposicao4);
		

	}

}
