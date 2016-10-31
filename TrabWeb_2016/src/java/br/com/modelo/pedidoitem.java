package br.com.modelo;

/**
 *
 * @author JOÃO PAULO
 */
public class pedidoitem {
    
    private int idProduto;
    private int idPedido;
    private int Quantidade;
    private double valorUnitario;

    public pedidoitem() {
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
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
        int hash = 3;
        hash = 23 * hash + this.idProduto;
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
        if (this.idProduto != other.idProduto) {
            return false;
        }
        return true;
    }

    
    
}
