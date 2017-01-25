package br.com.triadworks.leilaoweb.view;

import br.com.triadworks.leilaoweb.model.Usuario;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean // javax.faces.bean.ManagedBean
@SessionScoped
public class UsuarioWeb implements Serializable {

    private Usuario usuario;

    public void loga(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public boolean isLogado() {
        return this.usuario != null;
    }
    
    public void desloga() {
        this.usuario = null;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
