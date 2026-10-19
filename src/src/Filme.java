import java.util.*;
public class Filme {

    private String nome;

    private String anoDeLancamento;

    private String ondeAssistir;

    private boolean hot;

    public Filme(String nome, String anoDeLancamento, String ondeAssistir) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
        this.ondeAssistir = ondeAssistir;
    }

    public void setHot(boolean valor) {
      this.hot = valor;
    }

    public boolean isHot() {
        return this.hot;
    }

    public void setOndeAssistir(String local) {
        this.ondeAssistir = ondeAssistir;
    }

    public String getNome() {
        return nome;
    }

    public String getAnoDeLancamento() {
        return anoDeLancamento;
    }

    @Override
    public String toString() {
        String fogo = "";
        if (isHot()){
            fogo = "\uD83D\uDD25";
        }
        return fogo + " " +this.nome + ", " + anoDeLancamento + ", " + ondeAssistir;
    }

    @Override
    public boolean equals(Object o){
        if (o == null){
            return false;
        }

        if (o instanceof Filme){
            Filme oObject = (Filme) (o);
            if ((oObject.getNome().equals(this.nome)) &&(oObject.getAnoDeLancamento().equals(this.anoDeLancamento))){
                return true;
            }

        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.nome, this.anoDeLancamento);
    }

}