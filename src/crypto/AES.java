package crypto;

import java.nio.charset.Charset;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;


public class AES {
	
	private static final String CIPHER = "AES/CBC/PKCS5Padding";
    private static final String BASE64_KEY = "dbrCUoc4z9EFJTLBSsZtQw==";
    private static final String INIT_VECTOR = "/NYW0VJsb+oIvXyo";
    private static SecretKeySpec secretKeySpec;
    private static IvParameterSpec ivParameterSpec;
    private static Cipher encryptCipher;
    private static Cipher decryptCipher;
 
    public static void init() throws Exception {
        byte[] key = Base64.decode(BASE64_KEY);
        secretKeySpec = new SecretKeySpec(key, "AES");
        ivParameterSpec = new IvParameterSpec(INIT_VECTOR.getBytes("UTF-8"));
 
        encryptCipher = Cipher.getInstance(CIPHER);
        encryptCipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        decryptCipher = Cipher.getInstance(CIPHER);
        decryptCipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
    }
 
    public static String encrypt(String strToEncrypt) throws Exception {
        return Base64.encode(encryptCipher.doFinal(strToEncrypt.getBytes("UTF-8")));
    }
 
    public static String decrypt(String strToDecrypt) throws Exception {
        return new String(decryptCipher.doFinal(Base64.decode(strToDecrypt)),Charset.forName("UTF-8"));
    }

}
