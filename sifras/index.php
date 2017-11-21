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
	

require_once "config/config.php";
date_default_timezone_set($configvar['timezone']);
session_start();


require_once "library/sharedf.php";


$c = "";
if (!isset($_GET["contr"])){
	header("Location: index.php?contr=".$configvar["default_controller"]);
	die();
	//$c = $configvar["default_controller"];
}else{
	$c = $_GET["contr"];
}

if (!isset($_GET["action"])){
	$action = $configvar["default_action"];
}else{
	$action = $_GET["action"];
}

/* check permission according user profile */
if(!User::hasPermission($c.'.'.$action)){
	if($configvar["gotologin"]){
		isLogged();
	}else{
		header("Location: ".getUrl("index","nopermission", array("accessto"=>$c.'-'.$action)));
		die();
	}
}

$contName = $c."Controller";

$controller = new $contName;
if(is_callable(array($controller, $action))){	
	$controller->$action();
}else{
	print "Not callable.";
}














