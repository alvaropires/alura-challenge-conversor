package br.com.alura.frames;

import br.com.alura.enums.CodigoMoedasEnum;
import br.com.alura.exceptions.MoedaNaoEncontradaException;
import br.com.alura.formulario.MenuConverteMoedasForm;
import br.com.alura.model.ConversorMoedaModel;
import br.com.alura.service.CotacaoMoedaService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.net.UnknownHostException;
import java.text.DecimalFormat;

public class MenuConverteMoedas extends MenuConverteMoedasForm {

    public void converteMoeda(String codigoMoeda){
        try{
            ConversorMoedaModel conversorMoeda = CotacaoMoedaService.getServicoDeCotacao (codigoMoeda);
            double valorParaConverter = this.trataEntradaDeStringParaDouble(JOptionPane.showInputDialog("Insira um valor: "));
            double valorDaCotacao = conversorMoeda.getValor();
            double valorConvertido = valorDaCotacao * valorParaConverter;
            DecimalFormat df = new DecimalFormat("#0.00");

            String[] tiposDeMoedas = conversorMoeda.getName().split("/");

            String mensagem = df.format(valorParaConverter) + " " + tiposDeMoedas[0] +
                    " equivale a " + df.format(valorConvertido) + " " + tiposDeMoedas[1];
            JOptionPane.showMessageDialog(null, mensagem);
        }catch (NumberFormatException | MoedaNaoEncontradaException | UnknownHostException ex){
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Erro inesperado: " + ex.getMessage());
        }

    }
    @Override
    public void btnConverterClick(ActionEvent ev) {
        String codigoConversao = CodigoMoedasEnum.getNameByIndex(cbxEscolhaMoeda.getSelectedIndex());
        this.converteMoeda(codigoConversao);
    }
    @Override
    public void setBtnCancelarClick(ActionEvent ev) {
        System.out.println("Cancelando...");
        super.setVisible(false);
        super.dispose();
    }

    public double trataEntradaDeStringParaDouble(String valorEntrada){
        return Double.parseDouble(valorEntrada.replace(",", "."));
    }
}
