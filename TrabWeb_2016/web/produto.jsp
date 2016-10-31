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
%>
<html>
    <head>
         <title>Produto</title>
    </head>
    <body>
        <h1>Produto</h1>
        <% if (mensagemErro != null) {%>
        <p class="erro"><%= mensagemErro%></p>
        <% }%>
        <form action="ServletProduto" method="POST">
            <input type="hidden" name="idProduto" value="" />
            <label>Descrição</label><br />
            <input type="text" name="produto" value="" />
            <br /><br />
            <label>Informação</label><br />
            <textarea name="informacao" rows="10" cols="50" value=""></textarea>
            <br /><br />
            <label>Valor</label><br />
            <input type="text" name="valor" value="" />
            <br /><br />
            <input type="submit" value="Publicar" />
        </form>
    </body>
</html>
