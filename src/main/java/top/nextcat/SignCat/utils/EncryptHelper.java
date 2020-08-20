package top.nextcat.SignCat.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptHelper {
    public static byte[] a = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8 };

    public static String decrypt(String text, String password) {
        try {
            byte[] arrayOfByte = EncryptUtils.a(text);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(a);
            SecretKeySpec secretKeySpec = new SecretKeySpec(password.getBytes(), "DES");
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(arrayOfByte));
        } catch (Exception exception) {
            return "";
        }
    }

    public static String encrypt(String text, String password) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(a);
            SecretKeySpec secretKeySpec = new SecretKeySpec(password.getBytes(), "DES");
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return EncryptUtils.a(cipher.doFinal(text.getBytes()));
        } catch (Exception exception) {
            return "";
        }
    }
}
