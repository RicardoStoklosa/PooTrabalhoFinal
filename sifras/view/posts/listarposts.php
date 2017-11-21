

<h1>Posts</h1>

<table class="table1 wi100">
	<tr>
		<th>
			Título
		</th>
		<th>
			Posts
		</th>
		<th>
			Data Criação
		</th>
	</tr>
	<?php foreach($posts as $v){ ?>
	<tr>
		<td>
			<?php echo $v["titulo"]; ?>
		</td>
		<td>
			<?php echo $v["conteudo"]; ?>
		</td>
		<td>
			<?php echo $v["datacad"]; ?>
		</td>
	</tr>
	<?php } ?>

</table>
