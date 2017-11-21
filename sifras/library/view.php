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

class View
{
    protected $_file;
    protected $_data = array();

    public function __construct($file)
    {
        $this->_file = 'view/'.$file;
    }

    public function set($key, $value)
    {
        $this->_data[$key] = $value;
    }

    public function get($key) 
    {
        return $this->_data[$key];
    }

    public function render()
    {
        if (!file_exists($this->_file))
        {
            throw new Exception("Template " . $this->_file . " doesn't exist.");
        }

        extract($this->_data);
        ob_start();
        include($this->_file);
        $output = ob_get_contents();
        ob_end_clean();
        echo $output;
    }
	
	public function getrender(){
		if (!file_exists($this->_file))
        {
            throw new Exception("Template " . $this->_file . " doesn't exist.");
        }

        extract($this->_data);
        ob_start();
        include($this->_file);
        $output = ob_get_contents();
        ob_end_clean();
        return $output;
	}
}
