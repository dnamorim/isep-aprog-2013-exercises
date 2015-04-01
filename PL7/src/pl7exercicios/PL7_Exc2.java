/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl7exercicios;

/**
 * Exercício 2: 
 * 
 * a) A Funcionalidade do método enigma é determinar o maior número na Matriz.
 * 
 * @author Duarte Nuno Amorim
 */

import java.util.Formatter;

public class PL7_Exc2 {
    
    static Formatter out = new Formatter(System.out);
    
    public static void main(String[] args) {
        int x=0;
        int m[][]= { {1,4,2,1}, {9,7,2,2}, {1,7,3,5}, {2,5,0,3}, {4,7,2,1}};
        
        for(int i=0; i<m.length; i++) {
            x=m[i][0];
            for(int j=1; j<m[i].length; j++) {
                if(m[i][j]> x) {
                    x=m[i][j];
                }
            }
        }
        
        out.format("Maior Número na Matriz: %d", x);
        showMatriz(m);
        medias(m);
        mTransposta(m);
    }
    
    /**
     * Método showMatriz
     *  » imprime a matriz no ecrã 
     * @param m matriz de inteiros
     */
    private static void showMatriz(int[][] m) {
        out.format("\nIMPRESSÃO DE MATRIZ: \n");
        
        for(int i=0; i<m.length; i++) {
            for(int j=0; j<m[i].length; j++){
                out.format("  %d  ", m[i][j]);
            }
            out.format("\n");
        }
    }

    /**
     * Método medias
     *  » apresenta a média de cada coluna e a média global da matriz
     * @param m matriz
     */
    private static void medias(int[][] m) {
        float[] medCol = new float[m[0].length];
        //Cada posição deste vector armazena a média de cada coluna. 
        int s=0,sCol;
        for(int j=0; j<m[j].length; j++) {
            sCol=0;
            for(int i=0; i<m.length; i++) {
                s+=m[i][j];
                sCol+=m[i][j];
            }
            medCol[j]=sCol/m[j].length;
        }
        
        out.format("\nAPRESENTAÇÃO DE MÉDIAS:\n\n");
        
        out.format("Média Global da Matriz: %.2f\n", ((float)s/(m.length*m[0].length)) );
        
        out.format("Média de Colunas: \n");
        for(int j=0; j<m[j].length;j++) {
            out.format(" » Coluna nº %d: %.2f\n",j+1,medCol[j]);
        }
    }
    
    /**
     * 
     * @param m 
     */
    private static void mTransposta(int[][] m) {
        out.format("\nMATRIZ TRANSPOSTA:\n");
        for(int j=0; j<m[j].length; j++) {
            for(int i=0; i<m.length;i++) {
                out.format("  %d  ",m[i][j]);
            }
            out.format("\n");
        }
    }
    
}
