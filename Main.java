
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double saldo = 2500.0;
        String nome = "Bruna Soares";
        String tipoConta = "Corrente";

        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        while (opcao != 4) {

            System.out.println("****************************");
            System.out.println("\nDados iniciais do cliente:");
            System.out.println("Nome: " + nome);
            System.out.println("Tipo de conta: " + tipoConta);
            System.out.printf("Saldo: R$ %,.2f%n", saldo);
            System.out.println("\n****************************");

            System.out.println("Operações");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Receber valor");
            System.out.println("3 - Transferir valor");
            System.out.println("4 - Sair");
            System.out.println("Digite a opção desejada:");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
            } else {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scanner.next();
                opcao = 0;
                continue;
            }

            if (opcao == 1) {

                System.out.printf("Saldo atual: R$ %,.2f%n", saldo);

            } else if (opcao == 2) {

                double deposito;

                while (true) {
                    System.out.println("Informe o valor a depositar:");

                    if (scanner.hasNextDouble()) {
                        deposito = scanner.nextDouble();

                        if (deposito > 0) {
                            break;
                        } else {
                            System.out.println("Valor de depósito inválido. Digite um valor maior que zero.");
                        }

                    } else {
                        System.out.println("Entrada inválida. Digite um valor numérico.");
                        scanner.next();
                    }
                }

                saldo = saldo + deposito;

                System.out.printf("Saldo atualizado: R$ %,.2f%n", saldo);

            } else if (opcao == 3) {

                double valorTransferencia;

                while (true) {
                    System.out.println("Informe o valor que deseja transferir:");

                    if (scanner.hasNextDouble()) {
                        valorTransferencia = scanner.nextDouble();

                        if (valorTransferencia > 0) {
                            break;
                        } else {
                            System.out.println("Valor de transferência inválido. Digite um valor maior que zero.");
                        }

                    } else {
                        System.out.println("Entrada inválida. Digite um valor numérico.");
                        scanner.next();
                    }
                }

                String confirmacao;

                do {
                    System.out.println("Deseja confirmar a transferência? (S/N)");
                    confirmacao = scanner.next();

                    if (!confirmacao.equalsIgnoreCase("S")
                            && !confirmacao.equalsIgnoreCase("N")) {
                        System.out.println("Resposta inválida. Digite S ou N.");
                    }

                } while (!confirmacao.equalsIgnoreCase("S")
                        && !confirmacao.equalsIgnoreCase("N"));

                if (confirmacao.equalsIgnoreCase("S")) {

                    if (saldo >= valorTransferencia) {
                        saldo = saldo - valorTransferencia;
                        System.out.printf("Saldo atualizado: R$ %,.2f%n", saldo);

                    } else {
                        System.out.println("Não há saldo suficiente para realizar esta transferência.");
                    }

                } else {
                    System.out.println("Transferência cancelada.");
                }

            } else if (opcao == 4) {

                System.out.println("Encerrando o programa. Até logo!");

            } else {

                System.out.println("Opção inválida. Escolha uma opção de 1 a 4.");

            }
        }

        scanner.close();
    }
}

