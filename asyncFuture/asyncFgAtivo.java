package asyncFuture;

import domain.FgAtivo;

import java.util.Random;
import java.util.concurrent.Callable;

public class asyncFgAtivo implements Callable<FgAtivo> {

    private FgAtivo fg_ativo;

    public asyncFgAtivo(FgAtivo fg_ativo) {
        this.fg_ativo = fg_ativo;
    }

    @Override
    public FgAtivo call() throws Exception {
        int i = new Random().nextInt(2000);
        System.out.println("Fazendo Processo demorado - FGATIVO: " + i + "ms");
        Thread.sleep(i);
        return fg_ativo;
    }
}
