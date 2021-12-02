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
    
    public void incluir(Traducao traducao){
        
        TraducaoDAO dao = new TraducaoDAO();
        
        try{
        
            dao.incluir(traducao);
        
        }catch(Exception e){
            throw new RuntimeException("Erro ao inserir informação no banco de dados");
        }
        
    }
    
     public void excluir(Traducao traducao){
        
        TraducaoDAO dao = new TraducaoDAO();
        
        try{
        
            dao.excluir(traducao);
        
        }catch(Exception e){
            throw new RuntimeException("Erro ao excluir a informação no banco de dados");
        }
        
    }
    
    public void alterar(Traducao traducao){
        
        TraducaoDAO dao = new TraducaoDAO();
        
        try{
        
            dao.alterar(traducao);
        
        }catch(Exception e){
            throw new RuntimeException("Erro ao alterar a informação no banco de dados");
        }
        
    }
    
    
}
