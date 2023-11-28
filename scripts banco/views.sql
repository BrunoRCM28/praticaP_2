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