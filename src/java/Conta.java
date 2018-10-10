
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Conta {
    private String numero;
    private String cpf;
    
    public static ArrayList optionConta(){
        ArrayList option = new ArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/conta_bancaria", "root", "");
            PreparedStatement stm = conexao.prepareStatement("SELECT * FROM `contacorrente`");
            ResultSet re = stm.executeQuery();
            while(re.next()){
                option = "<option value='"+re.getString("conta")+"'>"+re.getString("conta")+"</option>";
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } catch (ClassNotFoundException e) {
            System.out.println("Erro: " + e);
        }
        return option;
    }
}
