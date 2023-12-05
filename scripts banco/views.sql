create view hotel.ver_dono_carro
as
	Select 
		 CONCAT(prenome,' ',sobrenome) as 'Dono do carro',telefone, E.cpf, modelo, placa
	from 
		 hotel.Estacionamento E join hotel.Hospedes H
		 on H.cpf = E.cpf

select * from hotel.ver_dono_carro



create view hotel.ver_especificacoes_reserva
as
	Select
		CONCAT(prenome, ' ' ,sobrenome) as 'Dono da Reserva',R.cpf as 'CPF', quantidadeDePessoas as 'Quantidade de Pessoas',observacao as 'Observações', Q.numeroQuarto as 'Numero do Quarto', andar as 'Andar',especificacao as 'Especificações',  dia_checkin as 'Dia do Check-in', dia_checkout as 'Dia do Check-out'
	from 
		((hotel.Quarto Q join hotel.TipoQuarto T on Q.id_Tipo = T.id_Tipo)Join hotel.Reserva R on Q.numeroQuarto = R.numeroQuarto)Join hotel.Hospedes H on H.cpf = R.cpf 

select * from hotel.ver_especificacoes_reserva


create view hotel.exibe_hospede
as 
	SELECT codigoCliente, prenome, sobrenome,cpf, telefone ,e_mail, rg, sexo, inativo 
	FROM hotel.Hospedes 

select * from hotel.exibe_hospede


create view hotel.exibe_quartos
as
	SELECT andar, numeroQuarto, id_Tipo 
	FROM hotel.Quarto 

select * from hotel.exibe_quartos

create view hotel.exibe_reserva
as
	SELECT id_Reserva, cpf, numeroQuarto, quantidadeDePessoas ,observacao, dia_checkin, dia_checkout 
	FROM hotel.Reserva 

select * from hotel.exibe_reserva


create view hotel.exibe_tipo
as 
	SELECT especificacao,id_Tipo  
	FROM hotel.TipoQuarto 

select * from hotel.exibe_tipo

create view hotel.vercarro
as
	select * from hotel.Estacionamento
