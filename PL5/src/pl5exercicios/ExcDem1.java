/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl5exercicios;

/**
 * Exercício Demonstrativo 1: Utilização de Módulos - Factorial
 * @author Duarte Nuno Amorim
 */

import java.util.Scanner;

public class ExcDem1 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n;
        
        do {
            System.out.println("Defina os N factoriais a apresentar:");
            n=read.nextInt();
        } while (n<1);
        
        System.out.println("LISTA DE FACTORIAIS DOS PRIMEIROS "+n+" FACTORIAIS:");
        
        for(int i=1; i<=n; i++) {
            System.out.println(factorial(i));
        }
    }
    
    /**
    * Factorial de um número
    *
    * @param nr numero inteiro não negativo
    * @return valor do factorial de nr
    */
    public static long factorial(int nr) {
        long fc = 1;
        for (int i=1; i<=nr; i++) {
            fc *= i;
        }
        
        return fc;
    }
}
