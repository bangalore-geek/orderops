package com.gopaperless.service;

import java.util.Collection;

import com.gopaperless.model.Bill;

public interface BillService {

	public Bill saveBill(Bill bill);

	public Collection<Bill> search(String query);

	public Collection<Bill> findAll();

}
