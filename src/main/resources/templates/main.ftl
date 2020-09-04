<#import "parts/common.ftl" as c>

<@c.page>
    <h3 align="center">List of Requests(Now/Total - ${size}/${total})</h3>
    <form method="get" action="/" class="form-inline">
        <input type="number" min="0" name="limit" class="form-control" value="${limit!}" placeholder="Choose limit"/>
        <button type="submit" class="btn btn-primary ml-2">Search</button>
    </form>

    <#if requestList??>
        <table class="table">
            <thead class="thead-inverse">
            <tr>
                <th>#</th>
                <th>Query Type</th>
                <th>Service</th>
                <th>Variation</th>
                <th>Question Type</th>
                <th>Category</th>
                <th>Sub Category</th>
                <th>Response Type</th>
                <th>Date</th>
                <th>Waiting Time(min)</th>
                <th>Code</th>
            </tr>
            </thead>
            <tbody>

            <#list requestList as request>
                <tr>
                    <td>${request.id}</td>
                    <td>${request.queryType}</td>
                    <td>${request.serviceId.name}</td>
                    <#if request.serviceId.variationId??>
                        <td>${request.serviceId.variationId.name}</td>
                    <#else>
                        <td>--</td>
                    </#if>
                    <td>${request.questionId.name}</td>
                    <#if request.questionId.categoryId??>
                        <td>${request.questionId.categoryId.name}</td>
                        <#if request.questionId.categoryId.subCategoryId??>
                            <td>${request.questionId.categoryId.subCategoryId.name}</td>
                        <#else>
                            <td>--</td>
                        </#if>
                    <#else>
                        <td>--</td>
                        <td>--</td>
                    </#if>
                    <td>${request.responseType}</td>
                    <#if request.queryType?starts_with("C")>
                        <td>${request.date}</td>
                    <#else>
                        <td>${request.startDate} - ${request.endDate}</td>
                    </#if>
                    <#if request.queryType?starts_with("C")>
                        <td>${request.responseWaitTime}</td>
                        <td>${request.serviceId.id}
                            <#if request.serviceId.variationId??>
                                .${request.serviceId.variationId.id!}
                            </#if>
                            |${request.questionId.id}
                            <#if request.questionId.categoryId??>
                                .${request.questionId.categoryId.id!}
                                <#if request.questionId.categoryId.subCategoryId??>
                                    .${request.questionId.categoryId.subCategoryId.id!}
                                </#if>
                            </#if>
                            |${request.responseType}| ${request.date}| ${request.responseWaitTime}</td>
                    <#else>
                        <td></td>
                        <#if request.serviceId.name?starts_with("*")>
                            <td>*
                        <#else>
                            <td>${request.serviceId.id}
                        </#if>

                        <#if request.serviceId.variationId??>
                            .${request.serviceId.variationId.id}
                        </#if>
                        |<#if request.questionId.name?starts_with("*")>
                        *
                    <#else>
                        ${request.questionId.id}
                    </#if>
                        <#if request.questionId.categoryId??>
                            .${request.questionId.categoryId.id}
                            <#if request.questionId.categoryId.subCategoryId??>
                                .${request.questionId.categoryId.subCategoryId.id}
                            </#if>
                        </#if>
                        |${request.responseType}|${request.startDate} - ${request.endDate}</td>

                    </#if>
                </tr>
            </#list>
            </tbody>
        </table>
    </#if>


    <#if average??>
        <h2>Average response time</h2>
        <table class="table">
            <thead class="thead-inverse">
            <tr>
                <th>Request №</th>
                <th>Average time(min)</th>
            </tr>
            </thead>
            <tbody>
            <#list average as key, value>
                <tr>
                    <td>${key}</td>
                    <td>${value}</td>
                </tr>
            </#list>

            <tr>
            </tr>
            </tbody>
        </table>
    </#if>

</@c.page>