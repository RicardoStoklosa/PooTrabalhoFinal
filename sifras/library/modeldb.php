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

$_dbHandle = null;

class ModelDB {

    /** Propriedades */
    protected $_prop;
    protected $_proptype;
    protected $_usehtmlentities=true;
	protected $editing = false;
    
    
    public function get_usehtmlentities() {
        return $this->_usehtmlentities;
    }

    public function set_usehtmlentities($_usehtmlentities) {
        $this->_usehtmlentities = $_usehtmlentities;
    }

    
    function __construct($tablename = "") {
		if($tablename == ""){
			$this->_model = get_class($this);
			$this->_table = strtolower($this->_model) . "s";
			$this->_prop = array();
		}else{
			$this->_model = $tablename;
			$this->_table = $tablename;
			$this->_prop = array();
		}
    }

    function connect($address=DB_HOST, $account=DB_USER, $pwd=DB_PASSWORD, $name=DB_NAME) {
        global $_dbHandle;
        if ($_dbHandle == null) {
            
            $_dbHandle = @mysql_connect($address, $account, $pwd);
            if ($_dbHandle != 0) {
                if (mysql_select_db($name, $_dbHandle)) {
                    return 1;
                }
            }
			echo "Ops, infelizmente nosso servidor est&aacute; com 
			algum problema. Por favor volte daqui a pouco.";
			exit;
            return 0;
        }
        return 1;
    }

    /** Set Attribute. */
    function set($att, $val) {
        $this->_prop[$att] = $val;
    }
    
    function getProp(){
        $res = $this->query('SHOW COLUMNS FROM '.$this->_table);
        $a = $this->toArray($res);
        foreach($a as $k => $v){
            $this->_prop[$v["Field"]] = "";
            $this->_proptype[$v["Field"]] = $v["Type"];
        }
        
        //print_r($this->_prop);
    }
	
	
    
    function setAll($att){
		if(!$this->editing)
			$this->getProp();
		
        foreach($this->_prop as $k=>$v){
            if(isset($att[$k])){
                $this->_prop[$k] = $att[$k];
            }else{
				if(!$this->editing)
					unset($this->_prop[$k]);
			}
        }
    }

    /** Get attribute */
    function get($att) {
        return $this->_prop[$att];
    }
    
    function getAll(){
        return $this->_prop;
    }

    /** Execute a custom query */
    function query($qr) {
        global $_dbHandle;
        $this->connect();
        $r = mysql_query($qr, $_dbHandle);
        //echo mysql_error();
        return $r;
    }
    
    function query_ar($qr){
        return $this->toArray($this->query($qr));
    }

    /** Load the model by 'id' */
    function load($id) {
        $this->connect();
        $r = $this->query("select * from " . $this->_table . " where id='" . mysql_real_escape_string($id) . "'");
        $data = $this->getRow($r);
        $this->_prop = array();
        if(isset($data) and count($data)>0 and $data!=null){
            foreach ($data as $k => $v) {
                $this->_prop[$k] = $v;
            }
        }
		$this->editing = true;
    }
    
    function reload(){
        $this->load($this->get("id"));
    }

    /** Persist the model, inserting or updating if 'id' exists. */
    function persist($getsql = false) {
        $sql = "";
        $cols = "";
        $vals = "";
        $res = null;


        if (!isset($this->_prop["id"]) or $this->_prop["id"] == null or $this->_prop["id"]=='' or !$this->editing) {
            //$this->_prop["id"] = Date("YmdHsi").rand(0,9999)."-".rand(0,99);
			if (!isset($this->_prop["id"]) or $this->_prop["id"] == null or $this->_prop["id"]==''){
				$this->_prop["id"] = Date("YmdHsi").str_pad(rand(0,9999),4,"0",STR_PAD_LEFT);
			}
            
            foreach ($this->_prop as $k => $v) {
                $cols = $cols . "," . mysql_real_escape_string($k);
                $vals = $vals . ",'" . mysql_real_escape_string($v) . "'";
            }
            $cols[0] = ' ';
            $vals[0] = ' ';

            $sql = "insert into " . $this->_table . "(" . $cols . ") values(" . $vals . ")";
        } else {
            foreach ($this->_prop as $k => $v) {
                if ($k != "id")
                    $vals = $vals . "," . $k . "='" . $v . "'";
            }
            $vals[0] = ' ';
            $sql = "update " . $this->_table . " set " . $vals . " where id='" . $this->_prop["id"] . "'";
        }
        //echo $sql;
        if($getsql){
            return $sql;
        }
        $res = $this->query($sql);
        return $res;
        
    }
    
