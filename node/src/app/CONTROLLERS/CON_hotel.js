const e = require("express");
const bd = require("../../config/database")
const hotelDAO = require("../BD/DAO_hotel")



class CON_hotel {

    //listagens

    exibequarto() {
        return function(req,res) {
            const hDAO = new hotelDAO(bd);
            hDAO.exibequartos() 
              .then((resultados) => {
                 console.log(resultados);
                 res.render('../views/quarto', { quarto: Array.isArray(resultados.recordset) ? resultados.recordset : [resultados.recordset] });
              })
              .catch(erro => console.log(erro));
        }
    }

    exibeestacionamento() {
        return function(req,res) {
            const hDAO = new hotelDAO(bd);
            hDAO.exibeesta() 
              .then((resultados) => {
                 console.log(resultados);
                 res.render('../views/estacionamento', { esta: Array.isArray(resultados.recordset) ? resultados.recordset : [resultados.recordset] });
              })
              .catch(erro => console.log(erro));
        }
    }

    exibehospede() {
        return function(req,res) {
            const hDAO = new hotelDAO(bd);
            hDAO.exibehospede() 
              .then((resultados) => {
                 console.log(resultados);
                 res.render('../views/hospede', { hospede: Array.isArray(resultados.recordset) ? resultados.recordset : [resultados.recordset] });
              })
              .catch(erro => console.log(erro));
        }
    }

    exibereserva() {
        return function(req,res) {
            const hDAO = new hotelDAO(bd);
            hDAO.exibereserva() 
              .then((resultados) => {
                 console.log(resultados);
                 res.render('../views/reserva', { reserva: Array.isArray(resultados.recordset) ? resultados.recordset : [resultados.recordset] });
              })
              .catch(erro => console.log(erro));
        }
    }

    exibetipo() {
        return function(req,res) {
            const hDAO = new hotelDAO(bd);
            hDAO.exibetipo() 
              .then((resultados) => {
                 console.log(resultados);
                 res.render('../views/tipoquarto', { tipo: Array.isArray(resultados.recordset) ? resultados.recordset : [resultados.recordset] });
              })
              .catch(erro => console.log(erro));
        }
    }

    //deletes

    deletaesta() {
        return function(req,res) {
            // const arduino = require("../../config/arduino");
            // const ardu = new arduino();
            const hDAO = new hotelDAO(bd);
            let id = req.params.id_Vaga
            hDAO.excluicarro(id) 
              .then((resultados) => {
                 console.log(resultados);
                 res.redirect('/listagemestacionamento')
                //  ardu.removerSucesso();, ardu.removerErro()
              })
              .catch(erro => console.log(erro));
        }
    }

    deletahospede() {
        return function(req,res) {
            // const arduino = require("../../config/arduino");
            // const ardu = new arduino();
            const hDAO = new hotelDAO(bd);
            let id = req.params.codigoCliente
            hDAO.excluihospede(id) 
              .then((resultados) => {
                console.log(resultados);
                // ardu.removerSucesso();, ardu.removerErro()
             })
              .catch(erro => console.log(erro));
        }
    }

    deletaquarto() {
        return function(req,res) {
            // const arduino = require("../../config/arduino");
            // const ardu = new arduino();
            const hDAO = new hotelDAO(bd);
            let id = req.params.numeroQuarto
            hDAO.excluiquarto(id) 
              .then((resultados) => {
                 console.log(resultados);
                // ardu.removerSucesso();, ardu.removerErro()
              })
              .catch(erro => console.log(erro));
        }
    }

    deletareserva() {
        return function(req,res) {
            // const arduino = require("../../config/arduino");
            // const ardu = new arduino();
            const hDAO = new hotelDAO(bd);
            let id = req.params.id_Reserva
            hDAO.excluireserva(id) 
              .then((resultados) => {
                 console.log(resultados);
                 res.redirect('/listagemreservas')

                // ardu.removerSucesso();, ardu.removerErro()
              })
              .catch(erro => console.log(erro));
        }
    }

    deletatipo() {
        return function(req,res) {
            // const arduino = require("../../config/arduino");
            // const ardu = new arduino();
            const hDAO = new hotelDAO(bd);
            let id = req.params.id_Tipo
            hDAO.excluitipo(id) 
              .then((resultados) => {
                 console.log(resultados);
                // ardu.removerSucesso();, ardu.removerErro(
              })
              .catch(erro => console.log(erro));
        }
    }

    //edições

    editacarro() {
        return function(req,res) {
            // const arduino = require("../../config/arduino");
            // const ardu = new arduino();
            var cor = req.body.cor
            var modelo = req.body.modelo
            var placa = req.body.placa
            var id = req.params.id_Vaga
            const hDAO = new hotelDAO(bd);
            hDAO.editacarro(cor,modelo,placa,id)
                .then((resultados) => {
                    res.redirect('/listagemestacionamento')
                    // ardu.editarSucesso();, ardu.editarErro()
                })
                .catch(erro => console.log(erro))
        }
    }

    editahospede() {
        return function(req,res) {
            // const arduino = require("../../config/arduino");
            // const ardu = new arduino();
            var prenome = req.body.nome
            var sobrenome = req.body.sobrenome
            var cpf = req.body.cpf
            var telefone = req.body.telefone
            var email = req.body.email
            var rg = req.body.rg
            var sexo = req.body.sexo
            var inativo = req.body.inativo
            var id = req.params.codigoCliente
            const hDAO = new hotelDAO(bd);
            hDAO.editahospede(prenome,sobrenome,cpf,telefone,email,rg,sexo,inativo,id)
                .then((resultados) => {
                    res.redirect('/listagemhospedes')
                    // ardu.editarSucesso();, ardu.editarErro()
                })
                .catch(erro => console.log(erro))
        }
    }

    editareserva() {
        return function(req,res) {
            // const arduino = require("../../config/arduino");
            // const ardu = new arduino();
            var nquarto = req.body.quarto
            var qpessoas = req.body.pessoas
            var obs = req.body.obs
            var diain = req.body.in
            var diaout = req.body.out
            var id = req.params.id_Reserva
            const hDAO = new hotelDAO(bd);
            hDAO.editareserva(nquarto,qpessoas,obs,diain,diaout,id)
                .then((resultados) => {
                    res.redirect('/listagemreserva')
                    // ardu.editarSucesso();, ardu.editarErro()
                })
                .catch(erro => console.log(erro));
        }
    }

    editatipo() {
        return function(req,res) {
            // const arduino = require("../../config/arduino");
            // const ardu = new arduino();
            var esp = req.body.esp
            var id = req.params.id_Tipo
            const hDAO = new hotelDAO(bd);
            hDAO.editatipo(esp,id)
                .then((resultados) => {
                    res.redirect('/listagemTipoQuarto')
                    // ardu.editarSucesso();ardu.editarErro()
                })
                .catch(erro => console.log(erro));
        }
    }

    editaquarto() {
        return function(req,res) {
            // const arduino = require("../../config/arduino");
            // const ardu = new arduino();
            var an = req.body.an
            var tipo = req.body.tipo
            var id = req.params.numeroQuarto
            const hDAO = new hotelDAO(bd);
            hDAO.editaquarto(an,tipo,id)
                .then((resultados) => {
                    res.redirect('/listagemquarto')
                    // ardu.editarSucesso();, ardu.editarErro()
                })
                .catch(erro => console.log(erro));
        }
    }


}

module.exports = CON_hotel