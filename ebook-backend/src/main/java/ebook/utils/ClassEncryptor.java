package ebook.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ClassEncryptor {

  public static void main(String[] args) {
    if (args.length != 3) {
      System.out.println("USAGE: java ClassEncryptor  in out key");
      return;
    }
    try {
      FileInputStream in = new FileInputStream(args[0]);
      FileOutputStream out = new FileOutputStream(args[1]+".enclass");
      int key = Integer.parseInt(args[2]);
      int ch;
      while ((ch = in.read()) != -1) {
        byte c = (byte) (ch + key);
        out.write(c);
      }
      in.close();
      out.close();
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }
}