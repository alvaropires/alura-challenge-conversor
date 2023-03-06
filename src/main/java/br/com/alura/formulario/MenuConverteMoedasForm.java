package br.com.alura.formulario;


import br.com.alura.enums.CodigoMoedasEnum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public abstract class MenuConverteMoedasForm extends JFrame{
    private JPanel pnlForm;
    private JPanel pnlRodape;

    private JButton btnConverter;
    private JButton btnCancelar;

    private JLabel lblEscolhaMoeda;
    protected JComboBox cbxEscolhaMoeda;


    public MenuConverteMoedasForm(){
        this.inicializar();
        this.eventos();
    }

    private void inicializar() {
        this.setTitle("Moedas");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setResizable(false);
        this.setLayout(new BorderLayout());

        this.getContentPane().add(getPnlForm(), BorderLayout.CENTER);
        this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);

//        this.setSize(300,240);
        this.pack();
    }

    public abstract void btnConverterClick(ActionEvent ev);
    public abstract void setBtnCancelarClick(ActionEvent ev);

    public void eventos(){
        this.btnConverter.addActionListener(this::btnConverterClick);
        this.btnCancelar.addActionListener(this::setBtnCancelarClick);
    }

    public JPanel getPnlForm() {
        if (this.pnlForm == null){
            this.pnlForm = new JPanel(new GridLayout(2,1));

            this.lblEscolhaMoeda = new JLabel("Escolha a moeda para a qual deseja" +
                    "girar o seu dinheiro");



            this.cbxEscolhaMoeda = new JComboBox(CodigoMoedasEnum.getMensagens().toArray());

            this.pnlForm.add(lblEscolhaMoeda);
            this.pnlForm.add(cbxEscolhaMoeda);

        }
        return this.pnlForm;
    }

    public JPanel getPnlRodape() {
        if(this.pnlRodape == null){
            this.pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));

            this.btnConverter = new JButton("Converter");
            this.btnCancelar = new JButton("Cancelar");

            this.pnlRodape.add(btnConverter);
            this.pnlRodape.add(btnCancelar);
        }
        return this.pnlRodape;
    }
    public JComboBox getCbxEscolhaMoeda() {
        return cbxEscolhaMoeda;
    }

}
