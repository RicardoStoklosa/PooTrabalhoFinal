<?php


Class postsController extends Controller{
	
	
	public function index(){
		$v = new View('shared/top.php');
		$v->render();
		
		$m = new Model('posts');
		$r = $m->query_ar("SELECT * FROM posts");
		$v = new View('posts/listarposts.php');
		$v->set('posts', $r);
		$v->render();
		
		$v = new View('shared/bot.php');
		$v->render();
	}
	
	public function cadastrapost(){
		ini_set('display_errors', 1);
		error_reporting(E_ALL);

		$v = new View('shared/top.php');
		$v->render();
		
		$msgsalvo = false;
		$salvo = false;
		if(isset($this->_post['titulo'])){
			$m = new Model('posts');
			//$m->set('titulo', $this->_post['titulo']);
			$m->setAll($this->_post);
			$m->set('permitecomentario', 
				isset($this->_post['permitecomentario']));
			$m->set('users_id', $_SESSION['userid']);
			$m->set('datacad', Date("Y-m-d H:i:s"));
			$msgsalvo = true; 
			$salvo = $m->persist();
		}
		
		$v = new View('posts/cadastrapost.php');
		$v->set('msgsalvo', $msgsalvo);
		$v->set('salvo', $salvo);
		$v->render();
		
		
		$v = new View('shared/bot.php');
		$v->render();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
