package br.com.triadworks.leilaoweb.view;

import br.com.triadworks.leilaoweb.dao.UsuarioDao;
import br.com.triadworks.leilaoweb.model.Usuario;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class UsuarioBean {
    
    private Usuario usuario = new Usuario();

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
