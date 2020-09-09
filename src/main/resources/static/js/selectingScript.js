    $("#serviceSelect").change(function(){
    if($(this).val() === '*'){
    $("#variationSelect").show();
}else{
    $("#variationSelect").hide();
}
});
