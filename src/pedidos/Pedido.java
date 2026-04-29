package pedidos;

import clientes.Cliente;
import interfaces.PedidoObserver;
import interfaces.PedidoSubject;

import java.util.ArrayList;
import java.util.List;

public class Pedido implements PedidoSubject {
    private List<PedidoObserver> observadores = new ArrayList<>();
    private final Cliente cliente;
    private final  String id;
    private String status;

    public Pedido(Cliente cliente, String id) {
        this.cliente = cliente;
        this.status = "CRIADO";
        this.id = id;
    }

    @Override
    public void adicionarObserver(PedidoObserver observer) {
        if(observer != null) {
            observadores.add(observer);
        }

    }

    @Override
    public void removerObserver(PedidoObserver observer) {
        boolean achou = false;
        for(PedidoObserver pedido : observadores) {
            if (pedido.equals(observer)) {
                observadores.remove(observer);
                achou = true;
                break;
            }
        }

        if(achou == false) {
            throw new IllegalArgumentException("Não foi possivel remover o observador por ele não esta na lista");
        }
    }

    @Override
    public void notificarObserver() {
        for(PedidoObserver observer : observadores) {
            observer.atualizar(this);
        }
    }

    public void atualizarStatus(String novoStatus) {
        if(novoStatus == null || novoStatus.isEmpty() || novoStatus.isBlank() ) {
            throw new IllegalArgumentException("Status inválido! Não pode ser nulo, vazio ou conter apenas espaços.");        }
        else {
            System.out.println("====================Atualizando o status do pedido para: " + novoStatus + "=============================");
            this.status = novoStatus;
            notificarObserver();

        }
    }

    // Getters
    public String getStatus() {
        return this.status;
    }
    public Cliente getCliente() {
        return this.cliente;
    }

    public String getId() {
        return this.id;
    }
}
