class Quarto{
    #andar
    #numeroQuarto
    #idTipo

    constructor(andar, numeroQuarto, idTipo){
        this.andar = andar;
        this.numeroQuarto = numeroQuarto;
        this.idTipo = idTipo;
    }

    get andar(){
        return this.#andar;
    }

    get numeroQuarto(){
        return this.#numeroQuarto;
    }

    get idTipo(){
        return this.#idTipo;
    }

    set andar (andar){
        if (andar===undefined || typeof andar !== 'number' || isNaN(andar) || andar!==parseInt(andar) || andar<=0){
            throw ('Andar inválido');
        }
        this.#andar = andar;
    }

    set numeroQuarto (numeroQuarto){
        if (numeroQuarto===undefined || typeof numeroQuarto !== 'number' || isNaN(numeroQuarto) || numeroQuarto!==parseInt(numeroQuarto) || numeroQuarto<=0){
            throw ('Número Quarto inválido');
        }
        this.#numeroQuarto = numeroQuarto;
    }

    set idTipo (idTipo){
        if (idTipo===undefined || typeof idTipo !== 'number' || isNaN(idTipo) || idTipo!==parseInt(idTipo) || idTipo<=0){
            throw ('Id do Tipo inválido');
        }
        this.#idTipo = idTipo;
    }
}

function novoQuarto(andar, numero, id){
    return new Quarto(andar, numero, id);
}

function selectQuarto(){
    return new Quarto();
}

module.exports = {novoQuarto, selectQuarto};