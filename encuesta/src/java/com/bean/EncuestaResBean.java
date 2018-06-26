/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.model.EncuestaRes;
import com.dao.EncuestaResDao;
import com.dao.EncuestaResImp;
import com.util.Messages;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author luis_
 */
@Named(value = "encuestaResBean")
@ViewScoped
public class EncuestaResBean implements Serializable{
    
    private List<EncuestaRes> list;
    private EncuestaRes result = new EncuestaRes();
    
    private String[] programas = {
        "Ingeniería de sistemas", 
        "Ingeniería industrial", 
        "Ingeniería de Telecomunicaciones"
    };
    private String[] generos = {"Hombre", "Mujer"};
    private String[] bebidas = {"Gaseosa", "Jugo natural", "Agua de panela"};
    
    public EncuestaResBean() {
    }

    public EncuestaRes getResult() {
        return result;
    }

    public void setResult(EncuestaRes result) {
        this.result = result;
    }

    public List<EncuestaRes> getList() {
        EncuestaResDao resDao = new EncuestaResImp();
        list = resDao.getAllEncuestaRes();
        return list;
    }
    
    public void addEncuesta () throws IOException {
        EncuestaResDao resDao = new EncuestaResImp();
        
        if (result.getEdad() <= 0 || result.getEdad() > 150) {
            Messages.errorMensaje("No se completó el registro", "Ingresa un rango de edad válido");
            result = new EncuestaRes();
            return;
        }
        if (getTotal() >= 10) {
            Messages.errorMensaje("No se completó el registro", "Ya se ha alcanzado el límite se registros para esta encuesta.");
        } else {
            if (resDao.add(result))
                Messages.succesMensaje("Correcto", "Se han registrado sus datos correctamente");
            else
                Messages.errorMensaje("Hubo un problema", "No se pudo registrar sus datos, intente nuevamente.");
        }
            
        result = new EncuestaRes();
    }

    public String[] getProgramas() {
        return programas;
    }

    public String[] getGeneros() {
        return generos;
    }

    public String[] getBebidas() {
        return bebidas;
    }
    
    public long getTotal () {
        EncuestaResDao resDao = new EncuestaResImp();
        return resDao.total();
    }
    
    //Estudiantes entre 20 y 30 que prefieren gaseosa
    public long getEdadBebida () {
        EncuestaResDao resDao = new EncuestaResImp();
        return resDao.edadBebida();
    }
    
    //Programa con menos estudiantes encuestados
    public String programaMenos () {
        EncuestaResDao resDao = new EncuestaResImp();
        return resDao.programaMenos();
    }
    
    //Proporcion de mujeres y hombres que prefieren agua de panela sobre el resto de bebidas
    public String proporcion () {
        EncuestaResDao resDao = new EncuestaResImp();
        return resDao.proporcion();
    }
}
