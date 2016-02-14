import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by ilkaygunel on 13/02/16.
 */
@ManagedBean
@SessionScoped
public class CustomValidatorBean {
    String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
