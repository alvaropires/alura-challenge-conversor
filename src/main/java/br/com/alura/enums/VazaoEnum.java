package br.com.alura.enums;

import java.util.ArrayList;
import java.util.List;

public enum VazaoEnum {
    L_SEGUNDO_L_HORA("Litros/segundo em Litros/hora"),
    L_SEGUNDO_M3_HORA("Litros/segundo em m³/hora"),
    M3_HORA_L_SEGUNDO("m³/hora em Litros/segundo"),
    M3_SEGUNDO_M3_HORA("m³/segundo em m³/hora");

    private String mensagem;

    VazaoEnum(String mensagem) {
        this.mensagem = mensagem;
    }

    public static List<String> getMensagens(){
        List<String> mensagens = new ArrayList<>();
        for (VazaoEnum n: values()){
            mensagens.add(n.mensagem);
        }
        return mensagens;
    }
}
