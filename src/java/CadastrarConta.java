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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CLIENTE
 */
@WebServlet(urlPatterns = {"/CadastrarConta"})
public class CadastrarConta extends HttpServlet {

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
        
        String numero = request.getParameter("NumeroConta");
        String cpf = request.getParameter("cpf");
            
            response.getWriter().println("<!DOCTYPE html>");
            response.getWriter().println("<html>");
            response.getWriter().println("<head>");
            response.getWriter().println("<title>Cadastrar Conta</title>");            
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
            PreparedStatement stm = conexao.prepareStatement("INSERT INTO `contacorrente`(`NumeroConta`, `CPF_Titular`) VALUES (?, ?)");
            stm.setString(1, numero);
            stm.setString(2, cpf);
            stm.execute();
            conexao.close();
            response.getWriter().println("<h2>Conta cadastrada!</h2>");
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
