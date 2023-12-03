class Reserva{
    #idReserva
    #cpf
    #numeroQuarto
    #quantidadeDePessoas
    #observacao
    #dia_checkin
    #dia_checkout

    constructor( idReserva,cpf, numeroQuarto, quantidadeDePessoas, observacao,dia_checkin,dia_checkout){
        this.idReserva = idReserva;
        this.cpf = cpf;
        this.numeroQuarto = numeroQuarto;
        this.quantidadeDePessoas = quantidadeDePessoas;
        this.observacao = observacao;
        this.dia_checkin = dia_checkin;
        this.dia_checkout = dia_checkout;
    }

    get idReserva(){
        return this.#idReserva;
    }

    get cpf(){
        return this.#cpf;
    }

    get numeroQuarto(){
        return this.#numeroQuarto;
    }

    get quantidadeDePessoas(){
        return this.#quantidadeDePessoas;
    }

    get observacao(){
        return this.#observacao;
    }

    get dia_checkin(){
        return this.#dia_checkin;
    }

    get dia_checkout(){
        return this. #dia_checkout;
    }


    set idReserva(idReserva){
        if(idReserva===undefined || typeof idReserva !== 'number' || isNaN(idReserva) || idReserva!==parseInt(idReserva) || idReserva<=0){
            throw('ID da Reserva invalido');
        }
        this.#idReserva = idReserva;
    }

    set cpf(cpf){
        if(cpf===undefined || typeof cpf !== 'number' || isNaN(cpf) || cpf!==parseInt(cpf) || cpf<=0){
            throw('Cpf invalido');
        }
        this.#cpf = cpf;
    }

    set numeroQuarto(numeroQuarto){
        if(numeroQuarto===undefined || typeof numeroQuarto !== 'number' || isNaN(numeroQuarto) || numeroQuarto!==parseInt(numeroQuarto) || numeroQuarto<=0){
            throw('Número do quarto invalido');
        }
        this.#numeroQuarto = numeroQuarto;
    }

    set quantidadeDePessoas(quantidadeDePessoas){
        if(quantidadeDePessoas===undefined || typeof quantidadeDePessoas !== 'number' || isNaN(quantidadeDePessoas) || quantidadeDePessoas!==parseInt(quantidadeDePessoas) || quantidadeDePessoas<=0){
            throw('Quantidades de pessoas invalida');
        }
        this.#quantidadeDePessoas = quantidadeDePessoas;
    }

    set observacao(observacao){
        if (observacao===undefined || typeof observacao !== 'String'){
            throw('observacao invalida')
        }
        this.#observacao = observacao;
    }

    set dia_checkin(dia_checkin){
        if(dia_checkin===undefined || typeof dia_checkin !== 'number' || isNaN(dia_checkin) || dia_checkin!==parseInt(dia_checkin) || dia_checkin<=0){
            throw('dia_checkin invalido');
        }
        this.#dia_checkin = dia_checkin;
    }

    set dia_checkout(dia_checkout){
        if(dia_checkout===undefined || typeof dia_checkout !== 'number' || isNaN(dia_checkout) || dia_checkout!==parseInt(dia_checkout) || dia_checkout<=0){
            throw('dia_checkout invalido');
        }
        this.#dia_checkout = dia_checkout;
    }
}

function novaRes(cpf, numeroQuarto, quantidadeDePessoas, observacao,dia_checkin,dia_checkout){
    return new Tpquarto(cpf, numeroQuarto, quantidadeDePessoas, observacao,dia_checkin,dia_checkout);
}

function selectRes(){
    return new Tpquarto();
}

module.exports = {novaRes, selectRes}