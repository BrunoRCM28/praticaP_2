const bd = require ('./bd');
const { espnovo } = require('./cadastraesp');

async function inclua (cadastraesp)
{
    const conexao = await bd.getConexao ();
    if (conexao==null) return null;

    try
    {
        const sql     = 'INSERT INTO hotel.TipoQuarto (especificacao) VALUES (?)';
        const dados   = [espnovo.nome];
        await conexao.query (sql, dados);
        return true;
    }
    catch (excecao)
    {
        return false;
    }
}


module.exports = {inclua}



