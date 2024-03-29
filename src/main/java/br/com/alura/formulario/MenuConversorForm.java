package br.com.alura.formulario;


import br.com.alura.frames.MenuPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public abstract class MenuConversorForm extends JFrame{
    protected JPanel pnlForm;
    private JPanel pnlRodape;

    private JButton btnConverter;
    private JButton btnCancelar;

    protected JLabel lblEscolhaDoMenu;
    protected JComboBox cbxEscolhaDoMenu;
    private String tituloDoPnlForm;


    public MenuConversorForm(){
        this.inicializar();
        this.eventos();
    }

    private void inicializar() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setResizable(false);
        this.setLayout(new BorderLayout());



        this.getContentPane().add(getPnlForm(), BorderLayout.CENTER);
        this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);

        this.setSize(300,240);
        this.setTitle(this.tituloDoPnlForm);
        this.pack();
        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - getWidth()/2,
                Toolkit.getDefaultToolkit().getScreenSize().height/2 - getHeight()/2);
    }

    public abstract void btnConverterClick(ActionEvent ev);
    public abstract void setBtnCancelarClick(ActionEvent ev);

    public abstract JPanel getPnlForm();

    public void eventos(){
        this.btnConverter.addActionListener(this::btnConverterClick);
        this.btnCancelar.addActionListener(this::setBtnCancelarClick);
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
    public JComboBox getCbxEscolhaDoMenu() {
        return cbxEscolhaDoMenu;
    }

    public void menuEscolhaSaida(){
        int escolha = JOptionPane.showConfirmDialog(null, "Deseja continuar?");
        switch (escolha){
            case JOptionPane.YES_OPTION:
                break;
            case JOptionPane.NO_OPTION:
                JOptionPane.showMessageDialog(null, "Programa Finalizado!");
                System.exit(0);
                break;

            case JOptionPane.CANCEL_OPTION:
                JOptionPane.showMessageDialog(null, "Programa Concluído!");
                System.exit(0);
                break;
        }
    }

    public void setTituloDoPnlForm(String tituloDoPnlForm) {
        this.tituloDoPnlForm = tituloDoPnlForm;
    }


    public double trataEntradaDeStringParaDouble(String valorEntrada){
        return Double.parseDouble(valorEntrada.replace(",", "."));
    }
}
