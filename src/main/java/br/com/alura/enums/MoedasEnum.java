package br.com.alura.enums;

import java.util.ArrayList;
import java.util.List;

public enum MoedasEnum {

                    BRL_USD("BRL-USD", "De Reais a Dólares"),
                    BRL_EUR("BRL-EUR", "De Reais a Euros"),
                    BRL_GBP("BRL-GBP", "De Reais a Libras Esterlinas"),
                    BRL_ARS("BRL-ARS", "De Reais a Peso Argentino"),
                    BRL_CLP("BRL-CLP", "De Reais a Peso Chileno"),
                    USD_BRL("USD-BRL", "De Dólares a Reais"),
                    EUR_BRL("EUR-BRL", "De Euros a Reais"),
                    GBP_BRL("GBP-BRL", "De Libras Esterlinas a Reais"),
                    ARS_BRL("ARS-BRL", "De Peso Argentino a Reais"),
                    CLP_BRL("CLP-BRL", "De Peso Chileno a Reais");

                    private String valor;
                    private String mensagem;

    MoedasEnum(String valor, String mensagem){
        this.valor = valor;
        this.mensagem = mensagem;
    }

    public static String getNameByIndex(int indice){
        for(MoedasEnum n: values()){
            if(n.ordinal() == indice){
                return n.valor;
            }
        }
        throw new IllegalArgumentException("Indice de CodigoMoedas inválido: " + indice);
    }

    public static List<String> getMensagens() {
        List<String> mensagens = new ArrayList<>();
        for(MoedasEnum n: values()){
            mensagens.add(n.mensagem);
        }
        return mensagens;
    }
}
