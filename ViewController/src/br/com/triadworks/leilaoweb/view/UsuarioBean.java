package br.com.triadworks.leilaoweb.view;

import br.com.triadworks.leilaoweb.dao.UsuarioDao;
import br.com.triadworks.leilaoweb.model.Usuario;

import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class UsuarioBean {
    
    private Usuario usuario = new Usuario();

    public List<Usuario> getUsuarios() {
        UsuarioDao dao = new UsuarioDao();
        return dao.listaTudo();
    }
    
    public void remove(Usuario usuario) {
        UsuarioDao dao = new UsuarioDao();
        dao.remove(usuario);
    }

    public void salva() {
        
        UsuarioDao dao = new UsuarioDao();
        dao.adiciona(usuario);
        
        this.usuario = new Usuario();
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Usuario getUsuario() {
        return usuario;
    }
}
