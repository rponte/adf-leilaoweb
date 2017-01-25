package br.com.triadworks.leilaoweb.view.listener;

import br.com.triadworks.leilaoweb.view.UsuarioWeb;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class AutorizacaoListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {

        FacesContext context = event.getFacesContext();

        String paginaAcessada = context.getViewRoot().getViewId();
        if ("/login.xhtml".equals(paginaAcessada)) {
            return;
        }

        UsuarioWeb usuarioWeb = context.getApplication()
                .evaluateExpressionGet(context, "#{usuarioWeb}", UsuarioWeb.class);

        // verifica se o usuário está logado
        if (!usuarioWeb.isLogado()) {
            NavigationHandler handler = context.getApplication().getNavigationHandler();
            handler.handleNavigation(context, null, "/login?faces-redirect=true");

            // Pula para última fase do ciclo de vida
            context.renderResponse();
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        // faz nada
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}
