package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoUsado extends Produto{
    //esqueci de formatar a data aqui no inicio
    private static final SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
    private Date dataFabricacao;

    public ProdutoUsado() {
        super();
    }

    public ProdutoUsado(String nome, Double preco, Date dataFabricacao) {
        super(nome, preco);
        this.dataFabricacao = dataFabricacao;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    @Override
    public String etiquetaPreco(){
        return getNome()+" (usado) $"+ String.format("%.2f",getPreco())
                +"  (Data de fabricação: "+ sdf.format(dataFabricacao) +" )";

    }
}
