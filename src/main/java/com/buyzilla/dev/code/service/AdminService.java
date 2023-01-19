package com.buyzilla.dev.code.service;

import com.buyzilla.dev.code.entity.Admin;
import com.buyzilla.dev.code.respository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public Admin findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }
}
