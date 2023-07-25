package Models;

import java.util.List;

public class buscadorCep implements Comparable<buscadorCep>  {


    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public String getCep() {
        return cep;
    }



    @Override
    public int compareTo(buscadorCep outroCep) {
        return this.getCep().compareTo(outroCep.getCep());
    }
}