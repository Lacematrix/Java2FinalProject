package com.example.stackoverflow.repository;

import com.example.stackoverflow.model.APIData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface APIDataRepository extends JpaRepository<APIData, Long> {
  APIData getAPIDataByName(String name);

  @Query(value = "select e.name,e.cnt,e.type from APIData e order by e.cnt desc limit 5", nativeQuery = true)
  List<APIData> findMax5API();
}
