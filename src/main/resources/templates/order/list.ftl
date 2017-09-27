<html>
<#include "../common/header.ftl">
<body>
    <div id="wrapper" class="toggled">
        <#--边栏sidebar-->
        <#include "../common/nav.ftl">
        <#--主要内容content-->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>订单id</th>
                                <th>姓名</th>
                                <th>手机号</th>
                                <th>地址</th>
                                <th>金额</th>
                                <th>订单状态</th>
                                <th>支付状态</th>
                                <th>创建时间</th>
                                <th colspan="2">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list list.content as dto>
                            <tr>
                                <td>${dto.orderId}</td>
                                <td>${dto.buyerName}</td>
                                <td>${dto.buyerPhone}</td>
                                <td>${dto.buyerAddress}</td>
                                <td>${dto.orderAmount}</td>
                                <td>${dto.getOrderStatusEnum().msg}</td>
                                <td>${dto.getPayStatusEnum().msg}</td>
                                <td>${dto.createTime}</td>
                                <td><a href="/sell/seller/order/detail?orderId=${dto.orderId}">详情</a></td>
                                <td class="cancel_confirm">
                                    <#if dto.getOrderStatusEnum().msg == "新订单">
                                        <a class="cancel" href="/sell/seller/order/cancel?orderId=${dto.orderId}" onclick="if(confirm('确认取消订单吗？')==false)return false;">取消</a>
                                    </#if>
                                </td>
                            </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-md-12 column">
                        <ul class="pagination pull-right">
                        <#if currentPage lte 1>
                            <li class="disabled"><a href="#">上一页</a></li>
                        <#else >
                            <li><a href="/sell/seller/order/list?page=${currentPage -1}&size=${size}">上一页</a></li>
                        </#if>
                        <#list 1..list.getTotalPages() as index>
                            <#if currentPage == index>
                                <li class="disabled"><a href="#">${index}</a></li>
                            <#else >
                                <li class=><a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                            </#if>
                        </#list>
                        <#if currentPage gte list.getTotalPages()>
                            <li class="disabled"><a href="#">下一页</a></li>
                        <#else >
                            <li><a href="/sell/seller/order/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
                        </#if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="myModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" id="myModalLabel">
                        提醒：
                    </h4>
                </div>
                <div class="modal-body">
                    你有新的订单...
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button onclick="location.reload()" type="button" class="btn btn-primary">查看新的订单</button>
                </div>
            </div>

        </div>

    </div>

    <!-- 播放音乐 -->
    <audio id="notice">
        <source src="/sell/mp3/song.mp3" type="audio/mpeg">
    </audio>

    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script>
        var websocket = null;
        if('WebSocket' in window){
          //判断浏览器是否支持webSocket
          websocket = new WebSocket('ws://1fann.natapp1.cc/webSocket');
//          websocket = new WebSocket('ws://localhost:8099/websocket');
        }else{
          alert("该浏览器不支持WebSocket");
        }

        websocket.onopen = function (event) {
            console.log("建立连接");
        };

        websocket.onclose = function (event) {
             console.log("连接关闭");
        };

        websocket.onmessage = function (event) {
            console.log('收到消息：' + event.data);
            //弹窗提醒，播放音乐
            $("#myModal").modal('show');
//            $('#notice').play();
            document.getElementById('notice').play();
        };

        websocket.onerror = function () {
            alert("WebSocket通信发送错误!");
        };

        window.onbeforeunload = function () {
            websocket.close();
        }
    </script>


</body>
</html>