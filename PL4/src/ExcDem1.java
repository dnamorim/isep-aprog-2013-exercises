/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Exercício Demonstrativo 1:
 *
 * Objectivo Algoritmo: 
 * - recolher notas inseridas e calcular a média de todas as notas inseridas
 * 
 * @author Duarte Nuno Amorim
 */

import javax.swing.JOptionPane;

public class ExcDem1 {
    public static void main(String[] args) {
        int i=0;
        
        double nota, media, soma=0;
        
        nota=Double.parseDouble(JOptionPane.showInputDialog("Qual é a nota? (0 para terminar)"));
        
        while (nota !=0) {
            soma += nota;
            i++;
            nota=Double.parseDouble(JOptionPane.showInputDialog("Qual é a nota? (0 para terminar)"));
        }
        
        if(i>0) {
            media=soma/i;
            JOptionPane.showMessageDialog(null, "Média Notas: "+media);
        } else {
            JOptionPane.showMessageDialog(null, "Não foram introduzidas notas.");
        }
    }
}
