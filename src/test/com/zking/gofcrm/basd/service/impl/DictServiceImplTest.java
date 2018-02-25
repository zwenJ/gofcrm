package com.zking.gofcrm.basd.service.impl;

import com.zking.gofcrm.BaseCodeTest;
import com.zking.gofcrm.common.util.page.PageBean;
import com.zking.gofcrm.basd.model.Dictionary;
import com.zking.gofcrm.basd.service.IDictService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 说明：数据字典 的测试
 *
 * @author Jzw
 * @date 2018/1/30 18:04
 */
public class DictServiceImplTest extends BaseCodeTest{

    @Autowired
    private IDictService dictService;


    /**
     * 添加
     * @throws Exception
     */
    @Test
    public void addObj() throws Exception {

        Dictionary dictionary = new Dictionary();
        dictionary.setDictIsEditable(1);         //是否可以编辑
        dictionary.setDictItem("地区");          //设置字典条例
        dictionary.setDictType("cst_customer");  //该字段所属表
        dictionary.setDictValue("华北地区");     //具体的值

        System.out.println(dictService.addObj(dictionary));

    }


    /**
     * 修改
     * @throws Exception
     */
    @Test
    public void editObj() throws Exception {

        Dictionary dictionary = new Dictionary();
        dictionary.setDictId(2);

        System.out.println(dictService.editObj(dictionary));

    }


    /**
     * 查询、加载
     * @throws Exception
     */
    @Test
    public void listObj() throws Exception {

        PageBean pageBean = new PageBean();
        pageBean.setPaginate(false);  //不开启分页

        for (Dictionary dictionary : dictService.listObj(pageBean)) {
            System.out.println(dictionary);
        }
    }



}