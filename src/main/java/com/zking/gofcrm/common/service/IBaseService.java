package com.zking.gofcrm.common.service;

import com.zking.gofcrm.common.util.page.PageBean;

import java.util.List;
import java.util.Map;

/**
 * 说明：基础接口
 * 面向接口编程，一个最底层的接口，定义每个Service实现的最基本功能
 *
 * @author Jzw
 * @date 2018/1/17 13:52
 */
public interface IBaseService<T> {

    /**
     * 通用增加的方法，传入对象，返回true/false
     * @param t
     * @return
     */
    public boolean addObj(T t);

    /**
     * 通用删除方法，传入id，返回处理结果
     * @param id
     * @return
     */
    public boolean delObj(Integer id);

    /**
     * 通用编辑（修改）方法，传入要修改的对象（必须保证要有主键(id)）
     * @param t
     * @return
     */
    public boolean editObj(T t);

    /**
     * 加载（获取）一个对象，条件重PageBean的Map属性中获取，根据 K/V 式
     * @param pageBean
     * @return
     */
    public T loadObj(PageBean pageBean);

    /**
     * 获取一个集合的对象，条件从PageBean的Map中获取，支持分页查询
     * @param pageBean
     * @return
     */
    public List<T> listObj(PageBean pageBean);

    /**
     * doAssignment  执行任务（工作）
     * 只需告诉我执行是否成功
     * 使用Map集合保存参数，目的是：执行任务无法保证参数究竟有多少！（参数是个未知数）
     *
     * @param map
     * @return
     */
    public boolean doAssignment(Map<String, Object> map);

}
