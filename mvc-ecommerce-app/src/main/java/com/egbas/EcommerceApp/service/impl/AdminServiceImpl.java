package com.egbas.EcommerceApp.service.impl;

import com.egbas.EcommerceApp.dto.AdminAuthentication;
import com.egbas.EcommerceApp.dto.AdminDto;
import com.egbas.EcommerceApp.model.Admin;
import com.egbas.EcommerceApp.repository.AdminRepository;
import com.egbas.EcommerceApp.service.AdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {


    @Autowired
    private AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public AdminDto registerAdmin(AdminDto adminDto) {

        if(adminDto.getLogin() == null || adminDto.getPassword() == null){
            return null;
        }else{
            if(adminRepository.findFirstByLogin(adminDto.getLogin()).isPresent()){
                return null;
            }
            Admin admin = Admin.builder()
                    .login(adminDto.getLogin())
                    .password(adminDto.getPassword())
                    .email(adminDto.getEmail())
                    .build();

            adminRepository.save(admin);

            AdminDto adminDto1 = new AdminDto();

            BeanUtils.copyProperties(admin, adminDto1);

            return adminDto1;
        }




    }

    @Override
    public Admin loginAdmin(AdminAuthentication adminAuthentication) {
        return adminRepository.findByLoginAndPassword(adminAuthentication.getLogin(), adminAuthentication.getPassword())
                .orElse(null);
    }
}
