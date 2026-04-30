package service;
import interfaces.PedidoObserver;
import pedidos.Pedido;

public class PedidoService {
    public static void registrarObserver(Pedido pedido, PedidoObserver observer) {
        try {
            pedido.adicionarObserver(observer);
        } catch(IllegalArgumentException erro) {
            System.out.println(erro.getMessage());
        }

    }

    public static void removerObserver(Pedido pedido, PedidoObserver observer) {
        try {
            pedido.removerObserver(observer);
        } catch (IllegalArgumentException erro) {
            System.out.println(erro.getMessage());
        }

    }

}
