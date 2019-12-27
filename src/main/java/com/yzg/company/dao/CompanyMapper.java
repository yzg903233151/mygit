package com.yzg.company.dao;

import com.yzg.company.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("CompanyMapper")
public interface CompanyMapper {
    public int count();

    public List<User> userShow(Map map);

    public int del(User user);

    public List<User> userList(User user);

    public int update_(User user);

    public List<User> user_rec(Map map);

    public int user_reccount();
}
