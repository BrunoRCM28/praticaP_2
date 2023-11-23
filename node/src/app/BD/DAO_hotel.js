class DAO_hotel {
    
    constructor(bd) {
        this._bd = bd;
    }

    //listagens

    exibequartos() {
        return new Promise((resolve, reject) => 
        {
            var sql = "SELECT andar, numeroQuarto, id_Tipo FROM hotel.Quarto ORDER by id_Tipo"
            this._bd.query(sql,function(erro,recordset) 
            {
            if (erro) 
            {
                console.log(erro);
                return reject("Lista de quartos FALHOU!");
            }
            resolve(recordset);
            });
        });
    }

    exibeesta() {
        return new Promise((resolve, reject) => 
        {
            var sql = "SELECT id_Vaga, cpf, cor, modelo ,placa FROM hotel.Estacionamento ORDER by id_Vaga"
            this._bd.query(sql,function(erro,recordset) 
            {
            if (erro) 
            {
                console.log(erro);
                return reject("Lista de vagas FALHOU!");
            }
            resolve(recordset);
            });
        });
    }

    exibehospede() {
        return new Promise((resolve, reject) => 
        {
            var sql = "SELECT codigoCliente, prenome, sobrenome, telefone ,e_mail, rg, sexo, inativo FROM hotel.Hospedes ORDER by codigoCliente"
            this._bd.query(sql,function(erro,recordset) 
            {
            if (erro) 
            {
                console.log(erro);
                return reject("Lista de hospedes FALHOU!");
            }
            resolve(recordset);
            });
        });
    }

    exibereserva() {
        return new Promise((resolve, reject) => 
        {
            var sql = "SELECT id_Reserva, cpf, numeroQuarto, quantidadeDePessoas ,observacao, dia_checkin, dia_checkout FROM hotel.Reserva ORDER by id_Reserva"
            this._bd.query(sql,function(erro,recordset) 
            {
            if (erro) 
            {
                console.log(erro);
                return reject("Lista de reserva FALHOU!");
            }
            resolve(recordset);
            });
        });
    }

    exibetipo() {
        return new Promise((resolve, reject) => 
        {
            var sql = "SELECT especificacao,id_Tipo  FROM hotel.TipoQuarto ORDER by id_Tipo"
            this._bd.query(sql,function(erro,recordset) 
            {
            if (erro) 
            {
                console.log(erro);
                return reject("Lista de tipo FALHOU!");
            }
            resolve(recordset);
            });
        });
    }

    //delete

    excluicarro(idcarro) {
        return new Promise((resolve,req) => {
            var sql = "Delete from hotel.estacionamento where id_Vaga = (" + idcarro + ")";
            console.log(sql)
            this._bd.query(sql,function(erro,recordset) {
                if(erro) {
                    console.log(erro);
                    return("Listagem de tipos falhou")
                }
                resolve(recordset);
            });
        });
    }

    excluihospede(idhospede) {
        return new Promise((resolve,req) => {
            var sql = "Delete from hotel.Hospedes where codigoCliente = (" + idhospede + ")";
            console.log(sql)
            this._bd.query(sql,function(erro,recordset) {
                if(erro) {
                    console.log(erro);
                    return("Listagem de tipos falhou")
                }
                resolve(recordset);
            });
        });
    }

    excluiquarto(idquarto) {
        return new Promise((resolve,req) => {
            var sql = "Delete from hotel.Quarto where numeroQuarto = (" + idquarto + ")";
            console.log(sql)
            this._bd.query(sql,function(erro,recordset) {
                if(erro) {
                    console.log(erro);
                    return("Listagem de tipos falhou")
                }
                resolve(recordset);
            });
        });
    }

    excluireserva(idreserva) {
        return new Promise((resolve,req) => {
            var sql = "Delete from hotel.reserva where id_Reserva = (" + idreserva + ")";
            console.log(sql)
            this._bd.query(sql,function(erro,recordset) {
                if(erro) {
                    console.log(erro);
                    return("Listagem de tipos falhou")
                }
                resolve(recordset);
            });
        });
    }

    excluitipo(idtipo) {
        return new Promise((resolve,req) => {
            var sql = "Delete from hotel.TipoQuarto where id_Tipo = (" + idtipo + ")";
            console.log(sql)
            this._bd.query(sql,function(erro,recordset) {
                if(erro) {
                    console.log(erro);
                    return("Listagem de tipos falhou")
                }
                resolve(recordset);
            });
        });
    }

}

module.exports = DAO_hotel