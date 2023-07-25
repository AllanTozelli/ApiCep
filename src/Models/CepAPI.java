package Models;

import com.google.gson.annotations.SerializedName;

public record CepAPI(

        //Utilizamos o @SerializedName("nome na API") passando o nome para nos fazermos o DE PARA
        @SerializedName("cep") String cep,
        @SerializedName("logradouro") String logradouro,
        @SerializedName("complemento") String complemento,
        @SerializedName("bairro") String bairro,
        @SerializedName("localidade") String localidade,
        @SerializedName("uf") String uf) {
}
