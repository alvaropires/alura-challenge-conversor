package br.com.alura.frames;

import br.com.alura.enums.MoedasEnum;
import br.com.alura.exceptions.MoedaNaoEncontradaException;
import br.com.alura.formulario.MenuConversorForm;
import br.com.alura.model.ConversorMoedaModel;
import br.com.alura.service.CotacaoMoedaService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.UnknownHostException;
import java.text.DecimalFormat;

public class MenuConverteMoedas extends MenuConversorForm {

    public void converteMoeda(String codigoMoeda){
        try{
            ConversorMoedaModel conversorMoeda = CotacaoMoedaService.getServicoDeCotacao (codigoMoeda);
            double valorParaConverter = super.trataEntradaDeStringParaDouble(JOptionPane.showInputDialog("Insira um valor: "));
            double valorDaCotacao = conversorMoeda.getValor();
            double valorConvertido = valorDaCotacao * valorParaConverter;
            DecimalFormat df = new DecimalFormat("#0.00");

            String[] tiposDeMoedas = conversorMoeda.getName().split("/");

            String mensagem = df.format(valorParaConverter) + " " + tiposDeMoedas[0] +
                    " equivale a " + df.format(valorConvertido) + " " + tiposDeMoedas[1];
            JOptionPane.showMessageDialog(null, mensagem);
        }catch (NumberFormatException | MoedaNaoEncontradaException | NullPointerException |UnknownHostException ex){
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Erro inesperado: " + ex.getMessage());
        }

    }
    @Override
    public void btnConverterClick(ActionEvent ev) {
        String codigoConversao = MoedasEnum.getNameByIndex(this.getCbxEscolhaDoMenu().getSelectedIndex());
        super.setVisible(false);
        super.dispose();
        this.converteMoeda(codigoConversao);
        super.menuEscolhaSaida();
    }
    @Override
    public void setBtnCancelarClick(ActionEvent ev) {
        super.setVisible(false);
        super.dispose();
    }

    @Override
    public JPanel getPnlForm() {
        if (super.pnlForm == null){
            super.pnlForm = new JPanel(new GridLayout(2,1));
            super.setTituloDoPnlForm("Moedas");

            super.lblEscolhaDoMenu = new JLabel("Escolha a moeda para a qual deseja" +
                    "girar o seu dinheiro");
            super.cbxEscolhaDoMenu = new JComboBox(MoedasEnum.getMensagens().toArray());

            super.pnlForm.add(lblEscolhaDoMenu);
            super.pnlForm.add(cbxEscolhaDoMenu);

        }
        return super.pnlForm;
    }

}
