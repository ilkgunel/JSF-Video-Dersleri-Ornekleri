import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ilkaygunel on 13/02/16.
 */
@FacesValidator("customValidator")
public class CustomValidatorClass implements Validator{
    Pattern pattern;
    Matcher matcher;

    public  CustomValidatorClass()
    {
        pattern = Pattern.compile("^[A-Za-z0-9-+]+(\\.[A-Za-z0-9+-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$");
    }

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        matcher = pattern.matcher(o.toString());
        if(!matcher.matches())
            //pattern.matcher(o.toString()).matches();
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Geçersiz E-Posta Adresi","Geçerisiz E-Posta Adresi");
            throw new ValidatorException(message);
        }
    }
}
