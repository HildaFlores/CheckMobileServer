package Util;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
public class Encryption {

    private static final String ENCRYPTION_ALGORITHM = "AES";

    /**
     * Holds the key used by the encryption algorithm.
     */
    private static final byte[] KEY = {'b', 'p', 's', 'y', 'o', 'u', 'r', 'b', 'e', 's', 't', 'a', 'l', 'l', 'y', 'f'};

    /**
     * Encrypts a string.
     *
     * @param data The string to be encrypted.
     * @return A encrypted string.
     * @throws Exception
     */
    public static String encrypt(String data) throws Exception {
        Key key = new SecretKeySpec(KEY, ENCRYPTION_ALGORITHM);
        Cipher c = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, key);
        String encryptedValue = new BASE64Encoder().encode(c.doFinal(data.getBytes()));
        return encryptedValue;
    }

    /**
     * Decrypts a string.
     *
     * @param encryptedData The string to be decrypted.
     * @return A decrypted string.
     * @throws Exception
     */
    public static String decrypt(String encryptedData) throws Exception {
        Key key = new SecretKeySpec(KEY, ENCRYPTION_ALGORITHM);
        Cipher c = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);
        String decryptedValue = new String(c.doFinal(new BASE64Decoder().decodeBuffer(encryptedData)));
        return decryptedValue;
    }
}
