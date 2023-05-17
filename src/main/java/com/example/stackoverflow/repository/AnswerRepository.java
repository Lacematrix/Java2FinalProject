package com.example.stackoverflow.repository;

import com.example.stackoverflow.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    long countByIsAccepted(boolean accepted);

    @Query("SELECT (a.creationDate - q.creationDate) as time FROM Question q JOIN Answer a ON q.questionId = a.questionId WHERE a.isAccepted IS TRUE ")
    List<Object[]> findResolvedTime();
}
