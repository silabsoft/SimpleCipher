/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silabsoft.simplecipher;

/**
 *
 * @author Silabsoft
 */
public class ROT13Cipher extends SimpleCipher {

    @Override
    public String encrypt(String plainText) {
        String s = "";
        for (char c : plainText.toCharArray()) {
            int i = getValidCharacterIndex(c);
            if(i > -1){
                s+= getValidCharacterForIndex((i+13)%26);
            }
            else
                s+=c;
        }
        return s;
    }

    @Override
    public String decrypt(String encrypted) {
        return encrypt(encrypted);
    }
}
