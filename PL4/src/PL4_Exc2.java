/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Exercício 2: Classificação Temperaturas Máximas
 * 
 * @author Duarte Nuno Amorim
 */
import javax.swing.JOptionPane;

public class PL4_Exc2 {
   public static void main(String[] args) {
       int d, i, mTemp=0, t; //d: limite de dias;  t: temperatura de determinado dia 
       
       do {
           d=Integer.parseInt(JOptionPane.showInputDialog("Defina a quantidade de dias a ler a temperatura:"));
       } while(d<1);
       
       //LEITURA DE TEMPERATURAS & ENCONTRAR A TEMPERATURA MÁXIMA DE UM DIA
       for(i=1; i<=d; i++) {
           do {
               t=Integer.parseInt(JOptionPane.showInputDialog("Qual a temperatura do dia "+i+"?"));
               if(t<-30 || t>50) {
                   JOptionPane.showMessageDialog(null, "Temperatura Extrema");
               }
           } while(t<-30 || t>50);
           
           if(i==1) {
               mTemp=t;
           } else {
               if(t>mTemp) {
                   mTemp=t;
               }
           }
       }
       
       //CLASSIFICACAO DA TEMPERATURA
       if(mTemp >= -30 && mTemp < 9) {
           JOptionPane.showMessageDialog(null, "Muito Frio.");
       } else if(mTemp >= 9 && mTemp < 15) {
           JOptionPane.showMessageDialog(null, "Frio.");
       } else if(mTemp >= 15 && mTemp < 20) {
           JOptionPane.showMessageDialog(null, "Ameno.");
       } else if(mTemp >= 20 && mTemp < 30) {
           JOptionPane.showMessageDialog(null, "Quente.");
       } else if(mTemp >= 30 && mTemp < 50) {
           JOptionPane.showMessageDialog(null, "Muito Quente.");
       } else {
           JOptionPane.showMessageDialog(null, "Erro Inesperado.");
       }
       
   } 
}
