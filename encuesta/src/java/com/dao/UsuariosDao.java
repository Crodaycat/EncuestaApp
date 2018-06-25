/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Usuarios;
import java.util.List;

/**
 *
 * @author luis_
 */
public interface UsuariosDao {
    public List<Usuarios> getAllUsuarios ();
    public List<Usuarios> login (String user, String password);
}
