package Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeradorArquivo {


    // Criando o Metodo para salvar a lista de arquivos em formato de Json
    public void salvaJson(List listCepApi) throws IOException {
        // Declarando o GsonBuilder para fazer a formatação dos dados passados.
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //Instanciando a Classe FileWrite que salva o arquivo solicitado
        FileWriter fw = new FileWriter("Cep.json");
        // Pegando um metodo da classe instanciada e passando o parametro ListCeApi recebido da classe Main
        fw.write(gson.toJson(listCepApi));
        // Fechando o arquivo e salvado
        fw.close();

    }
    // Criando o Metodo para salvar a lista de arquivos em formato de TXT
    public void salvaTxt(List listCepApi) throws IOException {
        // Declarando o GsonBuilder para fazer a formatação dos dados passados.
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //Instanciando a Classe FileWrite que salva o arquivo solicitado
        FileWriter escrita = new FileWriter("Cep.txt");
        // Pegando um metodo da classe instanciada e passando o parametro ListCeApi recebido da classe Main
        escrita.write(gson.toJson(listCepApi));
        // Fechando o arquivo e salvado
        escrita.close();
    }
    }
