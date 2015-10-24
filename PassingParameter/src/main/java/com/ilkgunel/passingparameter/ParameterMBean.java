/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ilkgunel.passingparameter;

import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped
public class ParameterMBean {
    String messageObject;

    public String getMessageObject() {
        return messageObject;
    }

    public void setMessageObject(String messageObject) {
        this.messageObject = messageObject;
    }
    
    public void writeToConsole()
    {
        System.out.println("Mesaj:"+messageObject);
    }
    
    public void catchTheFParam()
    {
        Map<String,String> params=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String parameter=params.get("parametre1");
        System.out.println("Parametre:"+parameter);
    }
    
    public void catchTheFAttribute(ActionEvent event)
    {
        System.out.println(event.getComponent().getAttributes().get("parametre2"));
    }
    
    public void writeTheParameter(String message)
    {
        System.out.println("Metot İle Parametre Geçirmeden Gelen Mesaj:"+message);
    }
}
