$(function(){
    $('#sys_tab').tabs('add',{
        'title':'首页',
        'href':'html/home.html'
    });
    $('#layout_body').layout('hidden','east');
//        $('#layout_body').layout('unsplit','east');
    $(".menu_accordion").find("ul li").bind("click",function () {
        //将其他的样式背景的active处理掉，然后在当前的li上面加上active
        $(".menu_accordion").find("ul li").removeClass("checkactive");
        $(this).closest("li").addClass("checkactive");
    });
});
function showTab(title,url) {
    var tab = $('#sys_tab').tabs('getTab',title);
    if(tab!=null){
        $('#sys_tab').tabs('select',title);
    }else{
        $('#sys_tab').tabs('add',{
            'title':title,
            'href':url,
            'closable':true
        });
        $('#layout_body').layout('hidden','east');
    }
}
function layoutresize() {
    $("body").onresize(function () {
        $('#layout_body').layout("resize");
    });
}
function loadWin(title,url) {
    $('#win_main').window({
        width:$(window).width()*0.618,
        height:$(window).height()*0.618,
        modal:true,
        title:title,
        href:url,
        collapsible:false,
        minimizable:false,
        maximizable:false
    });
    $('#win_main').window('center');
    $('#win_main').window('open');
}
function loadWin2(title,url) {
    $('#win_main_2').window({
        width:$(window).width()*0.618*0.618,
        height:$(window).height()*0.618*0.618,
        modal:true,
        title:title,
        href:url,
        collapsible:false,
        minimizable:false,
        maximizable:false
    });
    $('#win_main_2').window('center');
    $('#win_main_2').window('open');
}