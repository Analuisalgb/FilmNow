import java.io.*;
import java.util.*;

/**
 * A classe Main é a interface entre o sistema e o usuário. Possuí diversos métodos auxiliares que conectam a classe
 * do sistema, FilmNow, com a interface do usuário.
 *
 * @author Ana Luísa Lopes
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FilmNow filmNow = new FilmNow();
        try {
            /*
             * Essa é a maneira de lidar com possíveis erros por falta do arquivo.
             */
            carregaFilmes("filmes_inicial.csv", filmNow);
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erro lendo arquivo: " + e.getMessage());
        }


        while (true){
            System.out.print(menu());
            System.out.println("");
            System.out.print("Opção> ");
            String input = sc.nextLine().toUpperCase().trim();
            System.out.println("");
            if (input.equals("S")){
                break;
            }
            if (!input.equals("A")&& !input.equals("M")&& !input.equals("D")&& !input.equals("E") && !input.equals("H") && !input.equals("R")&&!input.equals("S")){
                System.out.println("OPÇÃO INVÁLIDA!");
                System.out.println("");
            }
            if(input.equals("A")){
                adiciona(sc,filmNow);
            }
            if(input.equals("D")){
                detalhaFilme(sc,filmNow);
            }
            if(input.equals("M")){
                mostraTodosFilmes(filmNow);
            }
            if(input.equals("E")){
                mostraHotList(filmNow);
            }
            if(input.equals("H")){
                adicionaHotList(sc,filmNow);
            }
            if(input.equals("R")){
                removeHotList(sc,filmNow);
            }
        }
    }
    private static String menu(){
        String menuString = "(A)Adicionar filme \n(M)Mostrar todos \n(D)Detalhar filme \n(E)Exibir HotList \n(H)Atribuir Hot \n(R)Remover Hot  \n(S)Sair \n";
        return menuString;
    }

    private static void adiciona(Scanner sc, FilmNow filmNow){
        System.out.print("Posição> ");
        int pos = Integer.parseInt(sc.nextLine());
        System.out.print("");

        System.out.print("Nome> ");
        String nome = sc.nextLine();
        System.out.print("");

        System.out.print("Ano> ");
        String ano = sc.nextLine();
        System.out.print("");

        System.out.print("Local> ");
        String ondeAssistir = sc.nextLine();
        System.out.print("");

        System.out.println(filmNow.adicionaFilme(pos,nome,ano,ondeAssistir));
        System.out.println("");
    }

    private static void detalhaFilme(Scanner sc, FilmNow filmNow){
        System.out.print("Posição> ");
        int pos = Integer.parseInt(sc.nextLine());
        System.out.print("");

        System.out.println(filmNow.detalhaFilme(pos));
        System.out.println("");
    }

    private static void mostraTodosFilmes(FilmNow filmNow){
        System.out.println(filmNow.visualizaFilmes());
        System.out.println("");
    }

    private static void mostraHotList(FilmNow filmNow){
        System.out.println(filmNow.exibirHotList());
        System.out.println("");
    }

    private static void adicionaHotList(Scanner sc, FilmNow filmNow){
        System.out.print("Filme> ");
        int filme = Integer.parseInt(sc.nextLine());
        System.out.print("");

        System.out.print("Posição> ");
        int pos = Integer.parseInt(sc.nextLine());
        System.out.print("");

        System.out.println(filmNow.adicionarHot(pos,filme));
        System.out.println("");
    }

    private static void removeHotList(Scanner sc, FilmNow filmNow){
        System.out.print("Posição> ");
        int pos = Integer.parseInt(sc.nextLine());
        System.out.print("");

        System.out.println(filmNow.removerHot(pos));
        System.out.println("");
    }

    private static void carregaFilmes(String arquivoFilmes, FilmNow fn) throws FileNotFoundException, IOException {
        LeitorFilmNow leitor = new LeitorFilmNow();

        int carregados =  leitor.carregaContatos(arquivoFilmes, fn);
        System.out.println("Carregamos " + carregados + " registros.");
    }
}