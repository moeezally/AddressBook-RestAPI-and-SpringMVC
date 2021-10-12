package org.moeez.adbook2.controllers;

import org.moeez.adbook2.models.address;
import org.moeez.adbook2.services.dashboardLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class dashboardController {

    @Autowired
    private dashboardLoaderService Service;

    @RequestMapping("/dashboard")
    public ModelAndView showDashboard(HttpServletRequest request)  {

        ArrayList<address> allAddresses=Service.LoadDashboard();

        ModelAndView mv=new ModelAndView("dashboard");

        if(request.getSession().getAttribute("email")==null){

            mv.setViewName("redirect:/?login=false");
            return mv;
        }


        if(request.getParameter("login")!=null){
            mv.addObject("msg","Logged In Successfully.");
        }
        else if (request.getParameter("added")!=null){
            mv.addObject("msg","Address added Successfully");
        }
        else if(request.getParameter("deleted")!=null){
            mv.addObject("msg","Address deleted Successfully");
        }
        else if(request.getParameter("updated")!=null){
            mv.addObject("msg","Address updated Successfully");
        }
        mv.addObject("allAddresses", allAddresses);
        return mv;
    }
}
