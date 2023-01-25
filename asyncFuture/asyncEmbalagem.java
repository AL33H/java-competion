package asyncFuture;

import domain.Embalagem;

import java.util.Random;
import java.util.concurrent.Callable;

public class asyncEmbalagem implements Callable<Embalagem> {

    private Embalagem embalagem;

    public asyncEmbalagem(Embalagem descricao) {
        this.embalagem = descricao;
    }

    @Override
    public Embalagem call() throws Exception {
        int i = new Random().nextInt(2000);
        System.out.println("Fazendo Processo demorado - EMBALAGEM: " + i + "ms");
        Thread.sleep(i);
        return embalagem;
    }
}
