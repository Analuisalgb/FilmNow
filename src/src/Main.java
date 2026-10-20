import java.io.*;
import java.util.*;

/**
 * Interface com menus texto para manipular o sistema FilmNow. Possuí diversos métodos auxiliares que conectam a classe
 * do sistema, FilmNow, com a interface de texto.
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

            System.out.print("Opção> ");
            String input = sc.nextLine().toUpperCase().trim();

            System.out.println("");
            executaOpcoes(input,sc,filmNow);
        }
    }

    /**
     * Interpreta a opção escolhida por quem está usando o sistema.
     *
     * @param input Opção digitada.
     * @param filmNow O sistema FilmNow que estamos manipulando.
     * @param sc Objeto scanner para o caso do comando precisar de mais input.
     */
    private static void executaOpcoes(String input, Scanner sc, FilmNow filmNow){
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
        if (input.equals("S")){
            sai();
        }
    }

    /**
     * Exibe o menu e suas opções para o usuário/a
     *
     * @return A representação textual do menu.
     */
    private static String menu(){
        String menuString = "(A)Adicionar filme \n(M)Mostrar todos \n(D)Detalhar filme \n(E)Exibir HotList \n(H)Atribuir Hot \n(R)Remover Hot  \n(S)Sair \n";
        System.out.println("");
        return menuString;
    }

    /**
     * Sai da aplicação.
     */
    private static void sai() {
        System.out.println("Finalizando o programa. Volte sempre! \uD83C\uDFA5");
        System.exit(0);
    }

    /**
     * Cadastra um filme no sistema.
     *
     * @param sc Scanner para pedir informações do filme.
     * @param filmNow O sistema FilmNow a ser manipulado.
     */
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
    }

    /**
     * Imprime os detalhes de um dos filmes.
     *
     * @param sc Scanner para identificar o filme.
     * @param filmNow O sistema FilmNow a ser manipulado.
     */
    private static void detalhaFilme(Scanner sc, FilmNow filmNow){
        System.out.print("Posição> ");
        int pos = Integer.parseInt(sc.nextLine());
        System.out.print("");

        System.out.println(filmNow.detalhaFilme(pos));
    }

    /**
     * Imprime lista de filmes.
     *
     * @param filmNow O sistema FilmNow a ser manipulado.
     */
    private static void mostraTodosFilmes(FilmNow filmNow){
        System.out.println(filmNow.visualizaFilmes());
    }

    /**
     * Imprime lista de filmes na hot list.
     *
     * @param filmNow O sistema FilmNow a ser manipulado.
     */
    private static void mostraHotList(FilmNow filmNow){
        System.out.println(filmNow.exibirHotList());
    }

    /**
     * Cadastra um filme na hot list.
     *
     * @param sc Scanner para capturar qual o filme.
     * @param filmNow O sistema FilmNow a ser manipulado.
     */
    private static void adicionaHotList(Scanner sc, FilmNow filmNow){
        System.out.print("Filme> ");
        int filme = Integer.parseInt(sc.nextLine());
        System.out.print("");

        System.out.print("Posição> ");
        int pos = Integer.parseInt(sc.nextLine());
        System.out.print("");

        System.out.println(filmNow.adicionarHot(pos,filme));
    }

    /**
     * Retira um filme da hot list.
     *
     * @param sc Scanner para capturar qual o filme.
     * @param filmNow O sistema FilmNow a ser manipulado.
     */
    private static void removeHotList(Scanner sc, FilmNow filmNow){
        System.out.print("Posição> ");
        int pos = Integer.parseInt(sc.nextLine());
        System.out.print("");

        System.out.println(filmNow.removerHot(pos));
    }

    /**
     * Lê carga de filmes de um arquivo csv.
     *
     * @param arquivoFilmes O caminho para o arquivo.
     * @param fn O sistema FilmNow a ser populado com os dados.
     * @throws IOException Caso o arquivo não exista ou não possa ser lido.
     */
    private static void carregaFilmes(String arquivoFilmes, FilmNow fn) throws FileNotFoundException, IOException {
        LeitorFilmNow leitor = new LeitorFilmNow();

        int carregados =  leitor.carregaContatos(arquivoFilmes, fn);
        System.out.println("Carregamos " + carregados + " registros.");
    }
}