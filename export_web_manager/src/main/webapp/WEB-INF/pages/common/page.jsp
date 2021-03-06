<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<body>
<div class="pull-left">
    <div class="form-group form-inline">
        总共${pageInfo.pages} 页，共${pageInfo.total} 条数据。每页
        <select id="curPageSize" class="form-control" onchange="goPageSize()">
            <option value="${pageInfo.pageSize}" selected="selected">${pageInfo.pageSize}</option>
            <option value="5">5</option>
            <option value="15">15</option>
            <option value="20">20</option>
            <option value="50">50</option>
        </select>条
    </div>
</div>

<div class="box-tools pull-right">
    <ul class="pagination" style="margin: 0px;">
        <li>
            <a href="javascript:goPage(1)" aria-label="Previous">首页</a>
        </li>
        <li><a href="javascript:goPage(${pageInfo.prePage})">上一页</a></li>


        <c:if test="${pageInfo.pages <= 10}">
            <c:forEach begin="${1}" end="${pageInfo.pages}" var="i">
                <li class="paginate_button ${pageInfo.pageNum==i ? 'active':''}"><a
                        href="javascript:goPage(${i})">${i}</a>
                </li>
            </c:forEach>
        </c:if>
        <c:if test="${pageInfo.pages > 10}">
            <c:if test="${pageInfo.pageNum <= 5}">
                <c:forEach begin="${1}" end="${10}" var="i">
                    <li class="paginate_button ${pageInfo.pageNum==i ? 'active':''}"><a
                            href="javascript:goPage(${i})">${i}</a>
                    </li>
                </c:forEach>
            </c:if>

            <c:if test="${pageInfo.pageNum > 5 && pageInfo.pageNum+5 < pageInfo.pages }">
                <c:forEach begin="${pageInfo.pageNum - 4 > 0 ? pageInfo.pageNum - 4 : 1}" end="${pageInfo.pageNum + 5 < pageInfo.pages? pageInfo.pageNum+5:pageInfo.pages}" var="i">
                    <li class="paginate_button ${pageInfo.pageNum==i ? 'active':''}"><a
                            href="javascript:goPage(${i})">${i}</a>
                    </li>
                </c:forEach>
            </c:if>

            <c:if test="${pageInfo.pageNum > 5 && pageInfo.pageNum+5 >= pageInfo.pages }">
                <c:forEach begin="${pageInfo.pages - 9}" end="${pageInfo.pages}" var="i">
                    <li class="paginate_button ${pageInfo.pageNum==i ? 'active':''}"><a
                            href="javascript:goPage(${i})">${i}</a>
                    </li>
                </c:forEach>
            </c:if>

        </c:if>
        <li><a href="javascript:goPage(${pageInfo.nextPage})">下一页</a></li>
        <li>
            <a href="javascript:goPage(${pageInfo.pages})" aria-label="Next">尾页</a>
        </li>
    </ul>
</div>
<form id="pageForm" action="${param.pageUrl}" method="post">
    <input type="hidden" name="pageNum" id="pageNum">
    <input type="hidden" name="pageSize" id="pageSize">
    <input type="hidden" name="likeName" id="likeName2"/>
</form>
<script>
    function goPage(pageNum) {
        let pageSize = $("#curPageSize").val();
        document.getElementById("pageNum").value = pageNum;
        $("#likeName2").val($("#likeName").val());
        document.getElementById("pageSize").value = pageSize;
        document.getElementById("pageForm").submit();
    }

    function goPageSize() {
        let pageSize = $("#curPageSize").val();
        document.getElementById("pageSize").value = pageSize;
        document.getElementById("likeName2").value = $("#likeName").val();
        document.getElementById("pageForm").submit();
    }

    function search() {
        let val = $("#likeName").val();
        let pageSize = $("#curPageSize").val();
        location.href = "${pageContext.request.contextPath}/company/list.do?likeName=" + val + "&pageSize=" + pageSize;
    }
</script>
</body>
</html>
