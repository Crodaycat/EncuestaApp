/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author luis_
 */
@Named(value = "usuario")
@SessionScoped
@Entity

public class Usuario implements Serializable {
    
    @Id
    private int id;
    private String userName;
    private String password;
    
    public Usuario() {
    }
    
    public boolean login () {
        if (userName.equals("luis") && password.equals("123456")) {
            return true;
        }
        return false;
    }

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
}
