package br.com.alura.formulario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class MenuConversorForm extends JFrame {

    private final static String[] tipoDeConversao = new String[]{
            "Conversor de Moedas",
            "Conversor de Temperatura"};

    private JPanel pnlForm;
    private JPanel pnlRodape;

    private JButton btnOk;
    private JButton btnFechar;

    private JLabel lblOpcoes;
    private JComboBox cbxOpcoes;

    public MenuConversorForm(){
        this.inicializar();
        this.eventos();
    }

    private void inicializar() {
        this.setTitle("Aplicativo Conversor");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setResizable(false);
        this.setLayout(new BorderLayout());

        this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);
        this.getContentPane().add(getPnlForm(), BorderLayout.CENTER);
//        this.setSize(600, 480);
        this.pack();
    }

    public abstract void btnOkClick(ActionEvent ev);
    public abstract void btnFecharClick(ActionEvent ev);

    public void eventos(){
        btnOk.addActionListener(this::btnOkClick);
        btnFechar.addActionListener(this::btnFecharClick);

    }

    public JPanel getPnlForm() {
        if(this.pnlForm == null){
            this.pnlForm = new JPanel(new GridLayout());

            this.lblOpcoes = new JLabel("Escolha uma opção");
            this.cbxOpcoes = new JComboBox<>(tipoDeConversao);

            pnlForm.add(lblOpcoes);
            pnlForm.add(cbxOpcoes);
        }
        return pnlForm;
    }

    public JPanel getPnlRodape() {
        if(this.pnlRodape == null){
            pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));

            this.btnOk = new JButton("OK");
            this.btnFechar = new JButton("Fechar");

            pnlRodape.add(btnOk);
            pnlRodape.add(btnFechar);
        }
        return pnlRodape;
    }

    public JComboBox getCbxOpcoes() {
        return cbxOpcoes;
    }

}
