package application;

import models.Produto;
import models.ProdutoImportado;
import models.ProdutoUsado;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner src= new Scanner(System.in);
        List<Produto> lista = new ArrayList<>();

        System.out.println("Digite o número de produtos:");
        int n= src.nextInt();

        for (int i=1;i<=n;i++){
            System.out.println("Produto #"+i+" dados:");
            System.out.println("O produto é comum, usado ou importado? (c/u/i)");
            char tipoProduto = src.next().charAt(0);
            System.out.println("Nome:");
            src.nextLine(); // sem esse não tava pegando o nome para printar na tag
            String nomeProduto= src.nextLine();

            System.out.println("Preço do produto:");
            double precoProd=src.nextDouble();
            if(tipoProduto == 'c'){
                lista.add(new Produto(nomeProduto,precoProd));
            } else if (tipoProduto == 'u') {
                System.out.println("Data de fabricação: (DD/MM/AAAA)");
                Date data= sdf.parse(src.next());
                lista.add(new ProdutoUsado(nomeProduto,precoProd,data));
            }
            else {
                System.out.println("Taxa de importação:");
                Double taxa= src.nextDouble();
                lista.add(new ProdutoImportado(nomeProduto,precoProd,taxa));
            }
        }

        System.out.println();
        System.out.println("Tags de preço:");
        for(Produto prod :lista){
            System.out.println(prod.etiquetaPreco());
        }
    }
}
