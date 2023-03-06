package br.com.alura.frames;

import br.com.alura.formulario.MenuConverteMoedasForm;
import br.com.alura.formulario.MenuConversorForm;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MenuConversor extends MenuConversorForm {
    public void converteTemperatura(){
        JOptionPane.showMessageDialog(new JDialog(), "Convertendo Temperaturas...");
    }
    @Override
    public void btnOkClick(ActionEvent ev) {
//        System.out.println(super.getCbxOpcoes().getSelectedItem());
        switch (super.getCbxOpcoes().getSelectedIndex()){
            case 0:
                MenuConverteMoedasForm menuConverteMoedas = new MenuConverteMoedas();
                menuConverteMoedas.setVisible(true);
                super.dispose();
                break;

            default:
                JOptionPane.showMessageDialog(new JDialog(), "Método não implementado!");
        }
    }

    @Override
    public void btnFecharClick(ActionEvent ev) {
        super.setVisible(false);
        super.dispose();

    }
}
