package com.egbas.EcommerceApp.repository;

import com.egbas.EcommerceApp.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByLoginAndPassword(String login, String password);

    Optional<Admin> findFirstByLogin(String login);
}
