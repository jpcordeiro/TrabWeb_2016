package br.com.app;

import br.com.modelo.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JOÃO PAULO
 */
public class ServletCarrinho extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");
        Produto prod = new Produto();

        if (acao.equals("addProduto")) {
            String idProduto = req.getParameter("idProduto");
            String produto = req.getParameter("produto");
            String valor = req.getParameter("valor");
            
            
            HttpSession session = req.getSession();
            session.setAttribute("idProduto", idProduto);
            session.setAttribute("produto", produto);
             session.setAttribute("valor", valor);
            

            RequestDispatcher rd = req.getRequestDispatcher("/ListaCliente.jsp");
            rd.forward(req, resp);
        }
        
         }
        
        
    
    
}
