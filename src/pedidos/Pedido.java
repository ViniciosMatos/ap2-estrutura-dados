package pedidos;

public class Pedido<T> {
    int id;
    T pedido;
    Pedido<T> proximoPedido;

    public Pedido(int id, T pedido){
        this.id = id;
        this.pedido = pedido;
        this.proximoPedido = null;
    }
}
