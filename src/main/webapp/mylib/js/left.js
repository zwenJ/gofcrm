
$(function(){
    //用于保存分组类型的下标对应的ID
    var auth_id_sz = [];
    var auth_id_index = 0;

    //生成左侧树级菜单
    $.ajax({
        type: "post",
        dataType: "json",
        url:"auth/get",
        data:{
            apId:1,
            at:'FOLDER',
        },
        success: function(data){
            $.each(data, function(i, n){
                $("#accordion_div").accordion("add",{
                    title:n.authText,
                    selected: false,
                    iconCls: n.authImage,
                    content: "<ul name='accordion_tree_"+n.authText+"'></ul>"
                });
                auth_id_sz[auth_id_index] = n.authId;
                auth_id_index++;
            });
        }
    });

    //获取选中的分类面板
    $("#accordion_div").accordion({
        onSelect:function (title, index) {
            //在其内部生成树
            $("ul[name='accordion_tree_"+title+"']").tree({
                url:"auth/tree?apId="+auth_id_sz[index],

                onClick:function (node) {

                    /**
                     * 用于判断用户是否已经登陆
                     */
                    $.post("to/isLogin",{
                        id:1
                    },function(data){
                        console.log(data);
                        //如果没有登陆则，给你重定向到index.html页面
                        if ("error" == data.trim()) {
                            location.href = "html/index.html";
                        }
                    });

                    if ("FOLDER" != node.attributes.authType){

                        //根据选项卡的“标题”/“索引”来判断这个选项卡是否存在
                        var tbas_select = $("#sys_tab").tabs("exists",node.text);
                        //如果存在
                        if (tbas_select) {
                            //则直接选中这个选项卡
                            $("#sys_tab").tabs("select",node.text);
                        }
                        //如果不存在
                        else {
                            //则生成这个选项卡
                            //点击不同的tree节点，生成不同的功能选项卡
                            $("#sys_tab").tabs("add",{
                                title:node.text,
                                fit:true,
                                href:'to/view/'+node.attributes.authUrl,
                                closable:true,
                            });
                        }
                    }
                }
            });
        }
    });
});