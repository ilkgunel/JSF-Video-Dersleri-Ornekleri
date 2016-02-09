import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by ilkaygunel on 09/02/16.
 */
@ManagedBean
@SessionScoped
public class ValidatorTagsBean {
    String nameAndSurname;
    double salary;
    int age;
    String email;

    public String getNameAndSurname() {
        return nameAndSurname;
    }

    public void setNameAndSurname(String nameAndSurname) {
        this.nameAndSurname = nameAndSurname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
