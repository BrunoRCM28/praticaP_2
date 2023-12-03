class Hospedes{
    #idHospedes
    #prenome
    #sobrenome
    #cpf
    #telefone
    #email
    #rg
    #sexo

    constructor(idHospedes, prenome, sobrenome, cpf, telefone, email, rg, sexo){
        this.idHospedes = idHospedes;
        this.prenome = prenome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.rg = rg;
        this.sexo = sexo;
    }

    get idHospedes(){
        return this.#idHospedes;
    }

    get prenome(){
        return this.#prenome;
    }

    get sobrenome(){
        return this.#sobrenome;
    }

    get cpf(){
        return this.#cpf;
    }

    get telefone(){
        return this.#telefone;
    }

    get email(){
        return this.#email;
    }

    get rg(){
        return this. #rg;
    }

    get sexo(){
        return this. #sexo;
    }


    set idHospedes(idHospedes){
        if(idHospedes===undefined || typeof idHospedes !== 'number' || isNaN(idHospedes) || idHospedes!==parseInt(idHospedes) || idHospedes<=0){
            throw('ID dos Hospedes invalido');
        }
        this.#idHospedes = idHospedes;
    }

    set prenome(prenome){
        if(prenome===undefined || typeof prenome !== 'String'){
            throw('Prenome invalido');
        }
        this.#prenome = prenome;
    }

    set sobrenome(sobrenome){
        if(sobrenome===undefined || typeof sobrenome !== 'String'){
            throw('Sobrenome invalido');
        }
        this.#sobrenome = sobrenome;
    }

    set cpf(cpf){
        if(cpf===undefined || typeof cpf !== 'number' || isNaN(cpf) || cpf!==parseInt(cpf) || cpf<=0){
            throw('Cpf invalido');
        }
        this.#cpf = cpf;
    }

    set telefone(telefone){
        if(telefone===undefined || typeof telefone !== 'number' || isNaN(telefone) || telefone!==parseInt(telefone) || telefone<=0){
            throw('Telefone invalido');
        }
        this.#telefone = telefone;
    }

    set email(email){
        if(email===undefined || typeof email !== 'String'){
            throw('E-mail invalido');
        }
        this.#email = email;
    }

    set rg(rg){
        if(rg===undefined || typeof rg !== 'number' || isNaN(rg) || rg!==parseInt(rg) || rg<=0){
            throw('RG invalido');
        }
        this.#rg = rg;
    }

    set sexo(sexo){
        if(sexo===undefined || typeof sexo !== 'String'){
            throw('Sexo invalido');
        }
        this.#sexo = sexo;
    }
}

function novoHos(prenome , sobrenome, cpf, telefone, e_mail, rg, sexo){
    return new Tpquarto(prenome , sobrenome, cpf, telefone, e_mail, rg, sexo);
}

function selectHos(){
    return new Tpquarto();
}

module.exports = {novoHos, selectHos};