package com.czg.jtgl.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.czg.jtgl.model.YpjgRegcom;

public class JtglDAO extends HibernateDaoSupport{
      public List findYpjgRegcomByUserid(String userid){
             String hql="from Bdjg t where 1=1 ";
             List list = this.getHibernateTemplate().find(hql);
             if(list.size()>0){
            	 return list;
             }
             return null;
      }
      
      
}
