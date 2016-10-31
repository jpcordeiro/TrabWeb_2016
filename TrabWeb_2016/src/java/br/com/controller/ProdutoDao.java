package br.com.controller;

import br.com.conexao.Mysql;
import br.com.modelo.Produto;
import com.mysql.jdbc.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JOÃO PAULO
 */
public class ProdutoDao{

    Connection conexao;
     public ProdutoDao() {
         conexao = Mysql.getConexaoMySQL();
     }

   

    
    public void inserir(Produto objeto) throws SQLException {
        
        PreparedStatement ps = conexao.prepareStatement(
         "INSERT INTO produto (produto, informacao, valor) VALUES (?, ?, ?)");
        ps.setString(1,objeto.getProduto());
        ps.setString(2,objeto.getInformacao());
        ps.setDouble(3,objeto.getValor());
        ps.execute();
        ps.close();
    }

   
    public void remover(Produto objeto) throws SQLException {
        PreparedStatement ps = conexao.prepareStatement("DELETE FROM produto WHERE idProduto = ?");
        ps.setInt(1, objeto.getIdProduto());
        ps.execute();
        ps.close();
        
    }

    public void atualizar(Produto objeto) throws SQLException {
        PreparedStatement ps = conexao.prepareStatement(" UPDATE produto SET produto = ?, informacao = ?, valor = ?"
                + " WHERE idProduto = ? ");

        ps.setString(1, objeto.getProduto());
        ps.setString(2,objeto.getInformacao());
        ps.setDouble(3,objeto.getValor());
        ps.setInt(4, objeto.getIdProduto());
        ps.execute();
        ps.close();
    }
    
    public List<Produto> ConsultaGeral() throws SQLException{
        String sql = "SELECT * FROM produto";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Produto> produtos = new ArrayList<Produto>();

        while(rs.next()){
             Produto p = new Produto();
             p.setIdProduto(rs.getInt("idProduto"));
             p.setProduto(rs.getString("produto"));
             p.setInformacao(rs.getString("informacao"));
             p.setValor(rs.getDouble("valor"));
             produtos.add(p);
        }
        rs.close();
        return produtos;
    }

    public Produto retornaProdutoId(Produto p) throws SQLException{
        String sql = "SELECT * FROM produto WHERE idProduto = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, p.getIdProduto());
        ResultSet result = ps.executeQuery();
        
        result.next();
        p.setIdProduto(result.getInt("idProduto"));
        p.setProduto(result.getString("prdoduto"));
        p.setInformacao(result.getString("informacao"));
        p.setValor(result.getDouble("VALOR"));
        result.close();
        return p;
    }
    
}
