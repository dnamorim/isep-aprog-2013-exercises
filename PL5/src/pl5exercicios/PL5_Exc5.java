/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl5exercicios;

/**
 * Exercício 5:Verificação de Capicuas
 *
 * @author Duarte Nuno Amorim
 */

import java.util.Scanner;
import java.util.Formatter;

public class PL5_Exc5 {
    /**
        * Verificar se Número é Capicua
        *
        * @param nr número inteiro 
        * @return true ou false (se é capicua ou não)
        */
    public static boolean capicua(long nr) {
        long inv = 0, dig, n = nr;

        if (nr > 0) {
            while (n != 0) {
                inv *= 10 + (n % 10);
                n /= 10;
            }
        }
        
        if (nr == inv) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
        * Verificar se Número é Capicua 
        * (recorre a propiedades de strings)
        * 
        * @param nr String com um número 
        * @return true ou false (se é capicua ou não)
        */
    public static boolean capicua_str(String nr) {
        int size = nr.length();
        for(int i=0; i <= size/2; i++) {
            if(nr.charAt(i)!= nr.charAt(size-1-i)) {
                return false;
            }
        }
        return true;           
    }
    
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        Formatter out = new Formatter(System.out);
        int nr, i=1;
        
        out.format("Insira um Número Inteiro: ");
        nr=in.nextInt();
        while(capicua(nr) || i<=100) {
            out.format("Insira um Número Inteiro: ");
            nr=in.nextInt();
            i++;
        }
        /*RESOLUÇÃO RECORRENDO A STRING
         * 
        String num = Integer.toString(nr);
        while(capicua_str(num) || num <=100) {
                        out.format("Insira um Número Inteiro: ", args);
            nr=in.nextInt();
            i++;
        }
        }
        */
    }
}