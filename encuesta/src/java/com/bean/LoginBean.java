/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.UsuariosDao;
import com.dao.UsuariosImp;
import com.model.Usuarios;
import com.util.Messages;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author luis_
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable{
    
    private Usuarios user = new Usuarios();
    
    private boolean loged = false;
            
    public LoginBean() {
    }
    
    public void login () {
        UsuariosDao userDao = new UsuariosImp();
        List<Usuarios> result = userDao.login(user.getNombre(), user.getPassword());
        if (!result.isEmpty()) {
            user = result.get(0);
            loged = true;
            Messages.succesMensaje("Correcto", "Se ha loggeado satisfactoriamente.");
        } else {
            Messages.errorMensaje("Incorecto", "Usuario o contraseña inválidos.");
        }
    }
    
    public void logout () {
        user = new Usuarios();
        loged = false;
    }

    public Usuarios getUser() {
        return user;
    }

    public boolean isLoged() {
        return loged;
    }
    
    
}
