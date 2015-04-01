/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl7exercicios;

/**
 * Exercício Demonstrativo 1: Ordenação de Matrizes
 * @author Duarte Nuno Amorim
 */

import java.util.Scanner;
import java.util.Formatter;

public class ExcDem1 {

    static Scanner in = new Scanner(System.in);
    static Formatter out = new Formatter(System.out);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int nrLin = lerDimensao("linhas");
        int nrCol = lerDimensao("colunas");
        int mtr[][] = new int[nrLin][nrCol];
        lerMatriz(mtr);
        int somaLin[] = somatorioLinhas(mtr);
        showMatriz(mtr,"inserida");
        directSort(mtr,somaLin);
        showMatriz(mtr,"ordenada");
    }
    
    private static int lerDimensao(String tipo) {
        int nr;
        out.format("Qual a quantidade de %s da matriz a criar? ", tipo);
        do {
            nr=in.nextInt();
        } while(nr<=0);
        return nr;
    }
    
    private static void lerMatriz (int[][] m) {
        out.format("Insira números inteiros a guardar na Matriz: \n");
        for(int i=0; i<m.length; i++) { //Linhas da Matriz
            for(int j=0; i < m[i].length; j++) {
                out.format("Posição (%d,%d): ", i+1,j+1);
                m[i][j]=in.nextInt();
            }
        }
    }

    private static int[] somatorioLinhas(int[][] m) {
        int s[]= new int[m.length];
        
        for(int i=0; i<m.length; i++) {
            s[i]=m[i][0];
            for(int j=1; i < m[i].length;j++) {
                s[i] += m[i][j];
            }
        }
        return s;
    }
    
    private static void showMatriz(int[][] m, String s) {
        out.format("\nMatriz %s:\n", s);
        
        for(int i=0; i < m.length; i++) {
            for(int j=0; j < m[i].length; j++) {
                out.format("3%d", m[i][j]);
            }
            out.format("/n");
        }
    }

    private static void bubbleSort(int[][] m, int[] s) {
        int tmp;
        int[] tmpM;
        boolean trocas=false;
        int end = s.length-1;
        do {
            for(int i=0; i<end; i++) {
                if(s[i]<s[i+1]) {
                    tmp=s[i];
                    s[i]=s[i+1];
                    s[i+1]=tmp;
                    trocas=true;
                    
                    tmpM=m[i];
                    m[i]=m[i+1];
                    m[i+1]=tmpM;
                }
            }
            end--;
        } while(trocas);
    }
    
    private static void directSort(int[][] m, int[] s) {
        for(int i=0; i < s.length -1; i++) {
            for(int j=i+1; j < s.length; j++) {
                if(s[j] > s[i]) {
                    int tmp=s[i];
                    s[i]=s[j];
                    s[j]=tmp;
                
                    int[] tmpM=m[i];
                    m[i]=m[j];
                    m[j]=tmpM;
                }
            }
        }
    }
}
