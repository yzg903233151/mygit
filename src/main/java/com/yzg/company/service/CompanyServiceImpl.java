package com.yzg.company.service;

import com.yzg.company.dao.CompanyMapper;
import com.yzg.company.entity.Page;
import com.yzg.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("CompanyService")
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public int count() {
        return companyMapper.count();
    }

    @Override
    public List<User> userShow(Page<User> page, Map map) {
        int totalCount=this.count();//计算总条数

        page.setTotalCount(totalCount);//保存总条数

        int startSize =(page.getCurrentPage()-1)*page.getPageSize();//计算分页

        System.out.println(page.getCurrentPage()+"计算时："+page.getTotalCount()+">>>>>"+startSize+">>");

        map.put("currentpages",startSize);
        map.put("pageSize", page.getPageSize());
        return companyMapper.userShow(map);
    }

    @Override
    public int del(User user) {
        return companyMapper.del(user);
    }

    @Override
    public List<User> userList(User user) {
        return companyMapper.userList(user);
    }

    @Override
    public int update_(User user) {
        return companyMapper.update_(user);
    }

    @Override
    public List<User> user_rec(Page<User> page, Map map) {
        System.out.println("进入了》》》》");
        int totalCount=this.user_reccount();//计算总条数

        page.setTotalCount(totalCount);//保存总条数

        int startSize =(page.getCurrentPage()-1)*page.getPageSize();//计算分页

        System.out.println(page.getCurrentPage()+"计算时："+page.getTotalCount()+">>>>>"+startSize+">>");

        map.put("currentpages",startSize);
        map.put("pageSize", page.getPageSize());
        return companyMapper.user_rec(map);
    }

    @Override
    public int user_reccount() {
        return companyMapper.user_reccount();
    }
}
