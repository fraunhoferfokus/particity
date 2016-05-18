create table ADHOC_offer_citm (
	itemId LONG not null,
	offerId LONG not null,
	primary key (itemId, offerId)
);

create table ADHOC_sub_citm (
	itemId LONG not null,
	subId LONG not null,
	primary key (itemId, subId)
);

create table AHADDR (
	addrId LONG not null primary key,
	street VARCHAR(160) null,
	number_ VARCHAR(75) null,
	coordLat DOUBLE,
	coordLon DOUBLE,
	regionId LONG
);

create table AHCATS (
	catId LONG not null primary key,
	name VARCHAR(80) null,
	descr STRING null,
	type_ INTEGER
);

create table AHCFG (
	name VARCHAR(75) not null primary key,
	value STRING null
);

create table AHCITEM (
	itemId LONG not null primary key,
	catId LONG,
	name VARCHAR(80) null,
	descr STRING null,
	parentId LONG
);

create table AHCONTACT (
	contactId LONG not null primary key,
	forename VARCHAR(80) null,
	surname VARCHAR(80) null,
	tel VARCHAR(80) null,
	mobile VARCHAR(80) null,
	fax VARCHAR(80) null,
	email VARCHAR(80) null,
	www VARCHAR(160) null
);

create table AHOFFER (
	offerId LONG not null primary key,
	title STRING null,
	description STRING null,
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
	name VARCHAR(160) null,
	holder VARCHAR(160) null,
	owner VARCHAR(75) null,
	userlist STRING null,
	description STRING null,
	legalStatus VARCHAR(80) null,
	created LONG,
	updated LONG,
	contactId LONG,
	addressId LONG,
	status INTEGER,
	logoLocation STRING null
);

create table AHREGION (
	regionId LONG not null,
	zip VARCHAR(75) not null,
	city VARCHAR(160) not null,
	country VARCHAR(160) not null,
	permissions INTEGER,
	primary key (regionId, zip, city, country)
);

create table AHSUBSCR (
	subId LONG not null primary key,
	uuid_ VARCHAR(75) null,
	email VARCHAR(80) null,
	status INTEGER,
	created LONG
);

create table PARTICITY_offer_citm (
	itemId LONG not null,
	offerId LONG not null,
	primary key (itemId, offerId)
);

create table PARTICITY_sub_citm (
	itemId LONG not null,
	subId LONG not null,
	primary key (itemId, subId)
);