package observers;

import interfaces.PedidoObserver;
import pedidos.Pedido;

public class LogService implements PedidoObserver {

    @Override
    public void atualizar(Pedido pedido) {
        System.out.println("LOG: Pedido " + pedido.getId() + " alterado para " + pedido.getStatus()) ;
    }
}
