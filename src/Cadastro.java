public class Cadastro {

    private String nome;
    private String email;
    private String senha;



//métodos getters, setters e construtor
    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }


//    public void setEmail(String email) {
//        this.email = email;
//    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Cadastro(){

    }
    public Cadastro(String nome, String senha, String email){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    //TO STRING
    public String toString(){
        return "Nome: " + nome + " - E-mail: " + email;
    }

    public int encotrarCadastro (Cadastro [] vetCadastro, String email, int cadastro){
        for(int c = 0; c < cadastro; c++){
            if(email.equals(vetCadastro[c].getEmail())){
                return c;
            }
        }
        return -1;
    }


}
