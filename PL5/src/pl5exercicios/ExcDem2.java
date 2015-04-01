/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl5exercicios;

/**
 * Exercício Demonstativo 2: Tabuada
 * @author Duarte Nuno Amorim
 */
import java.util.Scanner;
import java.util.Formatter;

public class ExcDem2 {
    
    /**
    *  Gerador de Tabuada (formatter)
    *
    * @param nr identificador da tabuada
    */
    public static void tabuada(int nr) {
        //Formatter out = new Formatter(System.out);
        String tab = "";
        for(int i=1; i<=10; i++) {
            tab=tab+nr+"x"+i+"="+(nr*i)+"\n";
            //tab = tab + String.format("%d x %2d = %d\n", nr, i, i*nr);
        }
        
        //out.format(tab);
        System.out.println(tab);
    }
    
    public static void main(String[] args){
        int nr;
        Scanner in = new Scanner(System.in);
                
        System.out.println("Inroduza o Nº da Tabuada a Calcular (0 p/ terminar):");
        nr=in.nextInt();
        
        while(nr!=0) {
            tabuada(nr);
            System.out.println("Inroduza o Nº da Tabuada a Calcular (0 p/ terminar):");
            nr=in.nextInt();
        }
        
        
    }
}
