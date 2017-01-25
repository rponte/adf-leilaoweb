package br.com.triadworks.leilaoweb.view;

import br.com.triadworks.leilaoweb.dao.UsuarioDao;
import br.com.triadworks.leilaoweb.model.Usuario;

import javax.faces.bean.ManagedBean;

@ManagedBean // javax.faces.bean.ManagedBean
public class LoginBean {

    private String login;
    private String senha;

    public void logar() {
        UsuarioDao autenticador = new UsuarioDao();
        Usuario usuario = autenticador.buscaPor(login, senha);
        boolean loginEhValido = (usuario != null);
        System.out.println("Login e senha são válidos? " + loginEhValido);
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
}
