package com.egbas.EcommerceApp.controller;

import com.egbas.EcommerceApp.dto.AdminAuthentication;
import com.egbas.EcommerceApp.dto.AdminDto;
import com.egbas.EcommerceApp.model.Admin;
import com.egbas.EcommerceApp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @GetMapping("/register")
    public String getAdminRegisterPage(Model model){
        AdminDto adminDto = new AdminDto();

        model.addAttribute("adminRegisterRequest", adminDto);
        return "admin_register_page";

    }

    @PostMapping("/register")
    public String register(@ModelAttribute AdminDto adminDto){
        AdminDto registeredAdmin = adminService.registerAdmin(adminDto);

        return registeredAdmin == null ? "error_page" : "redirect:/login";
    }

    @GetMapping("/login")
    public String getAdminLoginPage(Model model){
        AdminDto adminDto = new AdminDto();

        model.addAttribute("adminLoginRequest", adminDto);
        return "admin_login_page";

    }

    @PostMapping("/login")
    public String login(@ModelAttribute AdminAuthentication adminAuthentication, Model model){
        System.out.println("admin login request " + adminAuthentication);

        Admin authentication = adminService.loginAdmin(adminAuthentication);

        if(adminAuthentication != null){
            model.addAttribute("userLogin", adminAuthentication.getLogin());

            return "personal_Adminpage";
        }else {
            return "error_page";
        }
    }

}
