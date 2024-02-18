/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package exercicio19;

import java.util.Scanner;

import exercicio19.Dto.ContatoDto;

public class App {
    private static int idAutoIncrement = 1;
    private static AgendaTelefonica agenda = new AgendaTelefonica();

    public static void main(String[] args) {
        try {
            boolean sair = false;
            Scanner scanner = new Scanner(System.in);
            do {
                apresentarMenu();
                if (scanner.hasNext()) {
                    try {
                        int entrada = scanner.nextInt();
                        int opcao = entrada;
                        if (opcao == 0) {
                            sair = true;
                        } else {
                            executarComandos(opcao, scanner);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Por favor, insira um número inteiro válido.");
                    }
                }
            } while (!sair);
            scanner.close();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void apresentarMenu() {
        System.out.println("Agenda Telefonica");
        String menu = """
                -----------------------
                Escolha uma das opções:
                -----------------------
                [1] - Adicionar Contato
                [2] - Remover Contato Pelo Id
                [3] - Atualizar Contato Pelo Id
                [4] - Listar Agenda
                [0] - Sair
                -----------------------
                """;
        System.out.println(menu);
    }

    private static void executarComandos(int opcao, Scanner scanner) {
        switch (opcao) {
            case 1:
                Contato novoContato = criarContato(scanner);
                agenda.adicionarContato(novoContato);
                break;
            case 2:
                int idContatoExclusao = lerIdContatoExclusao(scanner);
                agenda.removerContato(idContatoExclusao);
                break;
            case 3:
                int idContatoAtualizar = lerIdContatoAtualizar(scanner);
                ContatoDto contatoDto = lerNovosDadosContato(scanner);
                agenda.atualizarContato(idContatoAtualizar, contatoDto.nome(), contatoDto.telefone());
                break;
            case 4:
                System.out.println(agenda.getAgendaTelefonica());
                break;

            default:
                throw new IllegalArgumentException("Comando inválido");
        }
    }

    private static Contato criarContato(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Informe o nome do contato");
        String nome = scanner.nextLine();
        System.out.println("Informe o telefone celular do contato");
        String telefone = scanner.nextLine();
        Contato contato = new Contato(idAutoIncrement, nome, telefone);
        incrementarId();
        return contato;
    }

    private static int lerIdContatoExclusao(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Informe o id do contato que deseja excluir");
        return scanner.nextInt();
    }

    private static int lerIdContatoAtualizar(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Informe o id do contato que deseja atualizar");
        return scanner.nextInt();
    }

    private static ContatoDto lerNovosDadosContato(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Informe o novo nome do contato");
        String nome = scanner.nextLine();
        System.out.println("Informe o novo telefone celular do contato");
        String telefone = scanner.nextLine();
        return new ContatoDto(nome, telefone);
    }

    private static void incrementarId() {
        idAutoIncrement += 1;
    }
}
