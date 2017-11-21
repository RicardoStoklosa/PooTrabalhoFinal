</td></tr>
		

	</table>   
</div>	
	<div style="border-top:1px solid rgb(150,150,150);text-align:center;color:rgb(100,100,100)">
	<br/>
	<?php echo SYS_TITLE; ?>
	 <?php echo SYS_VERSION; ?><br/>
	www.leandroip.com
	</div>  
	<br/><br/><br/>
	
<?php if(isset($inc_chosen)){ ?>

  <script src="publibrary/chosen/chosen.jquery.js" type="text/javascript"></script>
  <script src="publibrary/chosen/docsupport/prism.js" type="text/javascript" charset="utf-8"></script>
  <script type="text/javascript">
    var config = {
      '.chosen-select'           : {},
      '.chosen-select-deselect'  : {allow_single_deselect:true},
      '.chosen-select-no-single' : {disable_search_threshold:10},
      '.chosen-select-no-results': {no_results_text:'Oops, nothing found!'},
      '.chosen-select-width'     : {width:"95%"}
    }
    for (var selector in config) {
      $(selector).chosen(config[selector]);
    }
  </script>
  <?php } ?>
  
  
   </BODY>
</HTML>
