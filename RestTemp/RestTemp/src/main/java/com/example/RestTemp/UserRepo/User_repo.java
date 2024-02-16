package com.example.RestTemp.UserRepo;

import com.example.RestTemp.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User_repo extends JpaRepository<User,Long> {
}
