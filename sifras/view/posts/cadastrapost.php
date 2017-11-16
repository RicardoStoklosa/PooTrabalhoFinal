
<h1> Cadastrar/Editar Post </h1>
<?php 
	if(isset($msgsalvo) and $msgsalvo){
		if(isset($salvo) and $salvo){
			print "Salvo com sucesso";
		}else{
			print "Erro ao salvar";
		}
	}

?>


<div style="width:500px">
	<form method="POST" action="<?php eGetUrl('posts','cadastrapost'); ?>">
		Título: <input name="titulo" type="text" value=""/><br/>
		Conteúdo: <textarea name="conteudo">
		
		</textarea><br/>
		<input name="permitecomentario" type="checkbox"> Permitir comentário. <br/>
		<input type="submit" value="Salvar"/>
		
	</form>
</div>



