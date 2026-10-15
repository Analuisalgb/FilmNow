import java.util.*;
public class FilmNow {
    private Filme[] filmes;
    private Filme[] hotList;

    public FilmNow() {
        this.filmes = new Filme[101];
        this.hotList = new Filme[10];
    }

    public String adicionaFilme(int posicaoLista, String nome, int anoDeLancamento, String ondeAssistir) {
        Filme filme = new Filme(nome,anoDeLancamento,ondeAssistir);
        if((posicaoLista < 1)&& (posicaoLista > 100)){
            return "POSIÇÃO INVÁLIDA";
        }
        if(temFilme(filme)){
           return "FILME JÁ ADICIONADO!";
        }
        if((nome == null || nome.isBlank()) || (ondeAssistir == null || ondeAssistir.isBlank())){
            return "FILME INVALIDO";
        }
        filmes[posicaoLista] = filme;
        return "FILME ADICIONADO!";
    }

    public String visualizaFilmes() {
        String retorno = "";
        for (int i = 0; i < 100; i++){
            if (filmes[i] != null){
                retorno += i + " - " + filmes[i].getNome()+"\n";
            }
        }
        return retorno;
    }

    public String detalhaFilme(int posicaoLista) {
        return filmes[posicaoLista].toString();
    }

    public String adicionarHot(int posicaoHot, String nome, int anoDeLancamento, String ondeAssistir) {
        Filme filme = new Filme(nome,anoDeLancamento,ondeAssistir);
        if((posicaoHot <= 1)&& (posicaoHot >= 10)){
            return "POSIÇÃO INVÁLIDA";
        }
        if(temFilme(filme)){
            return "FILME JÁ ADICIONADO!";
        }
        if((nome == null || nome.isBlank()) || (ondeAssistir == null || ondeAssistir.isBlank())){
            return "FILME INVALIDO";
        }
        if(hotList[posicaoHot] != null){
            hotList[posicaoHot].setHot(false);
        }
        //falta ver se tem um hot na posição para eu continuar vendo se eles são hots ou não!
        hotList[posicaoHot-1] = filme;
        filme.setHot(true);
        return "FILME ADICIONADO!";

    }

    public String exibirHotList() {
        String retorno = "";
        for (int i = 0; i < 100; i++){
            if (hotList[i] != null){
                retorno += i + " - " + hotList[i].getNome()+"\n";
            }
        }
        return retorno;
    }

    public String removerHot(int posicaoHot) {
        if((posicaoHot < 1) && (posicaoHot > 10)){
            return "POSIÇÃO INVÁLIDA";
        }
        else{
            hotList[posicaoHot] = null;
            return "ADICIONADO À HOTLIST NA POSIÇÃO " + posicaoHot + "!";
        }

    }

    private boolean temFilme(Filme filme) {
        for (int i = 1; i < 101; i++){
            if (filmes[i].equals(filme)){
                return true;
            }
        }
        return false;
    }

}