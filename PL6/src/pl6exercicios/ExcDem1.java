/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl6exercicios;

import java.util.Scanner;
import java.util.Formatter;

/**
 * Exercício Demonstrativo 1: Leitura de Alunos/Notas e reectiva melhores classificações
 * @author Duarte Nuno Amorim
 */
public class ExcDem1 {
    
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        Formatter out = new Formatter(System.out);
        int n;
        
        do  {
            out.format("Número de Alunos? ");
            n = in.nextInt();
        } while(n<=0);
        in.nextLine();
        
        float grade[] = new float[n];
        String name[] = new String[n];
        
        float max = - Float.MAX_VALUE;
        
        for (int i=0; i<n; i++) {
            out.format("Nome do Aluno nº %d ? ", i+1);
            name[i] = in.nextLine();
            do {
                out.format("Nota do Aluno %s (nº %d)? ",name[i],i+1);
                grade[i] = in.nextFloat();
                in.nextLine();
            } while(grade[i]<0 || grade[i]>20);
        
            if(grade[i]>max) {
                max=grade[i];
            }
        }
        
        out.format("\nALUNO(S) COM MELHOR NOTA (%.2f):\n", max);
        for(int i=0; i<n; i++) {
            if(grade[i]==max) {
                out.format(" » %s (nº %d)\n", name[i], i+1);
            }
        }
    
    }
}


