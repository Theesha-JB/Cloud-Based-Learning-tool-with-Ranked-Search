/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import privacypreserving.*;
import java.lang.String.*;
import java.security.*;
import java.util.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.*;
import java.util.Base64;
/**
 *
 * @author 
 */
class AESencrp {
    private static final String ALGO = "AES";
    public static String encrypt(String Data, String k) throws Exception {
        Key key = generateKey(k);
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
       // String encryptedValue = new BASE64Encoder().encode(encVal);
        String encryptedValue=Base64.getEncoder().encodeToString(encVal);
        return encryptedValue;
    }
    public static String decrypt(String encryptedData, String k) throws Exception {
        Key key = generateKey(k);
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
      //  byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
    private static Key generateKey(String k1) throws Exception {
        //String k="muthuvelprograme";
        byte[] keyValue=k1.getBytes();
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
    }
}