
<div class="title1"><h1>Cadastro de Clientes</h1></div>
<?php //$topmenu->set('vars',$vars); $topmenu->render(); ?>

<div class='box1' style=''>

<div style="width:550px">
<?php if($save){ ?>
<div class='box_success'>
Alterações salvas com sucesso.
</div>
<?php } ?>

<?php

$f = new Form();
$f->setAction(getUrl('clients','addclient'));
$f->addField('hidden', 'id', 'id:', (isset($vars['id']) ? $vars['id'] : ""));

$f->addField('text', 'name', 'Nome:', (isset($vars['name']) ? $vars['name'] : ""));
$f->addField('text', 'phone', 'Telefone:', (isset($vars['phone']) ? $vars['phone'] : ""));
$f->addField('text', 'email', 'Email:', (isset($vars['email']) ? $vars['email'] : ""));

$f->addField('textarea', 'obs', 'OBS:', (isset($vars['obs']) ? $vars['obs'] : ""));

$f->render();


?>
</div>
</div>
