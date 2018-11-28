package com.example.entity.file;

import java.io.ByteArrayOutputStream;  
public class ImgFile {  
    private ByteArrayOutputStream pngByteArray;//
  private double width;  
    private double heigth;

    public double getWidth() {
  
      return width;  
  }  
                public void setWidth(double width) {  
  
      this.width = width;  
  }  
                public double getHeigth() {  
  
      return heigth;  
  }  
                public void setHeigth(double heigth) {  
  
      this.heigth = heigth;  
  }
    public ByteArrayOutputStream getPngByteArray() {
        return pngByteArray;
    }
    public void setPngByteArray(ByteArrayOutputStream outPut) {
        this.pngByteArray = outPut;
    }
}
