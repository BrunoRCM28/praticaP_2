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
	delete from hotel.Estacionamento where id_Vaga = @id
	end
end

create or alter procedure hotel.deletahos
@id int
as begin
	begin
	delete from hotel.Hospedes where codigoCliente = @id
	end
end

create or alter procedure hotel.deletaquarto
@id int
as begin
	begin
	delete from hotel.Quarto where numeroQuarto = @id
	end
end

create or alter procedure hotel.deletatipo
@id int 
as begin
	begin
	delete from hotel.TipoQuarto where id_Tipo = @id
	end
end

create or alter procedure hotel.inserehos
@nome varchar(25),@sobrenome varchar(25),@cpf bigint,@telefone bigint,@email varchar(50),@rg bigint, @sexo char(1)
as begin
	begin
		insert into hotel.Hospedes(prenome,sobrenome,cpf,telefone,e_mail,rg,sexo) values (@nome,@sobrenome,@cpf,@telefone,@email,@rg,@sexo)
	end
end