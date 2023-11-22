insert into hotel.TipoQuarto(especificacao)
values('solteiro'),
	  ('casal'),
	  ('familia pequena'),
	  ('familia grande')
	  
select * from hotel.TipoQuarto

insert into hotel.Quarto(andar, numeroQuarto, id_Tipo)
values (1, 1, 3),
	   (1, 2, 3),
	   (1, 3, 1),
	   (1, 4, 2),
	   (2, 5, 1),
	   (2, 6, 1),
	   (2, 7, 2),
	   (2, 8, 4),
	   (2, 9, 3),
	   (3, 10, 2),
	   (3, 11, 2),
	   (3, 12, 3),
	   (3, 13, 1)


select * from hotel.Quarto

select Q.numeroQuarto, Q.id_Tipo, T.especificacao
from hotel.TipoQuarto as T,
	 hotel.Quarto as Q
where Q.numeroQuarto = 2 and
	  Q.id_Tipo = T.id_Tipo

select Q.numeroQuarto, Q.andar, T.especificacao
from hotel.Quarto as Q,
	 hotel.TipoQuarto as T
where T.id_Tipo = Q.id_Tipo


insert into hotel.Hospedes(prenome , sobrenome, cpf, telefone, e_mail, rg, sexo)
values('Bruno', 'Moraes', 99999999999, 19222222222, 'bruno@gmail.com', 750232312, 'M')

select * from hotel.Hospedes

insert into hotel.Reserva(cpf, numeroQuarto, quantidadeDePessoas, observacao,dia_checkin,dia_checkout)
values(99999999999, 2, 3, 'Deixar sem travesseiros',Convert(date, '21-11-2023',103),Convert(date, '24-11-2023',103))

select * from hotel.Reserva

insert into hotel.Estacionamento(cpf, cor, modelo, placa)
values(99999999999, 'azul', 'kwid', '23es2r3')

select * from hotel.Estacionamento

select R.id_Reserva as 'Reserva', H.prenome + ' ' + H.sobrenome as 'Nome', T.especificacao as 'Tipo Quarto'
from hotel.Hospedes as H,
	 hotel.Reserva as R,
	 hotel.TipoQuarto as T,
	 hotel.Quarto as Q
where H.prenome = 'Bruno' and
	  H.cpf = R.cpf and 
	  R.numeroQuarto = Q.numeroQuarto and
	  Q.id_tipo = T.id_Tipo

select H.prenome + ' ' + H.sobrenome, H.cpf, R.id_Reserva, R.numeroQuarto, T.especificacao, E.placa
from hotel.Hospedes as H,
	 hotel.Reserva as R, 
	 hotel.Estacionamento as E,
	 hotel.TipoQuarto as T,
	 hotel.Quarto as Q
where H.prenome = 'Bruno' and
	  H.cpf = R.cpf and
	  T.id_Tipo = Q.id_Tipo


select H.codigoCliente, H.prenome + ' ' + H.sobrenome, H.cpf, R.id_Reserva, R.numeroQuarto, T.especificacao, E.placa
from hotel.Hospedes AS H
	 JOIN hotel.Reserva AS R ON H.cpf = R.cpf
	 JOIN hotel.Estacionamento AS E ON H.cpf = E.cpf
	 JOIN hotel.Quarto AS Q ON R.numeroQuarto = Q.numeroQuarto
	 JOIN hotel.TipoQuarto AS T ON T.id_Tipo = Q.id_Tipo 
WHERE H.inativo = 0


UPDATE hotel.Hospedes 
SET inativo = 0
WHERE cpf = 99999999999


	 
