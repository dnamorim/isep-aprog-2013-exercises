/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Exercício 3: Informações/Percentagens de pessoas maiores de 18
 * @author Duarte Nuno Amorim
 */
import java.util.Scanner;

public class PL4_Exc3 {
    public static void main(String[] args) {
        int age, i=0, ageI=0;
        String name;
        
        Scanner read = new Scanner(System.in);
        
        do {
            System.out.println("Introduza um nome: (zzz para terminar).");
            name=read.nextLine();
            if(!name.equalsIgnoreCase("zzz")) {
                do {
                    System.out.println("Introduza a idade de "+name+":");
                    age=read.nextInt();
                    read.nextLine();
                } while (age<0);
                i++;
               
                if(age>=18) {
                    if (i==1){
                      System.out.println("LISTAGEM DE PESSOAS COM MAIS DE 18 ANOS;");
                    }
                    ageI++;
                    System.out.println("Nome: "+name+"   Idade: "+age);
                }
            }
        } while(!name.equalsIgnoreCase("zzz"));
        
        if(i==0) {
            System.out.print("Não foram inseridas pessoas maiores de 18 anos.");
        } else {
            System.out.println("Percentagem de Pessoas maiores de 18 Anos:\n"+(float)(ageI*100/i) + "%");
        }
    }
        
    }
