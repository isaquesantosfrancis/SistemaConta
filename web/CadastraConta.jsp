<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Conta</title>
    </head>
    <body>
        <div>
            <h1>Sistema de Conta</h1>
            <ul>
                <li style="display:inline; background-color:#EDEDED; padding: 3px;"><a href="CadastraConta.jsp">Cadastrar Conta</a></li>
                <li style="display:inline; background-color:#EDEDED; padding: 3px;"><a href="Operacao.jsp">Operações</a></li>
                <li style="display:inline; background-color:#EDEDED; padding: 3px;"><a href="Extrato.jsp">Ver Extrato</a></li>
            </ul>
        </div>
        <hr>
        <h2>Cadastrar Conta</h2>
        <form action="" method="post">
            <p>Número da Conta:<br>
            <input type="text" name="NumeroConta" maxlength="6"></p>
            <p>CPF:<br>
            <input type="text" name="cpf" maxlength="11"></p>
            <p><input type="submit" value="Enviar" name="enviar"></p>
        </form>
    </body>
</html>
