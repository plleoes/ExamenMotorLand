/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablo.examenmotorland.controllers;

import com.pablo.examenmotorland.models.Conectar;
import com.pablo.examenmotorland.models.Motores;
import com.pablo.examenmotorland.models.ValidaMotor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author plleo
 */
@Controller
@RequestMapping("altamotor.htm")
public class AltaMotorController {
    
    private JdbcTemplate jdbcTemplate;
    private ValidaMotor validam;

    public AltaMotorController() {
        Conectar con=new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
        this.validam = new ValidaMotor();       
    }
    
     @RequestMapping(method=RequestMethod.GET) 
    public ModelAndView alta()
    {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("altamotor");
        mav.addObject("motores",new Motores());
        return mav;
    }
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView alta
        (
                @ModelAttribute("motores") Motores m,
                BindingResult result
        )
    {
         this.validam.validate(m, result);
        if (result.hasErrors())
        {
             ModelAndView mav=new ModelAndView();
            mav.setViewName("altamotor");
            mav.addObject("motores",new Motores());
            return mav;
        }
        else
        {
        this.jdbcTemplate.update
        (
        "insert into motores (modelo,fabricante,potencia,peso,cantidad ) values (?,?,?,?,?)",
         m.getModelo(),m.getFabricante(),m.getPotencia(),m.getPeso(),m.getCantidad());
         return new ModelAndView("redirect:/index.htm?opcion=2 ");
        }
    }
  
    
}
