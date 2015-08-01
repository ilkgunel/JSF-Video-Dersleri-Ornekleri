import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
@ManagedBean
@RequestScoped
public class AjaxBean {
    String isim="";
    String soyisim="";

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }
    
    public String mesajVer()
    {
        if(isim.equals("")||soyisim.equals(""))
        {
            return "";
        }
        else
        {
            return "İsim Soyisim:"+isim+" "+soyisim;
        }
    }
}
