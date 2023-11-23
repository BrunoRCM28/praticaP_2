
create or alter trigger hotel.removedependencias1
on hotel.Hospedes
instead of delete
as 
begin
	set nocount on;
	declare @cpf int
	select @cpf = cpf from deleted
	delete from hotel.Estacionamento where cpf = @cpf
	delete from hotel.Hospedes where cpf = @cpf
end





create or alter trigger hotel.removedependencias2
on hotel.TipoQuarto
instead of delete
as 
begin
	set nocount on;
	declare @id int
	select @id = id_Tipo from deleted
	delete from hotel.Quarto where id_Tipo = @id
	delete from hotel.TipoQuarto where id_Tipo = @id
end

