/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Exercício Complementar 2: Sequência Fibonacci
 * - Uma posição é igual a soma das suas 2 casas anteriores.
 * E.g: 1 1 2 3 5 ... (Obs. as 2 primeiras posições são sempre 1)
 * 
 * @author Duarte Nuno Amorim
 */
import java.util.Scanner;

public class PL4_ExcC2 {
    public static void main (String[] args) {
        int s,i=1, j=0; //Variáveis Auxiliares e variável que apresenta o resultado de certa posição da Seq.
        Scanner in = new Scanner (System.in);
        
        System.out.println("Defina o Nr. de Posições a Apresentar da Sequência Fibonacci:");
        int n=in.nextInt();
        
        for(int c=0; c<=n; c++) { //Controla As Posições
            s=i+j; //Soma de 2 valores anteriores da Seq.
            i=j; //i fica com o valor de j
            j=s; //j fica com o valor da ultima pos. da Seq.
            System.out.print(s+" ");
        }
    }
}
