package domain;

public class FgAtivo {
    private boolean fgAtivo;

    public FgAtivo(boolean fgAtivo) {
        this.fgAtivo = fgAtivo;
    }

    public boolean isFgAtivo() {
        return fgAtivo;
    }

    public void setFgAtivo(boolean fgAtivo) {
        this.fgAtivo = fgAtivo;
    }

    @Override
    public String toString() {
        return "FgAtivo{" +
                "fgAtivo=" + fgAtivo +
                '}';
    }
}
