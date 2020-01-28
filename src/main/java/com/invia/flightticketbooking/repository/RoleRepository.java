package com.invia.flightticketbooking.repository;

import com.invia.flightticketbooking.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface RoleRepository extends JpaRepository<Role, Integer> {
}
