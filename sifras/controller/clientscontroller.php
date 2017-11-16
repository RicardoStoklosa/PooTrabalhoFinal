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

Class clientsController extends Controller{

	public function index($rm=False){
		$v = new View('shared/top.php');
		$v->render();
		
		$m = new Model('clients');
		
		
		$r = $m->select(null, 'name');		
		

		$v = new View('clients/index.php');
		$v->set('clients',$r);
		$v->set('rm', $rm);
		$v->render();

		$v = new View('shared/bot.php');
		$v->render();

	}

	public function addclient(){
		$save = false;
		$data = array();
		if(isset($this->_get['id'])){
			$m = new Model('clients');
			$m->load($this->_get['id']);
			$data = $m->getAll();
		}
		
		if(isset($this->_post['name'])){
			$m = new Model('clients');
			if($this->_post['id']!=""){
				$m->load($this->_post['id']);				
			}else{
				$m->getProp();			
			}
			$m->setAll($this->_post);
			$m->persist();
			$m->load($m->get('id'));
			$data = $m->getAll();
			$save = true;
		}
		

		$v = new View('shared/top.php');
		$v->render();

		$v = new View('clients/addclient.php');
		$v->set('save', $save);
		$v->set('vars', $data);
		//$tm = new View('clients/topmenu.php');
		//$v->set('topmenu', $tm);
		$v->render();


		$v = new View('shared/bot.php');
		$v->render();
	}
	
	public function rmclient(){
		
		if(isset($this->_get['id'])){
			
			$m = new Model('clients');
			$m->load($this->_get['id']);
			$m->delete();
		}
		
		$this->index(True);
	}
}
