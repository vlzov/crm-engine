create table if not exists deal (id uuid primary key, title varchar(255) not null, amount numeric(19,2), stage varchar(32) not null, customer_id uuid, created_at timestamp with time zone not null);
