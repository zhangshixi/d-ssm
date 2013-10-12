/*
//还原主列表高度为auto
function heightAuto () {
	$('.left_list_Center').removeAttr('style');
	$('.left_list_Center').height();
}

//修改新的主列表高度
function height() {
	var winH = $(window).height();
	var h1 = heightAuto();
	var h2 = (winH-78)+'px';
	var h = h1<h2 ? h1 : h2;
	$('.left_list_Center').height(h);
}*/

//ie6展开闭合bugs
function ie6h() {
	$('.left_list_Bottom').css('float','left');
	$('.left_list_Bottom').removeAttr('style');
}

//if($.brower.msie&&($.browser.version==6.0)&&!$.support.style)

$(function() {
	//点击主标签展开闭合二级菜单
	$('#left_list dt').click(
		function() {
			if($(this).nextAll('dd:visible').length>0) {
				if($('#left_list dt').nextAll('dd:visible').length<$('#left_list dt').nextAll('dd').length) {
					$(this).nextAll('dd').hide();
					ie6h();
					$('#left_list_button').removeClass('left_button2').addClass('left_button1');
					} else {
					$(this).nextAll('dd').hide();
					ie6h();
					$('#left_list_button').removeClass('left_button2').addClass('left_button1');
					}
				} else {
				$(this).nextAll('dd').show();
				ie6h();
				$('#left_list_button').removeClass('left_button1').addClass('left_button2');
			}
		}
	);
	//点击主菜单展开闭合所有二级菜单
	$('.left_title_top').click(
		function() {
			if($('#left_list dt').nextAll('dd:visible').length>0) {
				$('#left_list dt').nextAll('dd').hide();
				ie6h();
				$(this).parent().find('#left_list_button').removeClass('left_button2').addClass('left_button1');
				} else {
				$('#left_list dt').nextAll('dd').show();
				ie6h();
				$(this).parent().find('#left_list_button').removeClass('left_button1').addClass('left_button2');
				}
			}
	);
	$('#left_list_button').click(
		function() {
			if($('#left_list dt').nextAll('dd:visible').length>0) {
				$('#left_list dt').nextAll('dd').hide();
				ie6h();
				$(this).parent().find('#left_list_button').removeClass('left_button2').addClass('left_button1');
				} else {
				$('#left_list dt').nextAll('dd').show();
				ie6h();
				$(this).parent().find('#left_list_button').removeClass('left_button1').addClass('left_button2');
				}
			}
	);

	//二级菜移入移出击效果
	$('#left_list dd').hover(function () {
		$(this).addClass('leftButtonHover');
	},function () {
		$(this).removeClass('leftButtonHover');
	});

	//二级菜单点击效果
	$('#left_list dd a').click(function () {
		$('#left_list dd').removeClass('leftButtonClick');
		$(this).parent().addClass('leftButtonClick');
	});
});