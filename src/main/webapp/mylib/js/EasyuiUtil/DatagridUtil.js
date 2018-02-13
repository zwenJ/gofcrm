/**
 * 描述:针对于 EasyUI 的 Datagrid 数据表格做的工具封装
 *     基于 jQuery 、EasyUI , 使用前需要导入 jQuery 依赖 和 EasyUI 组件
 * User: jzw
 * Date: 18-2-13
 * Time: 下午12:30
 */
;
(function(window, $){

    var DatagridUtil = {};

    /**
     * 参数配置
     * _fitColumns 表格大小是否适应父容器
     * _pagination 是否显示底部分页工具栏
     * _rownumbers 是否显示行号
     * _singleSelect 只允许选中一行
     */
    var _base_val = [true, false];
    var _fitColumns = _base_val;
    var _pagination = _base_val;
    var _rownumbers = _base_val;
    var _singleSelect = _base_val;

    /**
     * 默认使用
     * @param config
     * @param columns
     */
    DatagridUtil.showDefaultDatagrid = function (config,columns){
        console.log(config);

        config.fitColumns = _fitColumns[0];
        config.pagination = _pagination[0];
        config.rownumbers = _rownumbers[0];
        config.singleSelect = _singleSelect[0];
        config.columns = columns;

        _datagrid(config);
    }

    /**
     * 自定义渲染 参数完全按照自己的配置
     * @param config
     */
    DatagridUtil.showDatagrid = function (config){
        console.log(config);
        _datagrid(config);
    }

    /**
     * 生成数据网格
     * @param config
     * @private
     */
    function _datagrid(config) {
        $(config.id).datagrid({
            url:config.url,
            fitColumns:config.fitColumns,
            pagination:config.pagination,
            rownumbers:config.rownumbers,
            singleSelect:config.singleSelect,
            toolbar: config.toolbar,
            columns:config.columns
        });
    }

    window.DatagridUtil = DatagridUtil;
})(window, jQuery);