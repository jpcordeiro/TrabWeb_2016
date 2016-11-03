/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.conexao.Mysql;
import br.com.modelo.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author JOÃO PAULO
 */
public class PedidoDao {
    Connection conexao;
     public PedidoDao() {
         conexao = Mysql.getConexaoMySQL();
     }

   

    
    public void inserir(Pedido objeto) throws SQLException {
        
        PreparedStatement ps = conexao.prepareStatement(
         "INSERT INTO pedido (idUsuario) VALUES (?)");
        ps.setInt(1,objeto.getIdUsuario());;
        ps.execute();
        ps.close();
    }
}
     
            