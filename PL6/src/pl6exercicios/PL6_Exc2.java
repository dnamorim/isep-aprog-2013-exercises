/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl6exercicios;

/**
 * Exercício 2: Estatísticas Vencimentos Empresariais
 * @author Duarte Nuno Amorim
 */

import java.util.Scanner;
import java.util.Formatter;

public class PL6_Exc2 {
    
    public static void main(String[] args) {
        String nomes[] = new String[50];
        float venc[] = new float[50];
        
        Scanner in = new Scanner(System.in);
        Formatter out = new Formatter(System.out);
        int i=0, c=0;
        String ins;
        
        out.format("AVISO: 'tt' para terminar a leitura.\n\n");
        do {
            out.format("Nome do Funcionário nº %d? ",i+1);
            ins=in.nextLine();
            if(!ins.equalsIgnoreCase("tt")) {
                nomes[i]=ins;
                out.format("Vencimento do Funcionário %s (nº %d)? ", nomes[i],i+1);
                venc[i]=in.nextFloat();
                in.nextLine(); //Limpeza do Buffer do Teclado
                i++;
            }
        } while(!ins.equalsIgnoreCase("tt"));
        
        listVencInf(nomes,venc, i);
        
        percVencInfVal(venc,i);
        
    }
    
    
    /**
     * Método listVencInf
     * - Lista os funcionários com vencimentos inferiores à média
     * 
     * @param name[] Vector String com o nome dos funcionários
     * @param venc[] Vector float com os vencimentos dos funcionários
     * @param nFunc número de funcionarios lidos
     */
    public static void listVencInf(String name[], float venc[], int nFunc) {
        Formatter out = new Formatter(System.out);
        int s=0;
               
        
        for(int i=0;i<nFunc;i++) {
            s+=venc[i];
        }
        
        if(nFunc!= 0) {
            float med=(float)s/nFunc;

            out.format("\nLISTAGEM FUNCIONÁRIOS C/ VENCIMENTOS INFERIORES À MÉDIA (%.2f)\n",med);

            for(int i=0; i<nFunc;i++) {
                if(venc[i]<med) {
                    out.format(" » %s (nº%2d) \n", name[i], i+1);
                }
            }
        
        } else { 
           out.format("Não foram inseridos Funcionários.");
    } 
}
    
    /**
     * Método percVencInfVal
     * - Devolve a % de funcionarios com vencimento inferior ao definido
     * @param venc
     * @param nFunc
     */
    public static void percVencInfVal(float venc[], int nFunc) {
        Scanner in = new Scanner(System.in);
        Formatter out = new Formatter(System.out);
        
        out.format("\n\nPERCENTAGEM DE FUNCIONARIOS COM VENCIMENTO INFERIOR AO DEFINIDO \n \nDefina o valor de Vencimento: ");
        float valVenc = in.nextFloat();
        int c=0,i;
        
        for(i=0; i<nFunc; i++) {
            if(valVenc > venc[i]) {
              c++;  
            }
        }
        
        out.format("Percentagem (%%) de Funcionários com Vencimento Inferior a %.2f: %d%% \n", valVenc, (int)((c*100)/i) );
    }
    
    
}
