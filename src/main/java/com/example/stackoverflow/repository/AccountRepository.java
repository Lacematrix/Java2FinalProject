package com.example.stackoverflow.repository;

import com.example.stackoverflow.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long>, JpaSpecificationExecutor<Account> {
  Account getAccountByUserid(Long userId);
//  @Query(value="SELECT user_Name,join_Cnt FROM Account ORDER BY join_Cnt DESC LIMIT 5",nativeQuery = true)
  List<Account> findTop5ByOrderByJoincntDesc();
}
