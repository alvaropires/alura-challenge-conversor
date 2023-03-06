package br.com.alura.frames;

import br.com.alura.enums.TemperaturasEnum;
import br.com.alura.formulario.MenuConversorForm;
import br.com.alura.model.ConversorTemperaturaModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuConverteTemperatura extends MenuConversorForm {
    public void converteTemperatura(int tipoDeConversao){
        try{
            ConversorTemperaturaModel conversorTemperatura = new ConversorTemperaturaModel();
            double temperaturaEntrada = super.trataEntradaDeStringParaDouble(JOptionPane
                    .showInputDialog(null, "Digite o valor da temperatura: "));
            switch (tipoDeConversao){

                case 0:
                    conversorTemperatura.deCelciusParaFahrenheit(temperaturaEntrada);
                    break;
                case 1:
                    conversorTemperatura.deCelciusParaKelvin(temperaturaEntrada);
                    break;
                case 2:
                    conversorTemperatura.deFahrenheitParaCelcius(temperaturaEntrada);
                    break;
                case 3:
                    conversorTemperatura.deFahrenheitParaKelvin(temperaturaEntrada);
                    break;
                case 4:
                    conversorTemperatura.deKelvinParaCelcius(temperaturaEntrada);
                    break;
                case 5:
                    conversorTemperatura.deKelvinParaFahrenheit(temperaturaEntrada);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Não implementado.");
            }
        }catch (NullPointerException | NumberFormatException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    @Override
    public void btnConverterClick(ActionEvent ev) {
        super.setVisible(false);
        super.dispose();
        this.converteTemperatura(super.getCbxEscolhaDoMenu().getSelectedIndex());
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
            super.setTituloDoPnlForm("Temperaturas");

            super.lblEscolhaDoMenu = new JLabel("Escolha um tipo de Conversão de Temperatura: ");
            super.cbxEscolhaDoMenu = new JComboBox(TemperaturasEnum.getMensagens().toArray());

            super.pnlForm.add(lblEscolhaDoMenu);
            super.pnlForm.add(cbxEscolhaDoMenu);
        }
        return super.pnlForm;
    }
}
