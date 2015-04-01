/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl7exercicios;

/**
 * Exercício 7: Indíces
 * @author Duarte Nuno Amorim
 */

import java.util.Scanner;
import java.util.Formatter;

public class PL7_Exc3 {
    
    static Scanner in = new Scanner(System.in);
    static Formatter out = new Formatter(System.out);
    
    public static void main(String [] args) {
        int[][] m = readDimensao();
        readMatriz(m);
        int sum = sumMatriz(m);
        int maxVal=verifValMaxMatriz(m,sum);
        writePositions(m, maxVal,sum);
    }
    
    /**
     * Método readMatriz: leitura dos elementos de uma matriz
     * @param m matriz da aplicação
     */
    private static void readMatriz(int[][] m) {
        out.format("\nLEITURA DE VALORES DA MATRIZ:\n");
        
        for(int i=0; i<m.length; i++) {
            for(int j=0; j<m[i].length; j++) {
                out.format("Posição (%d,%d). Valor? ", i,j);
                m[i][j]=in.nextInt();
            }
        }
    }
    
    /**
     * Método readDimensao: lê a dimensão da matriz a criar
     * @return matriz criada
     */
    private static int[][] readDimensao() {
        out.format("Número de Linhas da Matriz? ");
        int i =in.nextInt();
        while(i<1) {
            out.format("Por favor, defina um valor válido para as linhas da Matriz. ");
            i=in.nextInt();
        }
        
        out.format("Número de Colunas da Matriz? ");
        int j =in.nextInt();
        while(j<1) {
            out.format("Por favor, defina um valor válido para as colunas da Matriz. ");
            j=in.nextInt();
        }
        
        int[][] m = new int[i][j];
        return m;
    }
    
    /**
     * Método sumMatriz: calcula o somatorio de todas as posições da matriz
     * @param m matriz da aplicação
     * @return soma de todas as posições
     */
    private static int sumMatriz(int[][] m) {
        int sum=0;
        for(int i=0; i<m.length; i++) {
            for(int j=0; j<m[i].length; j++) {
                sum+=m[i][j];
            }
        }
        return sum;
    }
    
    /**
     * Método verifSumElmMatriz: calcula a soma de todos os elementos que nao pertencem a uma linha e coluna fornecida.
     * 
     * @param sMat soma de todos os elementos da matriz
     * @param l linha elemento E (linha a nao contabilizar) 
     * @param c coluna elemento E (coluna a nao contabilizar)
     * @param m matriz da aplicacao
     * @return soma de todas as posicoes que nao pertencem a coluna c e linha l
     */
    private static int verifSumElmMatriz(int sMat, int l, int c, int[][] m) {
        int sL=0, sC=0; //variáveis p/ armazenar a soma da Linha e da Coluna
        
        //SOMA DA LINHA
        for(int i=0; i<m.length; i++) {
            sL+=m[i][c];
        }    
        
        //SOMA DA COLUNA
        for(int j=0; j<m[l].length; j++) {
            sC+=m[l][j];
        }
        
        //Fórmula de Cálculo: somaElemento= somaMatriz - (somaLinhaElemento+somaColunaElemento) + elemento (pq tira 2x o elemento)
        int sum=sMat - (sL+sC) + m[l][c];
        return sum;
    }
    
    /**
     * Método verifValMaxMatriz: verifica qual é o elemento que contem o 
     * Elemento cuja a soma das posicoes que nao sejam da sua linha e coluna 
     * é maior
     *
     * @param m matriz da aplicação
     * @param sum soma todas posicoes da matriz
     * @return valor maximo obtido de um elemento
     */
    private static int verifValMaxMatriz(int[][] m, int sum) {
        int maxVal=verifSumElmMatriz(sum,0,0,m);
        int tmp;
        for (int i=1; i<m.length; i++) {
            for(int j=0; j<m[i].length; j++) {
                tmp=verifSumElmMatriz(sum,i,j,m);
                if(tmp > maxVal) {
                    maxVal=tmp;
                }
            }
        }
        return maxVal;
    }
    
    /**
     * Método writePositions: escreve os índices em forma de mensagem para o utilizador
     * da(s) posicao/posicoes do elemento cuja soma de todas as posicoes que nao 
     * pertencem à sua linha e coluna correspondem ao valor maximo encontrado
     * 
     * @param m matriz da aplicação
     * @param maxVal valor Máximo da Soma
     * @param sum Somatório de todas as posições da matriz
     */
    private static void writePositions(int[][] m, int maxVal, int sum) {
        out.format("\nÍNDICES DA SOMA CONDICIONAL DO MAIOR ELEMENTO - %d:\n", maxVal);
        
        for(int i=0; i<m.length; i++) {
            for(int j=0; j<m[i].length; j++) {
                if(verifSumElmMatriz(sum,i,j,m) == maxVal) {
                    out.format("Posição (%d,%d) - Linha: %d   Coluna: %d\n",i,j,i,j);
                }

            }
        }
    }
}
