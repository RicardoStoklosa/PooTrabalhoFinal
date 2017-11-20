<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
   "http://www.w3.org/TR/html4/strict.dtd">
<HTML>
   <HEAD>
      <meta charset="UTF-8">
      <link rel="stylesheet" type="text/css" href="css/style.css">
<?php if(isset($inc_jquery) or isset($inc_chosen)){ ?>
	  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<?php } ?>
	<?php if(isset($inc_chosen)){ ?>
	
  <link rel="stylesheet" href="publibrary/chosen/chosen.css">
	<?php } ?>

		
      <TITLE>:: <?php echo SYS_TITLE; ?> ::</TITLE>
		<!--Load the AJAX API-->
    <link rel="icon" 
      type="image/png" 
      href="images/logo2.png" />
   </HEAD>
   <BODY>

	<div>
	<table  id="pagetable" cellpadding="0" cellspacing="0">
		<tr><th id="logoarea">
			<a style="color:white;font-size:25px;" href="index.php">
				
				<img style="height:50px" src='images/logo2.png'/>
			</a>
		</th><th id="headerarea" style="text-align:right">
			
			<?php if(isset($_SESSION['userrealname'])){ ?>
			<?php echo $_SESSION['userrealname']; ?>
			&nbsp;&nbsp;&nbsp;			
			<a style='color:rgb(255,180,200);' href="<?php egetUrl('index','logoff'); ?>">Sair</a>
			<?php }else{ ?>
			<a style='color:rgb(255,180,200);' href="<?php egetUrl('index','login'); ?>">Login</a>
			<?php } ?>
			
		</th></tr>
		<tr><td valign="top" id="menucol" >
			
			<div class="menuleft" style="min-height:900px">
				<ul>
					<li><a <?php ($_GET['contr']=='panel' ? print ('class="active"') : print ("")) ?> href="<?php egetUrl('index'); ?>"><img style="height:16px" src="images/panel.png" style="vertical-align: middle;"/>&nbsp;&nbsp; Painel</a></li>
					<li><a <?php ($_GET['contr']=='clients' ? print( 'class="active"') : print( "")) ?> href="<?php egetUrl('clients'); ?>"><img style="height:16px" src="images/client.png"/>&nbsp;&nbsp; Clientes</a></li>
					<li><hr style="border-bottom:1px solid rgb(60,60,60)"/></li>

				</ul>
			
			
		<?php //if($_SESSION['profile']=='admin'){ ?>		
			
<?php //} ?>	
</div>
			

		</td>
<td valign="top" id="contentcol" colspan="2">
