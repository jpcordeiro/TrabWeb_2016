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
import java.sql.ResultSet;
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
    
    public String ultimaOcorrencia(String tabela, String atributo) throws SQLException {
        ResultSet rs =  null;
        PreparedStatement ps = conexao.prepareStatement("SELECT COALESCE(MAX(" + atributo + "), 0) AS ULTIMO FROM ");
         ps.setString(1, tabela);
         ps.execute();
         ps.close();
        
        try {
            rs.first();
            return rs.getString("ULTIMO");
        } catch (SQLException ex) {
            System.out.println("Erro ao encontrar número de sequência! " + ex);
            return "";
        }
    }
}
     
            