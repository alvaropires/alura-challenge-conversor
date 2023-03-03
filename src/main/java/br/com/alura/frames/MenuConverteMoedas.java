package br.com.alura.frames;

import br.com.alura.enums.CodigoMoedasEnum;
import br.com.alura.formulario.MenuConverteMoedasForm;
import br.com.alura.model.ConversorMoedaModel;
import br.com.alura.service.CotacaoMoedaService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class MenuConverteMoedas extends MenuConverteMoedasForm {

    public void converteMoeda(String codigoMoeda){
        try{
            ConversorMoedaModel conversorMoeda = CotacaoMoedaService.getServicoDeCotacao (codigoMoeda);
            double valorParaConverter = Integer.parseInt(JOptionPane.showInputDialog("Insira um valor: "));
            double valorDaCotacao = conversorMoeda.getValor();
            double valorConvertido = valorDaCotacao * valorParaConverter;
            DecimalFormat df = new DecimalFormat("#0.00");

            String[] tiposDeMoedas = conversorMoeda.getName().split("/");

            String mensagem = df.format(valorParaConverter) + " " + tiposDeMoedas[0] +
                    " equivale a " + df.format(valorConvertido) + " " + tiposDeMoedas[1];
            JOptionPane.showMessageDialog(new JDialog(), mensagem);
        }catch (Exception ex){
            JOptionPane.showMessageDialog(new JDialog(), "Erro: " + ex.getMessage() +
                    "\nDigite um valor numérico válido!");
            ex.printStackTrace();
        }

    }
    @Override
    public void btnConverterClick(ActionEvent ev) {
        try {
            String codigoConversao = CodigoMoedasEnum.getNameByIndex(cbxEscolhaMoeda.getSelectedIndex());
            this.converteMoeda(codigoConversao);
        }catch (Exception ex){
            JOptionPane.showMessageDialog(new JDialog(), "Erro: " + ex);
        }
    }
    @Override
    public void setBtnCancelarClick(ActionEvent ev) {
        System.out.println("Cancelando...");
        super.setVisible(false);
        super.dispose();
    }
}
