public class Loja {

    private String nome;
    private String cep;
    private String rua;
    private String complemento;
    private boolean feito;

    //métodos getters e setters

    public String getNome() {
        return nome;
    }

    public String getRua() {
        return rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCep() {
        return cep;
    }

    public boolean getFeito(){
        return feito;
    }

    public void setFeito(boolean feito) {
        this.feito = feito;
    }

    public Loja(String nome, String rua, String cep, String complemento, boolean feito){
        this.nome = nome;
        this.cep = cep;
        this.complemento = complemento;
        this.rua = rua;
        this.feito = feito;
    }

    @Override
    public String toString() {
        return "Nome da loja: " + this.nome + "\nCEP: " + this.cep + " - Rua: " + this.rua + " - Complemento: " + this.complemento;
    }
}
