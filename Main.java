import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        System.out.println("=== SISTEMA DE RH - CADASTRO DE FUNCIONARIOS ===\n");

        // Cadastro de até 10 funcionários
        for (int i = 0; i < 10; i++) {
            System.out.println("Cadastro do Funcionario " + (i + 1));
            System.out.print("Deseja cadastrar um funcionario? (S/N): ");
            String continuar = scanner.nextLine();

            if (continuar.equalsIgnoreCase("N")) {
                break;
            }

            System.out.print("Tipo de funcionario (1-Assalariado / 2-Horista): ");
            int tipo = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("CPF: ");
            String cpf = scanner.nextLine();

            System.out.print("Endereco: ");
            String endereco = scanner.nextLine();

            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();

            System.out.print("Setor: ");
            String setor = scanner.nextLine();

            if (tipo == 1) {
                System.out.print("Salario Mensal: R$ ");
                double salario = scanner.nextDouble();
                scanner.nextLine(); // Limpar buffer

                funcionarios.add(new Assalariado(nome, cpf, endereco, telefone, setor, salario));
            } else if (tipo == 2) {
                System.out.print("Horas Trabalhadas: ");
                double horas = scanner.nextDouble();

                System.out.print("Valor da Hora: R$ ");
                double valorHora = scanner.nextDouble();
                scanner.nextLine(); // Limpar buffer

                funcionarios.add(new //<editor-fold defaultstate="collapsed" desc="comment">
        Horista
//</editor-fold>
(nome, cpf, endereco, telefone, setor, horas, valorHora));
            }

            System.out.println("\nFuncionario cadastrado com sucesso!\n");
        }

        // Mostrar dados e pagamento de todos os funcionários
        System.out.println("\n=== DADOS DOS FUNCIONARIOS CADASTRADOS ===\n");
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.println("Funcionario " + (i + 1) + ":");
            funcionarios.get(i).mostrarDados();
            System.out.println("-----------------------------");
        }

        // Aplicar aumento geral
        System.out.print("\nInforme o percentual de aumento para todos os funcionarios: ");
        double percentualAumento = scanner.nextDouble();

        for (Funcionario func : funcionarios) {
            func.aplicarAumento(percentualAumento);
        }

        // Mostrar pagamentos após o aumento
        System.out.println("\n=== PAGAMENTOS APOS O AUMENTO DE " + percentualAumento + "% ===\n");
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.println("Funcionario " + (i + 1) + ": " + funcionarios.get(i).getNome());
            System.out.println("Novo Pagamento: R$ " + funcionarios.get(i).calcularPagamento());
            System.out.println("------------------------------");
        }

        scanner.close();
    }
}