package br.com.alura.frames;

import br.com.alura.model.ConversorMoedaModel;
import br.com.alura.service.CotacaoMoedaService;
import br.com.alura.formulario.MenuConversorForm;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MenuConversor extends MenuConversorForm {

    public void converteMoeda() throws Exception {
        JOptionPane.showMessageDialog(new JDialog(), "Convertendo Moedas...");
//        TODO Adicionar recurso para criar String com o codigo de conversao;
        ConversorMoedaModel conversorMoeda = CotacaoMoedaService.getServicoDeCotacao ("USD-BRL");
        JOptionPane.showMessageDialog(new JLabel(), conversorMoeda.toString());

    }
    public void converteTemperatura(){
        JOptionPane.showMessageDialog(new JDialog(), "Convertendo Temperaturas...");
    }
    @Override
    public void btnOkClick(ActionEvent ev) {
//        System.out.println(super.getCbxOpcoes().getSelectedItem());
        switch (super.getCbxOpcoes().getSelectedIndex()){
            case 0:
                try {
                    converteMoeda();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case 1:
                converteTemperatura();
                break;
        }
    }

    @Override
    public void btnFecharClick(ActionEvent ev) {
        super.setVisible(false);
        super.dispose();

    }
}
