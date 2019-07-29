package com.dchip.cloudparking.web.iRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dchip.cloudparking.web.model.po.UserMessage;

@Repository
public interface IUserMessageRepository extends JpaRepository<UserMessage, Integer> {

}