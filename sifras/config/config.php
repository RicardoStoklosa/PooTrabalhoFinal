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

$carr = require "config/localconf.php";
$configvar = array_merge($carr['database'], $carr['sifras_cfg']);


define('DB_HOST', $configvar['dbhost']);
define('DB_USER', $configvar['user']);
define('DB_PASSWORD', $configvar['password']);
define('DB_NAME', $configvar['database']);
define('SYS_VERSION', '1.0.1');
define('SYS_TITLE', $configvar['system_title']);


