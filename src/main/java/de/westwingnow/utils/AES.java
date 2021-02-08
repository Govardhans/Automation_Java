package de.westwingnow.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.spec.AlgorithmParameterSpec;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AES {
    private static final String CIPHER_TYPE = "AES/CBC/PKCS5Padding";
    private static final String INITIALISATION_VECTOR = "1122334455667788";
    private static String sKey;

    public static byte[] encode(byte[] data) {
        return process(Cipher.ENCRYPT_MODE, data);
    }


    public static String encode(String clearText) {
        byte[] data = clearText.getBytes();
        byte[] res = encode(data);
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < res.length; i++) {
            builder.append(String.format("%02x ", res[i]));
        }
        return builder.toString();
    }


    public static byte[] decode(byte[] data) {
        return process(Cipher.DECRYPT_MODE, data);
    }

    public static String decode(String cipherText) {
        String[] strArr = cipherText.split(" ");
        byte[] strByte = new byte[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strByte[i] = Integer.decode("0x" + strArr[i]).byteValue();
        }
        return new String(decode(strByte));
    }

    public static void setSecretKey(String key) {
        sKey = key;
    }

    public static void setSecretKeyFilePath(String secretKeyFilePath) {
        if (sKey == null || sKey.isEmpty()) {
            File sKeyFile = new File(secretKeyFilePath);
            if (!sKeyFile.exists()) throw new RuntimeException("File not found with path " + secretKeyFilePath);

            if (sKeyFile.isFile()) {
                BufferedReader bufferedReader = null;
                FileReader fileReader;
                try {
                    fileReader = new FileReader(secretKeyFilePath);
                    bufferedReader = new BufferedReader(fileReader);
                    sKey = bufferedReader.readLine();
                    fileReader.close();
                    bufferedReader.close();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e.getMessage());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean isCipherFormat(String text) {
        String regex = "[a-f0-9][a-f0-9]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text.trim() + " ");
        int count = 0;
        while (matcher.find())
            count++;
        return (count % 16 == 0) && (count > 0);
    }

    private static byte[] process(int encryptMode, byte[] data) {
        if (sKey == null && sKey.isEmpty()) throw new RuntimeException(
                "Secret Key is not set properly");

        SecretKeySpec key = new SecretKeySpec(sKey.getBytes(), "AES");
        AlgorithmParameterSpec param = new IvParameterSpec(INITIALISATION_VECTOR.getBytes());
        try {
            Cipher cipher = Cipher.getInstance(CIPHER_TYPE);
            cipher.init(encryptMode, key, param);
            return cipher.doFinal(data);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
