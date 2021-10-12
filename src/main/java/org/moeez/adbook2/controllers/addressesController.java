package org.moeez.adbook2.controllers;

import org.moeez.adbook2.models.address;
import org.moeez.adbook2.services.addressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class addressesController {
    @Autowired
    addressBookService Service;

    @RequestMapping("/addNewAddress")
    public String ShowAddAddressForm(@ModelAttribute("newAddress") address NewAddress, HttpServletRequest request) {

        if(request.getSession().getAttribute("email")==null){
            return "redirect:/?login=false";
        }
        else {
            return "newAddress";
        }
    }

    @RequestMapping(path="/processForm", method = RequestMethod.POST)
    public String ProcessAddForm(@ModelAttribute("newAddress") address NewAddress,Model model,HttpServletRequest request)  {
        System.out.println(NewAddress);

        if(request.getSession().getAttribute("email")==null){
            return "redirect:/?login=false";
        }
        boolean inserted=Service.insertAddress(NewAddress);
        if(inserted){
            return "redirect:/dashboard?added=true";
        }
        else{
            model.addAttribute("msg","Address could not be added.");

            return "dashboard";
        }

    }

    @RequestMapping("/updateAddress")
    public String ShowUpdateForm( HttpServletRequest request, Model model) {

        if(request.getSession().getAttribute("email")==null){

            return "redirect:/?login=false";
        }
        else {
            int id = Integer.parseInt(request.getParameter("id"));
            address address = Service.GetAddressById(id);
            System.out.println(address);
            model.addAttribute("updateAddress", address);
            return "updateAddress";
        }
    }

    @RequestMapping(path = "/processUpdate", method = RequestMethod.POST)
    public String ProcessUpdateForm (@ModelAttribute("updateAddress") address updateAddress, Model model, HttpServletRequest request)  {

        if(request.getSession().getAttribute("email")==null){

            return "redirect:/?login=false";
        }
        boolean updated=Service.updateAddress(updateAddress);

        if(updated){
            return "redirect:/dashboard?updated=true";
        }
        else{
            model.addAttribute("msg","Address could not be updated.");
            return "dashboard";
        }

    }

    @RequestMapping("/deleteAddress")
    public String DeleteRecord(HttpServletRequest request, Model model)  {

        if(request.getSession().getAttribute("email")==null){

            return "redirect:/?login=false";
        }
        int id = Integer.parseInt(request.getParameter("id"));
        boolean deleted=Service.deleteAddressById(id);
        if(deleted){
            return "redirect:/dashboard?deleted=true";
        }
        else{
            model.addAttribute("msg","Address could not be deleted.");
            return "dashboard";
        }
    }


}
