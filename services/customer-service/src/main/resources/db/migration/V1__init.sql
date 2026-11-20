create table if not exists customer (id uuid primary key, name varchar(255) not null, email varchar(255), phone varchar(255), created_at timestamp with time zone not null);
