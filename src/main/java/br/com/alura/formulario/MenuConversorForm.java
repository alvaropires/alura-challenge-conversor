package br.com.alura.formulario;

import br.com.alura.enums.MenuOpcaoEnum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class MenuConversorForm extends JFrame {

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

        this.getContentPane().add(getPnlForm(), BorderLayout.CENTER);
        this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);
//        this.setSize(600, 480);
        this.pack();
    }

    public abstract void btnOkClick(ActionEvent ev);
    public abstract void btnFecharClick(ActionEvent ev);

    public void eventos(){
        this.btnOk.addActionListener(this::btnOkClick);
        this.btnFechar.addActionListener(this::btnFecharClick);

    }

    public JPanel getPnlForm() {
        if(this.pnlForm == null){
//            this.pnlForm = new JPanel(new GridLayout());
            this.pnlForm = new JPanel(new GridLayout(2,1));

            this.lblOpcoes = new JLabel("Escolha uma opção");
            this.cbxOpcoes = new JComboBox<>(MenuOpcaoEnum.getMensagens().toArray());

            this.pnlForm.add(lblOpcoes);
            this.pnlForm.add(cbxOpcoes);


        }
        return this.pnlForm;
    }

    public JPanel getPnlRodape() {
        if(this.pnlRodape == null){
            pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));

            this.btnOk = new JButton("OK");
            this.btnFechar = new JButton("Fechar");

            this.pnlRodape.add(btnOk);
            this.pnlRodape.add(btnFechar);
        }
        return this.pnlRodape;
    }
    public JComboBox getCbxOpcoes() {
        return this.cbxOpcoes;
    }

}
