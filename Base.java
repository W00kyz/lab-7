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
    ExecutorService consumidores = Executors.newCachedThreadPool();
    public static final int NUM_CLIENTES = 5;
    public static final int NUM_CONSUMIDORES = 10;

    public Base() {

    }

    public void run() {
        // Criar clientes (produtores)
        for (int i = 0; i < NUM_CLIENTES; i++) {
            clientes.submit(new Cliente(queue));
        }

        // Processar Pedidos (consumidores)

        //Reestocar
        
        //Relatório
        for (;;)

        clientes.shutdown();
    }


    public static void main(String[] args) {
        Base scenario = new Base();

        scenario.run();
    }


}