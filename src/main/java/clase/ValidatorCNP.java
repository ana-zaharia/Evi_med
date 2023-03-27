package clase;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validatorCNP")
public class ValidatorCNP implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String cnp = (String) o, errorMessage = null;
        if (cnp.length() != 13) {
            errorMessage = "CNP-ul trebuie să conțină 13 cifre";
        } else if (cnp.contains(" ")) {
            errorMessage = "CNP-ul nu trebuie să conțină spații";
        } else {
            for (int i = 0; i < cnp.length(); i++) {
                if (cnp.charAt(i) < '0' || cnp.charAt(i) > '9') {
                    errorMessage = "CNP-ul trebuie să conțină doar cifre";
                    break;
                }
            }
        }
        if (errorMessage != null) {
            FacesMessage message = new FacesMessage(errorMessage);
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
}
