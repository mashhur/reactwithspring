package org.reactjs.spring.api.repository;

import org.reactjs.spring.api.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by mashhur on 7/19/17.
 */


public interface UserRepository extends CrudRepository<User, Long> {

    // if you need pagination use Pageable interface
    Page<User> findAll(Pageable pageable);


}