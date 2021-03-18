package com.legist.myapp.repository;

import com.legist.myapp.domain.City;
import com.legist.myapp.domain.Region;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface CitiesRepository extends CrudRepository<City, Long> {

    Set<City> findAllByRegion(Region region);

    Set<City> findCitiesByRegionId(Long id);

    Set<City> findAll();

    City findByName(String name);
}
