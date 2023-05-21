package com.example.stackoverflow.repository;

import com.example.stackoverflow.model.Thread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ThreadRepository extends JpaRepository<Thread, Long> {
  @Query("select avg(e.ansUserPercent) from Thread e")
  double findAvgAnsPercent();

  @Query("select avg(e.commentUserPercent) from Thread e")
  double findAvgCommentPercent();
}
