<%-- 
    Document   : carrinho
    Created on : 31/10/2016, 16:09:28
    Author     : JOÃO PAULO
--%>
<%@page import="br.com.modelo.pedidoitem"%>
<%@page import="br.com.modelo.Pedido"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.modelo.Produto"%>
<%@page import="java.util.List"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>      
<html>
    <head> 
        <title>Carrinho</title>
    </head>
    <body>
        <br />
        <h1>Carrinho de Compras</h1>         
        <table border="1">
            <td colspan="5"><a href="/TrabWeb_2016/ListaCliente.jsp"><b>Continuar Comprando</b></a></td>
            <tr>
                <th>Código</th>
                <th>Produto</th>
                <th>Valor</th>
                <th>Quantidade</th>
            </tr>
            <% Pedido pedido = (Pedido) session.getAttribute("pedido");
                for (pedidoitem pIten : pedido.getItens()) { %>
            <tr>
                <td><%= pIten.getProduto().getIdProduto()%></td>
                <td><%= pIten.getProduto().getProduto()%></td>
                <td><%= pIten.getProduto().getValor()%></td>
                <td><%= pIten.getQuantidade()%></td>
                <td><a href="/TrabWeb_2016/ServletPedido?acao=excluirSessao&idProduto=<%= pIten.getProduto().getIdProduto()%>"><b>Excluir</b></a></td>
            </tr>                                                               
            <% } %>
            <td colspan="5"><a href="/TrabWeb_2016/ServletPedido?acao=comprar"><b>Efetuar Compra</b></a></td>
        </table>
        
    </body>
</html>

