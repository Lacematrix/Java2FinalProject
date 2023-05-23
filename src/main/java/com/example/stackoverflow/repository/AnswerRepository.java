package com.example.stackoverflow.repository;

import com.example.stackoverflow.model.Answer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface AnswerRepository extends JpaRepository<Answer, Long> {

  long countByIsAccepted(boolean accepted);

  @Query("SELECT (a.creationDate - q.creationDate) as time "
      +
      "FROM Question q JOIN Answer a ON q.questionId = a.questionId "
      +
      "WHERE a.isAccepted IS TRUE ")
  List<Object[]> findResolvedTime();

  @Query("SELECT a1.upVoteCount, a2.upVoteCount , a1.questionId "
      +
      "FROM Answer a1 join Answer a2 ON a1.questionId = a2.questionId "
      +
      "WHERE a1.answerId <> a2.questionId AND (a1.isAccepted IS TRUE AND a2.isAccepted is FALSE )"
      +
      " AND a2.upVoteCount > a1.upVoteCount")
  List<Object[]> findMoreVotes();
}
