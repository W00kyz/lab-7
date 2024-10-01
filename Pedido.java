import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class Pedido {

    static final AtomicInteger incrementador = new AtomicInteger(0);
    final int id;
    LinkedList<Produto> produtos = new LinkedList<>();

    public Pedido() {
        this.id = incrementador.incrementAndGet();
    }

    public void adicionar(Produto produto) {
        this.produtos.add(produto);
    }

    public double total() {
        double total = 0;
        for (Produto produto : this.produtos) {
            total += produto.valor;
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("==========================\n");
        sb.append("Pedido Nº "+id+":\n");
        for (Produto produto : produtos) {
            sb.append(produto.nome)
                    .append(" - R$ ")
                    .append(String.format("%.2f", produto.valor))
                    .append("\n");
        }

        sb.append("Total: R$").append(String.format("%.2f", total())).append("\n")
        .append("==========================\n");
        return sb.toString();
    }

}

enum NomesProdutos {
    ARROZ, FEIJAO, MACARRAO, LEITE, CAFÉ, AÇÚCAR, SAL, ÓLEO, FARINHA, MANTEIGA;
}

class Produto {

    String nome;
    double valor;

    public Produto(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return nome + " - R$ " + valor;
    }

}