package com.example.recruitmenttask.user;

import com.example.recruitmenttask.model.ApiRequestCount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApiRequestCountRepository extends JpaRepository<ApiRequestCount, Long> {

    Optional<ApiRequestCount> findApiRequestCountsByLogin(String login);
}
