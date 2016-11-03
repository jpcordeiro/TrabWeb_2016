
package br.com.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author JOÃO PAULO
 */
public class Pedido {
    private int idPedido;
    private int idUsuario;
    private List<pedidoitem> itens;

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<pedidoitem> getItens() {
        return itens;
    }

    public void setItens(List<pedidoitem> itens) {
        this.itens = itens;
    }
    
 public void adicionarProduto(pedidoitem pItem){
        if(this.itens==null){
            this.itens = new ArrayList<pedidoitem>();
        }
        this.itens.add(pItem);
    }
    
    public void removerProduto(pedidoitem pedidoItemRemover){
        for(Iterator it = itens.iterator(); it.hasNext();){
            pedidoitem pItem = (pedidoitem) it.next();
            if (pItem.getProduto().getIdProduto()== pedidoItemRemover.getProduto().getIdProduto()) {
                it.remove();
            }
        }
    }
    
}
