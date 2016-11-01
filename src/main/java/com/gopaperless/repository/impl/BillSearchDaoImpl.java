package com.gopaperless.repository.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.gopaperless.model.Bill;
import com.gopaperless.repository.BillSearchDao;

@Repository
public class BillSearchDaoImpl implements BillSearchDao {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public Collection<Bill> searchCars(String text) {
		return mongoTemplate.find(Query.query(new Criteria().orOperator(Criteria.where("vendor").regex(text, "i"),
				Criteria.where("source").regex(text, "i"))), Bill.class);
	}
}
