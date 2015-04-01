/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl6exercicios;

/**
 * Exercício 6: Conjunto Intersecção de Vectores Numéricos
 * @author Duarte Nuno Amorim
 */

import java.util.Formatter;
import java.util.Scanner;

public class PL6_Exc6 {
    
    static Formatter out = new Formatter(System.out);
    static Scanner in = new Scanner(System.in);
   
    public static void main (String [] args) {
        int elmVA,elmVB;
        
        do {
            out.format("Defina qual o número de nomes a inserir para o Conjunto nº 1? ");
            elmVA=in.nextInt();
        } while(elmVA<0||elmVA>100);
        
        do {
            out.format("Defina qual o número de nomes a inserir para o Conjunto nº 2? ");
            elmVB=in.nextInt();
        } while(elmVB<0||elmVB>100);
        
        in.nextLine();//Limpeza do Buffer
        
        String[] va = new String[elmVA];
        String[] vb = new String[elmVB];
        
        lerVector(va, 1);
        lerVector(vb, 2);
        
        uniao(va,vb);
    }
    
    /**
     * Método União
     * 
     *   Como Funciona?
     *      - o vc (resultado) faz uma cópia do vector a. Quando estiver a comparar o va com vb, 
     *      sempre que não encontrar um nome repetido, adiciona no final o respectivo nome.
     * @param va Conjunto de Nomes 1
     * @param vb Conjunto de Nomes 2
     */
    private static void uniao(String[] va, String[] vb) {
        String[] vc = new String[100];
        
        //Cópia Automática de Array
        System.arraycopy(va, 0, vc, 0, va.length);
        
        /* CÓPIA MANUAL de ARRAY
         * for(int i=0; i<va.length; i++) {
         *   vc[i]=va[i];
         * }
         */
        
        int flag;
        int nVC=va.length;
        
        for(int i=0; i<vb.length; i++) {
            flag=0;
            for(int j=0; j<vc.length; j++) {
                if(vb[i].equalsIgnoreCase(vc[j])) {
                    break;
                } else {
                    flag++;
                }
            }
            if(flag==vc.length) {
                vc[nVC]=vb[i];
                nVC++;
            }
        }
        
        out.format("\nCONJUNTO UNIÃO DOS NOMES \n");
        for(int i=0; i<nVC; i++) {
            out.format(" %s  ", vc[i]);
        }
        out.format("\n");
        
    }
    
    /**
     * Método: Ler Elementos para Vector
     * @param v Vector a inserir os nomes
     * @param cnj Informação sobre qual o vector a trabalhar (exclusivamente para mensagens ao utilizador)
     */
    
    private static void lerVector(String[] v, int cnj) {
        boolean flag;
        String aux;
        out.format("\nLEITURA DE ELEMENTOS PARA O CONJUNTO DE NOMES Nº %d: \n", cnj);
        for(int i=0; i<v.length;i++) {
            out.format("Nome na Posição %d? ", (i+1));
            do {
                aux=in.nextLine();
                flag=true;
                for(int j=0;j<i; j++) {
                    if(v[j].equalsIgnoreCase(aux)) {
                        flag=false;
                    }
                }
                if(!flag) {
                    out.format("Insira novamente outro nome não-repetido na posição %d. ", (i+1));
                } else {
                    v[i]=aux;
                }
            } while(flag==false);
        }
    }
    
   
}