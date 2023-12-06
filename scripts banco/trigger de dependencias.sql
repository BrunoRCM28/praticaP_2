
create or alter trigger hotel.removedependencias1
on hotel.Hospedes
instead of delete
as 
begin
	set nocount on;
	declare @cpf bigint
	select @cpf = cpf from deleted
	delete from hotel.Estacionamento where cpf = @cpf
	delete from hotel.Reserva where cpf = @cpf
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



create or alter trigger verificahospedagem
on hotel.Estacionamento
for insert,update 
as
Begin
	set nocount on;
	declare @cpf int, @cpf2 int
	select @cpf = cpf from inserted
	select @cpf2 = cpf from hotel.Reserva where @cpf = cpf
	if @cpf2 = null
	begin
		raiserror('não existe reserva nesse cpf portanto não sera possivel registrar carro no estacionamento',16,1)
		delete from hotel.Estacionamento where cpf = @cpf
	end
End