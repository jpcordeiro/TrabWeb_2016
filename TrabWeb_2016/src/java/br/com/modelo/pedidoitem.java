package br.com.modelo;

/**
 *
 * @author JOÃO PAULO
 */
public class pedidoitem {
    
    private int idPedidoItem;
    private int idPedido;
    private int Quantidade;
    private double valorUnitario;

    public pedidoitem() {
    }

    public int getIdPedidoItem() {
        return idPedidoItem;
    }

    public void setIdPedidoItem(int idPedidoItem) {
        this.idPedidoItem = idPedidoItem;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.idPedidoItem;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final pedidoitem other = (pedidoitem) obj;
        if (this.idPedidoItem != other.idPedidoItem) {
            return false;
        }
        return true;
    }
    
    
}
