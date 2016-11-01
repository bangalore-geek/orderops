package com.gopaperless.repository;

import java.util.Collection;

import com.gopaperless.model.Bill;

public interface BillSearchDao {

	Collection<Bill> searchCars(String text);

}