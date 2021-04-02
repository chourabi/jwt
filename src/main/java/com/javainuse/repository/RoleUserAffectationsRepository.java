package com.javainuse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javainuse.entitys.RoleUser;

@Repository
public interface RoleUserAffectationsRepository  extends JpaRepository<RoleUser, Long> {

}