/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CLIENTE
 */
@WebServlet(urlPatterns = {"/CadastrarOperacao"})
public class CadastrarOperacao extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int conta = Integer.parseInt(request.getParameter("conta"));
        String cpf = request.getParameter("cpf");
        float valor = Float.parseFloat(request.getParameter("tipo") + request.getParameter("conta"));
            
            response.getWriter().println("<!DOCTYPE html>");
            response.getWriter().println("<html>");
            response.getWriter().println("<head>");
            response.getWriter().println("<title>Cadastrar Operação</title>");            
            response.getWriter().println("</head>");
            response.getWriter().println("<body>");
            response.getWriter().println("<div>\n" +
"            <h1>Sistema de Conta</h1>\n" +
"            <ul>\n" +
"                <li style=\"display:inline; background-color:#EDEDED; padding: 3px;\"><a href=\"CadastraConta.jsp\">Cadastrar Conta</a></li>\n" +
"                <li style=\"display:inline; background-color:#EDEDED; padding: 3px;\"><a href=\"Operacao.jsp\">Cadastrar Operação</a></li>\n" +
"                <li style=\"display:inline; background-color:#EDEDED; padding: 3px;\"><a href=\"Extrato.jsp\">Emitir Extrato</a></li>\n" +
"            </ul>\n" +
"        </div>\n" +
"        <hr>");
            
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/conta_bancaria", "root", "");
            PreparedStatement stm = conexao.prepareStatement("INSERT INTO `operacao`(`ValorOperacao`, `CPFResponsavelOperacao`, `idContaCorrente`) VALUES (?, ?, ?)");
            stm.setFloat(1, valor);
            stm.setString(2, cpf);
            stm.setInt(3, conta);
            stm.execute();
            response.getWriter().println("<h2>Operação cadastrada!</h2>");
        } catch (SQLException ex) {
            response.getWriter().println("Erro: " + ex);
        } catch (ClassNotFoundException e) {
            response.getWriter().println("Erro: " + e);
        }
            response.getWriter().println("</body>");
            response.getWriter().println("</html>");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
