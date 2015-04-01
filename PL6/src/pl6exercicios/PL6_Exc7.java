/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl6exercicios;

/**
 * Exercício 7: Gestão de Visitantes de um Hospital
 * @author Duarte Nuno Amorim
 */

import java.util.Scanner;
import java.util.Formatter;

public class PL6_Exc7 {
    
    static Scanner in = new Scanner(System.in);
    static Formatter out = new Formatter(System.out);
            
    public static void main(String[] args) {
        out.format("VISITgest - Gestão de Visitantes Hospitalares\n");
        String[] vis = new String[100];
        int nVis=0;
        char opt=menu();
        String msgErro="Não é possível executar esta opção sem visitantes inseridos.\n";
        
        do {
            in.nextLine();//Limpeza de Buffer
            switch(opt) {
                case '1':
                   if(nVis>100) {
                        out.format("Foi atingido o número máximo de Visitantes. Averigue a lista e elimine algum Visitante para poder continuar.\n");
                   } else {
                        nVis=insertVist(vis,nVis); 
                   }
                   break;
                case '2':
                    if(nVis>0) {
                        listVist(vis,nVis);
                    } else {
                        out.format("Não existem visitantes a listar.\n");
                    }
                    break;
                case '3':
                    if(nVis!=0) {
                        out.format("Introduza o nome do Visitante a procurar: ");
                        String name =in.nextLine();
                        int pos = posVist(vis,nVis,name);
                        if(pos==-1) {
                            out.format("Não existe nenhum visitante com o nome %s.\n",name);
                        } else {
                            out.format("Nome do Visitante: %s   Posição/Número: %d\n", name, pos);
                        }
                    } else {
                        out.format(msgErro);
                    }
                    break;
                case '4':
                    if(nVis!=0) {
                        out.format("Introduza o nome do Visitante a substitiuir: ");
                        String nameOld =in.nextLine();
                        out.format("Introduza o novo nome para %s: ", nameOld);
                        String nameNew =in.nextLine();
                        if(updateVist(vis,nVis,nameOld,nameNew)) {
                            out.format("O nome %s foi alterado com sucesso para %s.\n", nameOld, nameNew);
                        } else {
                            out.format("Não foi possível alterar o nome %s. É possível que esse nome não exista.\n",nameOld);
                        }
                    } else {
                        out.format(msgErro);
                    }
                    break;
                case '5':
                    if(nVis!=0) {
                        out.format("Introduza o nome do Visitante a eliminar: ");
                        String name =in.nextLine();
                        int res=delVist(vis,nVis,name);
                        if(res!=-1) {
                            nVis=res;
                            out.format("O nome %s foi eliminado com sucesso.\nExistem neste momento %d visitantes.\n", name, nVis);
                        } else {
                            out.format("Não foi possível eliminar o nome %s. É possível que esse nome não exista.\n",name);
                        }
                    } else {
                        out.format(msgErro);
                    }
                    break;
                case '6':
                    if(nVis!=0) {
                        out.format("Introduza o caracter inicial dos nomes a listar: ");
                        char chr =in.next().charAt(0);
                        
                        listVistIni(vis,nVis,chr);
                    } else {
                        out.format(msgErro);
                    }
                    break;
                case '7':
                    if(nVis!=0) {
                        listNameRepeat(vis,nVis);
                    } else {
                        out.format(msgErro);
                    }
                    break;
                case '8':
                    break;
                default:
                    out.format("A opção inserida não é válida. Por favor, escolha uma das seguintes opções:\n");
                    break;          
            }
            opt=menu();
        } while(opt!='8');
    }
    
    /**
     * Método Menu
     * @return opção inserida
     */
    private static char menu() {
        String menu=String.format("\n1. Inserir Visitante\n2. Listar Visitantes\n3. Posição de Visitante\n4. Actualizar Visitante\n5. Eliminar Visitante\n6. Listagem filtrada de Visitantes\n7. Listagem de Visitantes Repetidos\n8. Terminar\n\nEscolha uma Opção: ");
        out.format("%s",menu);
        char opt=in.next().charAt(0);
        return opt;
    }

