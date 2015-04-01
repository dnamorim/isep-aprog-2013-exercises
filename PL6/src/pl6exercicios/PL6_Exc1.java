/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl6exercicios;

/**
 * Exercício 1
 * 
 *  a) Calcula a média de Números Pares de uma Seq. de Números lidos para um vector.
 * 
 * @author Duarte Nuno Amorim
 */
import java.util.Scanner;
import java.util.Formatter;

public class PL6_Exc1 { //aka Enigma
    
    public static void main(String[] args) {
        int i, s=0, c=0;
        int[] v = new int[10];
        
        Scanner in = new Scanner(System.in);
        Formatter out = new Formatter(System.out);
        
        for(i=0; i<v.length; i++) {
            out.format("Insira um Número na Posição %d: ",i);
            v[i]=in.nextInt();
        }
        
        for(i=0; i<v.length; i++) {
            if(v[i]%2==0) {
                s=s+v[i];
                c++;
            }
        }
        
        if(c!=0) {
            out.format("Média Números Pares: %.2f \n",((double)s)/c);
        } else {
            out.format("Operação Impossível de realizar.\n");
        }
        
        /*
         * Alínea c): Apresentar Índices dos Menores Valores
         */
        int min=menVect(v);
        
        out.format("ÍNDICES DOS MENORES ELEMENTOS DO VECTOR (%d) \n", min);
        
        for(i=0; i<v.length; i++) {
            if(min==v[i]) {
                out.format(" » Índice %2d \n", i);
            }
        }
    }
    
    /**
     * menVect
     * - devolve o menor numero armazenado num vector recebido
     * 
     * @param vec[] vector de inteiros
     * @return menor número armazenado no vector
     */
    public static int menVect(int vec[]) {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<vec.length; i++) {
            if(min>vec[i]) {
               min=vec[i]; 
            }
        }
        return min;
    }
    
}
