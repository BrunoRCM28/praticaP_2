class Tpquarto
{
    #especificacao
    #idtipo

    constructor(idtipo,especificacao){
        this.especificacao = especificacao;
        this.idtipo = idtipo;
    }

    get idtipo(){
        return this.#idtipo
    }

    get especificacao(){
        return this.#especificacao
    }

    set idtipo (idtipo)
    {
        if (idtipo===undefined || typeof idtipo !== 'number' || isNaN(idtipo) || idtipo!==parseInt(idtipo) || idtipo<=0)
            throw ('idtipo inválido');

        this.#idtipo = idtipo;
    }

    set especificacao(especificacao){
        if (especificacao===undefined || typeof especificacao !== 'String'){
            throw('Especificação invalida')
        }
        this.#especificacao = especificacao;
    }
}

function novaesp(especificacao){
    return new Tpquarto(especificacao);
}

function selectesp(){
    return new Tpquarto();
}

module.exports = {novaesp,selectesp}