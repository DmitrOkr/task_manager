<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <@l.login "/login" false/>
<a href="/registration">Добавить пользователя</a>
</@c.page>