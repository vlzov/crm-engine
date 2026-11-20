create table if not exists task_item (id uuid primary key, title varchar(255) not null, due_date date, completed boolean not null default false, customer_id uuid, deal_id uuid);
