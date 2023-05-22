package com.example.stackoverflow.repository;

import com.example.stackoverflow.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
  Account getAccountByUserId(Long userId);
  @Query(value = "SELECT e.userName,e.joinCnt FROM User e ORDER BY e.joinCnt DESC LIMIT 5", nativeQuery = true)
  List<Account> findActiveUser();
}
