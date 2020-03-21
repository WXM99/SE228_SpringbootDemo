package ebook.utils;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class CryptoClassLoader extends ClassLoader {

  private int byte_offset;

  public CryptoClassLoader(int byte_offset) {
    this.byte_offset = byte_offset;
  }

  private byte[] loadClassName(String className) throws IOException {
    String classPathName = className.replace('.', '/') + ".enclass"; // 加密类的后缀名
    FileInputStream in = null;
    try {
      ByteArrayOutputStream buffer = new ByteArrayOutputStream();
      int ch;
      while ((ch = in.read()) != -1) {
        byte b = (byte) (ch - this.byte_offset);
        buffer.write(b);
      }
      in.close();
      return buffer.toByteArray();
    } finally {
      in.close();
    }

  }

  protected Class<?> findClass(String className) throws ClassNotFoundException {
    byte[] classNameInBytes = null;
    try {
      classNameInBytes = loadClassName(className);
    } catch (IOException e) {
      throw new ClassNotFoundException(className);
    }

    Class<?> cl = defineClass(className, classNameInBytes, 0, classNameInBytes.length);
    if (cl == null)
      throw new ClassNotFoundException(className);
    return  cl;
  }
}
