import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Base {
    public static final int NUM_CLIENTES = 5;
    public static final int NUM_CONSUMIDORES = 10;
    public static final int TAMANHO_FILA = 10;

    BlockingQueue<Pedido> queue = new ArrayBlockingQueue<>(TAMANHO_FILA);
    ScheduledExecutorService clientes = Executors.newScheduledThreadPool(NUM_CLIENTES);
    ScheduledExecutorService consumidores = Executors.newScheduledThreadPool(NUM_CONSUMIDORES);

    public void run() {
        // TODO FUTURO: Trocar ScheduledThreadPool de clientes para CachedThreadPool
        // após fazer consumidores.
        for (int i = 0; i < NUM_CLIENTES; i++) {
            clientes.scheduleAtFixedRate(new Cliente(queue), 0, new Random().nextInt(5) + 1, TimeUnit.SECONDS);
        }

        // Processar Pedidos (consumidores) | Faça semelhante aos clientes
        for (int i = 0; i < NUM_CONSUMIDORES; i++) {
            consumidores.scheduleAtFixedRate(/* new Cliente(queue) */ null, 0, new Random().nextInt(5) + 1,
                    TimeUnit.SECONDS);
        }

        // Reestocar | Single thread para reestocar.

        // TODO: Fazer relatório na thread principal.

        // clientes.shutdown();
    }

    public static void main(String[] args) {
        Base scenario = new Base();

        scenario.run();
    }

}