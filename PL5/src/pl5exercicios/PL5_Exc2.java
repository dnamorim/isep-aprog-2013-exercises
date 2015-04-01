/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl5exercicios;

/**
 * Exercício 2: Ângulos Triângulo
 * @author Duarte Nuno Amorim
 */
import java.util.Scanner;

public class PL5_Exc2 {
    /**
    *  Cálculo de um angulo interno
    *
    * @param a ângulo a
    * @param b ângulo b
    * @param c ângulo c
    * @return ângulo interno do triângulo em graus
    */
    
    public static double angleInt(double a, double b, double c) { // valor a e b correspondem ao angulo a calcular 
        double ang;
        ang = Math.acos((Math.pow(a, 2)+Math.pow(b, 2)-Math.pow(c, 2))/ (2*a*b));
        return Math.toDegrees(ang);
    }
    
    public static void main (String[] args) {
        Scanner read = new Scanner(System.in);
        double a,b,c;
        
        System.out.println("Insira o lado do triângulo A:");
        a=read.nextDouble();

        System.out.println("Insira o lado do triângulo B:");
        b=read.nextDouble();
        
        System.out.println("Insira o lado do triângulo C:");
        c=read.nextDouble();
        
        if(a>0 && b>0 && c>0 && (a<b+c) && (b<a+c) && (c<a+b)) {
            System.out.println("Ângulo AB: "+angleInt(a,b,c));
            System.out.println("Ângulo AC: "+angleInt(a,c,b));
            System.out.println("Ângulo BC: "+angleInt(b,c,a));
        } else {
            System.out.println("Os lados fornecidos não formam um triângulo.");
        }
        
    }
            
}
