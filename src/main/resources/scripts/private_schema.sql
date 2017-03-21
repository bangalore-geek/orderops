CREATE SCHEMA deepak
  AUTHORIZATION postgres;
  
CREATE SCHEMA prashant
  AUTHORIZATION postgres;
  

CREATE TABLE tbluser
(
  cid serial NOT NULL,
  username character varying(200),
  password character varying(100),
  briefcasepassword character varying(100),
  email character varying(100),
  issystemdisabled boolean DEFAULT false,
  usertype integer,
  modifieddate timestamp without time zone,
  createddate timestamp without time zone,
  name character varying(200),
  CONSTRAINT tbluser_pkey PRIMARY KEY (cid),
  CONSTRAINT tbluser_username_key UNIQUE (username)
)

CREATE TABLE tblrole
(
  cid serial NOT NULL,
  name character varying(50),
  lastupdatedon timestamp without time zone,
  isprivate boolean DEFAULT false,
  system boolean DEFAULT false,
  description character varying,
  CONSTRAINT tblrole_pkey PRIMARY KEY (cid),
  CONSTRAINT tblrole_name_key UNIQUE (name)
)

CREATE TABLE tbl_user_roles
(
  cid serial NOT NULL,
  userid integer NOT NULL,
  roleid integer NOT NULL,
  CONSTRAINT tbl_user_roles_pkey PRIMARY KEY (cid),
  CONSTRAINT tbl_user_roles_fk_1 FOREIGN KEY (userid)
      REFERENCES tbluser (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT tbl_user_roles_fk_2 FOREIGN KEY (roleid)
      REFERENCES tblrole (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)


CREATE TABLE tblaccessrights
(
  cid serial NOT NULL,
  parentid integer,
  description character varying(125),
  code character varying(50),
  enabled boolean NOT NULL DEFAULT true,
  itemorder character varying(250),
  servicecode character varying(500),
  isold boolean DEFAULT false,
  isprivate boolean DEFAULT false,
  isadmin boolean DEFAULT false,
  isemployee boolean DEFAULT false,
  ismanager boolean DEFAULT false
  CONSTRAINT fk_tblfeatures_pkey PRIMARY KEY (cid),
  CONSTRAINT fk_role_features_fk_1 FOREIGN KEY (parentid)
      REFERENCES tblaccessrights (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT tblaccessrights_code_key UNIQUE (code)
)

CREATE TABLE tbl_role_accessrights
(
  cid serial NOT NULL,
  roleid integer NOT NULL,
  featureid integer NOT NULL,
  read_write_access boolean DEFAULT false,
  CONSTRAINT tbl_role_accessrights_pkey PRIMARY KEY (cid),
  CONSTRAINT tbl_role_accessrights_fk_1 FOREIGN KEY (featureid)
      REFERENCES tblaccessrights (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT tbl_role_accessrights_fk_2 FOREIGN KEY (roleid)
      REFERENCES tblrole (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uq_tbl_role_accessrights_role_feature UNIQUE (roleid, featureid)
)

CREATE TABLE tblauditcategory
(
  cid serial NOT NULL,
  code character varying(100),
  description character varying(500),
  CONSTRAINT tblauditcategory_pkey PRIMARY KEY (cid)
)

CREATE TABLE tblauditlog
(
  cid serial NOT NULL,
  auditdate timestamp without time zone,
  auditcategory integer,
  userid integer,
  additionalinfo character varying(5000),
  remoteaddress character varying(100),
  affecteduserid integer,
  ismailed boolean DEFAULT false,
  CONSTRAINT tblauditlog_pkey PRIMARY KEY (cid),
  CONSTRAINT tblauditlog_auditcategory_fkey FOREIGN KEY (auditcategory)
      REFERENCES tblauditcategory (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT tblauditlog_userid_fkey FOREIGN KEY (userid)
      REFERENCES tbluser (cid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)


CREATE TABLE tblcountry(
	cid serial not null,
	description character varying(200),
	CONSTRAINT tblcountry_pkey PRIMARY KEY (cid )
)


CREATE TABLE tblstate(
	cid serial not null,
	description character varying(200),
	country integer references tblcountry(cid),
	CONSTRAINT tblstate_pkey PRIMARY KEY (cid )
)
