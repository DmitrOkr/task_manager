<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>
<@c.page>
<div class="form-row" xmlns:form="http://www.w3.org/1999/html" xmlns:form="http://www.w3.org/1999/html">
</div>

    <form method="post" action=/ticket-update>

    <label for="id">Id</label>
        <input readonly type="number"  class="form-control"name="id" value="${ticket.id}"/>
    <br/>
    <label for="date">Дата</label>
    <input readonly type="text" class="form-control" name="" value="${ticket.date}" />

    <br/>
    <label for="message">Сообщение</label>
    <input readonly type="text"  class="form-control"name="message" value="${ticket.message}"/>
    <br/>

    <label for="author">Автор</label>
        <input readonly type="text" class="form-control"name="" value="${ticket.authorName}" />

    <br/>
    <label for="status">Статус</label>
        <input  type="text"  class="form-control"name="status" value="${ticket.getStatus().getStatusName()}"/>
    <br/>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <input type="submit" ata-toggle="collapse" href="#collapseExample" role="button"  value="Обновить">
</form>

</@c.page>



