package com.example.stackoverflow.repository;

import com.example.stackoverflow.model.Thread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ThreadRepository extends JpaRepository<Thread, Long> {

  @Query("select e.ans_Cnt from Thread e")
  List<Integer> findAnswerCnt();

  @Query("select e.comment_Cnt from Thread e")
  List<Integer> findCommentCnt();

  @Query("select e.comment_Cnt+e.ans_Cnt+1 from Thread e")
  List<Integer> findThreadCnt();

  @Query("select avg(e.ans_Cnt) from Thread e")
  Double findAvgAns();

  @Query("select avg(e.comment_Cnt) from Thread e")
  Double findAvgComment();
}
