package com.legist.myapp.repository;

import com.legist.myapp.domain.TypeOfRoadObj;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface RoadObjectsRepository extends CrudRepository<TypeOfRoadObj, Long> {
    Set<TypeOfRoadObj> findAll();
    TypeOfRoadObj findByName(String name);
}
