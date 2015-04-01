/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl5exercicios;

/**
 * Exercício 1: Palíndromo
 * @author Duarte Nuno Amorim
 */
import java.util.Scanner;

public class PL5_Exc1 {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String str;
        int i=0;
        
        System.out.println("Insira uma Palavra:");
        str=read.nextLine();
        
        while(!metodo1(str) || str.equalsIgnoreCase("")) { //!metodo(str) -> metodo1(str)==false
            System.out.println("Insira uma Palavra:");
            str=read.nextLine();
            i++;
        }
        
        System.out.println("Número de Palavras lidas antecedentes ao palindromo "+str+": "+i);
    }
    /**
    *  Verificação de Palindromo
    *
    * @param wrd palavra a verificar (string)
    * @return true/false (se é palindromo ou não)
    */
    public static boolean metodo1(String wrd) {
        boolean resp = true;
        wrd=wrd.toLowerCase();
        int size=wrd.length();
        for(int i=0; i < size/2; i++) {
            if(wrd.charAt(i) != wrd.charAt(size-1-i)) {
                resp=false;
                break;
            }
        }
        
        return resp;
    }
}
