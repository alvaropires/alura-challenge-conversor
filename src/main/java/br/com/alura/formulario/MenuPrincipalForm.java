package br.com.alura.formulario;

import br.com.alura.Application;
import br.com.alura.panels.JBackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public abstract class MenuPrincipalForm extends JFrame {

    private JPanel pnlForm;
    private JPanel pnlRodape;

    private JButton btnMoedas;
    private JButton bntTemperatura;
    private JButton btnVazao;
    private JLabel autor;


    public MenuPrincipalForm(){
        this.inicializar();
        this.eventos();
    }

    private void inicializar() {
        this.setTitle("Aplicativo Conversor");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setSize(800, 600);
        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - getWidth()/2,
                Toolkit.getDefaultToolkit().getScreenSize().height/2 - getHeight()/2);


        this.getContentPane().add(getPnlForm(), BorderLayout.CENTER);
        this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);

    }

    public abstract void btnMoedasClick(ActionEvent ev);
    public abstract void btnTemperaturaClick(ActionEvent ev);
    public abstract void btnVazaoClick(ActionEvent ev);

    public void eventos(){
        this.btnMoedas.addActionListener(this::btnMoedasClick);
        this.bntTemperatura.addActionListener(this::btnTemperaturaClick);
        this.btnVazao.addActionListener(this::btnVazaoClick);
    }

    public JPanel getPnlForm() {
        if(this.pnlForm == null){
            try {
                this.pnlForm = new JBackgroundPanel(Application.class.getResource("/images/challenge-conversor.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String texto = "Desenvolvido por @alvaropires";
            this.autor = new JLabel(texto);
            this.autor.setForeground(Color.cyan);
            this.autor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            this.autor.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/alvaro-pires-santos/"));
                    }catch (IOException | URISyntaxException ex){
                        ex.getMessage();
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    autor.setText("<html><a href=''>" + texto + "</a></html>");
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    autor.setText(texto);
                }
            });
        }
        this.pnlForm.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.pnlForm.add(this.autor);
        return this.pnlForm;
    }

    public JPanel getPnlRodape() {
        if(this.pnlRodape == null){
            pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));

            this.btnMoedas = new JButton("Moedas", new ImageIcon(Application.class.getResource("/images/moeda-icon.png")));
            this.bntTemperatura = new JButton("Temperatura", new ImageIcon(Application.class.getResource("/images/temperatura-icon.png")));
            this.btnVazao = new JButton("Vazão", new ImageIcon(Application.class.getResource("/images/vazao.png")));



            this.pnlRodape.add(btnMoedas);
            this.pnlRodape.add(bntTemperatura);
            this.pnlRodape.add(btnVazao);

            this.pnlRodape.setBackground(Color.darkGray);
        }
        return this.pnlRodape;
    }

}
