/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl5exercicios;

/**
 * Exercício 3: Representação Gráfica de Positivas e Negativas
 * @author Duarte Nuno Amorim
 */

import java.util.Formatter;
import java.util.Scanner;

public class PL5_Exc3 {
    
    /**
        * Impressão de dados relativos a uma disciplina
        * (gráficos de ***)
        *
        * @param disc nome da disciplina (string)
        * @param pos número de positivas (inteiro positivo)
        * @param neg número de negativas (inteiro positivo)
   */
    
    public static void printDisciplina(String disc, int pos, int neg){
        String print = String.format("Disciplina: %s\n", disc);
        String sPos="", sNeg="";
        
        for(int i=1; i<=neg; i++) {
            sNeg += "*";
        }
        for(int i=1; i<=pos; i++) {
            sPos += "*";
        }
        print += String.format("- Positivas: %s\n- Negativas: %s", sPos, sNeg);
        System.out.println(print);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Formatter out = new Formatter(System.out);
        
        String disc;
        int pos, neg;
        
        System.out.println("Insira o Nome da Disciplina: (escreva none para terminar)");
        disc=in.nextLine();
        
        while(!disc.equalsIgnoreCase("none")) {
            out.format("Positivas de %s? ",disc);
            pos=in.nextInt();
            out.format("Negativas de %s? ",disc);
            neg=in.nextInt();
            printDisciplina(disc,pos,neg);
            in.nextLine(); //Limpar Buffer Teclado
            
            System.out.println("Insira o Nome da Disciplina: (escreva none para terminar)");
            disc=in.nextLine();
        }
        
        
    }
    
    
}
