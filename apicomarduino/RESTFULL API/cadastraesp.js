class creserva
{
    #codigo
    #nome
    #preco

    constructor ( nome)
    {
        this.nome=nome;
    }

    get nome ()
    {
        return this.#nome
    }

    set nome (nome)
    {
        if (nome===undefined || typeof nome !== 'string' || nome==="")
            throw ('Nome inválido');

        this.#nome = nome;
    }
}

function espnovo (nome)
{
    return new Livro (nome);
}

module.exports = {espnovo}
