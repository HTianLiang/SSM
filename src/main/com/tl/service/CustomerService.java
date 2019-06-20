package com.tl.service;

import com.common.utils.Page;
import com.tl.pojo.Customer;
import com.tl.pojo.QueryVo;

import java.util.List;

public interface CustomerService {

    //通过四个条件，查询分页对象
    public Page<Customer> selectPageByQueryVo(QueryVo vo);
    //弹出修改界面 通过ID查询客户
    public Customer selectCustomerById(Integer id);
    //通过ID修改客户
    public void updateCustomerById(Customer customer);
    //通过ID删除客户
    public void deleteCustomerById(Integer id);
    //新增客户
    public void addCustomer(List<Customer> customer);

}
