package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.bookinfor;

@Repository
public interface bookinforrepository extends JpaRepository<bookinfor, Long> {

}
