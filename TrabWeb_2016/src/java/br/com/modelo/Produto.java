package br.com.modelo;

/**
 *
 * @author JOÃO PAULO
 */
public class Produto {
    private int idProduto;
    private String produto;
    private String informacao;
    private Double valor;

    public Produto() {
       }
    

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getInformacao() {
        return informacao;
    }

    public void setInformacao(String informação) {
        this.informacao = informação;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return  idProduto +  produto + informacao + valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Produto other = (Produto) obj;
        if (this.idProduto != other.idProduto) {
            return false;
        }
        return true;
    }
    
    
}
