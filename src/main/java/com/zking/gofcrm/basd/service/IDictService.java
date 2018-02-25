package com.zking.gofcrm.basd.service;

import com.zking.gofcrm.common.service.IBaseService;
import com.zking.gofcrm.basd.model.Dictionary;
import com.zking.gofcrm.common.util.combo.Combo;

import java.util.List;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/30 17:52
 */
public interface IDictService extends IBaseService<Dictionary> {


    /**
     * 获取数据字典类型集合
     * @return
     */
    public List<Combo> getDictTypelist();

}
