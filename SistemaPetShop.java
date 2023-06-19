package workfinal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaPetShop {
    private static List<Cliente> clientes;
    private static List<Servico> servicos;
    private static List<Venda> vendas;
    private static int proximoIdCliente;
    private static int proximoIdServico;
    private static int proximoIdVenda;

    public static void main(String[] args) {
        clientes = new ArrayList<>();
        servicos = new ArrayList<>();
        vendas = new ArrayList<>();
        proximoIdCliente = 1;
        proximoIdServico = 1;
        proximoIdVenda = 1;

        exibirMenuPrincipal();
    }

    private static void exibirMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("==== MENU PRINCIPAL ====");
            System.out.println("1. Gerenciar Clientes");
            System.out.println("2. Gerenciar Serviços");
            System.out.println("3. Registrar Venda");
            System.out.println("4. Ver Todas as Vendas");
            System.out.println("5. Ver Total de Dinheiro Feito");
            System.out.println("6. Sair");
            System.out.print("Selecione uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    exibirMenuClientes();
                    break;
                case 2:
                    exibirMenuServicos();
                    break;
                case 3:
                    registrarVenda();
                    break;
                case 4:
                    verTodasAsVendas();
                    break;
                case 5:
                    verTotalDinheiroFeito();
                    break;
                case 6:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 6);
    }

    private static void exibirMenuClientes() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n==== MENU CLIENTES ====");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Editar Cliente");
            System.out.println("3. Remover Cliente");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Selecione uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    editarCliente();
                    break;
                case 3:
                    removerCliente();
                    break;
                case 4:
                    listarClientes();
                    break;
                case 5:
                    System.out.println("Retornando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 5);
    }

    private static void cadastrarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n==== CADASTRAR CLIENTE ====");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Nome do Pet: ");
        String nomePet = scanner.nextLine();
        System.out.print("Tipo do Pet: ");
        String tipoPet = scanner.nextLine();

        Cliente cliente = new Cliente(proximoIdCliente, nome, endereco, telefone, nomePet, tipoPet);
        clientes.add(cliente);
        proximoIdCliente++;

        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void editarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n==== EDITAR CLIENTE ====");
        System.out.print("ID do cliente a ser editado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Cliente cliente = buscarClientePorId(id);
        if (cliente != null) {
            System.out.print("Novo nome: ");
            String nome = scanner.nextLine();
            System.out.print("Novo endereço: ");
            String endereco = scanner.nextLine();
            System.out.print("Novo telefone: ");
            String telefone = scanner.nextLine();

            cliente.setNome(nome);
            cliente.setEndereco(endereco);
            cliente.setTelefone(telefone);

            System.out.println("Cliente editado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void removerCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n==== REMOVER CLIENTE ====");
        System.out.print("ID do cliente a ser removido: ");
        int id = scanner.nextInt();

        Cliente cliente = buscarClientePorId(id);
        if (cliente != null) {
            clientes.remove(cliente);
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void listarClientes() {
        System.out.println("\n==== LISTA DE CLIENTES ====");
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente cliente : clientes) {
                cliente.exibirInformacoes();
                System.out.println("-----------");
            }
        }
    }

    private static Cliente buscarClientePorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    private static void exibirMenuServicos() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n==== MENU SERVIÇOS ====");
            System.out.println("1. Cadastrar Serviço");
            System.out.println("2. Editar Serviço");
            System.out.println("3. Remover Serviço");
            System.out.println("4. Listar Serviços");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Selecione uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarServico();
                    break;
                case 2:
                    editarServico();
                    break;
                case 3:
                    removerServico();
                    break;
                case 4:
                    listarServicos();
                    break;
                case 5:
                    System.out.println("Retornando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 5);
    }

    private static void cadastrarServico() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n==== CADASTRAR SERVIÇO ====");
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Valor: ");
        double valor = scanner.nextDouble();

        Servico servico = new Servico(proximoIdServico, descricao, valor);
        servicos.add(servico);
        proximoIdServico++;

        System.out.println("Serviço cadastrado com sucesso!");
    }

    private static void editarServico() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n==== EDITAR SERVIÇO ====");
        System.out.print("ID do serviço a ser editado: ");
        int id = scanner.nextInt();

        Servico servico = buscarServicoPorId(id);
        if (servico != null) {
            System.out.print("Nova descrição: ");
            String descricao = scanner.nextLine();
            System.out.print("Novo valor: ");
            double valor = scanner.nextDouble();

            servico.setDescricao(descricao);
            servico.setValor(valor);

            System.out.println("Serviço editado com sucesso!");
        } else {
            System.out.println("Serviço não encontrado.");
        }
    }

    private static void removerServico() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n==== REMOVER SERVIÇO ====");
        System.out.print("ID do serviço a ser removido: ");
        int id = scanner.nextInt();

        Servico servico = buscarServicoPorId(id);
        if (servico != null) {
            servicos.remove(servico);
            System.out.println("Serviço removido com sucesso!");
        } else {
            System.out.println("Serviço não encontrado.");
        }
    }

    private static void listarServicos() {
        System.out.println("\n==== LISTA DE SERVIÇOS ====");
        if (servicos.isEmpty()) {
            System.out.println("Nenhum serviço cadastrado.");
        } else {
            for (Servico servico : servicos) {
                servico.exibirInformacoes();
                System.out.println("-----------");
            }
        }
    }

    private static Servico buscarServicoPorId(int id) {
        for (Servico servico : servicos) {
            if (servico.getId() == id) {
                return servico;
            }
        }
        return null;
    }

    private static void registrarVenda() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n==== REGISTRAR VENDA ====");
        System.out.print("ID do cliente: ");
        int idCliente = scanner.nextInt();

        Cliente cliente = buscarClientePorId(idCliente);
        if (cliente != null) {
            List<Servico> servicosSelecionados = selecionarServicos();

            if (!servicosSelecionados.isEmpty()) {
                double total = calcularTotal(servicosSelecionados);

                Venda venda = new Venda(proximoIdVenda, cliente, servicosSelecionados, total);
                vendas.add(venda);
                proximoIdVenda++;

                System.out.println("Venda registrada com sucesso!");
            } else {
                System.out.println("Nenhum serviço selecionado. A venda não pode ser registrada.");
            }
        } else {
            System.out.println("Cliente não encontrado. A venda não pode ser registrada.");
        }
    }

    private static List<Servico> selecionarServicos() {
        Scanner scanner = new Scanner(System.in);
        List<Servico> servicosSelecionados = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n==== SELECIONAR SERVIÇOS ====");
            listarServicos();
            System.out.println("0. Finalizar seleção");
            System.out.print("Selecione um serviço (ID): ");
            opcao = scanner.nextInt();

            if (opcao != 0) {
                Servico servico = buscarServicoPorId(opcao);
                if (servico != null) {
                    servicosSelecionados.add(servico);
                    System.out.println("Serviço selecionado: " + servico.getDescricao());
                } else {
                    System.out.println("Serviço não encontrado. Tente novamente.");
                }
            }
        } while (opcao != 0);

        return servicosSelecionados;
    }

    private static double calcularTotal(List<Servico> servicosSelecionados) {
        double total = 0;
        for (Servico servico : servicosSelecionados) {
            total += servico.getValor();
        }
        return total;
    }

    private static void verTodasAsVendas() {
        System.out.println("\n==== TODAS AS VENDAS ====");
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            for (Venda venda : vendas) {
                venda.exibirInformacoes();
                System.out.println("-----------");
            }
        }
    }

    private static void verTotalDinheiroFeito() {
        double total = 0;
        for (Venda venda : vendas) {
            total += venda.getTotal();
        }
        System.out.println("\n==== TOTAL DE DINHEIRO FEITO ====");
        System.out.println("Total: R$" + total);
    }
}