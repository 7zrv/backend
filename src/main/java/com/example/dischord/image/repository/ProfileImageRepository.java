package com.example.dischord.image.repository;


import com.example.dischord.image.entity.ProfileImage;
import com.example.dischord.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileImageRepository extends JpaRepository<ProfileImage, Long> {


}
