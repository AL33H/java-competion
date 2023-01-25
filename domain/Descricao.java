package domain;

public class Descricao {
    private String descricao;

    public Descricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Descricao{" +
                "descricao='" + descricao + '\'' +
                '}';
    }
}
