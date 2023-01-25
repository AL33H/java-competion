package asyncFuture;

import domain.Categoria;

import java.util.Random;
import java.util.concurrent.Callable;

public class asyncCategoria implements Callable<Categoria> {

    private Categoria categoria;

    public asyncCategoria(Categoria descricao) {
        this.categoria = descricao;
    }

    @Override
    public Categoria call() throws Exception {
        int i = new Random().nextInt(2000);
        System.out.println("Fazendo Processo demorado - CATEGORIA: " + i + "ms");
        Thread.sleep(i);
        return categoria;
    }
}
