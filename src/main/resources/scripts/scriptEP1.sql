/*Crear tabla*/
create table celular(
	id int,
	marca varchar(255),
	modelo varchar(255),
	sis_ope varchar(255),
	stock int
)

alter table celular add primary key (id);
alter table celular modify column id int auto_increment not null;

/*INSERTAR*/
insert into CELULAR (marca, modelo, sis_ope,stock) values('Apple', 'iPhone12','IOS',50);
insert into CELULAR (marca, modelo, sis_ope,stock) values('Samsung', 'S20+','Android',25);

/*ACTUALIZAR*/
update celular set modelo = 'iPhone14' where marca = 'Apple';

/*CONSULTAR*/
select * from celular

/*ELIMINAR*/
delete from celular where id=1

-----------------------------STORE PROCEDURE--------------------------

/*READ*/
create procedure getAllCelulares()
begin
	select * from celular;
end


call getAllCelulares();