import asyncFuture.*;
import domain.Categoria;
import domain.Descricao;
import domain.Embalagem;
import domain.FgAtivo;

import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        asyncProdutoPersistence();
    }

    private static void asyncProdutoPersistence() throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();

        Produto produto = new Produto();

        ExecutorService executorService = Executors.newFixedThreadPool(5, new ThreadFactoryImpl());

        asyncCategoria asyncCategoria = new asyncCategoria(new Categoria("Venda comercial"));
        asyncDescricao asyncDescricao = new asyncDescricao(new Descricao("Produto novo"));
        asyncEmbalagem asyncEmbalagem = new asyncEmbalagem(new Embalagem("Unitario"));
        asyncFgAtivo asyncFgAtivo = new asyncFgAtivo(new FgAtivo(true));

        Future<Categoria> categoriaFuture = executorService.submit(asyncCategoria);
        Future<Descricao> descricaoFuture = executorService.submit(asyncDescricao);
        Future<Embalagem> embalagemFuture = executorService.submit(asyncEmbalagem);
        Future<FgAtivo> fgAtivoFuture = executorService.submit(asyncFgAtivo);

        executorService.submit(new asyncProduto(produto, categoriaFuture, descricaoFuture, embalagemFuture, fgAtivoFuture)).get();

        long total = System.currentTimeMillis() - startTime;
        System.out.println("TIME DECORRIDO: " + total + "ms");

        System.out.println("Persistindo no banco ");
        produto.setId(UUID.randomUUID());
        System.out.println(produto);
    }

}
