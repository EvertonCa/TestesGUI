package sample;

public class Produto {

    public Produto()
    {
        this.nome = "";
        this.preco = 0.0;
        this.quantidade = 0;
    }

    public Produto(String nome, double preco, int quantidade)
    {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    private String nome;
    private Double preco;
    private int quantidade;
}
