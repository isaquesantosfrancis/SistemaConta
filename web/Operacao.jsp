<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Classes.Conta"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Operação</title>
    </head>
    <body>
        <div>
            <h1>Sistema de Conta</h1>
            <ul>
                <li style="display:inline; background-color:#EDEDED; padding: 3px;"><a href="CadastraConta.jsp">Cadastrar Conta</a></li>
                <li style="display:inline; background-color:#EDEDED; padding: 3px;"><a href="Operacao.jsp">Cadastrar Operação</a></li>
                <li style="display:inline; background-color:#EDEDED; padding: 3px;"><a href="Extrato.jsp">Emitir Extrato</a></li>
            </ul>
        </div>
        <hr>
        <h2>Cadastrar Operação</h2>
        <form action="CadastrarOperacao" method="post">
            <p>Número da Conta:<br>
                <select style="width: 173px; height: 25px" name="conta" required="required">
                    <option value="">Selecione uma conta</option>
                    <%  int i; 
                        int c = Conta.optionConta().size();
                        for(i=0; i<c; i++){ %>
                        <%= Conta.optionConta().get(i) %>
                    <% } %>
                </select></p>
            <p>CPF Responsável:<br>
            <input type="text" name="cpf" maxlength="11" required="required"></p>
            <p>Valor da Operação:<br>
            <input type="text" name="valor" required="required"></p>
            <p><input type="radio" name="tipo" value="+" checked="checked">Crédito
                <input type="radio" name="tipo" value="-">Débito</p>
            <p><input type="submit" value="Enviar" name="enviar"></p>
        </form>
    </body>
</html>
