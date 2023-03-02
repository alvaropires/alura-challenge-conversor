package br.com.alura;

import br.com.alura.formulario.MenuConversorForm;
import br.com.alura.frames.MenuConversor;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            MenuConversorForm menu = new MenuConversor();
            menu.setVisible(true);

        });
    }
}
