import domain.Categoria;
import domain.Descricao;
import domain.Embalagem;
import domain.FgAtivo;

import java.util.UUID;

public class Produto {

    private UUID id;
    private Descricao descricao;
    private FgAtivo fg_ativo;
    private Categoria categoria;
    private Embalagem embalagem;

    public Produto() {}

    public Produto(UUID id, Descricao descricao, FgAtivo fg_ativo, Categoria categoria, Embalagem embalagem) {
        this.id = id;
        this.descricao = descricao;
        this.fg_ativo = fg_ativo;
        this.categoria = categoria;
        this.embalagem = embalagem;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Descricao getDescricao() {
        return descricao;
    }

    public void setDescricao(Descricao descricao) {
        this.descricao = descricao;
    }

    public FgAtivo getFg_ativo() {
        return fg_ativo;
    }

    public void setFg_ativo(FgAtivo fg_ativo) {
        this.fg_ativo = fg_ativo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Embalagem getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(Embalagem embalagem) {
        this.embalagem = embalagem;
    }

    @Override
    public String toString() {
        return "Produto\n{\n" +
                "id=" + id + "\n" +
                "descricao=" + descricao +
                "\nfg_ativo=" + fg_ativo +
                "\ncategoria=" + categoria +
                "\nembalagem=" + embalagem +"\n"+
                '}';
    }
}