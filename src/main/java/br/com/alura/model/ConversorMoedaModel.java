package br.com.alura.model;

public class ConversorMoedaModel {
    private String name;
    private String code;
    private String codein;
    private double bid;

    public String getName() {
        return name;
    }

    public String getCodigoMoedaEntrada() {
        return code;
    }

    public String getCodigoMoedaSaida() {
        return codein;
    }

    public double getValor() {
        return bid;
    }

    @Override
    public String toString() {
        return "ConversorMoeda{" +
                "name='" + name + '\'' +
                ", codigoMoedaEntrada='" + code + '\'' +
                ", codigoMoedaSaida='" + codein + '\'' +
                ", valor=" + bid +
                '}';
    }
}
