Data for the first filling database

insert into client (first_name, last_name)
values ('Ivan', 'Ivanov');

select * from client;

insert into bill (cashback, deposit, client_id)
values (0, 5000, 1);

select * from bill;

select * from client
                   left join bill b on client.id = b.client_id
where client_id = 1;

select * from transaction;