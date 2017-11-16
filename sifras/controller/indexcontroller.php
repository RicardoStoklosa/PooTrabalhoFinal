<?php
/*****************************************************************************
    SiFraS: Simple PHP Framework for Students
    Copyright (C) 2016  Leandro Israel Pinto

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*****************************************************************************/


class indexController extends Controller{
	/*
	function __construct(){
		parent::__construct();
	}
	*/
	public function index(){		
		
		//require 'view/shared/top.php';
		$v = new View('shared/top.php');
		
		$v->render();
		
		//print "Index page";
		$v = new View('index/index.php');
		$v->set('var1','a value to var 1...');
		$v->render();
		
		//require 'view/shared/bot.php';
		$v = new View('shared/bot.php');
		$v->render();
		
	}
	
	public function login(){
		
		//header("Location: index.php");
		$v = new View('index/login.php');
		
		if(isset($this->_post['user'])){
			$v->set('error',true);
			$u = new User();
			if($u->login($this->_post['user'], $this->_post['pass'])){
				header("Location: index.php");
				//echo 'Login ok';
			}else{
				$v->set('error',true);
			}
		}
		
		//require 'index/login.php';		
		
		$v->render();
	}
	
	public function logoff(){
		$u = new User();
		$u->logoff();
		$v = new View('index/login.php');
		$v->render();
	}
	
	public function nopermission(){
		$v = new View('shared/top.php');		
		$v->render();
		
		//print "Index page";
		$v = new View('index/nopermission.php');
		$v->set('accessto',$this->_get["accessto"]);
		$v->render();
		
		//require 'view/shared/bot.php';
		$v = new View('shared/bot.php');
		$v->render();
	}
	
	/**
	An example of function for cron task.
	*/	
	public function crontask(){
		echo "Empty";
	}
	
}
