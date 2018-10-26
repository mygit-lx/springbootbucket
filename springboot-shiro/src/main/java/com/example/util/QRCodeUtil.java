package com.example.util;

import com.swetake.util.Qrcode;
import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.data.QRCodeImage;
import jp.sourceforge.qrcode.exception.DecodingFailedException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * 二维码工具类
 * @author luoxiang
 * @date 2017-05-05 10:22:19
 */
public class QRCodeUtil {

    /**
     * 生成二维码(QRCode)图片
     * @param content
     * @param imgPath
     */
    public static void encoderQRCode(String content, String imgPath) {
        try {

            Qrcode qrcodeHandler = new Qrcode();
            qrcodeHandler.setQrcodeErrorCorrect('M');
            qrcodeHandler.setQrcodeEncodeMode('B');
            qrcodeHandler.setQrcodeVersion(7);

            System.out.println(content);
            byte[] contentBytes = content.getBytes("utf-8");

            BufferedImage bufImg = new BufferedImage(140, 140,
                    BufferedImage.TYPE_INT_RGB);

            Graphics2D gs = bufImg.createGraphics();

            gs.setBackground(Color.white);
            gs.clearRect(0, 0, 140, 140);

            // 设定图像颜色 > BLACK
            gs.setColor(Color.BLACK);

            // 设置偏移量 不设置可能导致解析出错
            int pixoff = 2;
            // 输出内容 > 二维码
            if (contentBytes.length > 0 && contentBytes.length < 120) {
                boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);
                for (int i = 0; i < codeOut.length; i++) {
                    for (int j = 0; j < codeOut.length; j++) {
                        if (codeOut[j][i]) {
                            gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
                        }
                    }
                }
            } else {
                System.err.println("QRCode content bytes length = "
                        + contentBytes.length + " not in [ 0,120 ]. ");
            }

            gs.dispose();
            bufImg.flush();

            File imgFile = new File(imgPath);

            // 生成二维码QRCode图片
            ImageIO.write(bufImg, "png", imgFile);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 解码二维码
     * @param imgPath
     * @return String
     */
    public static String decoderQRCode(String imgPath) {

        // QRCode 二维码图片的文件
        File imageFile = new File(imgPath);

        BufferedImage bufImg = null;
        String decodedData = null;
        try {
            bufImg = ImageIO.read(imageFile);

            QRCodeDecoder decoder = new QRCodeDecoder();
            decodedData = new String(decoder.decode(new J2SEImage(bufImg)));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } catch (DecodingFailedException dfe) {
            System.out.println("Error: " + dfe.getMessage());
            dfe.printStackTrace();
        }
        return decodedData;
    }

    static class J2SEImage implements QRCodeImage {
        BufferedImage bufImg;

        public J2SEImage(BufferedImage bufImg) {
            this.bufImg = bufImg;
        }

        public int getWidth() {
            return bufImg.getWidth();
        }

        public int getHeight() {
            return bufImg.getHeight();
        }

        public int getPixel(int x, int y) {
            return bufImg.getRGB(x, y);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String imgPath = "f:/jar/zzh.png";

//        String content = "\t二维码信息"
//                + "\nMyblog  :https://github.com/mygit-lx"
//                + "\nEMail   :qilu_lx@163.com"
//                + "\nQQ      :936201259";
        String content = "https://github.com/mygit-lx&qilu_lx@163.com&936201259";

        encoderQRCode(content, imgPath);
        System.out.println("encoder QRcode success");

        System.out.println("===================================================");

        String decoderContent =decoderQRCode(imgPath);
        System.out.println("解析结果如下：");
        System.out.println(decoderContent);
        System.out.println("========decoder success!!!");
    }

}
