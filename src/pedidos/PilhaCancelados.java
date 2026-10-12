package pedidos;

public class PilhaCancelados<T> {
    private Pedido<T> ultimoPedido;
    private int tamanho;

    public PilhaCancelados(){
        this.ultimoPedido = null;
        this.tamanho = 0;
    }

    public void adicionar(Pedido<T> pedido){
        if (tamanho == 0){
            pedido.proximoPedido = null;
            ultimoPedido = pedido;
            tamanho++;
            return;
        }
        pedido.proximoPedido = ultimoPedido;
        ultimoPedido = pedido;
        tamanho++;
    }

    public void restaurar(FilaPendentes<T> fila){
        if (tamanho == 0) {
            IO.println("Não existem pedidos para restaurar");
            return;
        };

        Pedido<T> pedidoRestaturado = ultimoPedido;
        ultimoPedido = ultimoPedido.proximoPedido;
        fila.restaurar(pedidoRestaturado);

        IO.println("Ultimo pedido restaurado.");
    }

    public void imprimirCancelados(){

        if (tamanho == 0) {
            IO.println("Não há pedidos cancelados!");
            IO.println();
            return;
        };

        Pedido<T> atual = ultimoPedido;
        IO.println();
        IO.println("-- Pedidos Cancelados--");
        while (atual != null){
            IO.println(atual.id + ": " + atual.pedido);
            atual = atual.proximoPedido;
        }
        IO.println("----------------------");
    }
}
