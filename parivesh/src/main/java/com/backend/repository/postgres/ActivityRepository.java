package com.backend.repository.postgres;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.model.Activities;

public interface ActivityRepository extends JpaRepository<Activities, Long>{

}
