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
import java.sql.ResultSet;
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
@WebServlet(urlPatterns = {"/emitirExtrato"})
public class emitirExtrato extends HttpServlet {

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
        float saldo = 0;
        
            response.getWriter().println("<!DOCTYPE html>");
            response.getWriter().println("<html>");
            response.getWriter().println("<head>");
            response.getWriter().println("<title>Emitir Extrato</title>");            
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
            
                response.getWriter().println("<table border='1px' width='300px'>");
                response.getWriter().println("<tr><td colspan='2' align='center'>Extrato</td></tr>");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/conta_bancaria", "root", "");
            PreparedStatement stm = conexao.prepareStatement("SELECT * FROM `contacorrente` WHERE `idContaCorrente` = ?");
            stm.setInt(1, conta);
            ResultSet re = stm.executeQuery();
            while(re.next()){
                response.getWriter().println("<tr><td colspan='2'>Conta: "+re.getString("NumeroConta")+"</td></tr>");
                response.getWriter().println("<tr><td colspan='2'>CPF: "+re.getString("CPF_Titular")+"</td></tr>");
            }
            
            PreparedStatement stm2 = conexao.prepareStatement("SELECT * FROM `operacao` WHERE `idContaCorrente` = ?");
            stm2.setInt(1, conta);
            ResultSet re2 = stm2.executeQuery();
            while(re2.next()){
                response.getWriter().println("<tr><td>"+re2.getString("DataOperacao")+"</td>");
                response.getWriter().println("<td>"+re2.getString("ValorOperacao")+"</td></tr>");
                saldo = saldo + Float.parseFloat(re2.getString("ValorOperacao"));
            }
            conexao.close();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } catch (ClassNotFoundException e) {
            System.out.println("Erro: " + e);
        }
        
                response.getWriter().println("<tr><td>Saldo Total</td>");
                response.getWriter().println("<td>"+saldo+"</td></tr>");
            
                response.getWriter().println("</table>");
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
