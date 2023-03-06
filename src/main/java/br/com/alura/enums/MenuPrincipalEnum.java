package br.com.alura.enums;

import java.util.ArrayList;
import java.util.List;

public enum MenuPrincipalEnum {
    CONVERTE_MOEDA("Conversor de Moedas"),
    CONVERTE_TEMPERATURA("Conversor de Temperaturas");

    private String mensagem;

    MenuPrincipalEnum(String mensagem) {
        this.mensagem = mensagem;
    }

    public static List<String> getMensagens(){
        List<String> mensagens = new ArrayList<>();
        for(MenuPrincipalEnum n: values()){
            mensagens.add(n.mensagem);
        }
        return mensagens;
    }
}
