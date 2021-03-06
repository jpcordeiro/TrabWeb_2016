package br.com.app;

import br.com.controller.LoginController;
import br.com.controller.PedidoDao;
import br.com.controller.PedidoItenDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.controller.ProdutoDao;
import br.com.modelo.Pedido;
import br.com.modelo.Produto;
import br.com.modelo.Produto2;
import br.com.modelo.pedidoitem;
import java.awt.Dialog;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

public class ServletPedido extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");
        String id = (String) req.getParameter("idProduto");

        if (acao.equals("addProduto")) {
            int idProduto = Integer.parseInt(id);
            boolean existe = false;

            HttpSession sessao = req.getSession();
            Pedido pedido = (Pedido) sessao.getAttribute("pedido");

            if (pedido == null) {
                pedido = new Pedido();
                sessao.setAttribute("pedido", pedido);
                Produto2 prod = new Produto2();
                sessao.setAttribute("produto", prod);
            }

            if (pedido.getItens() != null) {
                for (pedidoitem pItem : pedido.getItens()) {
                    if (pItem.getProduto().getIdProduto() == idProduto) {
                        pItem.setQuantidade(pItem.getQuantidade() + 1);
                        existe = true;
                    }
                }
            }

            if (existe == false) {
                Produto produto = null;
                try {
                    produto = new ProdutoDao().retornaProdutoId(idProduto);
                } catch (SQLException ex) {
                    Logger.getLogger(ServletPedido.class.getName()).log(Level.SEVERE, null, ex);
                }

                pedidoitem pedidoItem = new pedidoitem();
                pedidoItem.setProduto(produto);
                pedidoItem.setQuantidade(1);

                pedido.adicionarProduto(pedidoItem);
            }

            RequestDispatcher rd = req.getRequestDispatcher("/ListaCliente.jsp");
            rd.forward(req, resp);
        } else if (acao.equals("excluirSessao")) {
            HttpSession sessao = req.getSession();

            Pedido pedido = (Pedido) sessao.getAttribute("pedido");

            int idProduto = Integer.parseInt(req.getParameter("idProduto"));

            pedidoitem pedidoItem = new pedidoitem();
            Produto produto = new Produto();
            produto.setIdProduto(idProduto);
            pedidoItem.setProduto(produto);

            pedido.removerProduto(pedidoItem);
            RequestDispatcher rd = req.getRequestDispatcher("/carrinho.jsp");
            rd.forward(req, resp);
        } else if (acao.equals("cancelarCompra")) {
            HttpSession sessao = req.getSession();

            sessao.removeAttribute("pedido");

            RequestDispatcher rd = req.getRequestDispatcher("/carrinho.jsp");
            rd.forward(req, resp);

        } else if (acao.equals("comprar")) {
            HttpSession sessao = req.getSession();
         //   ArrayList<Pedido> produtos = (ArrayList) sessao.getAttribute("pedido");
             

            PedidoDao pedidoDAO = new PedidoDao();
           Pedido pedido = new Pedido();

            Cookie[] cookies = req.getCookies();
            LoginController login = new LoginController();
            int idUsuario = 0;
            try {
                idUsuario = login.getIdUsuario(cookies[1].getValue());
            } catch (SQLException ex) {
                Logger.getLogger(ServletPedido.class.getName()).log(Level.SEVERE, null, ex);
            }

            pedido.setIdUsuario(idUsuario);
            try {
                pedidoDAO.inserir(pedido);
                req.setAttribute("mensagem_erro", "Compra realizada com sucesso!.");
            } catch (SQLException ex) {
                Logger.getLogger(ServletPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            RequestDispatcher rd = req.getRequestDispatcher("/carrinho.jsp");
            rd.forward(req, resp);
            
//            pedidoitem pItem = new pedidoitem();
//            PedidoItenDao PIDAO = new PedidoItenDao();
//
//            for (Pedido produto : produtos) {
//                Produto prod = new Produto();
//                
//
//                pItem.getPedido().setIdPedido(produto.getIdPedido());
//                pItem.getProduto().setIdProduto(prod.getIdProduto());
//                pItem.setQuantidade(1);
//                pItem.setValorUnitario(prod.getValor());
//
//                try {
//                    PIDAO.inserir(pItem);
//                } catch (SQLException ex) {
//                    Logger.getLogger(ServletPedido.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
                
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
