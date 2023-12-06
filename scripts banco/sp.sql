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

exec hotel.inserehos 'rafael','alves',12345446,1996934923943,'rafael019wi@gmail.com',1203012031,M
select * from hotel.exibe_hospede

create or alter procedure hotel.inserereserva
@cpf bigint,@numq int,@qpessoa int,@observacao text,@diain varchar(20), @diaout varchar(20)
as begin
	begin
		insert into hotel.Reserva(cpf,numeroQuarto,quantidadeDePessoas,observacao,dia_checkin,dia_checkout) values (@cpf,@numq,@qpessoa,@observacao,CONVERT(date,@diain,103),CONVERT(date,@diaout,103))
	end
end

exec hotel.inserereserva 12345446,1,4,'sem agua', '14/09/2024','14/09/2025'
select * from hotel.Reserva

create or alter procedure hotel.inserecarro
@cpf bigint,@cor varchar(10),@modelo varchar(10),@placa text
as begin
	begin
		insert into hotel.Estacionamento(cpf,cor,modelo,placa) values(@cpf,@cor,@modelo,@placa)
	end
end

create or alter procedure hotel.updtesta
@cor varchar(10),@modelo varchar(10),@placa text,@id varchar(10)
as begin
	declare @cpf bigint
	Select @cpf = cpf from hotel.Estacionamento where id_Vaga = @id
	begin
		Update hotel.Estacionamento set cor = @cor,modelo = @modelo,placa = @placa where id_Vaga = @id and cpf = @cpf
	end
end

exec hotel.inserecarro 99999999999 ,'rosa','kwid','dasdws12'

exec hotel.updtesta 'rosa','kwid','23rs534','1'

select * from hotel.Estacionamento