import java.util.*;

/**
 * A classe FilmNow organiza os filmes em um array do objeto Filme e em uma hot list, com os filmes que se quer assistir
 * com mais urgência, que caso ja estiverem sidos adicionados, podem ser marcados como hot. É possível listar os filmes,
 * tanto hot como normais, e detalhar-los.
 *
 * @author ana.luisa.lopes.carneiro.de.aragao.monteiro
 */
public class FilmNow {
    private Filme[] filmes;
    private Filme[] hotList;

    /**
     * Construtor da classe. Inicializa os arrays (TAMANHO FIXO). Usa-se um número a mais que a especificação para
     * facilitar o tratamento do índice.
     *
     */
    public FilmNow() {
        this.filmes = new Filme[101];
        this.hotList = new Filme[11];
    }

    /**
     * Recebe parâmetros para a inicialização de um objeto da classe Filme, que logo em seguida é adicionado à lista de filmes.
     *
     * @param posicaoLista
     * @param nome
     * @param anoDeLancamento
     * @param ondeAssistir
     * @return possíveis erros ao se adicionar o filme, esclarecidos na especificação.
     */
    public String adicionaFilme(int posicaoLista, String nome, String anoDeLancamento, String ondeAssistir) {
        Filme filme = new Filme(nome,anoDeLancamento,ondeAssistir);
        if (posicaoLista < 1 || posicaoLista > 100){
            return "POSIÇÃO INVÁLIDA";
        }
        else if(temFilme(filme)){
           return "FILME JÁ ADICIONADO!";
        }
        else if((nome == null || nome.isBlank()) || (ondeAssistir == null || ondeAssistir.isBlank())){
            return "FILME INVALIDO";
        }
        else {
            filmes[posicaoLista] = filme;
            return "FILME ADICIONADO!";
        }
    }

    /**
     *
     * @return
     */
    public String visualizaFilmes() {
        String retorno = "";
        for (int i = 0; i < 101; i++){
            if (filmes[i] != null){

                retorno += i + " - " + filmes[i].getNome()+"\n";
            }
        }
        return retorno;
    }

    /**
     *
     * @param posicaoLista
     * @return
     */
    public String detalhaFilme(int posicaoLista) {
        if ((posicaoLista < 1) || (posicaoLista > 100)){
            return "POSIÇÃO INVÁLIDA";
        }
        else if (filmes[posicaoLista] == null){
            return "POSIÇÃO INVÁLIDA";
        }

        return filmes[posicaoLista].toString();
    }

    /**
     *
     * @param posicaoHot
     * @param posLista
     * @return
     */
    public String adicionarHot(int posicaoHot, int posLista) {
        if ((posicaoHot < 1) || (posicaoHot > 10)){
            return "POSIÇÃO INVÁLIDA";
        }
        if ((posLista < 1) || (posLista > 100)){
            return "FILME INVÁLIDO";
        }
        if (filmes[posLista] == null){
            return "FILME INVALIDO";
        }

        Filme filme = filmes[posLista];
        if(temHot(filme)){
            return "FILME JÁ ADICIONADO!";
        }

        if(hotList[posicaoHot] != null){
            hotList[posicaoHot].setHot(false);
        }
        hotList[posicaoHot] = filme;
        filme.setHot(true);
        return "FILME ADICIONADO!";

    }

    /**
     *
     * @return
     */
    public String exibirHotList() {
        String retorno = "";
        for (int i = 1; i < 11; i++){
            if (hotList[i] != null){
                retorno += i + " - " + hotList[i].getNome()+"\n";
            }
        }
        return retorno;
    }

    /**
     *
     * @param posicaoHot
     * @return
     */
    public String removerHot(int posicaoHot) {
        if((posicaoHot < 1) && (posicaoHot > 10)){
            return "POSIÇÃO INVÁLIDA";
        }
        else{
            hotList[posicaoHot].setHot(false);
            hotList[posicaoHot] = null;
            return "FILME REMOVIDO DA HOTLIST!";
        }
    }

    /**
     *
     * @param filme
     * @return
     */
    private boolean temFilme(Filme filme) {
        for (int i = 1; i < 101; i++){
            if ((filmes[i]!= null) && (filmes[i].equals(filme))){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param filme
     * @return
     */
    private boolean temHot(Filme filme) {
        for (int i = 1; i < 11; i++){
            if ((hotList[i]!= null) && (hotList[i].equals(filme))){
                return true;
            }
        }
        return false;
    }

}