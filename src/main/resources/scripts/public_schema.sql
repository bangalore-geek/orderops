CREATE TABLE tblserverinfo
(
  cid serial NOT NULL,
  ipaddress character varying(50) NOT NULL,
  connectionurl character varying(1000) NOT NULL,
  dbname character varying(200) NOT NULL,
  dbusername character varying(100) NOT NULL,
  dbpassword character varying(100) NOT NULL,
  dbcode character varying(500),
  port integer DEFAULT 5432,
  CONSTRAINT tblserverinfo_pkey PRIMARY KEY (cid),
  CONSTRAINT tblserverinfo_dbcode_key UNIQUE (dbcode)
)

CREATE TABLE tblaccountinfo
(
  cid serial NOT NULL,
  domainname character varying(100) NOT NULL,
  accountid integer NOT NULL,
  schemaname character varying(100) NOT NULL,
  schemausername character varying(100) NOT NULL,
  schemapassword character varying(100) NOT NULL,
  user_schema boolean DEFAULT true,
  enabled boolean DEFAULT false,
  accessid character varying(500),
  accesskey character varying(500),
  plan character varying(100),
  dbserver character varying(500),
  CONSTRAINT pk_account_info_cid PRIMARY KEY (cid),
  CONSTRAINT tblaccountinfo_dbserver_fkey FOREIGN KEY (dbserver)
      REFERENCES tblserverinfo (dbcode) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)

CREATE TABLE tblbrowserinfo
(
  cid serial NOT NULL,
  remoteaddress character varying(50),
  siteurl character varying(1000),
  accessdate timestamp without time zone DEFAULT now(),
  sessionid character varying(500),
  jstype character varying(500),
  browsertype character varying(500),
  browserversion character varying(500),
  osname character varying(500),
  subnetip character varying(50),
  proxies character varying(1000),
  CONSTRAINT tblbrowserinfo_pkey PRIMARY KEY (cid)
)

CREATE TABLE tblaccesslog
(
  cid serial NOT NULL,
  remoteaddress character varying(50),
  url character varying(1000),
  accessdate timestamp without time zone DEFAULT now(),
  userid integer,
  usertypeid integer,
  accountcode character varying(500),
  sessionid character varying(500),
  tomcat character varying(50),
  thread character varying(200),
  CONSTRAINT tblaccesslog_pkey PRIMARY KEY (cid)
)