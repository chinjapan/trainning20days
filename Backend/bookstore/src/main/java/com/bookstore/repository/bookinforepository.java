package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.bookinfo;

@Repository
public interface bookinforepository extends JpaRepository<bookinfo, Long> {

}
