/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import com.silabsoft.simplecipher.*;

/**
 *
 * @author Silabsoft
 */
public class CipherTest {

    public static SimpleCipher[] ciphers = {new AtbashCipher(), new CeaserCipher(-1), new BaconCipher(false), new ROT13Cipher(), new ROT13CeaserCipher(), new PolybiusSquareCipher(true)};

    public static void main(String args[]) {
        String test = "the quick red fox jumped over the lazy brown dog";
        for (SimpleCipher c : ciphers) {
            System.out.println("Cipher: " + c.getClass().getSimpleName());
            System.out.println("Plain txt: " + test);
            String encypted = c.encrypt(test);
            System.out.println("Encrypted: " + encypted);
            System.out.println("Decrypted: " + c.decrypt(encypted));
            System.out.println();
        }
    }
}
