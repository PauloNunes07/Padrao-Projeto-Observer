import clientes.Cliente;
import observers.*;
import pedidos.Pedido;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Paulo Henrique", "paulinnunes23@gmail.com");
        Pedido pedido1 = new Pedido(cliente, "PED-001");

        pedido1.adicionarObserver(new EmailService());
        pedido1.adicionarObserver(new LogService());
        pedido1.adicionarObserver(new DashboardService());
        pedido1.adicionarObserver(new EstoqueService());
        pedido1.adicionarObserver(new FaturamentoService());

        try {
            pedido1.atualizarStatus("PAGO");
            pedido1.atualizarStatus("EM_SEPARAÇÃO");
            pedido1.atualizarStatus("ENVIADO");
            pedido1.atualizarStatus("CANCELADO");
        }catch(IllegalArgumentException erro) {
            System.out.println(erro.getMessage());
        }

        try {
            pedido1.removerObserver(null);

        }catch(IllegalArgumentException erro) {
            System.out.println(erro.getMessage());
        }

    }
}
