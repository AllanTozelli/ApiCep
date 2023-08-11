package Models;

public class BuscadorCep implements Comparable<BuscadorCep>  {


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
    public int compareTo(BuscadorCep outroCep) {
        return this.getCep().compareTo(outroCep.getCep());
    }
}