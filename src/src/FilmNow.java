import java.util.*;
public class FilmNow {
    private Filme[] filmes;
    private Filme[] hotList;

    public FilmNow() {
        this.filmes = new Filme[101];
        this.hotList = new Filme[11];
    }

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

    public String visualizaFilmes() {
        String retorno = "";
        for (int i = 0; i < 101; i++){
            if (filmes[i] != null){

                retorno += i + " - " + filmes[i].getNome()+"\n";
            }
        }
        return retorno;
    }

    public String detalhaFilme(int posicaoLista) {
        if ((posicaoLista < 1) || (posicaoLista > 100)){
            return "POSIÇÃO INVÁLIDA";
        }
        else if (filmes[posicaoLista] == null){
            return "POSIÇÃO INVÁLIDA";
        }

        return filmes[posicaoLista].toString();
    }

    public String adicionarHot(int posicaoHot, int posLista) {
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
        //falta ver se tem um hot na posição para eu continuar vendo se eles são hots ou não!
        hotList[posicaoHot] = filme;
        filme.setHot(true);
        return "FILME ADICIONADO!";

    }

    public String exibirHotList() {
        String retorno = "";
        for (int i = 1; i < 11; i++){
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
            hotList[posicaoHot].setHot(false);
            hotList[posicaoHot] = null;
            return "FILME REMOVIDO DA HOTLIST!";
        }
    }

    private boolean temFilme(Filme filme) {
        for (int i = 1; i < 101; i++){
            if ((filmes[i]!= null) && (filmes[i].equals(filme))){
                return true;
            }
        }
        return false;
    }

    private boolean temHot(Filme filme) {
        for (int i = 1; i < 11; i++){
            if ((hotList[i]!= null) && (hotList[i].equals(filme))){
                return true;
            }
        }
        return false;
    }

}