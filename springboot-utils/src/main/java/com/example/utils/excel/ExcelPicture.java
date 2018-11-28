package com.example.utils.excel;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.imageio.ImageIO;

import com.example.entity.file.ImgFile;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * @ClassName: ExcelPicture
 * @Description: TODO(将多种格式的图片插入到excel 一个单元格内)
 * @date 2017年9月21日 下午4:21:11
 *
 */
public class ExcelPicture {
    public static void main(String[] args) throws Exception {
        System.out.println("开始插入图片");
        //创建Excel工作簿;
        WritableWorkbook workbook = Workbook.createWorkbook(new File("C:\\Users\\Administrator\\Desktop\\echart.xls"));
        //创建Excel电子薄;
        WritableSheet sheet = workbook.createSheet("插入图片演示", 0);
        //图片路径
        String[] filePaths = new String[4];
        filePaths[0] = "C:\\Users\\Administrator\\Desktop\\echart.png";
        filePaths[1] = "C:\\Users\\Administrator\\Desktop\\c.png";
        filePaths[2] = "C:\\Users\\Administrator\\Desktop\\a.jpg";
        filePaths[3] = "C:\\Users\\Administrator\\Desktop\\b.jpg";
        //filePaths[1] = "F:\\2.jpg";
        //filePaths[2] = "F:\\2.png";
        //filePaths[3] = "F:\\2.gif";
        //调用图片插入函数
        addPictureToExcel(sheet,filePaths,3,3);
        //写入Excel表格中;
        workbook.write();
        //关闭流;
        workbook.close();
        System.out.println("恭喜，图片插入成功！");
    }

    /**
     *
     * @Title: addPictureToExcel
     * @Description: TODO(将多个图片按实际大小，插入同一个单元格,最后一张图如果高度超过了单元格，则压缩高度使之在单元格内)
     * @date 2016年12月16日 下午6:13:52
     * @param @param picSheet
     * @param @param pictureFilePaths
     * @param @param cellRow
     * @param @param cellCol
     * @param @throws Exception 设定文件
     * @return void 返回类型
     * @throws
     */
    private static void addPictureToExcel(WritableSheet picSheet, String[] pictureFilePaths, double cellRow, double cellCol)
            throws Exception {

        final double cellSpace = 0.02;//图片之间的间隔 占比

        double picWidthMax = 0;
        double picHeightSum =0;//空出图片 离上下边框的距离
        ImgFile[] imgFiles = new ImgFile[pictureFilePaths.length];

        for (int i=0;i<pictureFilePaths.length;i++) {
            ImgFile imgFile = new ImgFile();
            File imageFile = new File(pictureFilePaths[i]);
            // 读入图片
            BufferedImage picImage = ImageIO.read(imageFile);
            ByteArrayOutputStream pngByteArray = new ByteArrayOutputStream();
            //将其他图片格式写成png的形式
            ImageIO.write(picImage, "PNG", pngByteArray);
            imgFile.setPngByteArray(pngByteArray);
            // 取得图片的像素高度，宽度
            double picWidth = picImage.getWidth() * 0.15;  //具体的实验值，原理不清楚。
            double picHeight = picImage.getHeight() * 15; //具体的实验值，原理不清楚。

            imgFile.setHeigth(picHeight);
            imgFile.setWidth(picWidth);
            //汇总
            if (picWidth > picWidthMax) {
                picWidthMax = picWidth;
            }
            picHeightSum += picHeight;
            imgFiles[i] = imgFile;
        }

        WritableFont font = new WritableFont(WritableFont.ARIAL,14,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.RED);
        WritableCellFormat cellFormat = new WritableCellFormat(font);
        //设置背景颜色;
        cellFormat.setBackground(Colour.WHITE);
        //设置边框;
        cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
        //设置自动换行;
        cellFormat.setWrap(true);
        //设置文字居中对齐方式;
        cellFormat.setAlignment(Alignment.CENTRE);
        //设置垂直居中;
        cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);

        Label imageLabel = new Label((int)cellCol, (int)cellRow, "",cellFormat);
        picSheet.addCell(imageLabel);

        //设置单元格宽高
        picSheet.setColumnView((int)cellCol, (int)picWidthMax);//列宽
        picSheet.setRowView((int)cellRow, (int)picHeightSum);//行高

        double widthStart = cellSpace;//开始宽度
        double heightStart = cellSpace;//开始高度
        //插入图片
        for (ImgFile imgFile0: imgFiles) {
            double heigthFact = imgFile0.getHeigth()/picHeightSum;//实际高度
            double widthFact = imgFile0.getWidth()/picWidthMax;
            //图片高度压缩了cellSpace+moreHeight,目的是为了该图片高度不超出单元格
            if (heightStart + heigthFact >= 1) {
                double moreHeight = heightStart + heigthFact - 1.00;
                heigthFact -= moreHeight;
                heigthFact -= cellSpace;
            }
            //图片宽度压缩了cellSpace,目的是为了该图片宽度不超出单元格
            if (widthFact >= 1) {
                widthFact -= cellSpace;
            }
            //生成图片对象
            WritableImage image = new WritableImage(cellCol+widthStart, cellRow + heightStart,
                    widthFact, heigthFact, imgFile0.getPngByteArray().toByteArray());
            //将图片对象插入到sheet
            picSheet.addImage(image);
            //开始高度累加，获取下一张图片的起始高度（相对该单元格）
            heightStart += heigthFact;
            heightStart +=cellSpace;//图片直接间隔为cellSpace
        }
    }
}
