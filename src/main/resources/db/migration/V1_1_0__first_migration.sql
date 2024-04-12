alter table if exists pharmacy_branch
drop constraint if exists fk_pharmacy_id;
alter table if exists pharmacy_branch
drop constraint if exists fk_pharmacy_branch_address_id;
alter table if exists stock
drop constraint if exists fk_medicine_id;
alter table if exists stock
drop constraint if exists fk_pharmacy_branch_id;
drop table if exists medicines cascade;
drop table if exists pharmacy cascade;
drop table if exists pharmacy_branch cascade;
drop table if exists pharmacy_branch_address cascade;
drop table if exists stock cascade;
create table medicines (
        medicine_id bigserial not null,
        medicine_form varchar(255) check (medicine_form in ('LIQUID','TABLET','INJECTION')),
        name varchar(255),
        primary key (medicine_id)
);
create table pharmacy (
        pharmacy_id bigserial not null,
        name varchar(255) unique,
        primary key (pharmacy_id)
);
create table pharmacy_branch (
        pharmacy_branch_address_id bigint unique,
        pharmacy_branch_id bigserial not null,
        pharmacy_id bigint,
        primary key (pharmacy_branch_id)
);
create table pharmacy_branch_address (
        pharmacy_branch_address_id bigserial not null,
        city varchar(255),
        country varchar(255),
        street varchar(255),
        primary key (pharmacy_branch_address_id)
);
create table stock (
        on_stock integer,
        medicine_id bigint,
        pharmacy_branch_id bigint,
        stock_id bigserial not null,
        primary key (stock_id)
);
alter table if exists pharmacy_branch
       add constraint fk_pharmacy_id
       foreign key (pharmacy_id)
       references pharmacy;
alter table if exists pharmacy_branch
       add constraint fk_pharmacy_branch_address_id
       foreign key (pharmacy_branch_address_id)
       references pharmacy_branch_address;
alter table if exists stock
       add constraint fk_medicine_id
       foreign key (medicine_id)
       references medicines;
alter table if exists stock
       add constraint fk_pharmacy_branch_id
       foreign key (pharmacy_branch_id)
       references pharmacy_branch;
