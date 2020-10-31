package com.backend.apiserver.repository;

import com.backend.apiserver.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    Store findByName(String name);
}
