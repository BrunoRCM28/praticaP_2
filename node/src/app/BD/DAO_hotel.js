class DAO_hotel {
    
    constructor(bd) {
        this._bd = bd;
    }

    //listagens

    exibequartos() {
        return new Promise((resolve, reject) => 
        {
            //SELECT andar, numeroQuarto, id_Tipo FROM hotel.Quarto ORDER by id_Tipo
            var sql = "select * from hotel.exibe_quartos";
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
            var sql = "SELECT * from hotel.vercarro"
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
            //SELECT codigoCliente, prenome, sobrenome,cpf, telefone ,e_mail, rg, sexo, inativo FROM hotel.Hospedes ORDER by codigoCliente
            var sql = "select * from hotel.exibe_hospede";
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

            //SELECT id_Reserva, cpf, numeroQuarto, quantidadeDePessoas ,observacao, dia_checkin, dia_checkout FROM hotel.Reserva ORDER by id_Reserva
            var sql = "select * from hotel.exibe_reserva";
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
            //SELECT especificacao,id_Tipo  FROM hotel.TipoQuarto ORDER by id_Tipo
            var sql = "select * from hotel.exibe_tipo";
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
                    return("exclusão do Estacionamento falhou")
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
                    return("exclusão de hospedes falhou")
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
                    return("exclusão de quartos falhou")
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
                    return("exclusão de reservas falhou")
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
                    return("exclusão dos tipos falhou")
                }
                resolve(recordset);
            });
        });
    }

    //editar

    editacarro(cor,modelo,placa,idvaga) {
        return new Promise((resolve,req) => {
            var sql2 = "Update hotel.Estacionamento set cor = ('" + cor + "'),modelo = ('" + modelo + "'),placa = ('" + placa + "') where id_Vaga = (" + idvaga + ")";
            console.log(sql2)
            this._bd.query(sql2,function(erro,recordset) {
                if(erro) {
                    console.log(erro);
                    return resolve("Edição do carro falhou")
                }
                resolve(recordset);
            });
        });
    }

    editahospede(prenome,sobrenome,cpf,telefone,email,rg,sexo,inativo,codcliente) {
        return new Promise((resolve,req) => {
            var sql2 = "Update hotel.Hospedes set prenome = ('" + prenome + "'),sobrenome = ('" + sobrenome + "'),cpf = ('" + cpf + "'),telefone = ('" + telefone + "'),e_mail = ('" + email + "'),rg = ('" + rg + "'),sexo = ('" + sexo + "'),inativo = ('" + inativo + "'), where codigoCliente = (" + codcliente + ")";
            console.log(sql2)
            this._bd.query(sql2,function(erro,recordset) {
                if(erro) {
                    console.log(erro);
                    return resolve("Edição de hospedes falhou")
                }
                resolve(recordset);
            });
        });
    }

    editareserva(numeroquarto,quantidadedepessoas,observacao,diacheckin,diacheckout,idreserva) {
        return new Promise((resolve,req) => {
            var sql2 = "Update hotel.Reserva set  numeroQuarto= ('" + numeroquarto + "'),quantidadeDePessoas = ('" + quantidadedepessoas + "'),observacao = ('" + observacao + "'),dia_checkin = Convert(date," + diacheckin + ",103),dia_checkout = Convert(date," + diacheckout + ",103) where id_Reserva = (" + idreserva + ")";
            console.log(sql2)
            this._bd.query(sql2,function(erro,recordset) {
                if(erro) {
                    console.log(erro);
                    return resolve("Edição de reservas falhou")
                }
                resolve(recordset);
            });
        });
    }

    editatipo(esp,idreserva) {
        return new Promise((resolve,req) => {
            var sql2 = "Update hotel.TipoQuarto set  especificacao= ('" + esp + "') where id_Tipo = (" + idreserva + ")";
            console.log(sql2)
            this._bd.query(sql2,function(erro,recordset) {
                if(erro) {
                    console.log(erro);
                    return resolve("Edição do tipos falhou")
                }
                resolve(recordset);
            });
        });
    }

    editaquarto(an,tipo,id) {
        return new Promise((resolve,req) => {
            var sql2 = "Update hotel.Quarto set  andar =  ('" + an + "'), id_tipo = ('"+tipo +"') where numeroQuarto = (" + id + ")";
            console.log(sql2)
            this._bd.query(sql2,function(erro,recordset) {
                if(erro) {
                    console.log(erro);
                    return resolve("Edição do Quartos falhou")
                }
                resolve(recordset);
            });
        });
    }

}

module.exports = DAO_hotel