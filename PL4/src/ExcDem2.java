/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Exercício Demnostrativo 2: N números primos
 * @author Duarte Nuno Amorim
 */
import java.util.Scanner;

public class ExcDem2 {
    public static void main(String[] args) {
        int n, p,soma,i;
        long nr;
        Scanner read = new Scanner(System.in);
        
        //NRS. PERFEITOS A APRESENTAR
        do {
            System.out.println("Insira a Quantidade de números perfeitos a apresentar:");
            n=read.nextInt();
        } while(n < 1);
        
        p=0; //CONTADOR PERFEITOS
        nr=1; //VARIÁVEL NR. PERFEITO
        
        System.out.println("LISTAGEM DE NRS. PERFEITOS:");
        
        do {
            nr++; //1 NÃO É PERFEITO
            soma=0; 
            
            
            //ENCONTRAR DIVISORES DE UM NUMERO
            for(i=1; i<= nr/2; i++) {
                if(nr % i == 0) {
                    soma+=i;
                }
            }
            
            if(soma == nr) { //SE É NR. PERFEITO
                p++;
                System.out.println(nr);
            }
        } while (p < n);
    }
}
