package com.example.stackoverflow.repository;

import com.example.stackoverflow.model.APIData;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface APIDataRepository extends JpaRepository<APIData, Long> {

  APIData getAPIDataByName(String name);

  List<APIData> findTop5ByOrderByCntDesc();
}
