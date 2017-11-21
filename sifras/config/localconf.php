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

$database = array(
	"database" => "sifras",
	"user" => "root",
	"password" => "",
	"dbhost" => "localhost",
	"tabprefix" => "",
);
$sifras_cfg = array(
	"default_controller" => "index",
	"default_action" => "index",
	"system_title" => "SiFraS",
	"timezone"=>'America/Sao_Paulo',	
	/*
	On permission error, goto login page if 
	the user is not logged.
	*/
	"gotologin" => False 
);



$profile_permissions = array(
	"admin" => "*.*",
	"guest" => "index.*",
	"user" => "index.*,clients.index"
);



return array(
	"database" => $database,
	"permissions" => $profile_permissions,
	"sifras_cfg" => $sifras_cfg
);
