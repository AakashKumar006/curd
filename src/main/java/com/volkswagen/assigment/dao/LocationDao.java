package com.volkswagen.assigment.dao;

import com.volkswagen.assigment.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationDao extends JpaRepository<Location, Integer> {
}
