import Models.CepApi;
import Utils.ConexaoHttp;
import Utils.GeradorArquivo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //Instanciando o Scanner para realizar a entrada de dados
        Scanner readLine = new Scanner(System.in);
        String busca = "";

        //Instanciando a classe ConexãoHTTP aonde se encontra a conexão com a API
        ConexaoHttp conexao = new ConexaoHttp();

        //Criando um novo ArrayList do tipo CepAPI
        List<CepApi> listaCep = new ArrayList<>();

        while (!busca.equalsIgnoreCase("sair")) {
// Realizando o Get do cep que o usuario deseja consultar
            System.out.println("Digite um CEP para buscar: ");
            conexao.setEndereco(readLine.nextLine());
// Se o usuario digitar Sair irá encerrar a aplicação
            if (conexao.getEndereco().equalsIgnoreCase("https://viacep.com.br/ws/sair/json/")) {
                break;
            }

            try{
                // Instanciando a classe Record CepAPI como uma nova busca no site da API.
                CepApi novoCep = conexao.acessarSite();

                // Instanciando a classe de geração de arquivos
                GeradorArquivo gerador = new GeradorArquivo();

                // Adicionando o Cep consultado na arrayList declarada no coemço do codigo
                listaCep.add(novoCep);

                System.out.println(listaCep);

                // Utilizando os dois metodos da classe Gerador para salvar as informações em arquivos Txt e Json
                gerador.salvaJson(listaCep);
                gerador.salvaTxt(listaCep);

                // Capturando Exeption caso ocorra a exceção ela já está tratada
            }catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizando a aplicação");
            }

        }












        /*while (!busca.equalsIgnoreCase("sair")) {

            ConexaoHttp conexao = new ConexaoHttp();

            System.out.println("Digite um CEP para buscar: ");
            conexao.setEndereco(readLine.nextLine());

            if (conexao.getEndereco().equalsIgnoreCase("https://viacep.com.br/ws/sair/json/")) {
                break;
            }
            System.out.println(conexao.getEndereco());

            conexao.acessarSite();
            buscadorCep novaBusca = new buscadorCep();
            novaBusca.getCepApi();




        }*/
    }
}