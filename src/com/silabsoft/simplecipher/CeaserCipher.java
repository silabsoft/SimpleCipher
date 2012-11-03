/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silabsoft.simplecipher;

/**
 *
 * @author Silabsoft
 */
public class CeaserCipher extends SimpleCipher {

    private final int shift;

    public CeaserCipher(int shift) {
        this.shift = shift;
    }

    @Override
    public String encrypt(String plainText) {
        String s = "";
        for (char c : plainText.toCharArray()) {
            int i = getValidCharacterIndex(c);

            if (i > -1) {
                int x = (i + shift) % 26;
                s += this.getValidCharacterForIndex(x < 0 ? 26 - Math.abs(x)  : x);

            } else {
                s += c;
            }
        }
        return s;
    }

    @Override
    public String decrypt(String encrypted) {
        String s = "";
        for (char c : encrypted.toCharArray()) {
            int i = getValidCharacterIndex(c);
            if (i > -1) {
                int x = (i - shift) % 26;
                s += this.getValidCharacterForIndex(x < 0 ? 26 + x : x);
            } else {
                s += c;
            }
        }
        return s;
    }
}
