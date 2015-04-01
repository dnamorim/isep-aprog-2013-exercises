/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl6exercicios;

/**
 * Exercício 4: Vectores Invertidos/Rodados
 * @author Duarte Nuno Amorim
 */

import java.util.Scanner;
import java.util.Formatter;

public class PL6_Exc4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Formatter out = new Formatter(System.out);
        
        char opt;
        int n = 0;
        boolean inv=false,rot=false;
        
        int[] vec = new int[100];
        do {
            opt=menu();
            switch(opt) {
                case '1':
                    int f=0;
                    out.format("Introduza a quantidade de números a ler: ");
                    do {
                        if(f==1) {
                            out.format("O Número inserido não é suportado pela Aplicação.\nIntroduza novamente a quantidade de números a ler: ");
                        }
                        n = in.nextInt(); 
                        f=1;
                    } while(n<0 || n>100);
                    lerVector(vec,n);
                    break;
                case '2':
                    if(n!=0) {
                        invertVect(vec,n);
                        inv=true;
                    } else {
                        out.format("Não inseriu elementos no vector.\nExecute a opção 1 da aplicação para poder continuar.\n");
                    }
                    break;
                case '3':
                    if(inv) {
                        showVector(vec,n);
                    } else {
                        out.format("Não inverteu o vector.\nExecute a opção 2 da aplicação para poder continuar.\n");
                    }
                    break;
                case '4':
                    if(inv) {
                        rotateVect(vec,n);
                        rot=true;
                    } else {
                        out.format("Não inverteu os elementos do vector.\nVerifique esta situação.\n");
                    }
                    break;
                case '5':
                    if(rot) {
                        showVector(vec, n);
                    } else {
                        out.format("Não rodou os elementos do vector.\nVerifique esta situação.\n");
                    }
                    break;
                case '6':
                    break;
                /* Opção Exclusiva para testes de controlo - ESTADO: Desactivado
                 * case '7':
                 *  showVector(vec,n);
                 *  break; */
                default:
                    out.format("A opção inserida não é válida.\n");
                    break;
            }
        
        } while(opt!='6');
    }
    
    /**
     * Método: Ler elementos para um Vector
     * @param vec Vector a receber valores
     * @param n número de elementos
     */
    private static void lerVector(int[] vec,int n){
        Scanner in = new Scanner(System.in);
        Formatter out = new Formatter(System.out);
        
        for(int i=0; i<n; i++) {
            out.format("Qual o número na Posição nº %d? ",i+1);
            vec[i]=in.nextInt();
        }
    } 
    
    /**
     * Método inverter Vector
     * @param vec vector a inverter
     * @param n número de elementos
     */
    private static void invertVect(int[] vec, int n) {
        int aux;
        for(int i=0; i<n/2; i++) {
            aux=vec[i];
            vec[i]=vec[n-(i+1)];
            vec[n-(i+1)]=aux;
        }
    }
       
    /**
     * Método rotateVect
     * » roda para a direita os valores de um vector
     * 
     * @param vec vector a ser rodado
     * @param n número de elementos
     */
    private static void rotateVect(int[] vec, int n) {
        int aux=vec[n-1];
        for(int i=n-1;i>0; i--) {
            vec[i]=vec[i-1];
        }
        vec[0]=aux;
    }
    
    /**
     * Método menu
     * » apresenta em forma de lista, o menu do programa
     * @return opção seleccionada (char)
     */
    private static char menu() {
        Formatter out = new Formatter(System.out);
        Scanner in = new Scanner(System.in);
        out.format("1. Leitura de Números\n2. Inversão do Vector\n3. Apresentar Vector Invertido\n4. Rotação Vector Invertido\n5. Apresentação Vector Invertido\n6. Terminar\n\nInsira a Opção: ");
        char opt = in.next().charAt(0);
        return opt;
    }
    
    /**
     * Método showVector
     * » apresenta o vector em forma de lista
     * @param v vector a apresentar
     * @param n número de elementos
     */
    private static void showVector(int[] v, int n) {
        Formatter out = new Formatter(System.out);
        for(int i=0; i<n; i++) {
            out.format("%2d", v[i]);
        }
        out.format("\n\n");
    }
}
