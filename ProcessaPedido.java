import java.util.concurrent.BlockingQueue;
import java.util.logging.Logger;

public class ProcessaPedido implements Runnable {
    static final Logger logger = Logger.getLogger(ProcessaPedido.class.getName());

    BlockingQueue<Pedido> queue;
    Estoque estoque;
    Base base;
    BlockingQueue<Pedido> pedidosPendentes;

    public ProcessaPedido(BlockingQueue<Pedido> queue, Estoque estoque, Base base, BlockingQueue<Pedido> pedidosPendentes) {
        this.queue = queue;
        this.estoque = estoque;
        this.base = base;
        this.pedidosPendentes = pedidosPendentes;
    }

    @Override
    public void run() {
        try {
            Pedido pedido = queue.take();
            boolean podeProcessar = true;

            for (Produto produto : pedido.produtos) {
                if (estoque.consultarEstoque(NomesProdutos.valueOf(produto.nome)) < 1) {
                    podeProcessar = false;
                    break;
                }
            }

            if (podeProcessar) {
                for (Produto produto : pedido.produtos) {
                    estoque.atualizarEstoque(NomesProdutos.valueOf(produto.nome),
                            estoque.consultarEstoque(NomesProdutos.valueOf(produto.nome)) - 1);
                }
                base.incrementarPedidosProcessados(pedido.total());
                logger.info("Pedido processado com sucesso: " + pedido);
            } else {
                pedidosPendentes.put(pedido);
                base.incrementarPedidosRejeitados();
                logger.warning("Pedido rejeitado (estoque insuficiente): " + pedido);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
