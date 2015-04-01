/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl7exercicios;

import java.util.Scanner;
import java.util.Formatter;

/**
 * Exercício Demonstrativo 2
 * @author Duarte Nuno Amorim
 */

public class ExcDem2 {

    static int NRJOGADORES = 5;
    static Scanner in = new Scanner(System.in);
    static Formatter out = new Formatter(System.out);
    
    public static void main(String[] args) {
        int nr = readNrEquipa();
        String equipas[][]=new String[NRJOGADORES][nr];
        readEquipas(equipas);
        out.format("Nº de Equipas Ordenadas: %d", nrColunasOrdenadas(equipas));
    }
    
    /**
     * Método readEquipas
     *  » lê o nr. de equipas para a matriz passada por parâmetro
     * 
     * @param m matriz de Strings
     */
    public static void readEquipas(String[][] m) {
        out.format("\nLEITURA DE EQUIPAS:\n");
        for(int j=0; j<m[j].length;j++) { //COLUNAS - Equipas
            out.format("\n» Equipa nº %d: ",j+1);
            for(int i=0; i<m[i].length; i++) { //LINHAS - Jogadores da Equipa
                out.format("  Nome Jogador nº %d? ",i+1);
                m[i][j] = in.nextLine();
            }
        }
    }
    
    /**
     * Método nrColunasOrdenadas
     * 
     * @param m matriz de Strings
     * @return retorna o número de Colunas que estão ordenadas
     */
    public static int nrColunasOrdenadas(String[][] m) {
        int k=0,i;
        //k: 
        for(int j=0; j<m[j].length; j++) {
            i=0;
            while (i<m.length-1 && m[i][j].compareToIgnoreCase(m[i+1][j]) <= 0) {
                i++;
            }
            
            /**
             * .compareToIgnoreCase
             * » compara 2 strings e indica se uma é maior que a outra (recorrendo ao código ASCII
             */
            
            if(i == m.length-1) {
                k++;
            }
        }
        return k;
    }
    
    /**
     * Método readNrEquipa
     *  » lê o número de Equipas pretendido (ou seja, o número de colunas da matriz a criar) 
     * @return número de equipas válido
     */
    public static int readNrEquipa() {
        out.format("Defina o número de Equipas a Ler: ");
        int nr = in.nextInt();
        while(nr<=0) {
            out.format("Introduza novamente um número válido de equipas a ler: ");
            nr = in.nextInt();  
        } 
        return nr;
    }
}
