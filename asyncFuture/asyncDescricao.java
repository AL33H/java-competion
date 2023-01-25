package asyncFuture;

import domain.Descricao;

import java.util.Random;
import java.util.concurrent.Callable;

public class asyncDescricao implements Callable<Descricao> {

    private Descricao descricao;

    public asyncDescricao(Descricao descricao) {
        this.descricao = descricao;
    }

    @Override
    public Descricao call() throws Exception {
        int i = new Random().nextInt(2000);
        System.out.println("Fazendo Processo demorado - DESCRICAO: " + i + "ms");
        Thread.sleep(i);
        return descricao;
    }
}
