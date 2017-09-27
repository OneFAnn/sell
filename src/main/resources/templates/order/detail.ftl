<html>
<#include "../common/header.ftl">
<body>
    <div id="wrapper" class="toggled">
        <#--边栏sidebar-->
        <#include "../common/nav.ftl">
        <#--主要内容content-->
        <div id="page-content-wrapper">
            <div class="container">
                <div class="row clearfix">
                    <div class="col-md-6 column">
                        <table class="table table-bordered table-condensed">
                            <thead>
                            <tr>
                                <th>订单id</th>
                                <th>订单总金额</th>
                                <th>订单状态</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>${orderDTO.orderId}</td>
                                <td>${orderDTO.orderAmount}</td>
                                <td>${orderDTO.getOrderStatusEnum().msg}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                <#--订单详情-->
                    <div class="col-md-12 column">
                        <table class="table table-bordered table-condensed">
                            <thead>
                            <tr>
                                <th>商品id</th>
                                <th>商品名称</th>
                                <th>价格</th>
                                <th>数量</th>
                                <th>总额</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list orderDTO.orderDetailList as dto>
                            <tr>
                                <td>${dto.productId}</td>
                                <td>${dto.productName}</td>
                                <td>${dto.productPrice}</td>
                                <td>${dto.productQuantity}</td>
                                <td>${dto.productPrice * dto.productQuantity}</td>
                            </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                    <!--  操作按钮 -->
                <#if orderDTO.getOrderStatusEnum().msg == "新订单">
                    <div class="col-md-12 column">
                        <a href="/sell/seller/order/finish?orderId=${orderDTO.orderId}" type="button"
                           class="btn btn-default btn-primary" onclick="if(confirm('确认完结订单吗？')==false)return false;">完结订单</a>
                        <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}" type="button"
                           class="btn btn-default  btn-danger" onclick="if(confirm('确认取消订单吗？')==false)return false;">取消订单</a>
                    </div>
                </#if>
                </div>
            </div>
        </div>
    </div>
</body>
</html>