/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestdesportiva;

/**
 * Aplicação Gestão de Actividade Desportiva [APROG]
 * @author Duarte Nuno Amorim
 */

import java.util.Scanner;
import java.util.Formatter;
import java.io.File;
        
public class GestDesportiva {

    private static final int MAX_PROVAS=10;
    private static final int MAX_ATLETAS=100;
    private static final String EXTENSAO = ".txt";
    
    private static Formatter out = new Formatter(System.out);
    private static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        String[] atletas = new String[MAX_ATLETAS];
        int[][] provas = new int [MAX_ATLETAS][MAX_PROVAS];
        
        //nElems: número de atletas inseridos
        
        int opt, nElems = 0, num;
        String nom;
        
        do {    
            opt = menu();
            switch (opt) {
                    case 1:
                        nom=askNomeFicheiro("Nome do Ficheiro?");
                        int ans =lerInfoFicheiro(nom, atletas, nElems);
                        if(ans==-1) {
                            out.format("Não foi possível ler para a memória toda a informação no ficheiro.");
                            nElems=MAX_ATLETAS;
                        } else {
                            nElems=ans;
                        }
                            
                        break;
                    case 2: 
                        num = leValor("Nº do Atleta",100,999);
                                                
                        mostrarInfoAtleta(num, atletas, nElems);
                        continuar();
                        break;
                    case 3: 
                        //Ler o nº da prova
                        int np = leValor("Número da Prova", 1, MAX_PROVAS);
                        
                        String nomefich=String.valueOf(np)+EXTENSAO;
                        inserirTempoProva(nElems, nomefich, np-1, atletas, provas);
                        break;
                    case 4: 
                        mostraInfoMemoria(atletas, nElems, provas);
                        continuar();
                        break;
                    case 5:
                        nom=askNomeFicheiro("Nome de ficheiro de Backup a criar?");
                        guardaInfoEmFicheiro(nom, atletas, provas, nElems);
                        break;        
                    case 6:
                        nom=askNomeFicheiro("Nome de ficheiro de Backup criado?");
                        nElems=recuperaInfoDeFicheiro(nom, atletas, provas);
                        break;
                    case 7: 
                        nElems=inserirAtleta(atletas, nElems);
                        continuar();
                        break;        
                    case 8: 
                        updateTempoProva(atletas, provas, nElems);
                        continuar();
                        break;
                    case 9: 
                        if(removerAtletaDesqualificado(atletas, provas, nElems)) {
                            out.format("Atleta Removido com Sucesso.%n");
                            nElems--;
                        } else {
                            out.format("O Atleta dado não Existe.%n");
                        }
                        break;        
                    case 10:
                        mostraProvaMelhorPior(nElems, atletas, provas);
                        continuar();
                        break;
                    case 11: 
                        char op;
                        do {
                            op=menuOrdenacao();
                            switch(op) {
                                case 'a':
                                    ordenacaoCamisola(atletas, nElems, provas);
                                    continuar();
                                    break;
                                case 'b':
                                    ordenacaoMediasDecrescente(atletas, nElems, provas);
                                    continuar();
                                    break;
                                case 's':
                                    out.format("%n%n");
                                    break;
                                default:
                                    out.format("%n%s%n","A opção Inserida não é válida.");
                                    break;
                            }
                        } while(op!='s' && op!= 'a' && op!='b');    
                        break;        
                    case 12: 
                        guardarAtletasFicheiro(atletas, nElems);
                        break;
                    case 13:
                        mediaAtleta(atletas, nElems, provas);
                        continuar();
                        break;        
                    case 14: 
                        listaMelhoresAtletasFicheiro(atletas, nElems, provas);
                        continuar();
                        break;
                    case 0: 
                        out.format("%n%s%n","O programa está a terminar...");
                        break;        
                    default:
                        out.format("%n%s%n","A opção Inserida não é válida.");
                        break;
             }
        } while(opt!=0); 

    }
    
    /**
     * Método menu(): apresenta um menu ao utilizador
     * @return opção inserida (nr do menu)
     */
    private static int menu() {
        out.format("GESTÃO DE ACTIVIDADE DESPORTIVA - MENU%n%n"
                  + "  1. Ler Informação de Ficheiro%n"
                  + "  2. Mostrar Informação de Atleta%n"
                  + "  3. Ler Tempos de Prova de Ficheiro%n"
                  + "  4. Listar Informação em Memória%n"
                  + "  5. Guardar Informação em Memória (Backup)%n"
                  + "  6. Recuperar Informação para Memória (de Backup)%n"
                  + "  7. Inserir Informação de Atleta%n"
                  + "  8. Actualizar tempo de Atleta%n"
                  + "  9. Remover Atleta Desqualificado%n"
                  + " 10. Melhor/Pior Prova de Atleta%n"
                  + " 11. Ordenar Informação em Memória%n"
                  + " 12. Guardar Informação em Memória para um novo ficheiro%n"
                  + " 13. Tempo Médio de Atleta%n"
                  + " 14. Guardar Melhores Qualificações em ficheiro%n"
                  + "  0. Sair%n"
                  + "%nEscolha a sua Opção: ");
        
        int opt = in.nextInt();
        in.nextLine();
        return opt;
    }
    
    /**
     * Método continuar(): fornece uma pausa controlada pelo utilizador
     */
    private static void continuar() {
        out.format("%n%s%n", "Pressione ENTER para continuar.");
        in.nextLine();
    }
    
    /**
     * Método lerInfoFicheiro: le a informacao de um ficheiro dado para memória
     * 
     * @param nomeFich nome do ficheiro a ler
     * @param atletas vector de atletas
     * @param nEl numero de elementos existentes
     * @return numero de Atletas actualizado
     * @throws Exception 
     */
    private static int lerInfoFicheiro(String nomeFich, String[] atletas, int nEl) throws Exception {
        Scanner fIn = new Scanner(new File(nomeFich));
        while(fIn.hasNext() && nEl < MAX_ATLETAS) {
            nEl=guardarInfoAtleta(fIn.nextLine(),atletas,nEl);
        }
        if(fIn.hasNext()) {
            fIn.close();
            return -1;
        }
        fIn.close();
        return nEl;
    }
    
    /**
     * Método guardarInfoAtleta(): analisa e coloca toda a informação vinda de um ficheiro para o array de atletas
     * @param aux informação lida do ficheiro
     * @param vec vector a guardar informação
     * @param n posicao a trabalhar no vector
     * @return numero de elementos total no vector
     */
    private static int guardarInfoAtleta(String aux, String[] vec, int n) {
        String[] temp = aux.split(";");
        
        vec[n]=temp[1];
        vec[n]+=temp[2];
        
        if(temp[3].equalsIgnoreCase("A") || temp[3].equalsIgnoreCase("B") || temp[3].equalsIgnoreCase("C")) {
            vec[n]+=temp[3];
        } else {
            if(Integer.parseInt(temp[3]) <= 20) {
                vec[n]+="A";
            } else {
                if (Integer.parseInt(temp[3]) <= 30) {
                    vec[n]+="B";
                } else {
                    vec[n]+="C";
                }
           }
        }
        
        temp[0]=temp[0].trim();
        
        //Colocar o nome curto no Array
        if(temp[0].length() > 20) {
            vec[n]+=temp[0].substring(0,20);
        } else {
            vec[n]+=temp[0];
        }
        
        return ++n;
    }
    
    /**
     * Método mostrarInfoAtleta(): apresentar no ecrã informação relativa a um atleta (nr) dado
     * @param num numero do atleta
     * @param atl vector de atletas
     * @param nEl numero de Atletas existentes
     */
    private static void mostrarInfoAtleta(int num, String[] atl, int nEl) {
        int pos = procurarAtletaNum(num,atl,nEl);
        
        if(pos!=-1) {
            out.format("%n%-14s: %s", "Nome", atl[pos].substring(5));
            out.format("%n%-14s: %c", "Sexo", atl[pos].charAt(0));
            out.format("%n%-14s: %c", "Categoria", atl[pos].charAt(4));
            out.format("%n%-14s: %3s%n", "Nº de Camisola", atl[pos].substring(1,4));
        } else {
            out.format("%nO atleta nº%d não existe.", num);
        }
    }
    
    /**
     * Método procurarAtletaNum(): procura o número que identifica a linha do atleta no vector, com o numero de camisola dado
     * @param num numero de camisola
     * @param v vector de atleta
     * @param nEl numero de elementos
     * @return posicao do vector
     */
    private static int procurarAtletaNum(int num, String[] v, int nEl) {
        for(int i=0; i<nEl; i++) {
            if (getNumCamisola(v[i]) == num) {
                return i;
            }
        }
        
        return -1;
    }
    
    /**
     * Método getNumCamisola(): devolve o número da camisola do atleta
     * @param atleta linha de identificação do atleta
     * @return numero da camisola
     */
    private static int getNumCamisola(String atleta) {
        return Integer.parseInt(atleta.substring(1,4));
    }

    /**
     * Método guardaInfoEmFicheiro: guardar informação existente em memória num ficheiro de backup
     * @param nomFich nome de ficheiro de backup
     * @param atl vector de atletas
     * @param prov matriz de provas
     * @param nEl numero de atletas
     * @throws Exception 
     */
    private static void guardaInfoEmFicheiro(String nomFich, String[] atl, int[][] prov, int nEl) throws Exception {
        Formatter fOut = new Formatter(new File(nomFich));
            for (int i=0; i<nEl; i++) {
                fOut.format("%s",atl[i]);
                for (int j=0; j < MAX_PROVAS; j++) {
                    fOut.format(";%d", prov[i][j]);
                }
                fOut.format("%n");
            }
            fOut.close();
    }

    /**
     * Método recuperaInfoEmFicheiro(): recupera de um ficheiro dado informação para um programa
     * @param nomFich nome do fichero dado
     * @param atl vector de atletas
     * @param prov matriz de provas
     * @return numero de elementos actualizado
     * @throws Exception 
     */
    private static int recuperaInfoDeFicheiro(String nomFich, String[] atl, int[][] prov) throws Exception {
        int nEl;
        Scanner fIn = new Scanner(new File(nomFich));
            nEl = 0;
            String aux;
            while(fIn.hasNext()) {
                aux=fIn.nextLine();
                nEl=recupera(aux, atl, prov, nEl);
            }
            out.format("Informação Recuperada com Sucesso.%n");

        fIn.close();
        return nEl;
    }
    
    /**
     * Método recupera(): recupera de uma linha do ficheiro lido informação para as ED da Aplicação
     * @param aux linha do ficheiro
     * @param atletas vector de atletas
     * @param provas matriz de provas
     * @param nEl numero de elementos preenchidos
     * @return numero de elementos actualizado
     */
    private static int recupera(String aux, String[] atletas, int[][] provas, int n) {
        String [] temp = aux.split(";");
        
        atletas[n]=temp[0].trim();
        
        for(int i=0; i<MAX_PROVAS; i++) {
            provas[n][i]=Integer.parseInt(temp[i+1]);
        }
        
        return ++n;
    }
    
    private static boolean inserirTempoProva(int nrElm, String nomFich, int nrProva, String[] atletas, int[][] provas) throws Exception {
        int nCamis, tmpProva, pos;
        
        if(nrProva>9) {
            return false;
        }
        Scanner fIn = new Scanner(new File(nomFich));
            while(fIn.hasNext()) {
                String[] temp = fIn.nextLine().split(";");
                nCamis=Integer.parseInt(temp[0]);
                tmpProva=Integer.parseInt(temp[1]);
                
                if((pos = procurarAtletaNum(nCamis, atletas, nrElm)) > -1 ) {
                    provas[pos][nrProva] = tmpProva;
                }
            }
        fIn.close();
        return true;
    }

    
    private static void mostraProvaMelhorPior(int nrElm, String[] atletas, int[][] provas) {
        int pos, mProva, pProva;
        
        int nrCamis=leValor("Número da Camisola", 100, 999);
        
        if((pos = procurarAtletaNum(nrCamis, atletas, nrElm)) > -1) {
            mProva=obterProvaCriterio(0, provas[pos]);
            pProva=obterProvaCriterio(1, provas[pos]);
            
            out.format("%nMelhor Prova: %n");
            mostrarProvaTempo(mProva, provas[pos]);
            
            out.format("%nPior Prova: %n");
            mostrarProvaTempo(pProva, provas[pos]);
            out.format("%n");
        } else {
            out.format("%nO Atleta %d não foi encontrado.%n", nrCamis);
        }
    }
    
    private static int obterProvaCriterio(int tipPrv, int[] provas) {
        int p = provas[0];

        for (int i = 0; i < MAX_PROVAS; i++) {
            if (tipPrv==1) {
                if (provas[i] > p) {
                    p = provas[i];
                }
            } else if (tipPrv==0) {
                if (provas[i] < p) {
                    p = provas[i];
                }
            }
        }

        return p;
    }
        
    private static void mostrarProvaTempo(int tempoProva, int[] provas) {
        for (int i=0; i<MAX_PROVAS; i++) {
            if(provas[i]==tempoProva) {
                out.format(" » %d%n", i+1);
            } 
        }
    }
    
    private static int leValor(String msg, int min, int max) {
        int nr;
        
        do {
            out.format("%n%s? ", msg);
            nr=in.nextInt();
            in.nextLine();
        } while(nr < min && nr > max);
        
        return nr;
    }
    
    private static String askNomeFicheiro(String msg) {
        out.format("%n%s ",msg);
        String name = in.nextLine();
        return name+EXTENSAO;
    }
    
    private static int inserirAtleta(String[] atletas, int nrAtletas) {
        if(nrAtletas==MAX_ATLETAS) {
            out.format("%nNão é possível adicionar mais atletas.%n");
            return MAX_ATLETAS;
        } 
        String aux;
        
        int nrAtleta;
        
        do {
            out.format("%nNúmero da Camisola do Atleta? ");
            nrAtleta=in.nextInt();
            in.nextLine();
        } while(procurarAtletaNum(nrAtleta,atletas,nrAtletas) != -1);
        
        //NOME
        out.format("%nNome do Atleta? ");
        String nome=in.nextLine();
        aux=nome+";";
        
        //SEXO
        char sex;
        do {
            out.format("%nSexo do Atleta %s (M ou F)? ", nome);
            sex=in.nextLine().toUpperCase().charAt(0);
        } while(sex != 'M' && sex != 'F');
        aux+=sex+";";
        
        //NUMERO DA CAMISOLA
        aux+=nrAtleta+";";
        
        //IDADE
        int age=leValor("Idade do Atleta "+nome, 1, 100);
        aux+=age+";";
        
        nrAtletas=guardarInfoAtleta(aux, atletas, nrAtletas);
        return nrAtletas;
    }
    
    private static void updateTempoProva(String[] atletas, int[][] provas, int nElems) {
        int nrCamis, i,j;
        do {
            nrCamis=leValor("Nº da Camisola do Atleta", 100, 999);
        } while((i=procurarAtletaNum(nrCamis, atletas, nElems)) == -1);
        
        j = leValor("Nº da Prova", 1, MAX_PROVAS);
        
        out.format("Novo Tempo da Prova %d para o Atlteta nº %d? ", j, nrCamis);
        provas[i][j-1] = in.nextInt();
        in.nextLine();
        
        out.format("Tempo actualizado com sucesso.");
    }
    
    private static boolean removerAtletaDesqualificado(String[] atletas, int[][] provas, int nrAtletas) {
        int pos, nrAtl = leValor("Nº do Atleta Desqualificado",100,999);
        if ((pos=procurarAtletaNum(nrAtl,atletas,nrAtletas)) == -1) {
            return false;
        }
        
        for(int i=pos; i<MAX_ATLETAS-1; i++) {
            for(int j=pos+1; j<MAX_ATLETAS; j++) {
                atletas[i]=atletas[j];
                provas[i]=provas[j];
            }
        }
        
        return true;
    }
    
    private static void mediaAtleta(String[] atletas, int nrAtletas, int[][] provas) {
        int nrAtl,i, somProvas=0, prv=0;
        do {
            nrAtl=leValor("Nº do Atleta",100,999);
        } while((i=procurarAtletaNum(nrAtl, atletas, nrAtletas)) == -1);
                
        for(int j=0; j<MAX_PROVAS; j++) {
            if(provas[i][j] != 0) {
                somProvas+=provas[i][j];
                prv++;
            }
        }
        
        out.format("%nAtleta Nº %d   Tempo Médio (seg.): %.2f", nrAtl, (float)somProvas/prv);
    }
    
    private static char menuOrdenacao() {
        out.format("%n  a) Número de Camisola%n  b) Ordem Decrescente Média das Provas%n  s) Voltar ao Menu Anterior%n%nEscolha a sua Opção: ");
        char op = in.nextLine().toLowerCase().charAt(0);
        return op;
    }
    
    private static void guardarAtletasFicheiro(String[] atletas, int nrAtletas) throws Exception {
        Formatter fOut = new Formatter(new File("atletas.txt"));
        char cat;

        for(int i=0; i<nrAtletas; i++) {
            cat = atletas[i].charAt(5);
            String age;
        /**
            //Valores padrão para idade para possivel re-leitura

            if(cat=='A') {
                age="20";
            } else {
                if(cat=='B') {
                    age="25";
                } else {
                    age="30";
                }
            }
            **/
            fOut.format("%s;%c;%s;%s%n", atletas[i].substring(5), atletas[i].charAt(0), getNumCamisola(atletas[i]), atletas[i].charAt(4));
        }
        fOut.close();
        
    }
    
    private static float[] calculaMedias(int[][] provas, int nrElm, int prvPrp) {
        int prvEfec;
        float[] medias = new float[MAX_ATLETAS];
        for(int i=0; i<nrElm; i++) {
            prvEfec=0;
            for(int j=0; j<MAX_PROVAS; j++) {
                medias[i]+=provas[i][j];
                if(provas[i][j]!= 0 && prvPrp==1) {
                    prvEfec++;
                }
            } 
            if(prvPrp==0) {
                prvEfec=MAX_PROVAS;
            }
            if(prvEfec!=0) {
                medias[i]=(float)medias[i]/prvEfec;
            } else {
                medias[i]=0;
            }
            }
        return medias;
    }
    
    private static void ordenacaoMediasDecrescente(String[] atletas, int nrAtletas, int[][] provas) {
        float[] medias = calculaMedias(provas, nrAtletas, 0);
        float auxM;
        int[] auxPrv;
        String auxAtl;
        
        for(int i=0; i<nrAtletas-1; i++) {
            for (int j=i+1; j<nrAtletas; j++) {
                if(medias[j]>medias[i]) {
                    auxM=medias[i];
                    medias[i]=medias[j];
                    medias[j]=auxM;
                    
                    auxPrv=provas[i];
                    provas[i]=provas[j];
                    provas[j]=auxPrv;
                    
                    auxAtl=atletas[i];
                    atletas[i]=atletas[j];
                    atletas[j]=auxAtl;
                }
            }
        }
        out.format("Ordenação Decrescente por Médias efectuada com sucesso.");
    }

    private static void listaMelhoresAtletasFicheiro(String[] atletas, int nrAtletas, int[][] provas) throws Exception {
        float[] medias=calculaMedias(provas, nrAtletas, 1);
        float auxM;
        int[] auxPrv;
        String auxAtl;
        
        String nFile=askNomeFicheiro("Nome para o ficheiro com os 3 Melhores Atletas?");
        Formatter fOut = new Formatter(new File(nFile));
            for(int i=0; i<nrAtletas-1; i++) {
                for (int j=i+1; j<nrAtletas; j++) {
                    if(medias[j]<medias[i]) {
                        auxM=medias[i];
                        medias[i]=medias[j];
                        medias[j]=medias[i];
                        
                        auxPrv=provas[i];
                        provas[i]=provas[j];
                        provas[j]=provas[i];
                        
                        auxAtl=atletas[i];
                        atletas[i]=atletas[j];
                        atletas[j]=atletas[i];
                    }
                }
            }
            
            fOut.format("3 MELHORES ATLETAS:%n%n");    
            for(int i=0; i<3; i++) {
                fOut.format("%n » %-14s: %s", "Nome", atletas[i].substring(5));
                fOut.format("%n » %-14s: %c", "Sexo", atletas[i].charAt(0));
                fOut.format("%n » %-14s: %c", "Categoria", atletas[i].charAt(4));
                fOut.format("%n » %-14s: %3s%n", "Nº de Camisola", getNumCamisola(atletas[i]));
                fOut.format("%n » %-14s: %.2f%n%n","Média de Tempo", medias[i]);
            }
            fOut.close();
            out.format("Ficheiro com Melhores Atletas Criado com Sucesso.");
        
        
    }

    private static void ordenacaoCamisola(String[] atletas, int nrElem, int[][] provas) {
        int[] auxProv;
        String auxAtl;
        int nCi, nCj;
        
        for(int i=0; i<nrElem-1; i++) {
            for(int j=i+1; j<nrElem; j++) {
                nCi=getNumCamisola(atletas[i]);
                nCj=getNumCamisola(atletas[i]);
            
                if(nCj<nCi) {
                    auxAtl=atletas[i];
                    atletas[i]=atletas[j];
                    atletas[j]=auxAtl;
                    
                    auxProv=provas[i];
                    provas[i]=provas[j];
                    provas[j]=auxProv;
                }
            }
        }
        
        out.format("Ordenação pelo Número de Camisola Efectuada com Sucesso.");
    }

    private static void mostraInfoMemoria(String[] atletas, int nrElem, int[][] provas) {
        out.format("%nLISTAGEM DE INFORMAÇÃO EM MEMÓRIA:%n");
        
        for(int i=0; i<nrElem; i++) {
            out.format("%n» Atleta: %s  » NºCamisola: %d  » Sexo: %c  » Categoria: %c%n", 
                    atletas[i].substring(5), getNumCamisola(atletas[i]), atletas[i].charAt(0), atletas[i]. charAt(4));
            out.format("PROVAS:%n");
            for(int j=0; j<MAX_PROVAS; j++) {
                out.format(" %2dºProva: %d seg.%n", j+1, provas[i][j]);
            }
            
            out.format("%n");
        }
    }
}
