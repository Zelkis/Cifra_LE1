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
		System.out.printf("Mensagem em texto plano: %s \n",msg);
		System.out.printf("Mensagem cifrada por deslocamento: %s \n",msgCifrada);
		// Quebra a cifra baseando-se na distribuição de frequências da língua portuguesa
		String quebra = QuebraCifraDeslocamento.quebrarPorFrequencia(msgCifrada);
		System.out.printf("Mensagem quebrada por deslocamento: %s \n",quebra);
		// Retorna a chave da quebra acima
		System.out.printf("Chave da mensagem quebrada : %d \n \n",QuebraCifraDeslocamento.getKey());
		// Quebra a cifra na força bruta
		String msg2 ="transfira dez milhoes para minha conta hoje";
		String msgCifrada2 = CifraDeslocamento.Cifrar(msg2,8);
		String quebra2 = QuebraCifraDeslocamento.quebrarPorFrequencia(msgCifrada2);
		System.out.printf("Mensagem em texto plano: %s \n", msg2);
		System.out.printf("Mensagem cifrada por deslocamento: %s \n", msgCifrada2);
		System.out.printf("Mensagem quebrada por deslocamento: %s \n", quebra2);
		System.out.printf("Chave da mensagem quebrada : %s \n \n",QuebraCifraDeslocamento.getKey());
		
		System.out.println("Quebra por força bruta da primeira mensagem: \n");
		QuebraCifraDeslocamento.quebraForcaBruta(msgCifrada);
		System.out.println("\n \n");
		System.out.println("Quebra por força bruta da segunda mensagem: \n");
		QuebraCifraDeslocamento.quebraForcaBruta(msgCifrada2);
		System.out.println("\n\n");
		// Exemplo de mensagem cifrada por transposição por colunas utilizando a chave megabuck
		// Exemplo de mensagem cifrada por transposição por colunas utilizando a chave megabuck
		String msg_2 = "pleasetransferonemilliondollarstomyswissbankaccountsixtwotwo";
		String key2 = "megabuck";
		String msgTransposta=CifraTransposicao.transporMsg(msg_2, key2);
		System.out.printf("Mensagem em texto plano do slide: %s \n", msg_2);
		System.out.printf("Exemplo do slide transposto pelo algoritmo: %s \n \n",msgTransposta);
		// Tentativa de quebra da cifra de transposição por colunas usando outra mensagem em portugues
		String msg3 = "olatudobem";
		String key3 = "ola";
		String msgTransposta3 = CifraTransposicao.transporMsg(msg3, key3);
		System.out.printf("Mensagem em texto plano: %s \n",msg3);
		System.out.printf("Mensagem cifrada por transposição : %s \n ",msgTransposta3);
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
		System.out.printf("Mensagem quebrada por transposição : %s \n \n",quebraTransposicao3);
		// Exemplo utilizando outra mensagem
		String msg4 = "comovaivoce";
		String key4 ="dia";
		String msgTransposta4 =CifraTransposicao.transporMsg(msg4, key4);
		System.out.printf("Mensagem em texto plano : %s \n",msg4);
		System.out.printf("Mensagem cifrada por transposição : %s \n" ,msgTransposta4);
		String quebraTransposicao4 = QuebraCifraTransposicao.quebraCifra2(msgTransposta4, 3);
		System.out.printf("Mensagem quebrada por transposição : %s \n \n",quebraTransposicao4);
		String msg5 = "voubemevoce";
		String key5 = "cha";
		String msgTransposta5 = CifraTransposicao.transporMsg(msg5, key5);
		String quebraTransposicao5= QuebraCifraTransposicao.quebraCifra2(msgTransposta5,3);
		System.out.printf("Mensagem em texto plano: %s \n",msg5);
		System.out.printf("Mensagem quebrada por transposição: %s \n", msgTransposta5);
		System.out.printf("Mesagem quebrada por transposição : %s \n\n",quebraTransposicao5);
		String msg6 = "vamosaoparquehoje";
		String key6 = "bola";
		String msgTransposta6 = CifraTransposicao.transporMsg(msg6, key6);
		String quebraTransposicao6 =QuebraCifraTransposicao.quebraCifra2(msgTransposta6,4);
		System.out.printf("Mensagem em texto plano: %s \n",msg6);
		System.out.printf("Mensagem quebrada por transposição: %s \n", msgTransposta6);
		System.out.printf("Mesagem quebrada por transposição : %s \n\n",quebraTransposicao6);
		String msg7 = "certotevejola";
		String key7 = "gato";
		String msgTransposta7 = CifraTransposicao.transporMsg(msg7, key7);
		String quebraTransposicao7 =QuebraCifraTransposicao.quebraCifra2(msgTransposta7,4);
		System.out.printf("Mensagem em texto plano: %s \n",msg7);
		System.out.printf("Mensagem quebrada por transposição: %s \n", msgTransposta7);
		System.out.printf("Mesagem quebrada por transposição : %s",quebraTransposicao7);
		
		

	}

}
