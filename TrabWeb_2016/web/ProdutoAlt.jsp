<%-- 
    Document   : produto
    Created on : 24/10/2016, 21:57:35
    Author     : JOÃO PAULO
--%>
<%@page import="br.com.modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String mensagemErro = (String) request.getAttribute("mensagem_erro");
    Produto prod = (Produto) request.getAttribute("produto");
%>
<html>
    <head>
         <title>Produto</title>
    </head>
    <body>
        <h1>Alterar Produto</h1>
        <% if (mensagemErro != null) {%>
        <p class="erro"><%= mensagemErro%></p>
        <% }%>
        <form action="ServletProduto" method="POST">
            <input type="hidden" name="idProduto" value="<%=prod.getIdProduto()%>" />
            <label>Descrição</label><br />
            <input type="text" name="produto" value="<%=prod.getProduto()%>" />
            <br /><br />
            <label>Informação</label><br />
             <input type="text" name="informacao" value="<%=prod.getInformacao()%>" />
            <br /><br />
            <label>Valor</label><br />
            <input type="text" name="valor" value="<%=prod.getValor()%>" />
            <br /><br />
            <input type="submit" value="Publicar" />
        </form>
    </body>
</html>
