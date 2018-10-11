<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Classes.Conta"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Emitir Extrato</title>
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
        <h2>Emitir Extrato</h2>
        <form action="emitirExtrato" method="post">
            <p>Número da Conta:
                <select style="width: 173px; height: 25px" name="conta" required="required">
                    <option value="">Selecione uma conta</option>
                    <%  int i; 
                        int c = Conta.optionConta().size();
                        for(i=0; i<c; i++){ %>
                        <%= Conta.optionConta().get(i) %>
                    <% } %>
                </select>
                <input type="submit" value="Emitir" name="enviar"></p>
        </form>
    </body>
</html>
