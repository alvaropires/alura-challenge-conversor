package br.com.alura.service;

import br.com.alura.enums.TemperaturasEnum;

import javax.swing.*;
import java.text.DecimalFormat;

public class ConversorTemperaturaService {


    public double deCelciusParaFahrenheit(double celcius){
        double fahrenheit =  (celcius * 9/5) + 32;
        String mensagem = this.getMensagem(TemperaturasEnum.CELCIUS_FAHRENHEIT.ordinal(), celcius, fahrenheit);
        JOptionPane.showMessageDialog(null, mensagem);
        return fahrenheit;
    }

    public double deCelciusParaKelvin(double celcius) {
        double kelvin = celcius + 273.15;
        String mensagem = this.getMensagem(TemperaturasEnum.CELCIUS_KELVIN.ordinal(), celcius,kelvin);
        JOptionPane.showMessageDialog(null, mensagem);
        return kelvin;
    }
    public double deFahrenheitParaCelcius(double fahrenheit){
        double celcius = (fahrenheit - 32) * 5/9 ;
        String mensagem = this.getMensagem(TemperaturasEnum.FAHRENHEIT_CELCIUS.ordinal(), fahrenheit, celcius);
        JOptionPane.showMessageDialog(null, mensagem);
        return celcius;
    }
    public double deFahrenheitParaKelvin(double fahrenheit){
        double kelvin = (fahrenheit - 32) * 5/9 + 273.15;
        String mensagem = this.getMensagem(TemperaturasEnum.FAHRENHEIT_KELVIN.ordinal(), fahrenheit, kelvin);
        JOptionPane.showMessageDialog(null, mensagem);
        return kelvin;
    }
    public double deKelvinParaCelcius(double kelvin){
        double celcius = kelvin - 273.15;
        String mensagem = this.getMensagem(TemperaturasEnum.KELVIN_CELCIUS.ordinal(), kelvin, celcius);
        JOptionPane.showMessageDialog(null, mensagem);
        return celcius;
    }
    public double deKelvinParaFahrenheit(double kelvin){
        double fahrenheit = (kelvin-273.15)*9/5 + 32;
        String mensagem = this.getMensagem(TemperaturasEnum.KELVIN_FAHRENHEIT.ordinal(), kelvin, fahrenheit);
        JOptionPane.showMessageDialog(null, mensagem);
        return fahrenheit;
    }
    public String getMensagem(int indice, double temperaturaEntrada, double temperaturaSaida){
        DecimalFormat df = new DecimalFormat("#0.0");

        String[] codigo = TemperaturasEnum.getCodigoPorIndice(indice).split("-");
        return df.format(temperaturaEntrada) + " " + codigo[0] + " equivale a " + df.format(temperaturaSaida) +" "+codigo[1];
    }
}
