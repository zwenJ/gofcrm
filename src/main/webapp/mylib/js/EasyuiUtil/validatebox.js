/**
 * 描述: EasyUI 自定义表单验证规则
 * User: jzw
 * Date: 18-2-13
 * Time: 下午1:21
 */
var _type = [1, 2, 3];
var _new_pwd = "";
var _messages = "";

    function StringBuffer() {
        this.__strings__ = new Array;
    }

    StringBuffer.prototype.append = function (str) {
        this.__strings__.push(str);
    };

    StringBuffer.prototype.toString = function () {
        return this.__strings__.join("");
    };

$.extend($.fn.validatebox.defaults.rules, {
    /**
     * 用户密码验证
     */
    userPwd: {
        /**
         * @param value 是你的文本框输入的值
         * @param param 是你自定义的属性参数
         * @returns {boolean}
         */
        validator: function(value, param){
            var _message = new StringBuffer();

            //前缀
            _message.append(_to_prefix(param[0]));

            /**
             * 判断输入的字符串是否为undefined或者长度为0
             */
            if (undefined == value.length || value.length == 0) {
                _message.append("不能为空的！");
                _to_str_message(_message);
                return false;
            }
            else {
                /**
                 * 判断输入的字符串长度是否小于6位
                 */
                if (value.length < 6) {
                    _message.append("长度不应小于6位数字");
                    _to_str_message(_message);
                    return false;
                }
                else {
                    /**
                     * 如果是 新密码 就保存
                     */
                    if (_type[1] == param[0]) {
                        _new_pwd = value;  //记录新密码，用于匹配再次输入的密码是否一致
                    }
                    /**
                     * 如果是 再次确认密码 该怎么判断
                     */
                    else if (_type[2] == param[0]) {
                        if (_new_pwd != value) {
                            _message.append("不一致");
                            _to_str_message(_message);
                            return false;
                        }
                    }
                }
            }
            _message.append("符合要求");
            _to_str_message(_message);
            return true;
        },
        message: _messages+"",
    }
});

/**
 * 处理前缀
 * @param param
 * @private
 */
function _to_prefix(param){
    switch (param) {
        case _type[0]:
           return "原密码";
        case _type[1]:
            return "新密码";
        case _type[2]:
            return "两次密码";
        default:
            return "不符合规范";
    }
}

/**
 * 字符串转换
 * @param strs
 * @private
 */
function _to_str_message(strs){
    _messages = strs.toString();
    console.log(_messages);
}