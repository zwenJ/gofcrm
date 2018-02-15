package com.zking.gofcrm.basd.controller;

import com.zking.gofcrm.basd.model.Dictionary;
import com.zking.gofcrm.basd.service.IDictService;
import com.zking.gofcrm.common.controller.ParentController;
import com.zking.gofcrm.common.util.page.Datagrid;
import org.springframework.beans.factory.annotation.Autowired;
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


}
