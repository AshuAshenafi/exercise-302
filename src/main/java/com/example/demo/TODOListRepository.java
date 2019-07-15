package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface TODOListRepository extends CrudRepository<TODOList, Long> {
}
