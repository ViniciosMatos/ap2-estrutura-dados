public class FilaPendentes<T> {
    Pedido<T> primeiroPedido;
    Pedido<T> ultimoPedido;
    int tamanho = 0;

    public FilaPendentes(){
        this.primeiroPedido = null;
        this.ultimoPedido = null;
        this.tamanho = 0;
    }

    public void adicionar(T pedido){
        Pedido<T> novo = new Pedido<>(pedido);
        if (tamanho == 0){
            primeiroPedido = novo;
            ultimoPedido = novo;
        } else {
            ultimoPedido.proximoPedido = novo;
            ultimoPedido = novo;
        }

        tamanho++;
    }

    public void imprimirPendentes(){
        if (tamanho == 0) return;

        Pedido<T> atual = primeiroPedido;
        while (atual != null){
            IO.print(atual.pedido + " - ");
            atual = atual.proximoPedido;
        }
    }
}
