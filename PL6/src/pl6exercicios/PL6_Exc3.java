/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl6exercicios;

import java.util.Scanner;

/**
 * Exercício 3
 * 
 * a) Manipulação de Vectores, com Menu Personalizado. Opções: Adicionar, Eliminar e Listagem
 * 
 * @author Duarte Nuno Amorim
 */
public class PL6_Exc3 {
   
    public static void main (String[] args) {
        Scanner ler = new Scanner(System.in);
        
        int n=0;
        String nomes[] = new String[100];
        String m="1-Ler Nomes\n2-Listagem\n3-Enigma Nome(Eliminar)\n4-Terminar\n\nEscolha uma Opção:"; //String menu
        int i=2;
        
        char op;
        do {
            System.out.println(m);
            op=ler.next().charAt(0);//Le o primeiro caracter apenas
            
            switch (op) {
                case '1':
                    n = lerNomes(nomes);
                    break;
                case '2':
                    if(n!=0) {
                        listar(nomes,n);
                    } else {
                        System.out.println("Não foram inseridos nomes.");
                    }
                    break;
                case '3':
                    System.out.println("Nome: ");
                    String nome = ler.nextLine();
                    n=enigma(nomes,nome,n);
                    break;
                case '4':
                    break;
                default:
                    System.out.println("Opção Inválida.");
            } 
            
        } while(op!='4');
    }
    
    
    /**
     * Método lerNomes
     * » lê uma sequência de nomes terminada com a palavra FIM
     * » Armazena os nomes em vec, e retorna o número desses nomes
     * @param vec
     * @return (i) número de nomes inseridos
     */
    private static int lerNomes(String[] nomes) {
        int i=0;
        String name;
        Scanner in = new Scanner(System.in);
        System.out.println("Insira um nome:");
        name = in.nextLine();
        while(!name.equalsIgnoreCase("FIM")) {
            nomes[i]=name;
            i++;
            System.out.println("Insira um nome:");
            name = in.nextLine();
        }
        return i;
    }
    
    /**
     * Método listar
     * » Apresenta os primeiros n numeros de vec
     * @param vec
     */
    private static void listar(String[] nomes, int n) {
        System.out.println("LISTAGEM:\n");
        for(int i=0; i < n; i++) {
            System.out.println(nomes[i]);
        }
    }
    
    /**
     * Método enigma
     * » Elimina a primeira posição caso encontre o nome passado por parâmetro
     * 
     * @param nomes vector de nomes
     * @param nome nome para comparar
     * @param n numero de elementos do vector
     * @return
     */
    private static int enigma(String[] nomes, String nome, int n) {
        int i=0;
        
        //incrementa i enquanto o nome inserido não constar no vector e o i for menor q o nrElementos
        while(i<n && !nomes[i].equalsIgnoreCase(nome)) {
            i++;
        }
        
        if(i==n) {
            //numero de nomes diferentes, se for igual ao nr de Elementos
            return n;
        } else {

            for (int j=i; j< n-1; j++) {
                nomes[j]=nomes[j+1];
            }
            return --n;
        }
        
    }
}
