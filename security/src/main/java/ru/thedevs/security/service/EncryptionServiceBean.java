package ru.thedevs.security.service;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

@Component
class EncryptionServiceBean implements IEncryptionService {

  private final String S1;
  private final String S2;

  @Autowired
  public EncryptionServiceBean(Environment environment) {
    this.S1 = environment.getProperty("v");
    this.S2 = environment.getProperty("v1");
  }

  public String encrypt(String value) {
    try {
      IvParameterSpec iv = new IvParameterSpec(S2.getBytes(StandardCharsets.UTF_8));
      SecretKeySpec skeySpec = new SecretKeySpec(S1.getBytes(StandardCharsets.UTF_8), "AES");

      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
      cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

      byte[] encrypted = cipher.doFinal(value.getBytes());
      return Base64.encodeBase64String(encrypted);
    } catch (Exception ex) {
      throw new RuntimeException("Error while encrypting: " + ex.toString());
    }
  }

  public String decrypt(String encrypted) {
    try {
      IvParameterSpec iv = new IvParameterSpec(S2.getBytes(StandardCharsets.UTF_8));
      SecretKeySpec skeySpec = new SecretKeySpec(S1.getBytes(StandardCharsets.UTF_8), "AES");

      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
      cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

      byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

      return new String(original);
    } catch (Exception ex) {
      throw new RuntimeException("Error while decrypting: " + ex.toString());
    }
  }
}