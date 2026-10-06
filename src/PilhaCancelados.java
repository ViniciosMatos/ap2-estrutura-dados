public class PilhaCancelados<T> {
    Pedido<T> ultimoPedido;
    int tamanho;

    public PilhaCancelados(){
        this.ultimoPedido = null;
        this.tamanho = 0;
    }

    public void adicionar(T pedido){
        Pedido<T> novo = new Pedido<>(pedido);
        if (tamanho > 0) {
            novo.proximoPedido = ultimoPedido;
        }
        ultimoPedido = novo;
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
    }
}
