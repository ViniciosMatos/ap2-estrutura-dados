package pedidos;

public class FilaPendentes<T> {
    private Pedido<T> primeiroPedido;
    private Pedido<T> ultimoPedido;
    private int id;
    private int tamanho = 0;

    public FilaPendentes(){
        this.primeiroPedido = null;
        this.ultimoPedido = null;
        this.id = 1;
        this.tamanho = 0;
    }

    public void adicionar(T pedido){
        Pedido<T> novo = new Pedido<>(id, pedido);
        if (tamanho == 0){
            primeiroPedido = novo;
            ultimoPedido = novo;
        } else {
            ultimoPedido.proximoPedido = novo;
            ultimoPedido = novo;
        }
        id++;
        tamanho++;
        IO.println("pedidos.Pedido adicionado com sucesso!");
    }

    public void atender(){
        if (tamanho == 0) {
            IO.println("Não há pedido para ser atendido no momento.");
            return;
        }
        IO.println("pedidos.Pedido atendido: " + primeiroPedido.pedido);
        primeiroPedido = primeiroPedido.proximoPedido;
        tamanho--;
    }

    public void cancelar(PilhaCancelados<T> pilha){
        if (tamanho == 0) return;

        Pedido<T> pedidoCancelado = primeiroPedido;
        primeiroPedido = primeiroPedido.proximoPedido;
        pilha.adicionar(pedidoCancelado);

        IO.println("Ultimo pedido cancelado.");
        tamanho--;
    }

    public void restaurar(Pedido<T> pedidoRestaurado){
        pedidoRestaurado.proximoPedido = null;
        ultimoPedido.proximoPedido = pedidoRestaurado;
        ultimoPedido = pedidoRestaurado;
        tamanho++;
    }

    public void imprimirPendentes(){
        if (tamanho == 0) {
            IO.println("Não há pedidos pendentes!");
            IO.println();
            return;
        };

        Pedido<T> atual = primeiroPedido;
        IO.println();
        IO.println("-- Pedidos Pendentes --");
        while (atual != null){
            IO.println(atual.id + ": " + atual.pedido);
            atual = atual.proximoPedido;
        }
        IO.println("-----------------");
    }
}
