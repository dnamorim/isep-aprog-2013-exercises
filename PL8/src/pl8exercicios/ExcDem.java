/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl8exercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Exercício Demonstrativo
 * 
 * Considere que existe um ficheiro texto de nome “Alunos.txt”, com informação sobre os alunos
 * inscritos numa dada instituição. Cada linha do ficheiro tem a seguinte formatação:
 *      Número / Nome do aluno
 * 
 * Pretende-se criar um outro ficheiro de texto com as linhas formatadas de igual modo, mas
 * ordenado por número do aluno.
 * 
 * @author Duarte Nuno Amorim
 */
public class ExcDem {
    
    public static void main(String[] args) throws FileNotFoundException {
        int [] vNrs = new int[100];
        String [] vNom = new String[100];
        
        int nrElm = readFile(vNrs, vNom);
        sort(vNrs, vNom, nrElm);
        
        String [] str = new String[nrElm];
        for(int i=0; i < nrElm; i++) {
            str[i]=vNrs[i]+ "/"+vNom[i];
        }
        //writeFile(vNrs, vNom, nrElm);
        writeFile2(str);
        int som = Integer.parseInt(vNom[1]) + vNrs[1];
        str[1]=Integer.toString(som);
    }
    
    private static int readFile (int[] vNr, String[] vNm ) throws FileNotFoundException {
        String aux;
        String[] tmp;
        int i=0;
        
        Scanner fIn = new Scanner(new File("alunos.txt"));
        
        while(fIn.hasNext() && i<100) { //enquanto possuir dados para ler
            aux = fIn.nextLine();
            tmp=aux.split("/");
            vNr[i]=Integer.parseInt(tmp[0]);
            vNm[i]=tmp[1].trim();
            i++;
        }
        
        //Fechar o Ficheiro
        if (fIn != null) {
            fIn.close();
        }
        
        return i;
    }
    
    private static void sort (int[] vNr, String[] vNm, int nrElm) throws FileNotFoundException {
       //TO DO: ordenar informação por ordem crescento do nr de Alunos
       int auxNr;
       String auxNm;
       String xpto;
       
       
       for (int i=0; i< nrElm-1; i++) {
           for (int j=i+1; j < nrElm; j++) {
               if(vNr[i] > vNr[j]) {
                   auxNr=vNr[i];
                   vNr[i]=vNr[j];
                   vNr[j]=auxNr;
                   
                   auxNm=vNm[i];
                   vNm[i]=vNm[j];
                   vNm[j]=auxNm;
                }
           }
       }
    }

    private static void writeFile (int[] vNr, String[] vNm, int nrElm) throws FileNotFoundException {
        Formatter fOut = new Formatter(new File("alunosOrdenado.txt"));
        
        for (int i=0; i < nrElm; i++) {
            fOut.format("%d/%s %n", vNr[i], vNm[i]);
        }
        
        if (fOut != null) {
            fOut.close();
        }
        
        System.out.println("O ficheiro alunosOrdenado.txt foi criado.");
    }
    
    private static void writeFile2 (String [] str) throws FileNotFoundException {
        Formatter fOut = new Formatter(new File("alunosOrdenado.txt"));
        
        for (int i=0; i < str.length; i++) {
            fOut.format("%s%n", str[i]);
        }
        
        if (fOut != null) {
            fOut.close();
        }
        
        System.out.println("O ficheiro alunosOrdenado.txt foi criado.");
    }
}

