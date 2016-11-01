<%-- 
    Document   : carrinho
    Created on : 31/10/2016, 16:09:28
    Author     : JOÃO PAULO
--%>
<%@page import="java.util.List"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>      
<html>
    <head> 
        <title>Produtos</title>
    </head>
    <body>
        <br />
        <h1>Carrinho de Compras</h1>         
        <table border="1">
            <tr>
                <th>Código</th>
                <th>Produto</th>
                <th>Valor</th>
                <th>Quantidade</th>
            </tr>
        
            <tr>
                <td><%=session.getAttribute("idProduto")%></td>
                <td><%=session.getAttribute("produto")%></td>
                <td><%=session.getAttribute("valor")%></td>
                <td>1</td>
                <td><a href="/TrabWeb_2016/ListaCliente.jsp"><b>Continuar Comprando</b></a></td>
            </tr>
            
        </table>
        
    </body>
</html>

