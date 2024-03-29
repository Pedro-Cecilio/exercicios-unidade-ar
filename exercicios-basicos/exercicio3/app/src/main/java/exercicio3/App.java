/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package exercicio3;

import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1 - Pedra");
            System.out.println("2 - Papel");
            System.out.println("3 - Tesoura");
            System.out.println("Escolha sua opção:");
            int opcao = scanner.nextInt();
            int opcaoMaquina = new Random().nextInt(3) + 1;
            System.out.println("Maquina: " + opcaoMaquina);
            if(opcao < 1 || opcao > 3){
                System.out.println("Opção inválida");
                continue;
            }
            if(opcao == opcaoMaquina){
                System.out.println("Vocês empataram");
                continue;
            }
            if((opcao == 3 && opcaoMaquina == 2) || (opcao == 2 && opcaoMaquina == 1) || (opcao == 1 && opcaoMaquina == 3)){
                System.out.println("Você ganhou!");
                break;
            }
            System.out.println("Você perdeu!");
            break;
        } while (true);

    }
}
