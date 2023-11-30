create or alter procedure empresa.sp
 @nump int
 as begin
	begin
	delete from empresa.TRABALHA_EM where NumProjeto = @nump
	delete from empresa.PROJETO where NumProjeto = @nump
	end
 end
