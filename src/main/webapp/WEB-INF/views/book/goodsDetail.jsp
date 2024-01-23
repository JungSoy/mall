<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품상세(장바구니 추가)</title>
</head>
<body>

	<div class="button">						
		<div class="button_quantity">
			주문수량
			<input type="text" class="quantity_input" value="1">
			<span>
				<button class="plus_btn">+</button>
				<button class="minus_btn">-</button>
			</span>
		</div>
		<div class="button_set">
			<a class="btn_cart">장바구니 담기</a>
			<a class="btn_buy">바로구매</a>
		</div>
	</div>

<script>

	//수량 버튼 조작
	let quantity = $(".quantity_input").val();
	$(".plus_btn").on("click", function(){
		$(".quantity_input").val(++quantity);
	});
	$(".minus_btn").on("click", function(){
		if(quantity > 1){
			$(".quantity_input").val(--quantity);	
		}
	});

	// 서버로 전송할 데이터
	const form = {
			userNo : '${user.userNo}',
			bookId : '${goodsInfo.bookId}',
			bookCount : ''
	}
	
	// 장바구니 추가 버튼
	$(".btn_cart").on("click", function(e){
		form.bookCount = $(".quantity_input").val();
		$.ajax({
			url: '/cart/add',
			type: 'POST',
			data: form,
			success: function(result){
				cartAlert(result);
			}
		})
	});
	
	function cartAlert(result){
		if(result == '0'){
			alert("장바구니에 추가를 하지 못하였습니다.");
		} else if(result == '1'){
			alert("장바구니에 추가되었습니다.");
		} else if(result == '2'){
			alert("장바구니에 이미 추가되어 있습니다.");
		} else if(result == '5'){
			alert("로그인이 필요합니다.");	
		}
	}

</script>

</body>
</html>