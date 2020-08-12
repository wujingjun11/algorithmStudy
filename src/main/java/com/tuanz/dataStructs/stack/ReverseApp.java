package com.tuanz.dataStructs.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 栈事例1 字符串的反序列
 */
public class ReverseApp {

    public static void main(String[] args) throws IOException {

        String input, output;
        while (true){
            System.out.println("Enter a String: ");
            System.out.flush();
            input = getString();
            if(input.equals("")){
                break;
            }
            Reverser theReverser = new Reverser(input);
            output = theReverser.doRev();
            System.out.println("Reversed: "+ output);
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
