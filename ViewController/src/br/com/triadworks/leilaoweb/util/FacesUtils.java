package br.com.triadworks.leilaoweb.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtils {

    private FacesContext facesContext;

    public FacesUtils() {
        this.facesContext = FacesContext.getCurrentInstance();
    }

    public void erro(String mensagem) {
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
        facesContext.addMessage(null, facesMessage);
    }

    public void sucesso(String mensagem) {
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
        facesContext.addMessage(null, facesMessage);
    }
}
