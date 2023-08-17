drop table if exists events;
create table events (id bigint auto_increment primary key,
buyerParty varchar(250),
sellerParty varchar(250),
premiumAmount double,
premiumCurrency varchar(250));