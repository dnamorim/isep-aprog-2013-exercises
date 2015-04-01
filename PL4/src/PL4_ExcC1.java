/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Exercício Complementar 1: Persistência de um Número
 * 
 * @author Duarte Nuno Amorim
 */
import java.util.Scanner;
import java.util.Formatter;

public class PL4_ExcC1 {
    public static void main(String[] args) {
        int i=0, num, nr, n, dig;
        
        Scanner in = new Scanner(System.in);
        Formatter out = new Formatter (System.out);
        
        out.format("Introduza o número a determinar a sua persistência: ");
        nr = in.nextInt();
        while(nr<10) {
            out.format("O número %d inserido é demasiado baixo para determinar a sua persistência. \n Insira novamente outro número superior: ", nr);
            nr = in.nextInt();
        }
        n = nr; //Conservar Número Inserido
        
        while(nr != 0) {
            num=1;
            if(nr!=0) i++;
            while(nr != 0) {
                dig=nr%10;
                num*=dig;
                nr/=10;
            }
           
            nr=num;
        }
        
        out.format("O %d tem como persistência %d.", n, i);
    }
}
