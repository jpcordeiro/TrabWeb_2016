
package br.com.controller;

import br.com.conexao.Mysql;
import br.com.modelo.Pedido;
import br.com.modelo.pedidoitem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author JOÃO PAULO
 */
public class PedidoItenDao {
    Connection conexao;
    public class PedidoDao {
    
     public PedidoDao() {
         conexao = Mysql.getConexaoMySQL();
     }
    }
     
      public void inserir(pedidoitem objeto) throws SQLException {
        
        PreparedStatement ps = conexao.prepareStatement(
         "INSERT INTO pedidoitem (idPedido, idUsuario, Quantidade, valorUnitario) VALUES (?,?,?,?)");
        ps.setInt(1,objeto.getPedido().getIdPedido());
        ps.setInt(2,objeto.getProduto().getIdProduto());
        ps.setInt(3, objeto.getQuantidade());
        ps.setDouble(4, objeto.getValorUnitario());
        ps.execute();
        ps.close();
    }
    
}
