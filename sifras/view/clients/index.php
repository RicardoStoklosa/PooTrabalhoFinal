

<div class="title1">
	<h1>Clientes</h1>
</div>

<div class="menutop">
	<ul>
		<li><a href="<?php egetUrl('clients', 'addclient'); ?>">Adicionar Cliente</a></li>
	</ul>
</div>
<div class="box1">

<?php if($rm){ ?>
<div class='box_success'>
Cliente excluído com sucesso.
</div>
<?php } ?>

<?php 

$t = new Table();
$t->setClass('table1 wi100');
$t->addHeader('name', 'Nome');
$t->addHeader('phone', 'Telefone');
$t->addHeader('email', 'Email');
$t->addHeader('obs','Observacoes');

$t->addRows($clients);

$t->addMenu(array("template"=>'<a href="'.getUrl('clients','addclient',array('id'=>'__id__')).'">Editar</a>', 
	"replace"=>array('__id__'=>'id')));
$t->addMenu(array("template"=>'<a href="'.getUrl('clients','rmclient',array('id'=>'__id__')).'">Excluir</a>', 
	"replace"=>array('__id__'=>'id')));
	
$t->render();

?>
	

<br/>
</div>

	<br/>
	<br/>
