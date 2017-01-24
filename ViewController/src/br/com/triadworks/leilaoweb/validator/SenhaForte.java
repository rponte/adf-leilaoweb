package br.com.triadworks.leilaoweb.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator
public class SenhaForte implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uIComponent, Object value) throws ValidatorException {

        String valor = value.toString();
        if (!valor.contains("@")) {

            FacesMessage msg = new FacesMessage();
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            msg.setSummary("O campo senha não é forte o bastante");
            msg.setDetail("A senha deve conter o caractere '@'");

            throw new ValidatorException(msg);
        }
    }
}
