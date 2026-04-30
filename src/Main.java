import clientes.Cliente;
import interfaces.PedidoObserver;
import observers.*;
import pedidos.Pedido;
import service.PedidoService;

public class Main {
    public static void main(String[] args) {
        // Criando o cliente e o pedido
        Cliente cliente = new Cliente("Paulo Henrique", "paulinnunes23@gmail.com");
        Pedido pedido1 = new Pedido(cliente, "PED-001");

        // Criando Observadores
        PedidoObserver email = new EmailService();
        PedidoObserver log = new LogService();
        PedidoObserver dashboard = new DashboardService();
        PedidoObserver estoque = new EstoqueService();
        PedidoObserver faturamento = new FaturamentoService();

        // Adicionando observadores Observadores
        PedidoService.registrarObserver(pedido1, email);
        PedidoService.registrarObserver(pedido1, log);
        PedidoService.registrarObserver(pedido1, dashboard);
        PedidoService.registrarObserver(pedido1, estoque);
        PedidoService.registrarObserver(pedido1, faturamento);

        // mudando o status
        PedidoService.atualizarStatusSeguro(pedido1, "PAGO");
        PedidoService.atualizarStatusSeguro(pedido1, "EM_SEPARACAO");
        PedidoService.atualizarStatusSeguro(pedido1, "ENVIADO");
        PedidoService.atualizarStatusSeguro(pedido1, "CANCELADO");
        PedidoService.atualizarStatusSeguro(pedido1, null);

        // Testando a remoção de observadores
        PedidoService.removerObserver(pedido1, email);

    }
}
