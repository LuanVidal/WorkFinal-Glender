package workfinal;

class Cliente extends Pessoa {
    private String nomePet;
    private String tipoPet;

    public Cliente(int id, String nome, String endereco, String telefone, String nomePet, String tipoPet) {
        super(id, nome, endereco, telefone);
        this.nomePet = nomePet;
        this.tipoPet = tipoPet;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Nome do Pet: " + getNomePet());
        System.out.println("Tipo do Pet: " + getTipoPet());
    }

    // Getters e setters encapsulados
    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public String getTipoPet() {
        return tipoPet;
    }

    public void setTipoPet(String tipoPet) {
        this.tipoPet = tipoPet;
    }
}
