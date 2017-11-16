

<div class="title1">
	<h1>Usuários</h1>
</div>

<div class="menutop">
	<ul>
		<li><a href="<?php egetUrl('users', 'adduser'); ?>">Adicionar Usuário</a></li>
	</ul>
</div>
<div class="box1">

<?php 

$t = new Table();
$t->setClass('table1 wi100');
$t->addHeader('username', 'Username');
$t->addHeader('profile', 'Acesso');
$t->addHeader('name', 'Nome');
$t->addHeader('email', 'Email');



$t->addRows($users);

$t->addMenu(array("template"=>'<a href="'.getUrl('users','adduser',array('id'=>'__id__')).'">Editar</a>', 
	"replace"=>array('__id__'=>'id')));

$t->render();

?>
	

<br/>
</div>

	<br/>
	<br/>
