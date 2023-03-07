package br.com.alura.model;

import javax.swing.*;
import java.text.DecimalFormat;

public class ConversorVazaoModel {
    private double vazaoEntrada;
    private double vazaoSaida;

    public void litrosPorSegundoEmLitrosPorHora(double vazaoEntrada){
        double vazaoSaida = vazaoEntrada * 3600;
        String mensagem = vazaoEntrada + " L/s equivalem a " + vazaoSaida + " L/h.";
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public void litrosPorSegundoParaM3PorHora(double vazaoEntrada){
        double vazaoSaida = vazaoEntrada * 3600 / 1000;
        String mensagem = vazaoEntrada + " L/s equivalem a " + vazaoSaida + " m³/h.";
        JOptionPane.showMessageDialog(null, mensagem);
    }
    public void m3PorHoraParaLitrosPorSegundo(double vazaoEntrada){
        double vazaoSaida = vazaoEntrada * 1000/3600;
        String mensagem = vazaoEntrada + " m³/h equivalem a " + vazaoSaida + " L/s.";
        JOptionPane.showMessageDialog(null, mensagem);
    }
    public void m3PorSegundoParaM3PorHora(double vazaoEntrada){
        double vazaoSaida = vazaoEntrada * 3600;
        String mensagem = vazaoEntrada + " m³/s equivalem a " + vazaoSaida + " m³/h.";
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
