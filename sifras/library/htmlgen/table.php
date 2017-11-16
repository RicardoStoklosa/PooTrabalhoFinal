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

Class Table{
	/* index=>colname */
	private $_head = array();
	private $_rows = array();
	private $tclass="";
	private $hclass="";
	private $cclass="";
	private $menus=array();
	private $utf8e = false;
	
	public function setUtf8e($v){
		$this->utf8e = $v;
	}


	/**
	["template"=>"<a href='link/__id__'>menu</a>", "replace"=>['__id__', 'id']]
	*/
	public function addMenu($m){
		array_push($this->menus, $m);
	}

	public function addHeader($index, $name){
		$this->_head = array_merge($this->_head, array($index=>$name));
	}

	public function addRows($r){
		if(count($r) >0)
		$this->_rows = array_merge($this->_rows, $r);
	}

	public function setClass($t, $h="", $c=""){
		$this->tclass = $t;
		$this->hclass = $h;
		$this->cclass = $c;
	}

	

	public function render(){
		echo "<table class=\"".$this->tclass."\">";
		echo "<tr>";
		foreach ($this->_head as $k=>$v){
			echo "<th class=\"".$this->hclass."\">";
			echo $v;
			echo "</th>";
		}
		if(count($this->menus) > 0){
			echo '<th colspan="'.count($this->menus).'">&nbsp;</th>';
		}
		
		echo "</tr>";
		if(count($this->_rows)>0)
		foreach ($this->_rows as $v){
			echo "<tr>";
			foreach ($this->_head as $m=>$n){
				echo "<td class=\"".$this->cclass."\">";
				if(isset($v[$m]) and $v[$m] != "VOID"){			
					if(!$this->utf8e)
						echo $v[$m];
					else
						echo utf8_encode($v[$m]);
				}else
					echo '-';
				echo "</td>";
			}
			if(count($this->menus) > 0){
				//echo '<td colspan="'.count($this->menus).'">&nbsp;</td>';
				foreach($this->menus as $p){
					echo "<td class=\"".$this->cclass."\">";
					$menu = $p['template'];
					foreach($p['replace'] as $r=>$s){
						$menu = str_replace($r,$v[$s],$menu);
					}
					echo $menu;
					echo "</td>";				
				}
			}
			echo "</tr>";
		}
		echo "</table>";
	}
	

}
