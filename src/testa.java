import java.util.Scanner;



public class testa {
	public static void main(String[] args) {
		AVL arvore = null;

		int num, para = 0;
		/*arvore.inserir(2);
		arvore.imprimir();
		 */
		Scanner ler = new Scanner(System.in);
		System.out.println("Implementação de AVL.");

		while(para == 0){	
			System.out.println("Por favor digite uma operacao");

			String op = ler.nextLine();


			switch(op){
			case "0":
				arvore = new AVL();
				System.out.println("Árvore criada.");

				break;

			case "1":
				Scanner ler2 = new Scanner(System.in);
				num = ler2.nextInt();
				arvore.inserir(num);
				break;

			case "2":
				arvore.mostra(arvore.getRaiz(), 1);
				break;

			case "sair":
				para = 1;
				break;
			default:
				System.out.println("por favor insira uma opção valida");


			}
		}
	}
}
