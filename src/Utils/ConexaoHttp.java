package Utils;

import Models.buscadorCep;
import Models.CepAPI;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexaoHttp{
    private String endereco;

    //Instanciando o Gson
    Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy
                    .UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

    //Declarando o Get do endereço para ser usado como comparação na classe main
    public String getEndereco() {
        return endereco;
    }

    // Declarando o Set do endereço, para atribuir o link da APi com o Cep passando pelo console
    public void setEndereco(String endereco) {
        this.endereco = "https://viacep.com.br/ws/" + endereco + "/json/";
    }

    // Declarando o Metodo que realiza o acesso a API
    public CepAPI acessarSite() {
        // Instanciando um HttpCLiente para fazer a requisição (abre a conexão a partir de um HttpGet ou HttpPost)
        HttpClient client = HttpClient.newHttpClient();
// Instanciando o Http Request para realizar a requisição(chamada) na API
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        //realizando o Try para tentar pegar a (Resposta) do request.
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), CepAPI.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não foi possivel encontrar esse CEP");
        }

    }

}