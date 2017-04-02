
create table yogesh.tblcountry (
	cid serial PRIMARY KEY,
	code varchar(50),
	description varchar(50)
);

create table yogesh.tblstate (
	cid serial PRIMARY KEY,
	code varchar(50),
	description varchar(50),
	countryid bigint REFERENCES yogesh.tblcountry(cid)
);

commit;
create table yogesh.tblcity (
	cid serial PRIMARY KEY,
	code varchar(50),
	description varchar(50),
	stateid bigint REFERENCES yogesh.tblstate(cid),
	countryid bigint REFERENCES yogesh.tblcountry(cid)
);

create table yogesh.tbladdress (
	cid serial PRIMARY KEY,
	userid bigint REFERENCES yogesh.tbluser(cid),
	country integer,
	state integer,
	district integer,
	city integer,
	pin integer,
	mobile varchar,
	landline varchar,
	email varchar(100)
);

create table yogesh.tbluserprofile (
	cid serial PRIMARY KEY,
	userid bigint REFERENCES yogesh.tbluser(cid),
	firstname varchar(100),
	lastname varchar(100),
	email varchar(100),
	phone varchar(100),
	address bigint REFERENCES yogesh.tbladdress(cid),
	joindate timestamp without time zone,
	dob timestamp without time zone,
	gender varchar(100)
);


create table yogesh.tblempmanager (
	cid serial PRIMARY KEY,
	userid bigint REFERENCES yogesh.tbluser(cid),
	managerid bigint REFERENCES yogesh.tbluser(cid)
);

insert into yogesh.tblcountry(code,description) values ('india','india');

insert into yogesh.tblstate(code,description, countryid) values ('Karnataka','Karnataka', (select cid from yogesh.tblcountry where code='india'));
insert into yogesh.tblstate(code,description, countryid) values ('Jharkhand','Jharkhand' , (select cid from yogesh.tblcountry where code='india'));
insert into yogesh.tblstate(code,description, countryid) values ('Chhattisgarh','Chhattisgarh' , (select cid from yogesh.tblcountry where code='india'));
insert into yogesh.tblstate(code,description, countryid) values ('Andhra Pradesh','Andhra Pradesh' , (select cid from yogesh.tblcountry where code='india'));	
insert into yogesh.tblstate(code,description, countryid) values ('Telangana','Telangana' , (select cid from yogesh.tblcountry where code='india'));	
insert into yogesh.tblstate(code,description, countryid) values ('Tamil nadu','Tamil nadu' , (select cid from yogesh.tblcountry where code='india'));	
insert into yogesh.tblstate(code,description, countryid) values ('Maharashtra','Maharashtra' , (select cid from yogesh.tblcountry where code='india'));	

insert into yogesh.tblcity(code,description, stateid, countryid) values ('Bangalore','Bangalore' , (select cid from yogesh.tblstate where code='Karnataka'), (select cid from yogesh.tblcountry where code='india'));	
insert into yogesh.tblcity(code,description, stateid, countryid) values ('Mangalore','Mangalore' , (select cid from yogesh.tblstate where code='Karnataka'), (select cid from yogesh.tblcountry where code='india'));	
insert into yogesh.tblcity(code,description, stateid, countryid) values ('Mysore','Mysore' , (select cid from yogesh.tblstate where code='Karnataka'), (select cid from yogesh.tblcountry where code='india'));	


insert into yogesh.tblcity(code,description, stateid, countryid) values ('Ranchi','Ranchi' , (select cid from yogesh.tblstate where code='Jharkhand'), (select cid from yogesh.tblcountry where code='india'));	
insert into yogesh.tblcity(code,description, stateid, countryid) values ('Chakradharpur','Chakradharpur' , (select cid from yogesh.tblstate where code='Jharkhand'), (select cid from yogesh.tblcountry where code='india'));	
insert into yogesh.tblcity(code,description, stateid, countryid) values ('Tata','Tata' , (select cid from yogesh.tblstate where code='Jharkhand'), (select cid from yogesh.tblcountry where code='india'));	
	
insert into yogesh.tblcity(code,description, stateid, countryid) values ('Raipur','Raipur' , (select cid from yogesh.tblstate where code='Chhattisgarh'), (select cid from yogesh.tblcountry where code='india'));	
insert into yogesh.tblcity(code,description, stateid, countryid) values ('Rajnandgaon','Rajnandgaon' , (select cid from yogesh.tblstate where code='Chhattisgarh'), (select cid from yogesh.tblcountry where code='india'));	
insert into yogesh.tblcity(code,description, stateid, countryid) values ('Durg','Durg' , (select cid from yogesh.tblstate where code='Chhattisgarh'), (select cid from yogesh.tblcountry where code='india'));	
insert into yogesh.tblcity(code,description, stateid, countryid) values ('Bilaspur','Bilaspur' , (select cid from yogesh.tblstate where code='Chhattisgarh'), (select cid from yogesh.tblcountry where code='india'));	

insert into yogesh.tblcity(code,description, stateid, countryid) values ('Hyderabad','Hyderabad' , (select cid from yogesh.tblstate where code='Andhra Pradesh'), (select cid from yogesh.tblcountry where code='india'));	
insert into yogesh.tblcity(code,description, stateid, countryid) values ('Visakhapatnam','Visakhapatnam' , (select cid from yogesh.tblstate where code='Andhra Pradesh'), (select cid from yogesh.tblcountry where code='india'));	
insert into yogesh.tblcity(code,description, stateid, countryid) values ('Anantapur', 'Anantapur' , (select cid from yogesh.tblstate where code='Andhra Pradesh'), (select cid from yogesh.tblcountry where code='india'));	
insert into yogesh.tblcity(code,description, stateid, countryid) values ('Tirupati', 'Tirupati' , (select cid from yogesh.tblstate where code='Andhra Pradesh'), (select cid from yogesh.tblcountry where code='india'));	

insert into yogesh.tblcity(code,description, stateid, countryid) values ('Warangal', 'Warangal' , (select cid from yogesh.tblstate where code='Telangana'), (select cid from yogesh.tblcountry where code='india'));	
insert into yogesh.tblcity(code,description, stateid, countryid) values ('Mahabubnagar', 'Mahabubnagar' , (select cid from yogesh.tblstate where code='Telangana'), (select cid from yogesh.tblcountry where code='india'));	

insert into yogesh.tblcity(code,description, stateid, countryid) values ('Mumbai', 'Mumbai' , (select cid from yogesh.tblstate where code='Maharashtra'), (select cid from yogesh.tblcountry where code='india'));	
insert into yogesh.tblcity(code,description, stateid, countryid) values ('Pune', 'Pune' , (select cid from yogesh.tblstate where code='Maharashtra'), (select cid from yogesh.tblcountry where code='india'));	
insert into yogesh.tblcity(code,description, stateid, countryid) values ('Nagpur', 'Nagpur' , (select cid from yogesh.tblstate where code='Maharashtra'), (select cid from yogesh.tblcountry where code='india'));	



alter table yogesh.tbluser add column active boolean default true;



