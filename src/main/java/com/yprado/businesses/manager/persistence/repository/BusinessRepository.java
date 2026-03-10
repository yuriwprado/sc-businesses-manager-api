package com.yprado.businesses.manager.persistence.repository;

import com.yprado.businesses.manager.persistence.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<Business, String> {

}
