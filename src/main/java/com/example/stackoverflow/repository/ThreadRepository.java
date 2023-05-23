package com.example.stackoverflow.repository;

import com.example.stackoverflow.model.Thread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ThreadRepository extends JpaRepository<Thread, Long> {
  @Query("select avg(e.ans_Cnt) from Thread e")
  double findAvgAnswerCnt();

  @Query("select avg(e.comment_Cnt) from Thread e")
  double findAvgCommentCnt();
}
