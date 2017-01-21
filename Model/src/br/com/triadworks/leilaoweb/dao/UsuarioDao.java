package br.com.triadworks.leilaoweb.dao;

import br.com.triadworks.leilaoweb.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    private ConnectionFactory factory;
    
    public UsuarioDao() {
        this.factory = new ConnectionFactory();
    }
    
    /**
    * Adiciona novo usuario no banco de dados 
    */
    public void adiciona(Usuario usuario) {
        
        String sql = "INSERT INTO TB_USUARIO(ID, NOME, LOGIN, SENHA)"
                + " VALUES (SEQ_USUARIO.NEXTVAL, ?, ?, ?)";
        
        try (Connection conn = factory.getConnection()) {
                
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            
            stmt.execute();
            conn.commit();
                
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
    
    /**
    * Atualiza usuario no banco de dados 
    */
    public void atualiza(Usuario usuario) {
        String sql = "UPDATE TB_USUARIO SET NOME=?, LOGIN=?, SENHA=?"
                + "   WHERE ID = ? ";
        
        try (Connection conn = factory.getConnection()) {
                
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, usuario.getNome());
                stmt.setString(2, usuario.getLogin());
                stmt.setString(3, usuario.getSenha());
                stmt.setInt(4, usuario.getId());
                
                stmt.execute();
                conn.commit();
                
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
    
    /**
    * Remove usuario do banco de dados 
    */
    public void remove(Usuario usuario) {
        
        String sql = "DELETE FROM TB_USUARIO WHERE ID = ? ";
        
        try (Connection conn = factory.getConnection()) {
                
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, usuario.getId());
            
            stmt.execute();
            conn.commit();
                
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
    
    /**
    * Lista todos os usuarios do banco de dados
    */
    public List<Usuario> listaTudo() {
        
        List<Usuario> usuarios = new ArrayList<>();
        
        try (Connection conn = factory.getConnection()) {
                
            PreparedStatement stmt = conn.prepareStatement("SELECT * from TB_USUARIO");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("ID"));
                u.setNome(rs.getString("NOME"));
                u.setLogin(rs.getString("LOGIN"));
                u.setSenha(rs.getString("SENHA"));
                usuarios.add(u);
            }
            
            return usuarios;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
