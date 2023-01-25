package domain;

public class Embalagem {

    private String embalagem;

    public Embalagem(String embalagem) {
        this.embalagem = embalagem;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }

    @Override
    public String toString() {
        return "Embalagem{" +
                "embalagem='" + embalagem + '\'' +
                '}';
    }
}
