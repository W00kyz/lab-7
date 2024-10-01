import java.util.concurrent.BlockingQueue;
import java.util.Random;

public class Cliente implements Runnable {

    BlockingQueue<Pedido> queue;
    NomesProdutos[] nomeProdutos = NomesProdutos.values();

    public Cliente(BlockingQueue<Pedido> queue) {
        this.queue = queue;
    }

    // Checar se e thread-safe
    @Override
    public void run() {
        try {
            Pedido pedido = new Pedido();
            int qtdPedidos = new Random().nextInt(10) + 1;
            for (int i = 0; i < qtdPedidos; i++) {
                String nome = nomeProdutos[new Random().nextInt(nomeProdutos.length)].name();
                Produto produto = new Produto(nome, new Random().nextDouble(25) + 0.50);
                pedido.adicionar(produto);
                // System.out.println(pedido);
            }
            queue.put(new Pedido());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
