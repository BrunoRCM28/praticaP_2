create or alter procedure hotel.sp1
 @nump int
 as begin
	begin
	delete from hotel.Reserva where id_Reserva = @nump
	end
 end
