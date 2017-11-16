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

Class Form{
	private $_fields = array();
	private $action;
	private $method='POST';
	private $btCaption = 'OK';

	public function setBtCaption($c){
		$this->btCaption = $c;
	}

	public function setAction($a){
		$this->action = $a;
	}
	public function setMethod($m){
		$this->method = $m;
	}

	public function addField($type, $name='no name', $label='no label', $value='', $seldef=null, $class=''){
		array_push($this->_fields, array('type'=>$type, 'name'=>$name, 'label'=>$label, 'value'=>$value, 'seldef'=>$seldef, 'class'=>$class));
	}

	public function render(){
		print '<form method = "'.$this->method.'" action="'.$this->action.'">';
		echo '<table style="width:100%">';
		foreach ($this->_fields as $v){
			echo '<tr>';
			if($v["type"]=='hr'){
				echo "<td colspan='2'> <hr/> </td>";				
			}else{
			
				if($v['type'] != 'hidden')
					echo '<td>'.$v['label'].'</td>';
				echo '<td>';
				if($v['type'] == 'text'){
					echo '<input type="text" name="'.$v['name'].'" value="'.$v['value'].'"/>';
				}
				if($v['type'] == 'password'){
					echo '<input type="password" name="'.$v['name'].'" value="'.$v['value'].'"/>';
				}
				if($v['type'] == 'hidden'){
					echo '<input type="hidden" name="'.$v['name'].'" value="'.$v['value'].'"/>';
				}
				if($v['type'] == 'labtext'){
					echo $v['value'];
				}
				if($v['type'] == 'textarea'){
					echo '<textarea name="'.$v['name'].'">';
					echo $v['value'];
					echo '</textarea>';
				}
				if($v['type'] == 'select'){
					echo '<select name="'.$v['name'].'" class="'.$v['class'].'">';
					foreach($v['value'] as $m=>$n){
						$s = "";
						if($v['seldef'] == $m) $s = 'selected';
						echo '<option '.$s.' value="'.$m.'">'.$n.'</option>';
					}
					echo '</select>';
				}
				if($v['type'] == 'selectmul'){
					echo '<select multiple name="'.$v['name'].'" class="'.$v['class'].'">';
					foreach($v['value'] as $m=>$n){
						$s = "";
						if(in_array($m,$v['seldef'])) $s = 'selected';
						echo '<option '.$s.' value="'.$m.'">'.$n.'</option>';
					}
					echo '</select>';
				}
				
				echo '</td>';
			}
			
			
			echo '</tr>';
			
		}
		echo '<tr><td colspan="2" style="text-align:right"><input type="submit" value="'.$this->btCaption.'"/></td></tr>';
		echo '</table>';
		echo '</form>';
	
	}
}




