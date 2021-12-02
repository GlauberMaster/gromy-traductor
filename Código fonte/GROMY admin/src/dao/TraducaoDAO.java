package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import modelo.Traducao;

/**
 *
 * @author cleberlira
 */
public class TraducaoDAO {

    public void incluir(Traducao traducao) {
        
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO traducao (portugues,espanhol ) VALUES (?,?)");
           
            stmt.setString(1, traducao.getTextoPortugues());

            stmt.setString(2, traducao.getTextoEspanhol());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();

            //  throw new RuntimeException("Erro ao inserir informação no banco de dados");
        } finally {
            Conexao.fecharConexao(con, stmt);

        }

    }

    
    public void alterar(Traducao traducao) {
        
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE traducao SET portugues = ? , espanhol = ? where id = ? ");
           
            stmt.setString(1, traducao.getTextoPortugues());

            stmt.setString(2, traducao.getTextoEspanhol());
            
            stmt.setInt(3, traducao.getId());    
            
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();

            //  throw new RuntimeException("Erro ao inserir informação no banco de dados");
        } finally {
            Conexao.fecharConexao(con, stmt);

        }

    }

    
    
    
    public void excluir(Traducao traducao) {
        
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE from traducao WHERE id = ?");
           
            stmt.setInt(1, traducao.getId());
            
            
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();

            //  throw new RuntimeException("Erro ao inserir informação no banco de dados");
        } finally {
            Conexao.fecharConexao(con, stmt);

        }

    }

    
    
   public List<Traducao> consulta(){
       Connection con = Conexao.getConexao();
       PreparedStatement stmt = null;
       
       ResultSet rs = null;
       
       
       List<Traducao> traducoes = new ArrayList<Traducao>();
       
       
       try{
           
           stmt = con.prepareStatement("select id, portugues, espanhol from traducao order by espanhol");
           rs = stmt.executeQuery();
           
           while (rs.next()){
               Traducao traducao =  new Traducao();
              
               traducao.setId(rs.getInt("id"));
               traducao.setTextoPortugues(rs.getString("portugues"));
               traducao.setTextoEspanhol(rs.getString("espanhol"));
              
               
               traducoes.add(traducao);
               
           }
           
           
       }catch (SQLException s){
           s.printStackTrace();
           
       }
       
        finally {
            Conexao.fecharConexao(con, stmt);

        }
       
      return traducoes;

       
   }
    
    
}
