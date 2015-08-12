/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
/**
 *
 * @author ilkaygunel
 */
@ManagedBean
@RequestScoped
public class KayitCek {
    List<Kisiler> sorguSonucu;

    public List<Kisiler> getSorguSonucu() {
        return sorguSonucu;
    }

    public void setSorguSonucu(List<Kisiler> sorguSonucu) {
        this.sorguSonucu = sorguSonucu;
    }
    
    /*public List<Kisiler> getTablodakiKayitlar()
    {
        Connection connnection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        sorguSonucu=new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfdersleri","root","");
            preparedStatement=connnection.prepareStatement("select * from kisiler");
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                Kisiler kisiler=new Kisiler();
                kisiler.setId(resultSet.getInt("id"));
                kisiler.setIsim(resultSet.getString("isim"));
                kisiler.setSoyisim(resultSet.getString("soyisim"));
                kisiler.setUniversite(resultSet.getString("universite"));
                sorguSonucu.add(kisiler);
            }
        } catch (Exception e) {
            System.err.println("Hata Meydana Geldi. Hata:"+e);
        }
        finally{
            try {
                connnection.close();
                preparedStatement.close();
            } catch (Exception e) {
            }
        }
        return sorguSonucu;
    }*/
    
    
    @PostConstruct
    public void veriTabanindanKayitCek()
    {
        Connection connnection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        sorguSonucu=new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfdersleri","root","");
            preparedStatement=connnection.prepareStatement("select * from kisiler");
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                Kisiler kisiler=new Kisiler();
                kisiler.setId(resultSet.getInt("id"));
                kisiler.setIsim(resultSet.getString("isim"));
                kisiler.setSoyisim(resultSet.getString("soyisim"));
                kisiler.setUniversite(resultSet.getString("universite"));
                sorguSonucu.add(kisiler);
            }
        } catch (Exception e) {
            System.err.println("Hata Meydana Geldi. Hata:"+e);
        }
        finally{
            try {
                connnection.close();
                preparedStatement.close();
            } catch (Exception e) {
            }
        }
    }
    
}
