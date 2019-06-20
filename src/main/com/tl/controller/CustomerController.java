package com.tl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.common.utils.Page;
import com.tl.pojo.BaseDict;
import com.tl.pojo.Customer;
import com.tl.pojo.QueryVo;
import com.tl.service.BaseDictService;
import com.tl.service.CustomerService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
    客户管理
 */
@Controller
public class CustomerController {

    @Autowired
    private BaseDictService baseDictService;
    @Autowired
    private CustomerService customerService;

    //使用Value注解解决硬编码问题：让springmvc加载properties文件
    @Value("${industryType.code}")
    private String industryTypeCode;
    @Value("${fromType.code}")
    private String fromTypeCode;
    @Value("${levelType.code}")
    private String levelTypeCode;

    //入口
    @RequestMapping(value = "/customer/list")
    public String list(QueryVo vo, Model model){

        System.out.println("显示界面数据");
        //显示查询条件内容
        List<BaseDict> industryType = baseDictService.selectBaseDictByCode(industryTypeCode);
        List<BaseDict> fromType = baseDictService.selectBaseDictByCode(fromTypeCode);
        List<BaseDict> levelType = baseDictService.selectBaseDictByCode(levelTypeCode);

        model.addAttribute("industryType",industryType);
        model.addAttribute("fromType",fromType);
        model.addAttribute("levelType",levelType);

        //通过四个条件，查询分页对象
        Page<Customer> page = customerService.selectPageByQueryVo(vo);
        model.addAttribute("page",page);
        //回显
        model.addAttribute("custName", vo.getCustName());
        model.addAttribute("custSource", vo.getCustSource());
        model.addAttribute("custIndustry", vo.getCustIndustry());
        model.addAttribute("custLevel", vo.getCustLevel());
        return "customer";
    }
    //弹出修改界面
    @RequestMapping(value = "/customer/edit.action")
    public @ResponseBody
    Customer edit(Integer id){
        return customerService.selectCustomerById(id);
    }
    //保存修改
    @RequestMapping(value = "/customer/update.action")
    public @ResponseBody
    String update(Customer customer){

        System.out.println("修改："+customer.getCust_id());
        //修改
        customerService.updateCustomerById(customer);

        return "OK";
    }
    //保存更改
    @RequestMapping(value = "/customer/delete.action")
    public @ResponseBody
    String delete(Integer id){

        System.out.println("删除："+id);
        //删除
        customerService.deleteCustomerById(id);

        return "OK";
    }
    //新增
    @RequestMapping(value = "customer/updateAdd.action")
    @ResponseBody
    public String add(Customer customer) {

        List<Customer> list = new ArrayList<>();
        Customer cs = new Customer();
        cs.setCust_name(customer.getCust_name());
        cs.setCust_source(customer.getCust_source());
        cs.setCust_industry(customer.getCust_industry());
        cs.setCust_level(customer.getCust_level());
        cs.setCust_linkman(customer.getCust_linkman());
        cs.setCust_phone(customer.getCust_phone());
        cs.setCust_mobile(customer.getCust_mobile());
        cs.setCust_zipcode(customer.getCust_zipcode());
        cs.setCust_address(customer.getCust_address());
        cs.setCust_createtime(new Date());
        list.add(cs);
        customerService.addCustomer(list);
        System.out.println("用户 "+cs.getCust_name());

        return "OK";
    }

}
