<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="form-row" xmlns:form="http://www.w3.org/1999/html" xmlns:form="http://www.w3.org/1999/html">
        <div class="form-group col-md-6">
            <form method="get" action="/main" class="form-inline">
                <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Поиск по id">
                <button type="submit" class="btn btn-primary ml-2">Поиск</button>
            </form>
        </div>
    </div>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Новая заявка
    </a>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-4">
            <form method="post">

                <!-- <div class="form-group">
                <input type="text"  class="form-control" name="date" placeholder="Дата создания">
                </div>-->
                <div class="form-group">
                    <input type="text"  class="form-control"name="message" placeholder="Введите сообщение" />
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />

                <div class="form-group">
                    <select name="status" class="form-control"name="status"  required>
                        <option value="Создан" label ="Создан"/>
                    </select>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />

                <div class="form-group">
                    <button type="submit" class="btn btn-primary ml-2">Отправить заявку</button>
                </div>
            </form>
        </div>
    </div>

    <div class="form-group mt-3">
        <div class="container">
            <div class="row">
                <div class="col">
                    <b>ID</b>
                </div>
                <div class="col">
                    <b>Дата</b>
                </div>
                <div class="col">
                    <b>Сообщение</b>
                </div>
                <div class="col">
                    <b>Автор</b>
                </div>
                <div class="col">
                    <b>Статус</b>
                </div>
            </div>
        </div>
        <#list tickets as ticket>

            <div class="container">
                <div class="row">
                    <div class="col">
                        ${ticket.id}
                    </div>
                    <div class="col">
                        <col><span>${ticket.date}</span></col>
                    </div>
                    <div class="col">
                        <col><span>${ticket.message}</span></col>
                    </div>
                    <div class="col">
                        ${ticket.authorName}
                    </div>
                    <#if !isAdmin>

                <div class="col">

                    <col><span>${ticket.getStatus().getStatusName()}</span></col>

                </div>

                    </#if>
                    <#if isAdmin>


                        <div class="col">
                                <form method="post">
                                    <div class="form-group">

                                        <col><span>${ticket.getStatus().getStatusName()}</span></col>
                                        <td><a href="/ticket-update/ ${ticket.id}">Изменить</a></td>
                                    </div>

                                </form>

                            </div>
                    </#if>

                </div>
            </div>
        <#else>
            Нет тикетов
        </#list>
    </div>
</@c.page>