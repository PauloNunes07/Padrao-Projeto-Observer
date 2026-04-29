package observers;

import interfaces.PedidoObserver;
import pedidos.Pedido;

public class FaturamentoService implements PedidoObserver {

    @Override
    public void atualizar(Pedido pedido) {
        if(pedido.getStatus().equalsIgnoreCase("PAGO")){
            System.out.println("FATURAMENTO: Gerando lançamento financeiro do pedido " + pedido.getId());
            System.out.println("=============================================================");
        }

        else if(pedido.getStatus().equalsIgnoreCase("CANCELADO")) {
            System.out.println("FATURAMENTO: Estornando valores do pedido " + pedido.getId());
            System.out.println("========================================================\n");
        }

    }
}
