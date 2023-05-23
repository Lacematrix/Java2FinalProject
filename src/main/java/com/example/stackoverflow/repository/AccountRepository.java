package com.example.stackoverflow.repository;

import com.example.stackoverflow.model.Account;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AccountRepository extends JpaRepository<Account, Long>,
    JpaSpecificationExecutor<Account> {

  Account getAccountByUserid(Long userId);

  List<Account> findTop5ByOrderByJoincntDesc();
}
