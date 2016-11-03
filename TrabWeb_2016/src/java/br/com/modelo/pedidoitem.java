package br.com.modelo;

/**
 *
 * @author JOÃO PAULO
 */
public class pedidoitem {
    
    
    private int Quantidade;
    private double valorUnitario;
    
    private Produto produto = new Produto();
    private Pedido pedido = new Pedido();

    public pedidoitem() {
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

   

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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

    
    
}
