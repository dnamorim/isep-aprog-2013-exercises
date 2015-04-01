/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl5exercicios;

/**
 * Exercício 4: Teste CalCombinatorio Teoricas
 * @author Duarte Nuno Amorim
 */

import java.util.Scanner;
import java.util.Formatter;

public class PL5_Exc4 { //OU CalCombinatorio
    
        /**
        * Calcular o factorial de um número
        *
        * @param n número inteiro não negativo
        * @return o valor do factorial do n
        */
        private static float factorial(float n) {
            float fact=1;
            for (float i=n; i>1;i=i-1) {
                fact*=i;
            }
            return fact;
        } 
        
        /**
        * Calcula o combinações de n p a p
        *
        * @param n número inteiro não negativo
        * @param p número inteiro não negativo
        * @return o valor combinações de n p a p ou -1 caso n<p
        */
        public static float combinacoes(float n, float p ) {
            if(n<p) {
                return -1;
            }
            return factorial(n)/(factorial(p)*factorial(n-p));
        }
        
        /**
        * Calcula combinações de n (p a p)
        *
        * @param n número inteiro não negativo
        * @param p número inteiro não negativo
        * @return o valor arranjos de n p a p ou -1 caso n<p
        */
        public static float arranjos(float n, float p){
            if(n<p) {
                return -1;
            }
            return factorial(n)/(factorial(n-p));
        }
        
        /**
        * Calcula permutações de n 
        *
        * @param n número inteiro não negativo
        * @return o valor de permutacoes de n
        */
        public static float permutacoes(float n) {
            return factorial(n);
        }
        
        
        //CLASSE de TESTES
        
        public static void main (String[] args) {
            Scanner in = new Scanner(System.in);
            Formatter out = new Formatter(System.out);
                    
            out.format("CÁLCULOS COMBINATÓRIOS: \n");
            out.format("Defina N: ");
            float n = in.nextFloat();
            out.format("Defina P: ");
            float p = in.nextFloat();
            
            TesteCalCombinatorio(n,p);
        }
        
        /**
        * Classe de Testes CalCombinatorio 
        * » apresenta todos os cálculos efectuados pelos modulos criados
        * 
        * @param n número inteiro não negativo
        * @param p número inteiro não negativo
        */
        public static void TesteCalCombinatorio(float n, float p){
            Formatter out = new Formatter(System.out);
            float f= permutacoes(n);
            out.format("Permutações de %.0f = %.0f \n", n, f);
            
            if(arranjos(n,p)!=-1) {
                out.format("Arranjos de %.0f (%.0f a %.0f) = %.4f \n", n, p, p, arranjos(n,p));
            } 
            
            if(combinacoes(n,p)!=-1) {
                out.format("Combinações de %.0f (%.0f a %.0f) = %.4f \n", n, p, p, combinacoes(n,p));
            }
        }
}

       
