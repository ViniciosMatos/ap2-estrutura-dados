public class Pedido<T> {
    T pedido;
    Pedido<T> proximoPedido;

    public Pedido(T pedido){
        this.pedido = pedido;
        this.proximoPedido = null;
    }
}
