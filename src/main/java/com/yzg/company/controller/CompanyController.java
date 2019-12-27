package com.yzg.company.controller;

import com.alibaba.fastjson.JSON;
import com.yzg.company.entity.Page;
import com.yzg.company.entity.User;
import com.yzg.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CompanyController {
    private Map map = new HashMap();
    private Page<User> page = new Page<User>();
    HttpSession session = null;

    @Autowired
    private CompanyService companyService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/show")
    public String show(HttpServletRequest request, HttpServletResponse response, Model model){
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");


        model.addAttribute("username",request.getParameter("username"));

        map.put("username",request.getParameter("username"));
        String currentPage = request.getParameter("pageIndex");//分页页面

        if(currentPage==null) {
            currentPage="1";
        }


        page.setCurrentPage(Integer.parseInt(currentPage));//第几页
        map.put("CurrentPage", page.getCurrentPage());//获取当前页

        List<User> list=companyService.userShow(page,map);


        page.setList(list);//存入分页实体类中去前台遍历
        page.setTotalPage(page.getTotalPage());
        //request.setAttribute("tablelist", page);
        model.addAttribute("tablelist",page);

        System.out.println(page.getTotalPage()+">>>>>>>>>末页"+page.getTotalCount()+list.size());
        return "show";
    }

    @RequestMapping("/del")
    @ResponseBody
    public String del(User user){
        return JSON.toJSONString(companyService.del(user));
    }

    @RequestMapping("/update")
    public String update(HttpServletRequest request,User user,Model model){
        session = request.getSession();
        session.setAttribute("userId",request.getParameter("id"));
        List<User> list = companyService.userList(user);
        model.addAttribute("li",list);
        return "update";
    }

    @RequestMapping("/updates")
    @ResponseBody
    public String up(HttpServletRequest  request){
        User user = new User();
        user.setId(Integer.parseInt(session.getAttribute("userId").toString()));
        user.setUserSection(request.getParameter("userSection"));
        user.setUserPosition(request.getParameter("userPosition"));
        user.setUserPath(Double.parseDouble(request.getParameter("userPath")));
        user.setRejiaos(request.getParameter("rejiaos"));
        companyService.update_(user);
        return "update";
    }

    @RequestMapping("/recordlis")
    public String recordlis(HttpServletRequest request,HttpServletResponse response,Model model){
        Map map=new HashMap();
        Page<User> page=new Page<User>();
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");


        model.addAttribute("userName",request.getParameter("userName"));

        map.put("userName",request.getParameter("userName"));
        String currentPage = request.getParameter("pageIndex");//分页页面

        if(currentPage==null) {
            currentPage="1";
        }


        page.setCurrentPage(Integer.parseInt(currentPage));//第几页
        map.put("CurrentPage", page.getCurrentPage());//获取当前页

        List<User> list=companyService.user_rec(page,map);


        page.setList(list);//存入分页实体类中去前台遍历
        page.setTotalPage(page.getTotalPage());
        //request.setAttribute("tablelist", page);
        model.addAttribute("tablelist",page);

        System.out.println(page.getTotalPage()+">>>>>>>>>末页"+page.getTotalCount()+list.size());
        return "recordList";
    }
}
