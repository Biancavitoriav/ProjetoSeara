public class Produto {

    private String nome;
    private String codigoBarras;

    //getters e construtor

    public String getNome() {
        return nome;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public Produto(String nome, String codigoBarras){
        this.nome = nome;
        this.codigoBarras = codigoBarras;
    }

    public String toString(){
        return "Cod. Barras: " + this.codigoBarras + " - Nome do Produto:" + this.nome;
    }

}
