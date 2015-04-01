/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Exercício 6: Maior Sequência de Pares
 * @author Duarte Nuno Amorim
 */
import java.util.Scanner;

public class PL4_Exc6 {
    public static void main(String[] args) {
        int n, s1=0, s2=0;
        Scanner read = new Scanner(System.in);
        
        System.out.println("Insira os elementos da Sequência Nº1: (0 para terminar)");
        do {
            n=read.nextInt();
            if(n%2==0) {
                s1++;
            }
        } while(n!=0);

        System.out.println("Insira os elementos da Sequência Nº2: (-1 para terminar)");
        do {
            n=read.nextInt();
            if(n%2==0) {
                s2++;
            }
        } while(n!=-1);
    
        if(s1==s2) {
            System.out.println("As sequências têm a mesma quantidade de números pares.");
        } else if(s2>s1) {
            System.out.println("A Sequência 2 tem mais nº pares - "+s2);
        } else {
            System.out.println("A Sequência 1 tem mais nº pares - "+s1);
        }
    }
}
