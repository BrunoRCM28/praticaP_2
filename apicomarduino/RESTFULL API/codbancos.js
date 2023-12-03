const bd = require ('./bd');

async function incluirespecificacao(especificacao){
    const conexao = await bd.getConexao()
    if (conexao == null) return null;
    try{
        const sql = "Insert into hotel.TipoQuarto(especificacao) VALUES('"+ especificacao +"')"
        console.log(sql)
    }
    catch(excecao){
        return false;
    }
}

async function selecionarespt(){
    const conexao = await bd.getConexao()
    if (conexao == null) return null;
    try{
        const sql = "Select * from hotel.TipoQuarto"
        const [linhas] = await conexao.query(sql);
        return linhas;
    }
    catch(excecao){
        console.log(excecao)
        return false;
    }
}


module.exports = {incluirespecificacao,selecionarespt}