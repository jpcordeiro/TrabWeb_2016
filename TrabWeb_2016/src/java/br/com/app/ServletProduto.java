package br.com.app;

import br.com.controller.ProdutoDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.modelo.Produto;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServletProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acao = request.getParameter("acao");
        String idProduto = request.getParameter("idProduto");

        switch (acao) {
            case "listar":
                listaProdutos(request, response);
                break;

            case "editar":
                editarProduto(request, response, idProduto);
                break;

            case "excluir":
                excluirProduto(request, response, idProduto);
                break;
        }
    }
        Produto prod = new Produto();
        ProdutoDao prodDao = new ProdutoDao();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*Create*/
        
       String idProduto = request.getParameter("idProduto");
       String produto = request.getParameter("produto");
       String informacao = request.getParameter("informacao");
       String valor = request.getParameter("valor");

        if (!idProduto.equals("")) {
            prod.setIdProduto(Integer.parseInt(idProduto));
        }
        prod.setProduto(produto);
        prod.setInformacao(informacao);
        prod.setValor(Double.parseDouble(valor));

        if (idProduto.equals("")) {
            cadastrarProduto(prod, request, response);
        } else {
            try {
                editarProduto(prod, request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ServletProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void listaProdutos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Connection conexao = (Connection) req.getAttribute("conexao");
            ProdutoDao produtoDAO = new ProdutoDao();

            List<Produto> produtosList = produtoDAO.ConsultaGeral();

            req.setAttribute("produtos", produtosList);
            /*Load or List*/
        } catch (SQLException ex) {
            Logger.getLogger(ServletProduto.class.getName()).log(Level.SEVERE, null, ex);
        }

        req.getRequestDispatcher("/main.jsp").forward(req, resp);
    }

    private void cadastrarProduto(Produto produto, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!produto.getProduto().equals("")){
            try {
                prodDao.inserir(produto);;
                listaProdutos(req, resp);
            } catch (SQLException ex) {
                Logger.getLogger(ServletProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
    private void editarProduto(Produto produto, HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        prodDao.atualizar(produto);
        listaProdutos(req, resp);
    }
    
    private void editarProduto(HttpServletRequest req, HttpServletResponse resp, String id) throws ServletException, IOException {
        prod.setIdProduto(Integer.parseInt(id));
        {
//            try {
                req.setAttribute("produto", prod);
                req.getRequestDispatcher("/ProdutoAlt.jsp").forward(req, resp);
//            } catch (SQLException ex) {
//                Logger.getLogger(ServletProduto.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }

    private void excluirProduto(HttpServletRequest req, HttpServletResponse resp, String id) throws ServletException, IOException {
        prod.setIdProduto(Integer.parseInt(id));
        try {
            prodDao.remover(prod);
            listaProdutos(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(ServletProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}