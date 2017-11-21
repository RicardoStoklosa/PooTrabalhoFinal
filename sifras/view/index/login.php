<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
   "http://www.w3.org/TR/html4/strict.dtd">
<HTML>
   <HEAD>
      <meta charset="UTF-8">
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <TITLE>:: <?php echo SYS_TITLE; ?> ::</TITLE>
<link rel="icon" 
      type="image/png" 
      href="images/logo.png" />
   </HEAD>
   <BODY>
	
	<table  id="pagetable" cellpadding="0" cellspacing="0">
		<!--<tr><th id="logoarea">Sis</th><th id="headerarea">
			
		</th></tr> -->
		<tr>
<td valign="top" id="contentcol" colspan="2">


<br/>
<br/>
<br/>
<br/>
<br/>
<div style="text-align:center">
<img src="images/logo.png"/>
</div>

<div class='box1' style="margin:10px auto; padding:10px;background-color:white;width:300px;">
<h1 style="color:rgb(41,87,164)">Login</h1>
<form method="post" action="<?php echo getUrl('index','login'); ?>">

Usuário <br/>
<input class='forminput' style="width:100%;font-size:21px" type="text" name="user" /> <br/>
Senha <br/>
<input class='forminput' style="width:100%;font-size:21px" type="password" name="pass" /> <br/>
<?php if(isset($error)){ ?>
		Desculpe, login incorreto.
		<?php }?>
<div style="text-align:right">
	
<input type="submit" value="OK" />

</div>


</form>



</div>
<div style="min-height:500px"> </div>
</td></tr>
		

	</table>      
<div style="border-top:1px solid rgb(150,150,150);text-align:center;color:rgb(100,100,100)">
	<br/>
	www.jnaeletronicos.com
	</div>  
	<br/><br/><br/>

   </BODY>
</HTML>
