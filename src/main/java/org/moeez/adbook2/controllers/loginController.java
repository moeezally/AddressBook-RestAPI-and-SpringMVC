package org.moeez.adbook2.controllers;

import org.moeez.adbook2.models.user;
import org.moeez.adbook2.services.loginCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class loginController {
    @Autowired
    loginCheckService Service;

    @RequestMapping(path = "/loginCheck",method = RequestMethod.POST)
    public String checkLogin(@ModelAttribute("user") user User, HttpServletRequest request) {

        boolean userExist = Service.checkUser(User);

        if (userExist) {
            request.getSession().setAttribute("email", User.getEmail());
            return "redirect:/dashboard?login=true";
        } else {
            return "redirect:/?login=0";
        }
    }


    @GetMapping("/")
    public String showStart(@ModelAttribute("user") user User,Model model,HttpServletRequest request){
        if(request.getParameter("logout")!=null){
            model.addAttribute("msg","You are logged out successfully.");
        }
        else if(request.getParameter("login")!=null){
            if(request.getParameter("login").equals("0")) {
                model.addAttribute("msg", "Incorrect Email/Password. Try Again.");
            }
            if(request.getParameter("login").equals("false")){
                model.addAttribute("msg","You need to login first to access the Address Book.");
            }
        }
        else {
            model.addAttribute("msg","Welcome to Moeez's Address Book Developed using Spring Mvc");

        }
        return "login";
    }

    @RequestMapping("/logout")
    public String Logout(HttpServletRequest request){
        HttpSession Session = request.getSession();
        Session.removeAttribute("email");
        Session.invalidate();

        return "redirect:/?logout=true";
    }



}
