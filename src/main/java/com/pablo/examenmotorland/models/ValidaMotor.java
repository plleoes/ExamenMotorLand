/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablo.examenmotorland.models;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author plleo
 */
public class ValidaMotor implements Validator{
    
        @Override
    public boolean supports(Class<?> type) 
    {
        return Motores.class.isAssignableFrom(type);
       // return TuClase.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        
        Motores motor=(Motores)o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "modelo",
        "required.modelo", "El campo Modelo es Obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fabricante",
        "required.fabricante", "El campo Fabricante es Obligatorio.");

        if (motor.getModelo().length()!=5)
        {
            errors.rejectValue("modelo", "verificamodelo","El modelo debe contener cinco caracteres");
        }
        
        if(motor.getPotencia()<=0)
        {
	    errors.rejectValue("potencia", "verificapotencia","La potencia tiene que ser mayor de cero");
	}
        
        if(motor.getPeso()<=0)
        {
	    errors.rejectValue("peso", "verificapeso","El peso tiene que ser mayor de cero");
	}
        
    }

    
}
