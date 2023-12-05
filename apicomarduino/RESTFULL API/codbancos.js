const bd = require ('./bd');

async function incluirespecificacao(especificacao){
    const conexao = await bd.getConexao()
    if (conexao == null) return null;
    try{
        const sql = "Insert into hotel.TipoQuarto(especificacao) VALUES('"+ especificacao +"')"
        console.log(sql)
        await conexao.query (sql);
        return true;
    }
    catch(excecao){
        return false;
    }
}

async function selecionarespt(){
    const conexao = await bd.getConexao()
    if (conexao == null) return null;
    try{
        const sql = 'Select * from hotel.TipoQuarto'
        res.status(200).json(sql.recordset);
    }
    catch(excecao){
        console.log(excecao.message)
        return false;
    }
}


module.exports = {incluirespecificacao,selecionarespt}