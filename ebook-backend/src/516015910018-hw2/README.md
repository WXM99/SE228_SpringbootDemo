## Q1. 

> 编写一个自定义类加载器，实现字节码加解密

- 字节码解码类加载器: ``./main/java/ebook/utils/CryptoClassLoader.java``
  - 调用``findClass(className)``接口得到解码后的泛型类实例.
- 加密脚本: ``./main/java/ebook/utils/ClassEncryptor.java``
  - 输入原始字节文件和偏移量和输出加密类名称
  - 输出加密字节码文件
- 加密算法: 凯撒加密 — 设置字节偏移量k

## Q2

> 设计一种自定义的权限，可以实现对文件读取路径的控制

FilePermission类: ``./main/java/ebook/utils/FilePermission.java``

## Q3

> 设计一种自定义的认证模块，通过对给定文件中的用户名、密码和角色来进行认证

 ``./main/java/ebook/utils/Authentication``验证模块

// 主要重构了``SimpleLoginMoudel``类

## Q4

> 将E-Book系统的代码进行打包签名，以便在部署时可以先进行验证。

1. 工程打包(省略maven依赖, 仅打包源码)

   ```shell
   $shell jar -cfe ebook.jar ebook.EbookApplication -C java .
   ```

2. 生成秘钥对

   ```shell
   $shell keytool -genkeypair -alias 516015910018-weixm 
   ```

3. 为jar包签名

   ```shell
   $shell jarsigner ./ebook.jar 516015910018-weixm
   ```

4. 验证签名

   ```shell
   $shell jarsigner -verify ./ebook.jar
   ```

   4.1 可以利用公钥``./main/weixm_pub.crt``验证签名