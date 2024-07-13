package com.example.firma_sqlite;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

public class FirmaItem {
  private String imageBase64;
  private String firma;

  public FirmaItem(String imageBase64, String firma) {
    this.imageBase64 = imageBase64;
    this.firma = firma;
  }

  public String getImageBase64() {
    return imageBase64;
  }

  public void setImageBase64(String imageBase64) {
    this.imageBase64 = imageBase64;
  }

  public String getFirma() {
    return firma;
  }

  public void setFirma(String descripcion) {
    this.firma = firma;
  }

  public Bitmap getImageBitmap() {
    byte[] decodeString = android.util.Base64.decode(imageBase64, Base64.DEFAULT);

    return BitmapFactory.decodeByteArray(decodeString, 0, decodeString.length);
  }
}
