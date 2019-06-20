package com.tl.mapper;

import com.tl.pojo.Customer;
import com.tl.pojo.QueryVo;

import java.util.List;

public interface CustomerMapper {

    //查询总条数
    public Integer customerCountByQueryVo(QueryVo vo);
    //分页结果集
    public List<Customer> selectCustomerListByQueryVo(QueryVo vo);

    //弹出修改界面 通过ID查询客户
    public Customer selectCustomerById(Integer id);
    //通过ID修改客户
    public void updateCustomerById(Customer customer);
    //通过ID删除客户
    public void deleteCustomerById(Integer id);
    //新增客户
    public void addCustomer(List<Customer> customer);

}
