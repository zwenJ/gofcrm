package com.zking.gofcrm.basd.service.impl;

import com.zking.gofcrm.common.util.page.PageBean;
import com.zking.gofcrm.basd.mapper.DictionaryMapper;
import com.zking.gofcrm.basd.model.Dictionary;
import com.zking.gofcrm.basd.service.IDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/30 17:53
 */
@Service("DictServiceImpl")
public class DictServiceImpl implements IDictService {

    @Autowired
    private DictionaryMapper dictionaryMapper;

    /**
     * 通用增加的方法，传入对象，返回true/false
     *
     * @param dictionary
     * @return
     */
    public boolean addObj(Dictionary dictionary) {
        if (dictionaryMapper.insert(dictionary) > 0) {
            return true;
        }
        return false;
    }

    /**
     * 通用删除方法，传入id，返回处理结果
     *
     * @param id
     * @return
     */
    public boolean delObj(Integer id) {
        return false;
    }


    /**
     * 通用编辑（修改）方法，传入要修改的对象（必须保证要有主键(id)）
     *
     * @param dictionary
     * @return
     */
    public boolean editObj(Dictionary dictionary) {

        if (null != dictionary && null != dictionary.getDictId() && 0 != dictionary.getDictId()) {
            //先判断是否执行修改
            Dictionary dictionary1 = dictionaryMapper.selectByPrimaryKey(dictionary.getDictId());
            if (dictionary1.getDictIsEditable()==1){
                //可以修改
                int update = dictionaryMapper.updateByPrimaryKeySelective(dictionary);
                if (update>0) {
                    return true;
                }
            }
        }

        return false;
    }


    /**
     * 加载（获取）一个对象，条件重PageBean的Map属性中获取，根据 K/V 式
     *
     * @param pageBean
     * @return
     */
    public Dictionary loadObj(PageBean pageBean) {
        return null;
    }


    /**
     * 获取一个集合的对象，条件从PageBean的Map中获取，支持分页查询
     *
     * @param pageBean
     * @return
     */
    public List<Dictionary> listObj(PageBean pageBean) {
        return dictionaryMapper.selectByMap(pageBean.getParameterMap());
    }


    /**
     * doAssignment  执行任务（工作）
     * 只需告诉我执行是否成功
     * 使用Map集合保存参数，目的是：执行任务无法保证参数究竟有多少！（参数是个未知数）
     *
     * @param map
     * @return
     */
    public boolean doAssignment(Map<String, Object> map) {
        return false;
    }

}
