package com.egbas.EcommerceApp.service;

import com.egbas.EcommerceApp.model.Admin;
import com.egbas.EcommerceApp.dto.AdminAuthentication;
import com.egbas.EcommerceApp.dto.AdminDto;

public interface AdminService {
    AdminDto registerAdmin(AdminDto adminDto);

    Admin loginAdmin(AdminAuthentication adminAuthentication);
}
