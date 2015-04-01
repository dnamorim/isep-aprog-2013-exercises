/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl6exercicios;

/**
 * Exercício 5: Conjunto Intersecção de Vectores Numéricos
 * @author Duarte Nuno Amorim
 */

import java.util.Formatter;
import java.util.Scanner;

public class PL6_Exc5 {
    
    static Formatter out = new Formatter(System.out);
    static Scanner in = new Scanner(System.in);
   
    public static void main (String [] args) {
        int elmVA,elmVB;
        
        do {
            out.format("Defina qual o número de elementos para o Conjunto nº 1? ");
            elmVA=in.nextInt();
        } while(elmVA<0||elmVA>100);
        
        do {
            out.format("Defina qual o número de elementos para o Conjunto nº 2? ");
            elmVB=in.nextInt();
        } while(elmVB<0||elmVB>100);
        
        int[] va = new int[elmVA];
        int[] vb = new int[elmVB];
        
        lerVector(va, 1);
        lerVector(vb, 2);
        
        interseccao(va,vb);
    }
    
    /**
     * Método interseccção
     * @param va Conjunto numérico 1
     * @param vb Conjunto numérico 2
     */
    private static void interseccao(int[] va, int[] vb) {
        int[] vc = new int[100];
        int nVC=0;
        
        for(int i=0; i<va.length; i++) {
            for(int j=0; j<vb.length; j++) {
                if(va[i]==vb[j]) {
                    vc[nVC]=va[i];
                    nVC++;
                }
            }
        }
        
        if(nVC!=0) {
            out.format("\nCONJUNTO INTERSECÇÃO \n");
            for(int i=0; i<nVC; i++) {
                out.format("%2d", vc[i]);
            }
            out.format("\n");
        } else {
            out.format("Não existe intersecção nos dois Conjuntos Fornecidos.\n");
        }
        
    }
    
    /**
     * Método: Ler Elementos para Vector
     * (com validação de números repetidos
     * 
     * @param v Vector a inserir os números
     * @param cnj Informação sobre qual o vector a trabalhar (exclusivamente para mensagens ao utilizador)
     */
    
    private static void lerVector(int[] v, int cnj) {
        out.format("\nLEITURA DE ELEMENTOS PARA O CONJUNTO Nº %d: \n", cnj);
        boolean flag;
        int aux;
        for(int i=0; i<v.length;i++) {
            out.format("Número na Posição %d? ", (i+1));
            do {
                aux=in.nextInt();
                flag=true;
                for(int j=0;j<i; j++) {
                    if(v[j]==aux) {
                        flag=false;
                    }
                }
                if(flag==false) {
                    out.format("Insira novamente outro número não-repetido na posição %d. ", (i+1));
                } else {
                    v[i]=aux;
                }
            } while(flag==false);
        }
    }
    
   
}