    /**
     * Método: Inserir Visitante
     * @param v vector com os nomes dos visitantes
     * @param nElm número de visitantes 
     * @return numero de visitantes actualizado
     */
    private static int insertVist(String[] v, int nElm) {
        out.format("Introduza o nome do Visitante: ");
        v[nElm]=in.nextLine();
        nElm++;
        out.format("Visitante nº %1d: %s\n", nElm, v[nElm-1]);
        return nElm;
    }
    
    /**
     * Método: Listar Visitantes
     * @param v vector c/ nome dos visitantes
     * @param nElm número de visitantes
     */
    private static void listVist(String[] v, int nElm) {
        out.format("\nLISTAGEM DE VISITANTES:\n");
        for(int i=0; i<nElm; i++) {
            out.format("» Nº: %d - %s\n",i+1,v[i]);
        }
        out.format("TOTAL: %d\n", nElm);
    }
    
    /**
     * Método Posição de um Nome
     * @param v vector nome dos Visitantes
     * @param nElm número de Visitantes
     * @param name nome do Visitante a procurar
     * @return posição do visitante (o 1º que encontrar); -1 se não encontrar
     */
    private static int posVist(String[] v, int nElm, String name) {
        for(int i=0; i<nElm; i++) {
            if(v[i].equalsIgnoreCase(name)) {
                return (i+1);
            }
        }
        return -1;
    }
    
    /**
     * Método Alterar Nome
     * @param v vector c/ nome dos visitantes
     * @param nElm numero de visitantes
     * @param nameOld nome a alterar
     * @param nameNew nome novo
     * @return true se alterou com sucesso; false se não alterou com sucesso
     */
    private static boolean updateVist(String[] v, int nElm, String nameOld, String nameNew) {
        boolean flag = false;
        for(int i=0; i<nElm; i++) {
            if(v[i].equalsIgnoreCase(nameOld)) {
                v[i]=nameNew;
                flag=true;
            }
        }
        return flag;
    }
    
    /**
     * Método Eliminar Visitante
     * @param v vector com nome dos visitantes
     * @param nElm número de visitantes
     * @param name nome a eliminar
     * @return numero de elementos actual; -1 (não eliminou nenhum visitante)
     */
    private static int delVist(String[] v, int nElm, String name) {
        for(int i=0; i<nElm; i++) {
            if(v[i].equalsIgnoreCase(name)) {
                for(int j=i; j<nElm; j++) {
                    v[j]=v[j+1];
                }
                return (nElm-1);
            }
        }
        return -1;
    }
    
    /**
     * Método Listagem de Visitantes Iniciados por uma dada letra 
     * @param v vector com nome dos visitantes
     * @param nElm número de visitantes
     * @param chr letra a procurar
     */
    private static void listVistIni(String[] v, int nElm, char chr) {
        out.format("\nLISTAGEM DE VISITANTES INICIADOS POR - %s:\n",chr);
        boolean flag=false;
        for(int i=0; i<nElm; i++) {
            if(v[i].charAt(0)==chr) {
                out.format("» Nº: %d - %s\n",i+1,v[i]);
                flag=true;
            }
        }
        if(!flag) {
            out.format("Não existem visitantes cujo nome se inicie por %s.\n",chr);
        }
    }
    
    /**
     * Método Listagem de Nomes Repetidos 
     * @param v vector com nome dos Visitantes
     * @param nElm número de visitantes
     */
    private static void listNameRepeat(String[] v, int nElm) {
        boolean flag=false;
        int c=0;
        String aux;
        String[] vRep = new String[100];
        
        out.format("\nLISTAGEM DE NOMES REPETIDOS:\n");
        
        for(int i=0; i<nElm; i++) {
            for(int j=i+1; j<nElm; j++) {
                if(v[i].equalsIgnoreCase(v[j])) {
                    flag=true;
                    for(int k=0; k<c; k++) {
                        if(vRep[k].equalsIgnoreCase(v[i])) {
                            flag=false;
                        }
                    }
                    if(flag) {
                        out.format(" » %s \n", v[i]);
                        flag=true;
                        vRep[c]=v[i];
                        c++;
                    }
                }
            }
        }
        if(!(c==0)) {
            out.format("Não foram encontrados nomes repetidos.\n");
        }
    }        
}
