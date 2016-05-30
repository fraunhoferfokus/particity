create index IX_E54ADF41 on AHADDR (regionId);

create index IX_A71EEAAC on AHCATS (name[$COLUMN_LENGTH:75$], type_);
create index IX_573A6FCB on AHCATS (type_);

create index IX_B2FE824C on AHCITEM (catId);
create index IX_F1866C97 on AHCITEM (itemId);
create index IX_35DCDCEE on AHCITEM (parentId);

create index IX_E76EE6ED on AHCONTACT (email[$COLUMN_LENGTH:75$]);
create index IX_25337351 on AHCONTACT (forename[$COLUMN_LENGTH:75$], surname[$COLUMN_LENGTH:75$]);

create index IX_8CA6CC20 on AHOFFER (adressId);
create index IX_561A98B5 on AHOFFER (orgId, status, expires, publish);
create index IX_91D88E3C on AHOFFER (status, expires, publish);
create index IX_6893ADAD on AHOFFER (title[$COLUMN_LENGTH:75$]);

create index IX_BAD3F42 on AHORG (name[$COLUMN_LENGTH:75$]);
create index IX_C47AA980 on AHORG (owner[$COLUMN_LENGTH:75$]);
create index IX_B65359A9 on AHORG (status);

create index IX_DA777C51 on AHREGION (city[$COLUMN_LENGTH:75$], zip[$COLUMN_LENGTH:75$]);
create index IX_51F20D2D on AHREGION (country[$COLUMN_LENGTH:75$], city[$COLUMN_LENGTH:75$], zip[$COLUMN_LENGTH:75$]);
create index IX_AE300C04 on AHREGION (regionId);
create index IX_13FAF2D0 on AHREGION (zip[$COLUMN_LENGTH:75$]);

create index IX_A2CB361D on AHSUBSCR (email[$COLUMN_LENGTH:75$]);
create index IX_FF43F485 on AHSUBSCR (uuid_[$COLUMN_LENGTH:75$]);

create index IX_41F3E162 on PARTICITY_offer_citm (companyId);
create index IX_C462C088 on PARTICITY_offer_citm (itemId);
create index IX_BCB545C1 on PARTICITY_offer_citm (offerId);

create index IX_942324C6 on PARTICITY_sub_citm (companyId);
create index IX_4B74D7A4 on PARTICITY_sub_citm (itemId);
create index IX_90C6FB09 on PARTICITY_sub_citm (subId);