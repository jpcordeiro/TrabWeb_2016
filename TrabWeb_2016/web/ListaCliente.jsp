<%@page import="br.com.controller.ProdutoDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.com.modelo.Produto"%>
<%@page import="br.com.app.ServletProduto"%>
<%@ page import="br.com.controller.LoginController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<%
    
    Connection conexao = (Connection) request.getAttribute("conexao");
    ProdutoDao produtoDAO = new ProdutoDao();
    List<Produto> produtos = produtoDAO.ConsultaGeral();
     
%>
<html>
    <head> 
        <title>Produtos</title>
    </head>
    <body>
        <br />
         <% if (produtos != null) { %>
        <table border="1">
              <td><a href="/TrabWeb_2016/carrinho.jsp"><b>Ver Carrinho</b></a></td>
          
            <tr>
                <th>Código</th>
                <th>Produto</th>
                <th>Informação</th>
                <th>Valor</th>
            </tr>
            <% for (Produto prod: produtos){ %>
            <tr>
                <td><%= prod.getIdProduto()%></td>
                <td><%= prod.getProduto()%></td>
                <td><%= prod.getInformacao()%></td>
                <td><%= prod.getValor()%></td>
                <td><a href="/TrabWeb_2016/ServletPedido?acao=addProduto&idProduto=<%= prod.getIdProduto()%>"><b>Adicionar Carrinho</b></a></td>
            </tr>
            <%  } %>
        </table>
        <%  } %>
          
    </body>
</html>
