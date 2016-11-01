package com.gopaperless.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.gopaperless.model.Bill;

public interface BillRepository extends CrudRepository<Bill, String> {
}
