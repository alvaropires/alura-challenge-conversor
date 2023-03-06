package br.com.alura.frames;

import br.com.alura.formulario.MenuConversorForm;
import br.com.alura.formulario.MenuPrincipalForm;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends MenuPrincipalForm {
    @Override
    public void btnOkClick(ActionEvent ev) {
        switch (super.getCbxOpcoes().getSelectedIndex()){
            case 0:
                MenuConversorForm menuConverteMoedas = new MenuConverteMoedas();
                menuConverteMoedas.setVisible(true);
                super.dispose();
                break;
            case 1:
                MenuConversorForm menuConverteTemperatura = new MenuConverteTemperatura();
                menuConverteTemperatura.setVisible(true);
                super.dispose();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Método não implementado!");
        }
    }

    @Override
    public void btnFecharClick(ActionEvent ev) {
        super.setVisible(false);
        super.dispose();

    }
}
