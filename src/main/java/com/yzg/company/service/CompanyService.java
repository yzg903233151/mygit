package com.yzg.company.service;

import com.yzg.company.entity.Page;
import com.yzg.company.entity.User;

import java.util.List;
import java.util.Map;

public interface CompanyService {
    public int count();

    public List<User> userShow(Page<User> page, Map map);

    public int del(User user);

    public List<User> userList(User user);

    public int update_(User user);

    public List<User> user_rec(Page<User> page,Map map);

    public int user_reccount();
}
