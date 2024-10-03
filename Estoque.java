import java.util.concurrent.*;

public class Estoque {
    private final ConcurrentHashMap<String, Integer> estoque = new ConcurrentHashMap<>();
    
    public int consultarEstoque(String item) {
        return estoque.getOrDefault(item, 0);
    }

    public void atualizarEstoque(String item, int novaQuantidade) {
        estoque.put(item, novaQuantidade);
    }

}
