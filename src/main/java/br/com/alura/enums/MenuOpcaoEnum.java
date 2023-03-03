package br.com.alura.enums;

import java.util.ArrayList;
import java.util.List;

public enum MenuOpcaoEnum {
    CONVERTE_MOEDA("Conversor de Moedas"),
    CONVERTE_TEMPERATURA("Conversor de Temperaturas");

    private String mensagem;

    MenuOpcaoEnum(String mensagem) {
        this.mensagem = mensagem;
    }

    public static List<String> getMensagens(){
        List<String> mensagens = new ArrayList<>();
        for(MenuOpcaoEnum n: values()){
            mensagens.add(n.mensagem);
        }
        return mensagens;
    }
}
