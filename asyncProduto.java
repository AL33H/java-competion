import domain.Categoria;
import domain.Descricao;
import domain.Embalagem;
import domain.FgAtivo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class asyncProduto implements Runnable {

    private static final Long TIMEOUT = 2000L;

    private Produto produto;
    private Future<Categoria> categoriaFuture;
    private Future<Descricao> descricaoFuture;
    private Future<Embalagem> embalagemFuture;
    private Future<FgAtivo> fgAtivoFuture;

    public asyncProduto(Produto produto, Future<Categoria> categoriaFuture, Future<Descricao> descricaoFuture, Future<Embalagem> embalagemFuture, Future<FgAtivo> fgAtivoFuture) {
        this.produto = produto;
        this.categoriaFuture = categoriaFuture;
        this.descricaoFuture = descricaoFuture;
        this.embalagemFuture = embalagemFuture;
        this.fgAtivoFuture = fgAtivoFuture;
    }

    @Override
    public void run() {
        try {
            produto.setCategoria(categoriaFuture.get(TIMEOUT, TimeUnit.MILLISECONDS));
            produto.setDescricao(descricaoFuture.get(TIMEOUT, TimeUnit.MILLISECONDS));
            produto.setEmbalagem(embalagemFuture.get(TIMEOUT, TimeUnit.MILLISECONDS));
            produto.setFg_ativo(fgAtivoFuture.get(TIMEOUT, TimeUnit.MILLISECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            System.out.println("THREAD ERROR: " + Thread.currentThread().getName() + " EXCEPTION: " + e);
            this.categoriaFuture.cancel(true);
            this.descricaoFuture.cancel(true);
            this.embalagemFuture.cancel(true);
            this.fgAtivoFuture.cancel(true);
            throw new RuntimeException(e);
        }
    }
}
