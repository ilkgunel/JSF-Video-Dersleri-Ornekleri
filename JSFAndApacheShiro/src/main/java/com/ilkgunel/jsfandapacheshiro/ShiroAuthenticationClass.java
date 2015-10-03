package com.ilkgunel.jsfandapacheshiro;

import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

@ManagedBean
@RequestScoped
public class ShiroAuthenticationClass {

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String authenticateTheUser(){

        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);

         try{
                currentUser.login(token);
        } catch (UnknownAccountException uae ) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Giriş başarısız", "kullanıcı adınız yanlış"));
            return null;
        } catch (IncorrectCredentialsException ice ) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Giriş başarısız", "parolanız yanlış"));
            return null;
        } catch (LockedAccountException lae ) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Giriş başarısız", "Bu kullanıcı adı kilitli"));
            return null;
        } catch(AuthenticationException aex){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Giriş başarısız", aex.toString()));
            return null;
        }
        if(userName.equals("adminUser"))
            return "admin/adminPage.xhtml?faces-redirect=true";
        else
            return "guest/guestPage.xhtml?faces-redirect=true";
    }

    public String logout()
    {

        Subject currentUser = SecurityUtils.getSubject();

        try 
        {
            currentUser.logout();
        } 
        catch (Exception ex) {
            System.err.println(ex);
        }
        
        return "/loginPage.xhtml?faces-redirect=true";
    }
    
    public void isAnyUserLoggedIn()
    {
        if(SecurityUtils.getSubject().getPrincipal()!=null)
        {
            NavigationHandler nh=FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
            nh.handleNavigation(FacesContext.getCurrentInstance(), null, "/guest/guestPage.xhtml?faces-redirect=true");
        }
    }
}