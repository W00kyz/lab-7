import java.util.concurrent.*;

public class Estoque {
    // nome : quantidade (int)
    private final ConcurrentHashMap<NomesProdutos, Integer> estoque = new ConcurrentHashMap<>();

    public int consultarEstoque(NomesProdutos item) {
        return estoque.getOrDefault(item, 0);
    }

    public void atualizarEstoque(NomesProdutos item, int quantidade) {
        estoque.put(item, quantidade);
    }

    public void removerProduto(NomesProdutos item) {
        estoque.remove(item);
    }

    public void recomporEstoque() {
        System.out.println("Recompondo estoque...");
        estoque.forEach((item, quantidade) -> {
            estoque.put(item, quantidade + 10);
        });
    }

    public void adicionarProduto(NomesProdutos item, int quantidade) {
        estoque.put(item, quantidade);
    }
}