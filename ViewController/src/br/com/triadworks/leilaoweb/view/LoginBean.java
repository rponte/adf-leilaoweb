package br.com.triadworks.leilaoweb.view;

import br.com.triadworks.leilaoweb.dao.UsuarioDao;
import br.com.triadworks.leilaoweb.model.Usuario;

import br.com.triadworks.leilaoweb.util.FacesUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean // javax.faces.bean.ManagedBean
public class LoginBean {

    private String login;
    private String senha;

    @ManagedProperty("#{usuarioWeb}")
    private UsuarioWeb usuarioWeb;

    public String logar() {
        UsuarioDao dao = new UsuarioDao();
        Usuario usuario = dao.buscaPor(login, senha);
        if (usuario != null) {
            usuarioWeb.loga(usuario); // preenche usuário na sessão
            return "/pages/usuarios?faces-redirect=true";
        }
        new FacesUtils().erro("Login ou senha inválido.");
        return null;
    }
    
    public String sair() {
        usuarioWeb.desloga();
        return "/login?faces-redirect=true";
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public String getLogin() {
        return login;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getSenha() {
        return senha;
    }
    public void setUsuarioWeb(UsuarioWeb usuarioWeb) {
        this.usuarioWeb = usuarioWeb;
    }
    public UsuarioWeb getUsuarioWeb() {
        return usuarioWeb;
    }
}
