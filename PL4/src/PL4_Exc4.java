/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Exercício 4:
 * 
 * a) O Algoritmo retorna todos os nrs. impares dos numeros inseridos.
 * @author Duarte Nuno Amorim
 */
import javax.swing.JOptionPane;

public class PL4_Exc4 {
    public static void main (String[] args) {
        int nr, d, aux=1, res=0;
        
        nr=Integer.parseInt(JOptionPane.showInputDialog("Insira um número:"));
        while(nr != 0) {
            d=nr%10;
            if(d%2==1) {
                res += d*aux;
                aux*=10;
            }
            nr=nr/10;
        }
        JOptionPane.showMessageDialog(null,"Resultado: "+res);
    }
}
