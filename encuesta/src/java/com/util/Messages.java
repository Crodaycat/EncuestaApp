/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author luis_
 */
public class Messages {
    public static void succesMensaje(String title, String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage (FacesMessage.SEVERITY_INFO, title, message));
    }
    
    public static void infoMensaje(String title, String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage (FacesMessage.SEVERITY_INFO, title, message));
    }
    
    public static void errorMensaje(String title, String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage (FacesMessage.SEVERITY_ERROR, title, message));
    }
}
