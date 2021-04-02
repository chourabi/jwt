package com.javainuse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javainuse.entitys.Role;





@Repository
public interface RolesRepository  extends JpaRepository<Role, Long> {

}