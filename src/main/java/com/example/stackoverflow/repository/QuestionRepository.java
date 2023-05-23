package com.example.stackoverflow.repository;

import com.example.stackoverflow.model.Question;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuestionRepository extends JpaRepository<Question, Long> {

  long countByIsAnswered(boolean isAnswered);

  long count();

  @Query("SELECT MAX(e.answerCount) FROM Question e")
  double findMaxValue();

  @Query("SELECT AVG(e.answerCount) FROM Question e")
  double findAvgValue();

  @Query("SELECT e.answerCount, count (e) from Question e group by e.answerCount")
  List<Object[]> findDistribution();

}
