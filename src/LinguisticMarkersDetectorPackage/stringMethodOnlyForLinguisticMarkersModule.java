/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LinguisticMarkersDetectorPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

final class stringMethodOnlyForLinguisticMarkersModule {

    private static String symbols[] = {"\n", ".", "!", "?", ",", ";", "*", ":", " ", "s.", "s!", "s?", "s,", "s;", "s*", "s ", "s:", "s\n"};

    static boolean contains(String text, String para) {
        text = text.toLowerCase();
        boolean res = false;
        int i = 0;
        String param = "";
        for (i = 0; i < symbols.length; i++) {
            param = " " + para + symbols[i];
            if (text.contains(param.toLowerCase())) {
                res = true;
            }
            param = para + symbols[i];
            if (text.startsWith(param.toLowerCase())) {
                res = true;
            }

        }
        return res;
    }

    static boolean checkBetween(int i, int j, String param) {
        boolean res = false;
        String symbol[] = {".", "!", "?", ",", ";", "*", ":", " "};
        String temp = param.substring(i, j);
        for (int k = 0; k < symbol.length; k++) {
            if (temp.contains(symbol[k])) {
                res = true;
                break;
            }
        }
        return res;
    }

    static boolean containsDigit(String text) {
        boolean res = false;
        int i = 0;
        for (i = 0; i < 10; i++) {
            if (text.contains("" + i)) {
                res = true;
                break;
            }
        }
        return res;
    }

    static String FileToString(String path) throws FileNotFoundException, IOException {
        String file = null;
        File f = new File(path);
        FileInputStream fis = new FileInputStream(f);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String feed = br.readLine();
        while (!feed.isEmpty()) {
            file = file + feed + "\n";
            feed = br.readLine();
        }
        br.close();
        isr.close();
        fis.close();
        return file;
    }

    static String FileToString(File f) throws FileNotFoundException, IOException {
        String file = "";
        FileInputStream fis = new FileInputStream(f);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String feed = br.readLine();
        while (!feed.isEmpty()) {
            file = file + feed + " ";
            feed = br.readLine();
        }
        br.close();
        isr.close();
        fis.close();
        return file;
    }
}
