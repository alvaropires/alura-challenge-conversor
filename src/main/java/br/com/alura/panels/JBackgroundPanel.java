package br.com.alura.panels;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class JBackgroundPanel extends JPanel {
    protected BufferedImage backgroundImage = null;

    public JBackgroundPanel() {
        super();
    }

    public JBackgroundPanel(BufferedImage backgroundImage) {
        super();
        setBackgroundImage(backgroundImage);
    }

    public JBackgroundPanel(URL url) throws IOException {
        super();
        setBackgroundImage(url);
    }

    public JBackgroundPanel(String resourceLocation) throws IOException {
        super();
        setBackgroundImage(resourceLocation);
    }

    public void setBackgroundImage(BufferedImage img) {
        this.backgroundImage = img;
    }

    public void setBackgroundImage(URL url) throws IOException {
        this.backgroundImage = ImageIO.read(url);
    }

    public void setBackgroundImage(String resourceLocation) throws IOException {
        URL backgroundUrl = getClass().getResource(resourceLocation);
        this.backgroundImage = ImageIO.read(backgroundUrl);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), null);
        }
    }
}