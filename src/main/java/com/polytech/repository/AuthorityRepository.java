package com.polytech.repository;

import com.polytech.business.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by daivietquochoang on 15/04/2017.
 */
@Repository
public interface AuthorityRepository extends JpaRepository<Authority,String> {
}
