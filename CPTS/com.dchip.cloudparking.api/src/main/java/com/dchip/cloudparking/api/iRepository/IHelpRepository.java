package com.dchip.cloudparking.api.iRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dchip.cloudparking.api.model.po.Help;

@Repository
public interface IHelpRepository extends JpaRepository<Help, Integer>{

}
