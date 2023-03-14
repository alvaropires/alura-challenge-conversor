package br.com.alura.frames;

import br.com.alura.formulario.MenuConversorForm;
import br.com.alura.formulario.MenuPrincipalForm;

import java.awt.event.ActionEvent;

public class MenuPrincipal extends MenuPrincipalForm {
    @Override
    public void btnMoedasClick(ActionEvent ev) {
        MenuConversorForm menuConverteMoedas = new MenuConverteMoedas();
        menuConverteMoedas.setVisible(true);
    }

    @Override
    public void btnTemperaturaClick(ActionEvent ev) {
        MenuConversorForm menuConverteTemperatura = new MenuConverteTemperatura();
        menuConverteTemperatura.setVisible(true);
    }

    @Override
    public void btnVazaoClick(ActionEvent ev) {
        MenuConversorForm menuConverteVazao = new MenuConverteVazao();
        menuConverteVazao.setVisible(true);
    }

}
