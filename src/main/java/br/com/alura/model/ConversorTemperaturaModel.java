package br.com.alura.model;

import br.com.alura.enums.TemperaturasEnum;

import javax.swing.*;
import java.text.DecimalFormat;

public class ConversorTemperaturaModel {


    public void deCelciusParaFahrenheit(double temperaturaEntrada){
        double temperaturaSaida =  (temperaturaEntrada * 9/5) + 32;
        String mensagem = this.getMensagem(TemperaturasEnum.CELCIUS_FAHRENHEIT.ordinal(), temperaturaEntrada, temperaturaSaida);
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public void deCelciusParaKelvin(double temperaturaEntrada) {
        double temperaturaSaida = temperaturaEntrada + 273.15;
        String mensagem = this.getMensagem(TemperaturasEnum.CELCIUS_KELVIN.ordinal(), temperaturaEntrada,temperaturaSaida);
        JOptionPane.showMessageDialog(null, mensagem);
    }
    public void deFahrenheitParaCelcius(double temperaturaEntrada){
        double temperaturaSaida = (temperaturaEntrada - 32) * 5/9 ;
        String mensagem = this.getMensagem(TemperaturasEnum.FAHRENHEIT_CELCIUS.ordinal(), temperaturaEntrada, temperaturaSaida);
        JOptionPane.showMessageDialog(null, mensagem);
    }
    public void deFahrenheitParaKelvin(double temperaturaEntrada){
        double temperaturaSaida = (temperaturaEntrada - 32) * 5/9 + 273.15;
        String mensagem = this.getMensagem(TemperaturasEnum.FAHRENHEIT_KELVIN.ordinal(), temperaturaEntrada, temperaturaSaida);
        JOptionPane.showMessageDialog(null, mensagem);
    }
    public void deKelvinParaCelcius(double temperaturaEntrada){
        double temperaturaSaida = temperaturaEntrada - 273.15;
        String mensagem = this.getMensagem(TemperaturasEnum.KELVIN_CELCIUS.ordinal(), temperaturaEntrada, temperaturaSaida);
        JOptionPane.showMessageDialog(null, mensagem);
    }
    public void deKelvinParaFahrenheit(double temperaturaEntrada){
        double temperaturaSaida = (temperaturaEntrada-273.15)*9/5 + 32;
        String mensagem = this.getMensagem(TemperaturasEnum.KELVIN_FAHRENHEIT.ordinal(), temperaturaEntrada, temperaturaSaida);
        JOptionPane.showMessageDialog(null, mensagem);
    }
    public String getMensagem(int indice, double temperaturaEntrada, double temperaturaSaida){
        DecimalFormat df = new DecimalFormat("#0.0");

        String[] codigo = TemperaturasEnum.getCodigoPorIndice(indice).split("-");
        return df.format(temperaturaEntrada) + " " + codigo[0] + " equivale a " + df.format(temperaturaSaida) +" "+codigo[1];
    }
}
