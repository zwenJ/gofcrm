package com.zking.gofcrm.dictionary.service.impl;

import com.zking.gofcrm.BaseCodeTest;
import com.zking.gofcrm.common.util.page.PageBean;
import com.zking.gofcrm.dictionary.model.Dictionary;
import com.zking.gofcrm.dictionary.service.IDictService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

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
        dictionary.setDictValueId("暂无");       //该条例 所 对应 的对象编号

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
        dictionary.setDictValueId("1");

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