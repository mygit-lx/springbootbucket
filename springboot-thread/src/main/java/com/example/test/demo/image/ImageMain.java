package com.example.test.demo.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 *
 */
public class ImageMain {

    public static void main(String[] args) throws Exception{
        int width = 1366;
        int height = 768;
        String s = "正在做";

        File file = new File("E:\\luoxiang\\document\\image\\image.jpg");

        Font font = new Font("Serif", Font.BOLD, 100);
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D)bi.getGraphics();
        g2.setBackground(Color.PINK);
        g2.clearRect(0, 0, width, height);
        g2.setPaint(Color.BLACK);

        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(s, context);
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = -bounds.getY();
        double baseY = y + ascent;

        g2.drawString(s, (int)x, (int)baseY);

        ImageIO.write(bi, "jpg", file);
    }

}
