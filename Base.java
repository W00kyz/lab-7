import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Base
 */
public class Base {

    BlockingQueue<Pedido> queue = new ArrayBlockingQueue<>(10);
    ExecutorService clientes = Executors.newCachedThreadPool();
    public static final int NUM_CLIENTES = 10;

    public Base() {

    }

    public void run() {
        // Criar clientes (produtores)
        for (int i = 0; i < NUM_CLIENTES; i++) {
            clientes.submit(() -> new Cliente());
        }

        // Processar Pedidos (consumidores)

        //Reestocar

        //Relatório

        clientes.shutdown();
    }


    public static void main(String[] args) {
        Base scenario = new Base();

        scenario.run();
    }


}