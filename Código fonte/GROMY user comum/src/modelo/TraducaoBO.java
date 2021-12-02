package modelo;

import dao.TraducaoDAO;
import java.util.ArrayList;
import java.util.List;

public class TraducaoBO {
    
    
    public TraducaoBO(){
        
        
    }
        
    public List<Traducao> consulta(){

       TraducaoDAO dao = new TraducaoDAO();
       
       List<Traducao> traducoes = new ArrayList<Traducao>();
       
       try{
        
           traducoes =  dao.consulta();
        
        }catch(Exception e){
            throw new RuntimeException("Erro ao inserir recuperar no banco de dados");
        }

       return traducoes;
        
    }
    
    
    
}
