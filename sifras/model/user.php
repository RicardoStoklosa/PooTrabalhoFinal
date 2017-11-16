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


Class User extends Model{
	
	function __construct(){
		parent::__construct('users');
	}
	
	
	function login($user, $pass){
		$r = $this->select(array('username'=>$user, 'password'=>$pass));
		if(count($r) == 1){
			//session_start();
			$_SESSION['userid'] =$r[0]['id'];
			$_SESSION['username'] = $user;
			$_SESSION['userrealname'] = $r[0]['name'];
			$pm = new Model('profiles');
			$pm->load($r[0]['profile_id']);	
			$_SESSION['profile'] = $pm->get('name');
			return true;
		}
		return false;
	}
	
	function logged(){
		//session_start();
		return isset($_SESSION['username']);
	}
	
	function logoff(){
		//session_start();
		unset($_SESSION['username']);
		unset($_SESSION['profile']);
		unset($_SESSION['userrealname']);
		unset($_SESSION['profile']);
	}
	
	//User::hasPermission(...);
	public static function hasPermission($contrAction){
		
		$prof = 'guest';
		if(isset($_SESSION['profile'])){
			$prof = $_SESSION['profile'];
		}
		$confarr = require "config/localconf.php";
		$per = $confarr['permissions'][$prof];
		$per = str_replace(' ', '', $per);
		$per = str_replace(',', '$|^', $per);
		$per = str_replace('.', '\.', $per);
		$per = str_replace('*', '[a-z|A-Z|0-9|_]+', $per);
		$per = '/^'.$per.'$/';
		//echo $per.'=';
		preg_match($per, $contrAction, $output_array);
		if(count($output_array)>0){
			if($output_array[0] === $contrAction){
				//echo 'Sim';
				return True;
			}
		}
		//echo 'Nao';
		return False;		
	}
	
}
