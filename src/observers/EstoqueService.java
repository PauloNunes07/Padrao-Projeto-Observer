package observers;

import interfaces.PedidoObserver;
import pedidos.Pedido;

public class EstoqueService implements PedidoObserver {

    @Override
    public void atualizar(Pedido pedido) {
        if(pedido.getStatus().equalsIgnoreCase("PAGO")){
            System.out.println("ESTOQUE: Reservando itens do pedido " + pedido.getId());
        }

        else if(pedido.getStatus().equalsIgnoreCase("CANCELADO")) {
            System.out.println("ESTOQUE: Devolvendo itens ao estoque do pedido " + pedido.getId());
        }

    }
}
