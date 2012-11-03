/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silabsoft.simplecipher;

/**
 *
 * @author Silabsoft
 */
public class AtbashCipher extends SimpleCipher{

    @Override
    public String encrypt(String s){
        String re = "";
        for (char c : s.toCharArray()) {
            int i = getValidCharacterIndex(c);
            if(i > -1){
                re += this.getValidCharacterForIndex(25 - i);
            }
            else{
                re+=c;
            }
        }
        return re;
    }

    @Override
    public String decrypt(String s){
        String re = "";
        for (char c : s.toCharArray()) {
            int i = getValidCharacterIndex(c);
            if(i > -1){
                re += this.getValidCharacterForIndex(Math.abs(i-25));
            }
            else{
                re+=c;
            }
        }
        return re;
    }
}
