package com.tuanz.stack01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 分隔符匹配应用，匹配（）｛｝[]三种类型
 */
public class BracketApp {

    public static void main(String[] args) throws IOException {
        String input;
        while(true){
            System.out.print("Enter string containing delimiters: ");
            System.out.flush();
            input = getString();
            if ("".equals(input)){
                break;
            }
            BracketChecker theChecker = new BracketChecker(input);
            theChecker.check();
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
