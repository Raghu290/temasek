/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.temasek.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hackathon.temasek.entity.UserEntity;




@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
	
	@Modifying(clearAutomatically = true)
    @Transactional
    @Query(value="update UserEntity set password=:password where email=:email and phone=:phone")
    int updatePassword(@Param("email") String email, @Param("phone") String phone,@Param("password") String password);

	UserEntity findByUserId(String userid);
 
	@Transactional
	@Modifying
	@Query(value="update UserEntity set otp=:otp where userId=:userId")
    int insertOTP(@Param("otp") String otp, @Param("userId") String userId);

	@Transactional
	@Modifying
	@Query(value="update UserEntity set otp = NULL where userId=:userId")
    int deleteOTP( @Param("userId") String userId);
}