    function delete($id=""){
		if($id == ""){
        $sql = "delete from " . $this->_table . " where id='" . $this->_prop["id"] . "'";
		}else{
		$sql = "delete from " . $this->_table . " where id='" . $id . "'";
		}
        return $this->query($sql);
    }
    
    function count($where){
        $first = true;
        $table = $this->_table;
        $w = "";
        if ($where != null) {
            foreach ($where as $k => $v) {
                if ($first) {
                    $w = $k . "=" . "\"" . $v . "\"";
                    $first = false;
                } else {
                    $w = $w . " AND " . $k . "=" . "\"" . $v . "\"";
                }
            }
        }
        if ($where == null) {
            $sql = "SELECT count(*) as qtd FROM $table;";
        } else {
            $sql = "SELECT count(*) as qtd FROM $table WHERE $w;";
        }
        $res = $this->toArray($this->query($sql));
       // $i = 0;
          
        return $res[0]["qtd"];
    }

    /** Perform a select. */
    function select($where = null, $order=null, $from = null, $count = null) {
        $first = true;
        $table = $this->_table;
        if ($order != "" and $order != null)
            $order = "order by $order";
        $w = "";
        if ($where != null) {
            foreach ($where as $k => $v) {
                if ($first) {
                    $w = $k . "=" . "\"" . $v . "\"";
                    $first = false;
                } else {
                    $w = $w . " AND " . $k . "=" . "\"" . $v . "\"";
                }
            }
        }
        if ($where == null) {
            $sql = "SELECT * FROM $table $order";
        } else {
            $sql = "SELECT * FROM $table WHERE $w $order";
        }
        
        if($count != null){
            $sql = $sql." limit $from, $count";
        }
        
        $res = $this->query($sql);
       // $i = 0;

        return $this->toArray($res);
        /*
          while($row = mysql_fetch_array($res, MYSQL_ASSOC)){
          $j=0;
          foreach($row as $k=>$v){
          $r[$i][$k] = $v;
          $j++;
          }
          $i++;
          }
          return $r;
         * 
         */
    }

    /** MySQL result to array */
    function toArray($res) {
        //$res = db_execute($sql);
        $i = 0;
		$r = null;
        while ($row = mysql_fetch_array($res, MYSQL_ASSOC)) {
            $j = 0;
            foreach ($row as $k => $v) {
                if(!$this->_usehtmlentities){
                $r[$i][$k] = $v;
                }else{
                    $r[$i][$k] = htmlspecialchars($v);
                }
                $j++;
                //echo $v . "<br>";
            }
            $i++;
        }
        return $r;
    }

    /** Search - nao implementado */
    function search($term, $where = null, $onCols=null, $from , $count) {
        $first = true;
        $table = $this->_table;
        $w = "";
        if ($where != null) {
            foreach ($where as $k => $v) {
                if ($first) {
                    $w = $k . "=" . "\"" . $v . "\"";
                    $first = false;
                } else {
                    $w = $w . " AND " . $k . "=" . "\"" . $v . "\"";
                }
            }
        }
        if ($where == null) {
            $sql = "SELECT * FROM $table";
        } else {
            $sql = "SELECT *  FROM $table WHERE $w";
        }
        
        $s = "";
        $first = true;
        
        foreach($onCols as $k=>$v){
           
            foreach($term as $l=>$m){
                
                if ($first) {
                    $s = $s." $v LIKE '%$m%' ";
                    $first = false;
                }else{
                    $s = $s." OR $v LIKE '%$m%' ";
                }
            }
        }
        if($s!=""){
            $sql = $sql." AND( ".$s.")";
        }
        
       
       $tcount = count($this->toArray($this->query($sql)));
       if($count != null){
            $sql = $sql." limit $from, $count";
        }
        
          
        $r = $this->toArray($this->query($sql));
        $r["count"] = $tcount;
        return $r;
    }

    /** Num of rows. */
    function getNumRows($res) {
        return mysql_num_rows($res);
    }

    function getRow($result) {
        $row = mysql_fetch_array($result, MYSQL_ASSOC);
        return $row;
    }

}

