package observers;

import interfaces.PedidoObserver;
import pedidos.Pedido;

public class DashboardService implements PedidoObserver {

    @Override
    public void atualizar(Pedido pedido) {
        System.out.println("DASHBOARD: Atualizando painel do pedido " + pedido.getId() +
                " com status " + pedido.getStatus());
    }
}
