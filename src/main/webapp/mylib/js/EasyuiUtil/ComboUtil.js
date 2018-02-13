/**
 * 描述:针对于 EasyUI 的 Combo 下拉菜单栏做的工具封装
 *     基于 jQuery 、EasyUI , 使用前需要导入 jQuery 依赖 和 EasyUI 组件
 * User: jzw
 * Date: 18-2-13
 * Time: 下午12:30
 */
(function(window, $){

    /**
     * 定义工具对象
     * @type {{}}
     */
    var ComboUtil = {};

    /**
     * 配置工具参数
     */
    var _method = ["get", "post"];    //请求方式
    var _valueField = "id";           //明显不可见的 绑定到该组合框（ComboBox）的 value 上的基础数据的名称。
    var _textField = "text";          //明显可见的 绑定到该组合框（ComboBox）的 text 上的基础数据的名称。
    var _editable = [true, false];    //为true时用户可以直接输入文本到字段中
    var _limitToList = [true, false]; //设置为true时，输入的值只能是列表框中的内容 与 editable 共用


    /**
     * 渲染下拉框
     * @param config
     */
    ComboUtil.showCombobx = function (config){
        if (undefined == config.method) {
            config.method = _method[0];  //默认是get方式加载数据
        }
        if (undefined == config.valueField) {
            config.valueField = _valueField;
        }
        if (undefined == config.textField) {
            config.textField = _textField;
        }
        if (undefined == config.editable ) {
            config.editable = _editable[1];
        }
        if (undefined == config.limitToList) {
            config.limitToList = _limitToList[1];
        }

        console.log(config);

        _combo(config);
    }


    /**
     * 渲染下拉框的底层实现
     * @param config
     * @private
     */
    function _combo(config){
        $(config.id).combobox({
            url:config.url,
            method:config.method,
            valueField:config.valueField,
            textField:config.textField,
            limitToList:config.limitToList,
        });
    }

    window.ComboUtil = ComboUtil;
})(window, jQuery);
    