public class Formulario extends Produto{

    private int quantidadeProduto;
    private double precoProduto;
    private Cadastro cadastro;

    private Loja loja;
    // getters e construtor


    public double getPrecoProduto() {
        return precoProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public Cadastro getCadastro() {
        return cadastro;
    }

    public Loja getLoja() {
        return loja;
    }

    public Formulario(String nomeProduto, String codigoBarras, int quantidadeProduto, double precoProduto, Cadastro cadastro, Loja loja){
        super(nomeProduto, codigoBarras);
        this.quantidadeProduto = quantidadeProduto;
        this.precoProduto = precoProduto;
        this.cadastro = cadastro;
        this.loja = loja;
    }

    public String toString(){
        return super.toString() + "\nQuantidade: " + this.quantidadeProduto + " - Preço: "  + this.precoProduto + "\n" + cadastro.toString() + "\n" + loja.toString();
    }

}
