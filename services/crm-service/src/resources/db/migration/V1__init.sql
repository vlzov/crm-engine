create table customer (id uuid primary key, name varchar(255) not null, email varchar(255), phone varchar(255), created_at timestamp with time zone not null);
create table deal (id uuid primary key, title varchar(255) not null, amount numeric(19,2), stage varchar(32) not null, customer_id uuid, created_at timestamp with time zone not null);
create table task_item (id uuid primary key, title varchar(255) not null, due_date date, completed boolean not null default false, customer_id uuid, deal_id uuid);
