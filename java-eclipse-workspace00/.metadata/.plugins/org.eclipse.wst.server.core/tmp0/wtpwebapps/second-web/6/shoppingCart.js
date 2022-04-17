$(function () {
    $(".checkall").change(function () {
        $(".j-checkbox,.checkall").prop("checked", $(this).prop("checked"));    //全选的选择状态赋值
        if ($(this).prop("checked")) {
            $(".cart-item").addClass("check-cart-item");
        }
        else {
            $(".cart-item").removeClass("check-cart-item");

        }
    });
    $(".j-checkbox").change(function () {
        if ($(".j-checkbox:checked").length == $(".j-checkbox").length) {
            $(".checkall").prop("checked", true);
        }
        else {
            $(".checkall").prop("checked", false);
        }
        if ($(this).prop("checked")) {
            $(this).parents(".cart-item").addClass("check-cart-item");
        }
        else {
            $(this).parents(".cart-item").removeClass("check-cart-item");

        }
    });
    $(".increment").click(function () {
        var n = $(this).siblings(".itxt").val();
        n++;
        $(this).siblings(".itxt").val(n);
        //查找parent元素 使用parents("elementname");返回指定祖先元素
        var p = $(this).parents(".p-num").siblings(".p-price").html();
        p = p.substr(2);
        console.log(p);
        $(this).parent().parent().siblings(".p-sum").html("￥" + (p * n).toFixed(2));
        getSum();

    })
    $(".decrement").click(function () {
        var n = $(this).siblings(".itxt").val();
        if (n > 1) {
            n--;
        }
        $(this).siblings(".itxt").val(n);
        var p = $(this).parent().parent().siblings(".p-price").html();
        p = p.substr(2);
        // console.log(p);
        $(this).parent().parent().siblings(".p-sum").html("￥" + (p * n).toFixed(2));//tofixed（）操作，保留两位小数
        getSum();

    })
    $(".itxt").change(function () {
        var n = $(this).val();
        var p = $(this).parents(".p-num").siblings(".p-price").html();
        p = p.substr(2);
        $(this).parent().parent().siblings(".p-sum").html("￥" + (p * n).toFixed(2));
        getSum();

    })
    // 5. 计算总计和总额模块
    getSum();

    function getSum() {
        var count = 0; // 计算总件数 
        var money = 0; // 计算总价钱
        $(".itxt").each(function (i, ele) {   //each遍历 第一个参数自定义 
            count += parseInt($(ele).val());
        });
        $(".amount-sum em").text(count);
        $(".p-sum").each(function (i, ele) {
            money += parseFloat($(ele).text().substr(1));
        });
        $(".price-sum em").text("￥" + money.toFixed(2));
    }
    // 6. 删除商品模块
    // (1) 商品后面的删除按钮
    $(".p-action a").click(function () {
        // 删除的是当前的商品 
        $(this).parents(".cart-item").remove();
        getSum();
    });
    // (2) 删除选中的商品
    $(".remove-batch").click(function () {
        // 删除的是小的复选框选中的商品
        $(".j-checkbox:checked").parents(".cart-item").remove();
        getSum();
    });
    // (3) 清空购物车 删除全部商品
    $(".clear-all").click(function () {
        $(".cart-item").remove();
        getSum();
    })
})