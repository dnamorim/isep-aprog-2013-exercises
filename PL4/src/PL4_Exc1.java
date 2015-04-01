/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Exercício 1 - Calcular A média de N numeros pares inseridos
 * @author Duarte Nuno Amorim
 */

import javax.swing.JOptionPane;

public class PL4_Exc1 {
    public static void main(String[] args) {
        int n, nr, s=0, c=0, i;
        double m;
        
        do {
           String ler = JOptionPane.showInputDialog("Defina o limite de números a ler:");
           n = Integer.parseInt(ler);
          //n=Integer.parseInt(JOptionPane.showInputDialog("Defina o limite de números a ler:"));
        } while(n<1);
        
        for(i=1; i<=n; i++) {
            nr=Integer.parseInt(JOptionPane.showInputDialog("Insira um número ("+i+"):"));
            if(nr%2==0) {
                c++;
                s+=nr;
            }
        }
        
        if(c!=0){
            m=s/c;
            JOptionPane.showMessageDialog(null, "Média Nrs. Pares:"+ (double)m);
        } else {
            JOptionPane.showMessageDialog(null, "Não foram inseridos números pares.");
        }
 }               
}
