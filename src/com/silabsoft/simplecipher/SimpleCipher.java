/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silabsoft.simplecipher;

/**
 *
 * @author Silabsoft
 */
public abstract class SimpleCipher {

    private char[] VALID_LETTER = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public abstract String encrypt(String plainText);

    public abstract String decrypt(String encrypted);


    protected int getValidCharacterIndex(char c) {
        for (int i = 0; i < VALID_LETTER.length; i++) {
            if (c == VALID_LETTER[i]) {
                return i;
            }
        }
        return -1;
    }

    protected char getValidCharacterForIndex(int i){
        return VALID_LETTER[i];
    }
}
