create trigger verificadata
on hotel.Reserva
for insert,update 
as
Begin
	set nocount on;
	declare @diac date, @diao date, @id int
	select @diac = dia_checkin, @diao = dia_checkout, @id = id_Reserva from inserted
	if @diac < GETDATE()
	Begin
		raiserror('O dia do check-in não pode ser antes de hoje',15,1);
		delete  from hotel.Reserva where id_Reserva = @id
	end
	if @diao < @diac
	begin
		raiserror('O dia do check-out não pode ser antes do dia do check-in',16,1);
		delete  from hotel.Reserva where id_Reserva = @id
	end
End

