/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silabsoft.simplecipher;

/**
 *
 * @author Silabsoft
 */
public class PolybiusSquareCipher extends SimpleCipher {

    private final int[] polybiusSquare;
    private final boolean cheatTwentySix;

    public PolybiusSquareCipher() {

        this(new int[]{
                    11, 12, 13, 14, 15,
                    21, 22, 23, 24, 25,
                    31, 32, 33, 34, 35,
                    41, 42, 43, 44, 45,
                    51, 52, 53, 54, 55
                }, false);
    }

    public PolybiusSquareCipher(int[] square) {
        this(square, false);
    }

    public PolybiusSquareCipher(boolean cheatTwentySix) {
        this(new int[]{
                    11, 12, 13, 14, 15,
                    21, 22, 23, 24, 25,
                    31, 32, 33, 34, 35,
                    41, 42, 43, 44, 45,
                    51, 52, 53, 54, 55
                }, cheatTwentySix);
    }

    public PolybiusSquareCipher(int[] square, boolean cheatTwentySix) {
        this.polybiusSquare = square;
        this.cheatTwentySix = cheatTwentySix;
    }

    @Override
    public String encrypt(String plainText) {
        String s = "";
        for (char c : plainText.toCharArray()) {
            int i = getValidCharacterIndex(c);
            if (i == 9) {
                if (cheatTwentySix) {
                    s += 26;
                    continue;
                }
                i = 8;
            }
            if (i > 9) {
                i--;
            }

            s += i > -1 ? "" + polybiusSquare[i] : c;


        }
        return s;
    }

    @Override
    public String decrypt(String encrypted) {
        String s = "";
        char[] characters = encrypted.toCharArray();
        for (int i = 0; i < characters.length; i++) {

            if (Character.isDigit(characters[i]) && i + 1 < characters.length) {
                if (Character.isDigit(characters[i + 1])) {
                    int x = Integer.parseInt(characters[i] + "" + characters[i + 1]);
                    for (int y = 0; y < polybiusSquare.length; y++) {
                        if (x == polybiusSquare[y]) {
                            if (y > 8) {
                                y++;
                            }
                            s += getValidCharacterForIndex(y);
                            i++;
                            break;
                        }
                    }
                    if (x == 26 && cheatTwentySix) {
                        s += getValidCharacterForIndex(9);
                       continue;
                    }

                }

            } else {
                s += characters[i];
            }
        }

        return s;
    }
}
