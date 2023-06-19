package workfinal;

import java.util.List;

class Venda {
    private int id;
    private Cliente cliente;
    private List<Servico> servicos;
    private double total;

    public Venda(int id, Cliente cliente, List<Servico> servicos, double total) {
        this.id = id;
        this.cliente = cliente;
        this.servicos = servicos;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public double getTotal() {
        return total;
    }

    public void exibirInformacoes() {
        System.out.println("ID: " + id);
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Serviços:");
        for (Servico servico : servicos) {
            System.out.println("- " + servico.getDescricao());
        }
        System.out.println("Total: R$" + total);
    }
}
