package com.zking.gofcrm.common.service.impl;

import com.zking.gofcrm.authority.mapper.CrmIdSufUtilMapper;
import com.zking.gofcrm.authority.model.CrmIdSufUtil;
import com.zking.gofcrm.common.service.ICsfService;
import com.zking.gofcrm.common.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 说明：动态主键后缀业务
 *
 * @author Jzw
 * @date 2018/1/17 16:19
 */
@Service
public class CrmIdSufServiceImpl implements ICsfService{

    @Autowired
    private CrmIdSufUtilMapper crmIdSufUtilMapper;

    @Autowired
    private CrmIdSufUtil crmIdSufUtil;


    /**
     * 获取主键
     * tableName 为主键后缀生成规则实体类简称 如 SysUser 应为 USER，
     *
     * @param tableName
     * @return
     */
    public String doIdSuf(String tableName) {

        StringBuilder sbId = new StringBuilder();
        Object[] objects = DateUtil.getDateString();

        //调用主键规则服务层
        crmIdSufUtil.setCisTable(tableName);
        crmIdSufUtil.setCisDate((Date) objects[1]);

        // TODO: 2018/1/17  获取主键后缀
        /**
         *  判断这个表是否已经在该规则中注册；
         *  Y 判断日期是否跟原来一至
         *    Y 获取 cis_key 的值，然后执行 cis_key+1 保存
         *      return cis_key（原）
         *    N 修改 cis_date 为目前日期的值 ，修改 cis_key 为 100001
         *      return 100001
         *  N 新增一列， cis_table = 查询的表名， cis_date 为当前日期， cis_key 默认 100001
         *    return 100001
         */

        CrmIdSufUtil crmIdSufUtil1 = crmIdSufUtilMapper.selectByPrimaryKey(crmIdSufUtil.getCisTable());
        //判断该表是否已经注册
        if (null != crmIdSufUtil1) {
            //判断时间是否相等，转换成字符串比较
            if (DateUtil.dateToString(crmIdSufUtil.getCisDate()).
                    equalsIgnoreCase(DateUtil.dateToString(crmIdSufUtil1.getCisDate()))) {
                //读取目前的 ID 值
                crmIdSufUtil.setCisKey(crmIdSufUtil1.getCisKey());

                //在此基础上+1
                crmIdSufUtil1.setCisKey(crmIdSufUtil1.getCisKey()+1);
            }
            //时间不相等
            else {
                //设置为当前时间
                crmIdSufUtil1.setCisDate(crmIdSufUtil.getCisDate());
            }
            //数据库修改
            crmIdSufUtilMapper.updateByPrimaryKeySelective(crmIdSufUtil1);
        }
        //未注册
        else {
            //插入一条数据
            crmIdSufUtil.setCisKey(crmIdSufUtil.getCisKey()+1);
            crmIdSufUtilMapper.insert(crmIdSufUtil);
            crmIdSufUtil.setCisKey(crmIdSufUtil.getCisKey()-1);
        }

        sbId.append("CRM-");
        sbId.append(tableName+"-");
        sbId.append(objects[0]+"-");
        sbId.append(crmIdSufUtil.getCisKey());

        return sbId.toString();
    }



}
