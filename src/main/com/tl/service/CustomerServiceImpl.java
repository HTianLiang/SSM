package com.tl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.common.utils.Page;
import com.tl.mapper.CustomerMapper;
import com.tl.pojo.Customer;
import com.tl.pojo.QueryVo;

import java.util.List;

/*
    客户管理
 */
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerMapper customerMapper;

    //通过四个条件，查询分页对象
    public Page<Customer> selectPageByQueryVo(QueryVo vo){
        Page<Customer> page = new Page<Customer>();
        //每页数
        page.setSize(10);
        vo.setSize(10);
        if (vo!=null){
            //判断当前页
            if (vo.getPage()!=null){
                page.setPage(vo.getPage());
                //计算开始行==>分页时显示下一组数据
                System.out.println("页数："+vo.getPage());
                System.out.println("行数："+vo.getSize());
                vo.setStartRow((vo.getPage()-1)*vo.getSize());
            }
            if (vo.getCustName()!=null&&"".equals(vo.getCustName().trim())){
                vo.setCustName(vo.getCustName().trim());
            }
            if (vo.getCustSource()!=null&&"".equals(vo.getCustSource().trim())){
                vo.setCustSource(vo.getCustSource().trim());
            }
            if (vo.getCustIndustry()!=null&&"".equals(vo.getCustIndustry().trim())){
                vo.setCustIndustry(vo.getCustIndustry().trim());
            }
            if (vo.getCustLevel()!=null&&"".equals(vo.getCustLevel().trim())){
                vo.setCustLevel(vo.getCustLevel().trim());
            }
            //设置数据总条数
            page.setTotal(customerMapper.customerCountByQueryVo(vo));
            //数据分页结果集
            page.setRows(customerMapper.selectCustomerListByQueryVo(vo));
        }

        return page;
    }

    //弹出修改界面 通过ID查询用户
    @Override
    public Customer selectCustomerById(Integer id) {
        return customerMapper.selectCustomerById(id);
    }

    //修改
    @Override
    public void updateCustomerById(Customer customer) {
        customerMapper.updateCustomerById(customer);
    }

    //删除
    @Override
    public void deleteCustomerById(Integer id) {
        customerMapper.deleteCustomerById(id);
    }

    //新增
    @Override
    public void addCustomer(List<Customer> customer) {
        customerMapper.addCustomer(customer);
    }

}
