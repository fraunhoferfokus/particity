create index IX_96845B90 on ADHOC_offer_citm (itemId);
create index IX_2EC70BB9 on ADHOC_offer_citm (offerId);

create index IX_41D194AC on ADHOC_sub_citm (itemId);
create index IX_1CDA7D01 on ADHOC_sub_citm (subId);

create index IX_E54ADF41 on AHADDR (regionId);

create index IX_7B60B309 on AHCATS (name);
create index IX_A71EEAAC on AHCATS (name, type_);
create index IX_573A6FCB on AHCATS (type_);

create index IX_B2FE824C on AHCITEM (catId);
create index IX_F1866C97 on AHCITEM (itemId);
create index IX_35DCDCEE on AHCITEM (parentId);

create index IX_E76EE6ED on AHCONTACT (email);
create index IX_25337351 on AHCONTACT (forename, surname);

create index IX_8CA6CC20 on AHOFFER (adressId);
create index IX_6EA904B4 on AHOFFER (orgId);
create index IX_FC511034 on AHOFFER (orgId, expires, expires);
create index IX_561A98B5 on AHOFFER (orgId, status, expires, publish);
create index IX_67F268E1 on AHOFFER (status);
create index IX_91D88E3C on AHOFFER (status, expires, publish);
create index IX_6893ADAD on AHOFFER (title);

create index IX_BAD3F42 on AHORG (name);
create index IX_C47AA980 on AHORG (owner);
create index IX_B65359A9 on AHORG (status);

create index IX_4426ECC0 on AHREGION (city);
create index IX_DA777C51 on AHREGION (city, zip);
create index IX_51F20D2D on AHREGION (country, city, zip);
create index IX_AE300C04 on AHREGION (regionId);
create index IX_13FAF2D0 on AHREGION (zip);

create index IX_A2CB361D on AHSUBSCR (email);
create index IX_FF43F485 on AHSUBSCR (uuid_);