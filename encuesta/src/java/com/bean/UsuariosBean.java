/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.UsuariosDao;
import com.dao.UsuariosImp;
import com.model.Usuarios;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author luis_
 */
@Named(value = "usuariosBean")
@Dependent
public class UsuariosBean implements Serializable {
    
    private List<Usuarios> list;
    private Usuarios usuario;
    
    /**
     * Creates a new instance of UsuariosBean
     */
    public UsuariosBean() {
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setResult(Usuarios usuario) {
        this.usuario = usuario;
    }

    public List<Usuarios> getList() {
        UsuariosDao usuarioDao = new UsuariosImp();
        list = usuarioDao.getAllUsuarios();
        return list;
    }
    
}
