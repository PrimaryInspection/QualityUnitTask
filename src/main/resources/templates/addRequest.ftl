<#import "parts/common.ftl" as c>

<@c.page>
<form method="post">
    <div class="container">

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Query Type:</label>
            <div class="col-sm-1">
                <p><input type="radio" id="C" name="queryType" value="C"/>C-type</p>
                <p><input type="radio" id="D" name="queryType" value="D"/>D-type</p>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Response Type:</label>
            <div class="col-sm-1">
                <p><input type="radio" id="P" name="responseType" value="P"/>P-type</p>
                <p><input type="radio" id="N" name="responseType" value="N"/>N-type</p>
            </div>
        </div>

        <div  class="form-group row">
            <label class="col-sm-2 col-form-label">Service Type:</label>
            <div class="col-sm-1">
                <select id="serviceSelect" name="service">
                    <#list serviceList as service>
                        <option value="${service.name}">${service.name}</option>
                    </#list>
                </select>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Variation Type:</label>
            <div class="col-sm-1">
                <select  id="variationSelect" name="variation">
                    <#list variationList as variation>
                        <option value="${variation.id}">${variation.name}</option>
                    </#list>
                </select>
            </div>
        </div>

        <div id="questionSelect" class="form-group row">
            <label class="col-sm-2 col-form-label">Question Type:</label>
            <div class="col-sm-1">
                <select name="question">
                    <#list questionList as question>
                        <option value="question">${question.name}</option>
                    </#list>
                </select>
            </div>
        </div>

        <div id="categorySelect" class="form-group row">
            <label class="col-sm-2 col-form-label">Category Type:</label>
            <div class="col-sm-1">
                <select name="category">
                    <#list categoryList as category>
                        <option value="category">${category.name}</option>
                    </#list>
                </select>
            </div>
        </div>

        <div id="subCategorySelect" class="form-group row">
            <label class="col-sm-2 col-form-label">Sub-Category Type:</label>
            <div class="col-sm-1">
                <select name="subCategory">
                    <#list subCategoryList as subCategory>
                        <option value="subCategory">${subCategory.name}</option>
                    </#list>
                </select>
            </div>
        </div>





    </div>
</form>

</@c.page>