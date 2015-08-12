/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/**
 *
 * @author ilkaygunel
 */
@ManagedBean
@RequestScoped
public class KayitGonder {
    String isim,soyisim;

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
    
    public String veriTabaninaGonder()
    {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        int i=0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/deneme","root","");
            preparedStatement=connection.prepareStatement("insert into kisiler(isim,soyisim) values(?,?)");
            preparedStatement.setString(1, isim);
            preparedStatement.setString(2, soyisim);
            i=preparedStatement.executeUpdate();
            
        } catch (Exception e) {
            System.err.println(e);
        }
        finally{
            try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                System.err.println("Hata"+e);
            }
            
        }
        
        if(i>0)
            {
                System.out.println("Kayıt Başarılı");
                return "basarili?faces-redirect=true";
            }
            else  {
                System.out.println("Kayıt işlemi başarısız");
                return "basarisiz?faces-redirect=true";
            }
    }
    
}
