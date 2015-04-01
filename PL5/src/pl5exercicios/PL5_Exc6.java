/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl5exercicios;

/**
 * Exercício 6: Determinação Volumos de Sólidos de Revolução (cilindros, cones e esferas)
 * @author Duarte Nuno Amorim
 */

import java.util.Scanner;
import java.util.Formatter;
        
public class PL5_Exc6 {
    
    /**
    *  Volume de uma Esfera
    *
    * @param raio raio da esfera
    * @return volume da esfera
    */
    
    public static double vEsfera(double raio) {
        double vEsf = (4*Math.PI*Math.pow(raio, 3))/3;
        return vEsf;
    }

    /**
    *  Volume de um Cilindro
    *
    * @param raio raio da base
    * @param h altura do cilindro
    * @return volume do cilindro
    */
    
    public static double vCilindro(double raio, double h) {
        double vCil = Math.PI*Math.pow(h, 2)*h;
        return vCil;                
    }
    
    /**
    *  Volume de um Cone
    *
    * @param raio raio da base
    * @param h altura do cone
    * @return volume do cone
    */
    
    public static double vCone(double raio, double h) {
        double vCon = (Math.PI*Math.pow(h, 2)*h)/3;
        return vCon;                
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Formatter out = new Formatter(System.out);
        String solido;
        double r, h;
        out.format("Qual o tipo de Sólido a Calcular? \n - ESFERA \n - CILINDRO \n - CONE \n(FIM para terminar): \n");
        solido=in.nextLine();
        
        while(!solido.equalsIgnoreCase("FIM")) {
            if(solido.equalsIgnoreCase("ESFERA")) {
                out.format("Raio da Esfera? ");
                r=in.nextDouble();
                in.nextLine();
                double vEsf = vEsfera(r);
                out.format("Volume da Esfera = %.3f \n", vEsf);
            } else if(solido.equalsIgnoreCase("CILINDRO")) {
                out.format("Raio da Base do Cilindro? ");
                r=in.nextDouble();
                in.nextLine();
                out.format("Altura do Cilindro? ");
                h=in.nextDouble();
                in.nextLine();
                out.format("Volume do Cilindro = %.3f \n", vCilindro(r,h));
            } else if(solido.equalsIgnoreCase("CONE")) {
                out.format("Raio da Base do Cone? ");
                r=in.nextDouble();
                in.nextLine();
                out.format("Altura do Cone? ");
                h=in.nextDouble();
                in.nextLine();
                double vCon = vCone(r,h);
                out.format("Volume do Cone = %.3f \n", vCone(r,h));
            } else {
                out.format("Sólido Inválido. \n");
            }
            
            out.format("Qual o tipo de Sólido a Calcular? \n - ESFERA \n - CILINDRO \n - CONE \n(FIM para terminar): \n");
            solido=in.nextLine();
        }
        
    }
}
