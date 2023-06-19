package workfinal;

abstract class Pessoa {
    protected int id;
    protected String nome;
    protected String endereco;
    protected String telefone;

    public Pessoa(int id, String nome, String endereco, String telefone){
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public abstract void exibirInformacoes();

    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEndereco(){
        return endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
}
