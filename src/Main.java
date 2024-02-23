import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
//23/02/2024
//Autor: Bianca Vitória Veloso
public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        //VETORES DE CONTROLES DAS CLASSES
        Loja [] vetLoja = new Loja[3];
        vetLoja [0] = new Loja("Loja Barueri","Avenida Alphaville", "06472-020", "Não tem.", true);
        vetLoja [1] = new Loja("Loja Centro São Paulo","Avenida Paulista", "01153 000", "Não tem.", false);
        vetLoja [2] = new Loja("Loja Cotia","Avenida Dr.Odair Pacheco Pedroso", "06717200.", "Não tem.", false);

        Cadastro [] vetCadastro = new Cadastro[10];
        vetCadastro[0] = new Cadastro("Leticia ", "gegegeg", "efkjfk");

        Formulario [] vetFormulario = new Formulario[100];

        Produto [] vetProduto = new Produto[5];
        vetProduto [0] = new Produto("Lasanha", "567890111");
        vetProduto [1] = new Produto("Nuggets", "123456789");
        vetProduto [2] = new Produto("Pizza", "0987654321");
        vetProduto [3] = new Produto("Presunto", "230964752");
        vetProduto [4] = new Produto("Pão de queijo", "2345670987");




        //VARIAVEIS DE CONTROLE
        int contCadastro =1;
        Cadastro cadastro = new Cadastro();
        boolean confirmacaocadastro = false;
        int opcaoProduto = 100000000;
        int contFormulario = 0;
        int opcaoEntrada = 0;
        String email = null;
        int loja = 1;
        boolean verificacao = true;




        System.out.println("Bem-vindo!");
        //OPÇÃO DE ENTRADA
        do {
            do {
                try {
                    //opcaoEntrada = 0;
                    System.out.println("[1] Cadastro \n[2] Login");
                    opcaoEntrada = entrada.nextInt();
                    if(opcaoEntrada != 2 && opcaoEntrada != 1) {
                        System.out.println("Valor invalido! Insira novamente: ");
                        entrada.nextLine();
                    }
                    else {
                        verificacao = false;
                    }
                } catch (InputMismatchException erro) {
                    System.out.println("OPÇÃO INVALIDA! Insira apenas números. ");
                    System.out.println("Valor invalido! Insira novamente: ");
                    entrada.nextLine();

                }
            }while(verificacao == true);
            entrada.nextLine();
            //FAZENDO CADASTRO DO CLIENTE
            if (opcaoEntrada == 1) {
                System.out.println("CADASTRO");
                System.out.println("Para fazer o cadastro preencha os campos corretamente!");
                System.out.println("Nome (COMPLETO): ");
                String nome = entrada.nextLine();
                //entrada.nextLine();
                System.out.println("E-mail: ");
                String email1 = entrada.nextLine();
                System.out.println("Senha: ");
                String senha = entrada.nextLine();
                System.out.println("Confirme sua senha: ");
                String confirmacaoSenha = entrada.nextLine();
                while (!senha.equals(confirmacaoSenha)) {
                    System.out.println("Senha invalida! Insira novamente:");
                    confirmacaoSenha = entrada.nextLine();
                }


                for (int c = 0; c < contCadastro; c++) {
                    if (email1.equals(vetCadastro[c].getEmail())) {
                        System.out.println("Esse email já foi cadastrado!");
                        confirmacaocadastro = true;
                    }
                }
                if(!confirmacaocadastro) {
                    vetCadastro[contCadastro] = new Cadastro(nome, senha, email1);
                    System.out.println("Cadastro realizado com sucesso!");
                    contCadastro++;
                }


            }
            else{
                //FAZENDO O LOGIN DO CLIENTE
                System.out.println("LOGIN ");
                System.out.println("Insira seu email: ");
                email = entrada.nextLine();
                System.out.println("Insira sua senha: ");
                String senha = entrada.nextLine();
                int posicao = cadastro.encotrarCadastro(vetCadastro, email, contCadastro);
                if (posicao >= 0) {
                    System.out.println("Email já cadastrado!");
                    while (!senha.equals(vetCadastro[posicao].getSenha())) {
                        System.out.println("Senha invalida! Insira novamente:");
                        senha = entrada.next();
                    }
                    confirmacaocadastro = true;
                } else {
                    System.out.println("Email não casdatrado");
                    System.out.println("FAÇA SEU CADASTRO JÁ!");
                    System.out.println("Para fazer o cadastro preencha os campos corretamente!");
                    System.out.println("Nome (COMPLETO): ");
                    String nome = entrada.nextLine();
                    //entrada.nextLine();
                    System.out.println("E-mail: ");
                    String email1 = entrada.nextLine();
                    System.out.println("Senha: ");
                    String senha1 = entrada.nextLine();
                    System.out.println("Confirme sua senha: ");
                    String confirmacaoSenha = entrada.nextLine();
                    while (!senha1.equals(confirmacaoSenha)) {
                        System.out.println("Senha invalida! Insira novamente:");
                        confirmacaoSenha = entrada.nextLine();
                    }

//                        for (int c = 0; c < contCadastro; c++) {
//                            if (email1.equals(vetCadastro[c].getEmail())) {
//                                System.out.println("Esse email já foi cadastrado!");
//                            }
//                        }

                    vetCadastro[contCadastro] = new Cadastro(nome, senha1, email);
                    System.out.println("Cadastro realizado com sucesso!");
                    contCadastro++;
                }
            }


        }while(opcaoEntrada == 1);



        //PARTE DE DENTRO DO APLICATIVO
        System.out.println("-----------------------------------------");
        System.out.println("BEM VINDO AO APLICATIVO DA SEARA!");
        while(loja != 0) {
            System.out.println("-----------------------------------------");
            System.out.println("                LOJAS");
            System.out.println("[0] Parar");
            for (int c = 0; c < vetLoja.length; c++) {
                if (!vetLoja[c].getFeito()) {
                    System.out.println("[" + (c + 1) + "]" + vetLoja[c].toString());
                }
            }
            System.out.println("Qual loja você deseja ir: ");
            loja = entrada.nextInt();
            while (loja < 0 || loja > vetLoja.length) {
                System.out.println("Loja não encontrada, insira novamente: ");
                loja = entrada.nextInt();
            }
            System.out.println("-----------------------------------------");
            if(loja != 0) {
                System.out.println("Loja escolhida: " + vetLoja[loja - 1].toString());
                opcaoProduto = 1;
                while (opcaoProduto != 0) {
                    System.out.println("-----------------------------------------");
                    System.out.println("                PRODUTOS");
                    for (int c = 0; c < vetProduto.length; c++) {
                        System.out.println("[" + (c + 1) + "]" + vetProduto[c].toString());
                    }
                    System.out.println("Insira o número do produto que você quer adicionar as informações e 0 para parar: ");
                    opcaoProduto = entrada.nextInt();
                    while (opcaoProduto < 0 || loja > vetProduto.length) {
                        System.out.println("Produto não encontrada, insira novamente: ");
                        opcaoProduto = entrada.nextInt();
                    }
                    if (opcaoProduto == 0) {
                        break;
                    }
                    System.out.println("Produto: " + vetProduto[opcaoProduto - 1].toString());
                    System.out.println("Quantidade do produto: ");
                    int quantidadeProduto = entrada.nextInt();
                    System.out.println("Preço do produto: ");
                    double precoProduto = entrada.nextDouble();
                    contFormulario++;
                    int posicaoRespostaUsuario = cadastro.encotrarCadastro(vetCadastro, email, contCadastro);
                    vetFormulario[contFormulario] = new Formulario(vetProduto[opcaoProduto - 1].getNome(), vetProduto[opcaoProduto - 1].getCodigoBarras(), quantidadeProduto, precoProduto, vetCadastro[posicaoRespostaUsuario], vetLoja[loja-1]);
                }
                for (int c = 0; c < vetLoja.length; c++) {
                    if (c == (loja - 1)) {
                        vetLoja[c].setFeito(true);
                    }
                }
            }
        }
        String caminhoArquivo = "RelatórioFinal.txt";
        try{
            FileWriter fileWriter = new FileWriter(caminhoArquivo);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for(int c = 0; c < vetFormulario.length; c++){
                if(vetFormulario[c] != null) {
                    printWriter.println("----------------------------------------------------");
                    printWriter.println(vetFormulario[c]);
                }
            }
            printWriter.close();
        System.out.println("Relatório final salvo!");
        }catch (IOException e){
            System.out.println("erro");
        }











    }//fim
}//fim