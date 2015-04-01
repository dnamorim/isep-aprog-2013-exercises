/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

            /* OBSERVAÇÃO MÉTODO RANDOM
             * [5; 100]
             * 
             * Math.random()
             * » 0 ... 0.999 - retorna este valor
             * *96
             * » 0 ... 95.999
             * +5
             * » 5 ... 100.999
             * (int)
             * » 5 ... 100
             */

package pl6exercicios;

/**
 * Exercício Demonstrativo 2: Programa Modular de gestão de vectores
 * @author Duarte Nuno Amorim
 */

import java.util.Scanner;
import java.util.Formatter;

public class ExcDem2 {
    
    public static void main (String[] args) {
        int nr = ler();
        int vec[] = new int[nr];
        int nElm = 0;
        
        //TO DO: Inserir Números aleatórios no vector 
        do {
            int num = (int) (Math.random() *96) + 5; //Delimitar entre 5 e 100
            int pos = procurar(vec, nElm, num);
            if(pos==-1) {
                if(inserir(num, vec, nElm)==1) {
                    nElm++;
                }
            }
        } while (nElm < nr);
        listar(vec,nElm);
    }
    /**
     * Método Quantos numeros para o vector
     * @return Quantidade de números a ler
     */
    private static int ler() {
        Scanner in = new Scanner(System.in);
        Formatter out = new Formatter(System.out);
        int nr;
        do {
            out.format("Defina a quantidade de números aleatórios: \n");
            nr=in.nextInt();
        } while(nr<1 || nr>96); //MOSTRA 96 POSICOES
        return nr;
    }
    
    /**
     * Método: Procurar Números num vector
     * @param v vector com os elementos
     * @param nElm numero de elementos preenchidos no vector
     * @param n numero a procurar
     * @return posição onde se encontra o numero; -1 se nao encontrou
     */
    private static int procurar(int[] v, int nElm, int n) {
        if(nElm > 0 && nElm <= v.length) {
            int i=0;
            while(i<nElm && v[i]!=n) {
                i++;
            }
            if(i<nElm) {
                return i; //Posição onde encontrou
            }
         }
         return -1; //Não encontrou
    }
    
    /**
     * Método Inserir no vector
     * @param n número a inserir
     * @param v vector que vai receber o novo número
     * @param nElm número de elementos preenchidos
     * @return novo número de elementos
     */
    private static int inserir(int n, int[] v, int nElm) {
        int rtn = -1;
        if(nElm>=0 && nElm < v.length) {
            v[nElm]=n;
            rtn=1;
        }
        return rtn;
    }
    
    /**
     * Método Listar Vector de Números aleatórios
     * @param v vector a apresentar
     * @param nElm número de elementos preenchidos(e a ser apresentados)
     */
    private static void listar(int v[], int nElm) {
        Formatter out = new Formatter(System.out);
        if(nElm>0 && nElm <=v.length) {
            out.format("\n NÚMEROS ALEATÓRIOS:\n");
            for(int i=0; i< nElm; i++) {
                out.format("Posição: %d  Valor: %d", i+1, v[i]);
            }
        }
    }
}
