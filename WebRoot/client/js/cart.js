		// 增加某个商品的数量
	function ChangeProductNum (id,count,max){
		
		if (parseInt(count)>parseInt(max)){
			
			// 恢复数值
			
            document.getElementById('product_num_'+id).value=text_backup.value;

			window.alert('受库存限制，无法增加数量');


		}else if (parseInt(count)<1){
			

			// 恢复数值
			document.getElementById('product_num_'+id).value=text_backup.value;

			window.alert('无法减小数量');
		
		}else{
			window.location.href = "/bookstore/ChangeCartServlet?id="+id+"&count="+count;
		}
		
	}
	function DeleteConfirm(){
   		 	return window.confirm("确认要删除吗");
	}