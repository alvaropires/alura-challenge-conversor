package br.com.alura.frames;

import br.com.alura.enums.VazaoEnum;
import br.com.alura.formulario.MenuConversorForm;
import br.com.alura.model.ConversorVazaoModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuConverteVazao extends MenuConversorForm {

    public void converteVazao(int tipoDeConversao){
        ConversorVazaoModel conversorVazao = new ConversorVazaoModel();
        double vazaoEntrada = super.trataEntradaDeStringParaDouble(JOptionPane
                .showInputDialog(null, "Digite o valor da vazão: "));
        switch (tipoDeConversao){
            case 0:
                conversorVazao.litrosPorSegundoEmLitrosPorHora(vazaoEntrada);
                break;
            case 1:
                conversorVazao.litrosPorSegundoParaM3PorHora(vazaoEntrada);
                break;
            case 2:
                conversorVazao.m3PorHoraParaLitrosPorSegundo(vazaoEntrada);
                break;
            case 3:
                conversorVazao.m3PorSegundoParaM3PorHora(vazaoEntrada);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Não implementado...");
        }
    }
    @Override
    public void btnConverterClick(ActionEvent ev) {
        super.setVisible(false);
        super.dispose();

        this.converteVazao(super.getCbxEscolhaDoMenu().getSelectedIndex());

        super.menuEscolhaSaida();

    }

    @Override
    public void setBtnCancelarClick(ActionEvent ev) {
        super.setVisible(false);
        super.dispose();

    }

    @Override
    public JPanel getPnlForm() {
        if(super.pnlForm == null){
            super.pnlForm = new JPanel(new GridLayout(2,1));
            super.setTituloDoPnlForm("Vazão");

            super.lblEscolhaDoMenu = new JLabel("Escolha o tipo de conversão de vazão: ");
            super.cbxEscolhaDoMenu = new JComboBox(VazaoEnum.getMensagens().toArray());

            super.pnlForm.add(lblEscolhaDoMenu);
            super.pnlForm.add(cbxEscolhaDoMenu);

        }
        return pnlForm;
    }
}
