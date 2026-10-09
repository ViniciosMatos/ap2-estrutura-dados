public class PilhaCancelados<T> {
    Pedido<T> ultimoPedido;
    int tamanho;

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

    public Pedido<T> remover(T pedido){
        if (tamanho == 0) return null;

        Pedido<T> atual = ultimoPedido;
        Pedido<T> retornarPedido = null;
        while (atual != null){
            if (atual.pedido.equals(pedido)){
                // implementar para remover
                //
            }
            atual = atual.proximoPedido;
        }

        return null;
    }

    public void imprimirCancelados(){

        if (tamanho == 0) return;

        Pedido<T> atual = ultimoPedido;
        while (atual != null){
            IO.print(atual.pedido + " - ");
            atual = atual.proximoPedido;
        }
    }
}
