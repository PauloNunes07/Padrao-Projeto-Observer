package interfaces;

public interface PedidoSubject {
    public void adicionarObserver(PedidoObserver observer);
    public void removerObserver(PedidoObserver observer);
    public void notificarObserver();
}
