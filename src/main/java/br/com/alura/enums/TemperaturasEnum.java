package br.com.alura.enums;

import java.util.ArrayList;
import java.util.List;

public enum TemperaturasEnum {
    CELCIUS_FAHRENHEIT("De ºC para °F", "°C-°F"),
    CELCIUS_KELVIN("De °C para K", "°C-K"),
    FAHRENHEIT_CELCIUS("De °F para °C", "°F-°C"),
    FAHRENHEIT_KELVIN("De ºF para K", "°F-K"),
    KELVIN_CELCIUS("De K para °C", "K-°C"),
    KELVIN_FAHRENHEIT("De K para °F", "K-°F");
    private String mensagem;
    private String codigo;


    TemperaturasEnum(String mensagem, String codigo) {
        this.mensagem = mensagem;
        this.codigo = codigo;
    }

    public static List<String> getMensagens() {
        List<String> mensagens = new ArrayList<>();
        for(TemperaturasEnum n: values()){
            mensagens.add(n.mensagem);
        }
        return mensagens;
    }

    public static String getCodigoPorIndice(int indice) {
        for(TemperaturasEnum n: values()){
            if(n.ordinal() == indice){
                return n.codigo;
            }
        }
        throw new IllegalArgumentException("Índice de Temperaturas inválido: " + indice);
    }
}
