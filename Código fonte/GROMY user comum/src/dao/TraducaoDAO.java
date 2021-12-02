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
