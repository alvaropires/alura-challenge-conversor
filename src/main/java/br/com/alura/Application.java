package br.com.alura;

import br.com.alura.formulario.MenuPrincipalForm;
import br.com.alura.frames.MenuPrincipal;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            MenuPrincipalForm menu = new MenuPrincipal();
            menu.setVisible(true);

        });
    }
}
