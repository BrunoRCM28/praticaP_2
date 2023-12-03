class Estacionamento{
    #idVaga
    #cpf
    #cor
    #modelo
    #placa

    constructor(idVaga, cpf, cor, modelo, placa){
        this.idVaga = idVaga
        this.cpf = cpf;
        this.cor = cor;
        this.modelo = modelo;
        this.placa = placa;
    }

    get idVaga(){
        return this.#idVaga;
    }

    get cpf(){
        return this.#cpf;
    }

    get cor(){
        return this.#cor;
    }

    get modelo(){
        return this.#modelo;
    }

    get placa(){
        return this.#placa;
    }

    set idVaga(idVaga){
        if(idVaga===undefined || typeof idVaga !== 'number' || isNaN(idVaga) || idVaga!==parseInt(idVaga) || idVaga<=0){
            throw('Cpf invalido');
        }
        this.#idVaga = idVaga;
    }

    set cpf(cpf){
        if(cpf===undefined || typeof cpf !== 'number' || isNaN(cpf) || cpf!==parseInt(cpf) || cpf<=0){
            throw('Cpf invalido');
        }
        this.#cpf = cpf;
    }

    set cor(cor){
        if (cor===undefined || typeof cor !== 'String'){
            throw('Cor invalida')
        }
        this.#cor = cor;
    }

    set modelo(modelo){
        if (modelo===undefined || typeof modelo !== 'String'){
            throw('Modelo invalida')
        }
        this.#modelo = modelo;
    }

    set placa(placa){
        if (placa===undefined || typeof placa !== 'String'){
            throw('Placa invalida')
        }
        this.#placa = placa;
    }
}

function novaEsta(cpf, cor, modelo, placa){
    return new Estacionamento(cpf, cor, modelo, placa);
}

function selectEsta(){
    return new Estacionamento();
}

module.exports = {novaEsta, selectEsta}