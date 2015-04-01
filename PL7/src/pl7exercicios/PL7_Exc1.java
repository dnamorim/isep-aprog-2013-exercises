/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl7exercicios;

/**
 * Exercício 1
 * 
 * a) Ordenar um Vector de Strings de Acordo com o tamanho das palavras de cada posição. 
 * 
 * @author Duarte Nuno Amorim
 */

import java.util.Formatter;
import java.util.Scanner;

public class PL7_Exc1 {
    
        static Scanner in = new Scanner(System.in);
        static Formatter out = new Formatter(System.out);
        
    
    public static void sortLenght(String [] v, int n) {
        int m;
        String tmp;
        
        for(int i=0; i<n-1; i++) {
            m=i;
            for(int j=i+1; j<n; j++) {
                if(v[j].length() < v[m].length()) {
                    m=j;
                }
            }
            if(m!=i) {
                tmp=v[i];
                v[i]=v[m];
                v[m]=tmp;
            }
        }
    }
    
    public static void main (String[] args) {
        String[] vStr = new String[100];
        int nrElm=readElm(vStr);
        printVec(vStr,nrElm,"INSERIDO");
        sortLenght(vStr,nrElm);
        printVec(vStr,nrElm,"ORDENADO POR COMPRIMENTO");
        sortAlfab(vStr,nrElm);
        printVec(vStr,nrElm,"ORDENADO ALFABETICAMENTE");
        
        
    }
    
    private static void printVec(String[] v, int nElm, String type) {
        out.format("\nVECTOR %s:\n", type);
        for(int i=0; i<nElm; i++) {
            out.format("%s  ", v[i]);
        }
        out.format("\n");
    }
    
    private static int readElm(String[] v) {
        int nrElm=0;
        out.format("Insira um Nome em Cada posição do vector: (000 p/ terminar)\n");
        for(int i=0; i<v.length;i++) {
            out.format(" Posição nº %d: ",i+1);
            v[i]=in.nextLine();
            if(!v[i].equalsIgnoreCase("000")) {
                nrElm++; 
            } else {
                break;
            }
        }
        return nrElm;
    }
    
    private static void sortAlfab(String[] v, int nrElm) {
        for(int i=0; i<nrElm-1; i++) {
            for(int j=i+1; j<nrElm; j++) {
                if(v[i].compareToIgnoreCase(v[j]) > 0) {
                    String aux = v[i];
                    v[i]=v[j];
                    v[j]=aux;
                } 
            }
        }
    }
}
