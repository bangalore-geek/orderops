package com.gopaperless.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopaperless.model.Bill;
import com.gopaperless.repository.BillSearchDao;
import com.gopaperless.repository.jpa.BillRepository;
import com.gopaperless.service.BillService;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillRepository repository;

	@Autowired
	private BillSearchDao dao;

	@Override
	public Bill saveBill(Bill bill) {
		return repository.save(bill);
	}

	@Override
	public Collection<Bill> search(String query) {
		return dao.searchCars(query);
	}

	@Override
	public Collection<Bill> findAll() {
		return (Collection<Bill>) repository.findAll();
	}

}
