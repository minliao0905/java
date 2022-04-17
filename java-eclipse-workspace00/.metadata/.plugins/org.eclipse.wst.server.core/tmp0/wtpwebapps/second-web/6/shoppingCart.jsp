<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java"%>
<!DOCTYPE html>
<html lang="">

<head>
    <meta charset="UTF-8">
    <title>我的购物车</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <!-- 引入facicon.ico网页图标 -->
  
    <link rel="stylesheet" href="shoppingCart.css" type="text/css">
    <script src="jquery.min.js"></script>
    <script src="shoppingCart.js"></script>
</head>

<body>
 
   
    <!-- 购物车中心 -->
    <div class="buycars-container" style="margin-left:200px;">
        <div class="w">
            <div class="all"><em>全部商品</em></div>
        </div>
        <!-- 头部全选模块header -->
        <div class="all-thead">
            <div class="t-checkbox">
                <input type="checkbox" name="" id="" class="checkall"> 全选
            </div>
            <div class="t-goods">商品</div>
            <div class="t-price">单价</div>
            <div class="t-num">数量</div>
            <div class="t-sum">小计</div>
            <div class="t-action">操作</div>
        </div>
        <!-- 商品详情 -->
        <div class="all-item-list">
            <div class="cart-item">
                <div class="p-checkbox">
                    <input type="checkbox" name="" id="" class="j-checkbox">
                </div>
                <div class="p-goods">
                    <div class="p-img">
                        <img src="img/OIP (3).jfif" alt="">
                    </div>
                    <div class="p-msg">【5本26.8元】经典儿童文学彩图青少版八十天环游地球中学生语文教学大纲</div>
                </div>
                <div class="p-price"> ￥12.60</div>
                <div class="p-num">
                    <div class="quantity-form">
                        <a href="javascript:;" class="decrement">-</a>
                        <input type="text" class="itxt" value="1">
                        <a href="javascript:;" class="increment">+</a>
                    </div>
                </div>
                <div class="p-sum">￥12.60</div>
                <div class="p-action"><a href="javascript:;">删除</a></div>
            </div>
            <div class="cart-item">
                <div class="p-checkbox">
                    <input type="checkbox" name="" id="" class="j-checkbox">
                </div>
                <div class="p-goods">
                    <div class="p-img">
                        <img src="img/OIP (3).jfif" alt="">
                    </div>
                    <div class="p-msg">【5本26.8元】经典儿童文学彩图青少版八十天环游地球中学生语文教学大纲</div>
                </div>
                <div class="p-price"> ￥12.60</div>
                <div class="p-num">
                    <div class="quantity-form">
                        <a href="javascript:;" class="decrement">-</a>
                        <input type="text" class="itxt" value="1">
                        <a href="javascript:;" class="increment">+</a>
                    </div>
                </div>
                <div class="p-sum">￥12.60</div>
                <div class="p-action"><a href="javascript:;">删除</a></div>
            </div>
            <div class="cart-item">
                <div class="p-checkbox">
                    <input type="checkbox" name="" id="" class="j-checkbox">
                </div>
                <div class="p-goods">
                    <div class="p-img">
                        <img src="img/OIP (3).jfif" alt="">
                    </div>
                    <div class="p-msg">【5本26.8元】经典儿童文学彩图青少版八十天环游地球中学生语文教学大纲</div>
                </div>
                <div class="p-price"> ￥12.60</div>
                <div class="p-num">
                    <div class="quantity-form">
                        <a href="javascript:;" class="decrement">-</a>
                        <input type="text" class="itxt" value="1">
                        <a href="javascript:;" class="increment">+</a>
                    </div>
                </div>
                <div class="p-sum">￥12.60</div>
                <div class="p-action"><a href="javascript:;">删除</a></div>
            </div>
            <div class="cart-item">
                <div class="p-checkbox">
                    <input type="checkbox" name="" id="" class="j-checkbox">
                </div>
                <div class="p-goods">
                    <div class="p-img">
                        <img src="img/OIP (3).jfif" alt="">
                    </div>
                    <div class="p-msg">【5本26.8元】经典儿童文学彩图青少版八十天环游地球中学生语文教学大纲</div>
                </div>
                <div class="p-price"> ￥12.60</div>
                <div class="p-num">
                    <div class="quantity-form">
                        <a href="javascript:;" class="decrement">-</a>
                        <input type="text" class="itxt" value="1">
                        <a href="javascript:;" class="increment">+</a>
                    </div>
                </div>
                <div class="p-sum">￥12.60</div>
                <div class="p-action"><a href="javascript:;">删除</a></div>
            </div>
            <div class="cart-item">
                <div class="p-checkbox">
                    <input type="checkbox" name="" id="" class="j-checkbox">
                </div>
                <div class="p-goods">
                    <div class="p-img">
                        <img src="img/OIP (3).jfif" alt="">
                    </div>
                    <div class="p-msg">【5本26.8元】经典儿童文学彩图青少版八十天环游地球中学生语文教学大纲</div>
                </div>
                <div class="p-price"> ￥12.60</div>
                <div class="p-num">
                    <div class="quantity-form">
                        <a href="javascript:;" class="decrement">-</a>
                        <input type="text" class="itxt" value="1">
                        <a href="javascript:;" class="increment">+</a>
                    </div>
                </div>
                <div class="p-sum">￥12.60</div>
                <div class="p-action"><a href="javascript:;">删除</a></div>
            </div>
        </div>
        
        
        <div class="cart-floatbar">
            <div class="select-all">
                <input type="checkbox" name="" id="" class="checkall">全选
            </div>
            <div class="operation">
                <a href="javascript:;" class="remove-batch"> 删除选中的商品</a>
                <a href="javascript:;" class="clear-all">清理购物车</a>
            </div>
            <div class="toolbar-right">
                <div class="amount-sum">已经选<em>1</em>件商品</div>
                <div class="price-sum">总价： <em>￥12.60</em></div>
                <div class="btn-area">去结算</div>
            </div>
        </div>
    </div>
    <div class="cart-floatbar">

</body>

</html>