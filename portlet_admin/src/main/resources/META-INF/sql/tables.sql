create table AHADDR (
	addrId LONG not null primary key,
	street VARCHAR(75) null,
	number_ VARCHAR(75) null,
	coordLat DOUBLE,
	coordLon DOUBLE,
	regionId LONG
);

create table AHCATS (
	catId LONG not null primary key,
	name VARCHAR(75) null,
	descr VARCHAR(75) null,
	type_ INTEGER
);

create table AHCFG (
	name VARCHAR(75) not null primary key,
	value VARCHAR(75) null
);

create table AHCITEM (
	itemId LONG not null primary key,
	catId LONG,
	name VARCHAR(75) null,
	descr VARCHAR(75) null,
	parentId LONG
);

create table AHCONTACT (
	contactId LONG not null primary key,
	forename VARCHAR(75) null,
	surname VARCHAR(75) null,
	tel VARCHAR(75) null,
	mobile VARCHAR(75) null,
	fax VARCHAR(75) null,
	email VARCHAR(75) null,
	www VARCHAR(75) null
);

create table AHOFFER (
	offerId LONG not null primary key,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	workTime VARCHAR(75) null,
	workType INTEGER,
	type_ INTEGER,
	status INTEGER,
	socialStatus INTEGER,
	created LONG,
	updated LONG,
	expires LONG,
	publish LONG,
	adressId LONG,
	contactId LONG,
	sndContactId LONG,
	contactAgency BOOLEAN,
	orgId LONG
);

create table AHORG (
	orgId LONG not null primary key,
	name VARCHAR(75) null,
	holder VARCHAR(75) null,
	owner VARCHAR(75) null,
	userlist VARCHAR(75) null,
	description VARCHAR(75) null,
	legalStatus VARCHAR(75) null,
	created LONG,
	updated LONG,
	contactId LONG,
	addressId LONG,
	status INTEGER,
	logoLocation VARCHAR(75) null
);

create table AHREGION (
	regionId LONG not null,
	zip VARCHAR(75) not null,
	city VARCHAR(75) not null,
	country VARCHAR(75) not null,
	permissions INTEGER,
	primary key (regionId, zip, city, country)
);

create table AHSUBSCR (
	subId LONG not null primary key,
	uuid_ VARCHAR(75) null,
	email VARCHAR(75) null,
	status INTEGER,
	created LONG
);

create table PARTICITY_offer_citm (
	companyId LONG not null,
	itemId LONG not null,
	offerId LONG not null,
	primary key (itemId, offerId)
);

create table PARTICITY_sub_citm (
	companyId LONG not null,
	itemId LONG not null,
	subId LONG not null,
	primary key (itemId, subId)
);