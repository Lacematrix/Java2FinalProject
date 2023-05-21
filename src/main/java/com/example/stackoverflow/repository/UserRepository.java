package com.example.stackoverflow.repository;

import com.example.stackoverflow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
  User getUserById(Long id);
  @Query("SELECT e.userName,e.joinCnt FROM User e ORDER BY e.joinCnt DESC LIMIT 5")
  List<User> findActiveUser();
}
