<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="w" clstag="homepage|keycount|home2013|37a">
	<div id="service-2013">
		<dl class="fore1">
			<dt><b></b><strong>Shopping Guide</strong></dt>
			<dd>
				<div><a href="http://help.jd.com/help/question-61.html" target="_blank" rel="nofollow">Questions</a></div>
				<div><a href="http://help.jd.com/index.html" target="_blank" rel="nofollow">Service</a></div>
			</dd>
		</dl>
		<dl class="fore2">		
			<dt><b></b><strong>Shipping</strong></dt>
			<dd>
				<div><a href="http://help.jd.com/help/question-64.html" target="_blank" rel="nofollow">Pick Up</a></div>
				<div><a href="http://help.jd.com/help/question-360.html" target="_blank" rel="nofollow">Express</a></div>
			</dd>
		</dl>
		<dl class="fore3">
			<dt><b></b><strong>Payments</strong></dt>
			<dd>
				<div><a href="http://help.jd.com/help/question-67.html" target="_blank" rel="nofollow">COD</a></div>
				<div><a href="http://help.jd.com/help/question-68.html" target="_blank" rel="nofollow">Online</a></div>
				<div><a href="http://help.jd.com/help/question-71.html" target="_blank" rel="nofollow">Paypal</a></div>
			</dd>
		</dl>
		<dl class="fore4">		
			<dt><b></b><strong>After Service</strong></dt>
			<dd>
				<div><a href="http://myjd.jd.com/afs/help/afshelp.action" target="_blank" rel="nofollow">Policy</a></div>
				<div><a href="http://myjd.jd.com/repair/repairs.action" target="_blank" rel="nofollow">Return & Refund</a></div>
				<div><a href="http://help.jd.com/help/question-881.html" target="_blank" rel="nofollow">Cancel Order</a></div>
			</dd>
		</dl>
		<dl class="fore5">
			<dt><b></b><strong>Special</strong></dt>
			<dd>		
				<div><a href="http://help.jd.com/help/question-86.html" target="_blank">DIY</a></div>
				<div><a href="http://fuwu.jd.com/" target="_blank" rel="nofollow">Warranty</a></div>
			</dd>
		</dl>
		<!-- <div class="fr">
			<div class="sm" id="branch-office">
				<div class="smt">
					<h3>淘淘自营覆盖区县</h3>
				</div>
				<div class="smc">
					<p>淘淘已向全国1859个区县提供自营配送服务，支持货到付款、POS机刷卡和售后上门服务。</p>
					<p class="ar"><a href="http://help.jd.com/help/distribution-768.html" target="_blank">查看详情&nbsp;></a></p>
				</div>
			</div>
		</div> -->
		<span class="clr"></span>
	</div>
</div>
<div class="w" clstag="homepage|keycount|home2013|38a">
	<jsp:include page="footer-links.jsp"></jsp:include>
</div>
<script type="text/javascript" src="/js/jquery-1.6.4.js"></script>
<script type="text/javascript" src="/js/jquery-extend.js"></script>
<script type="text/javascript" src="/js/lib-v1.js" charset="utf-8"></script>
<script type="text/javascript" src="/js/taotao.js" charset="utf-8"></script>
<script type="text/javascript"> (function(){
/* var A="<strong>热门搜索：</strong><a href='http://sale.jd.com/act/OfHQzJ2GLoYlmTIu.html' target='_blank' style='color:#ff0000' clstag='homepage|keycount|home2013|03b1'>校园之星</a><a href='http://sale.jd.com/act/aEBHqLFMfVzDZUvu.html' target='_blank'>办公打印</a><a href='http://www.jd.com/pinpai/878-12516.html' target='_blank'>美菱冰箱</a><a href='http://sale.jd.com/act/nuzKb6ZiYL.html' target='_blank'>无肉不欢</a><a href='http://sale.jd.com/act/ESvhtcAJNbaj.html' target='_blank'>万件好货</a><a href='http://sale.jd.com/act/nAqiWgU34frQolt.html' target='_blank'>iPhone6</a><a href='http://sale.jd.com/act/p0CmUlEFPHLX.html' target='_blank'>哈利波特</a><a href='http://sale.jd.com/act/FstSdb2vCOLa8BRi.html' target='_blank'>美模接驾</a>"; */
var B=["Java","Apple","Google","Ipad","Cups","Elon Mask"];
B=pageConfig.FN_GetRandomData(B);
$("#hotwords").html(A);
var _searchValue = "${query}";
if(_searchValue.length == 0){
	_searchValue = B;
}
$("#key").val(_searchValue).bind("focus",function(){if (this.value==B){this.value="";this.style.color="#333"}}).bind("blur",function(){if (!this.value){this.value=B;this.style.color="#999"}});
})();
</script>