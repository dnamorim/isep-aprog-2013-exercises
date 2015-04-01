/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Exercício 5: Contagem de números inseridos divisives e divisores de nrs. previamente definidos 
 * @author Duarte Nuno Amorim
 */

import java.util.Scanner;

public class PL4_Exc5 {
    public static void main (String[] args) {
        int a,b,aux, nr, c, d, e;
        Scanner read=new Scanner(System.in);
        
        System.out.println("Defina o valor a: (para divisor ou dividendo)");
        a=read.nextInt();
        
        System.out.println("Defina o valor b: (para divisor ou dividendo)");
        b=read.nextInt();
        
        //INVERSÃO DE VARIÁVEIS: garantir que o divisor é mais baixo que o dividendo
        if(a>b) {
            aux=a;
            a=b;
            b=aux;
        }
        
        e=0;
        
        System.out.println("Defina o limite de iteracções:");
        d=read.nextInt();
        
        for(c=1; c<=d; c++) {
            do {
                System.out.println("Insira um número:");
                nr=read.nextInt();
            } while(nr<0);
            
            if(nr%a==0 && b%nr==0) {
                e++;
            }
        }
        
        System.out.println("Quantidade de números divisíveis por "+a+" e divisores de "+b+": "+e);
    }
}
