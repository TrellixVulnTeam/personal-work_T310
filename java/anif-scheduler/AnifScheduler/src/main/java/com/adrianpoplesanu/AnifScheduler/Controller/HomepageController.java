package com.adrianpoplesanu.AnifScheduler.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/")
public class HomepageController {
    @GetMapping
    ModelAndView index(HttpSession session) {
        if (session.getAttribute("username") != null) {
            ModelAndView modelAndView = new ModelAndView("/dashboard");
            modelAndView.getModel().put("username", session.getAttribute("username"));
            return modelAndView;
        }
        ModelAndView mv = new ModelAndView();
        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //String encoded_hash = encoder.encode("test in consola");
        //System.out.println(encoded_hash);
        //boolean is_match = encoder.matches("test in consola", "$2a$10$mr8Ej3rxkoItTzVMw/l6deManqUIOPBfgyqxBa83wI4ZmeMsUyB4m");
        //System.out.println(is_match);
        mv.setViewName("homepage");
        mv.getModel().put("anunt", "buna dimineata 2");
        //if (errorMessage != null) {
        //    mv.getModel().put("errorMessage", errorMessage);
        //}
        return mv;
    }
}
