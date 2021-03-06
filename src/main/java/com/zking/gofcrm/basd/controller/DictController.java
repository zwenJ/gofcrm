package com.zking.gofcrm.basd.controller;

import com.zking.gofcrm.basd.model.Dictionary;
import com.zking.gofcrm.basd.service.IDictService;
import com.zking.gofcrm.common.controller.ParentController;
import com.zking.gofcrm.common.message.Message;
import com.zking.gofcrm.common.util.combo.Combo;
import com.zking.gofcrm.common.util.page.Datagrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 说明：数据字典Controller
 *
 * @author Jzw
 * @date 2018/1/30 17:47
 */
@RequestMapping(value = "/dict", method = RequestMethod.POST)
public class DictController extends ParentController {

    @Autowired
    private IDictService dictService;

    /**
     * 前台数据表格的数据
     * @param datagrid
     * @return
     */
    @RequestMapping("/show")
    @ResponseBody
    public Datagrid show(Datagrid datagrid) {

        List<Dictionary> dictionaryList = dictService.listObj(pageBean);

        datagrid.setTotal(pageBean.getTotalRecord());
        datagrid.setRows(dictionaryList);

        return datagrid;
    }



    @RequestMapping(value = "/getDictTypeList", method = RequestMethod.GET)
    @ResponseBody
    public List<Combo> getDictTypeList() {
        return dictService.getDictTypelist();
    }


    /**
     * 添加数据字典条例
     * @param message
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Message add(@ModelAttribute("dictionary") Dictionary dictionary, Message message){

        if (null == dictionary) {
            message.setMessage("不能添加空数据！");
            message.setResult(false);
            return message;
        }

        boolean addObj = dictService.addObj(dictionary);
        if (addObj) {
            message.setMessage("添加成功！");
        }
        else {
            message.setMessage("添加失败！");
        }
        message.setResult(addObj);

        return message;
    }



    @RequestMapping("/remove")
    @ResponseBody
    public Message remove(@ModelAttribute("dictId") Integer dictId, Message message) {
        message.setType("DEL_DICT");
        if (dictId == null) {
            message.setMessage("参数错误！");
            message.setDatas();
            message.setStatus("DICT-10003");
            return message;
        }

        // TODO: 2018/2/25 通知业务逻辑层实现移除操作
        boolean delObj = dictService.delObj(dictId);
        message.setResult(delObj);

        if (!delObj) {
            message.setMessage("操作失败！");
            message.setDatas();
            message.setStatus("DICT-10002");
            return message;
        }

        message.setMessage("操作成功！");
        message.setStatus("DICT-10001");
        message.setDatas();
        return message;
    }


}
