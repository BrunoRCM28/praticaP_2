create or alter procedure hotel.sp1
 @nump int
 as begin
	begin
	delete from hotel.Reserva where id_Reserva = @nump
	end
 end


create or alter procedure hotel.deletaesta
@id int
as begin
	begin
	delete from hotel.Estacionamento where id_Vaga = @i
	end
end

DELETE FROM hotel.Hospedes WHERE codigoCliente = 

select * from hotel.Hospedes