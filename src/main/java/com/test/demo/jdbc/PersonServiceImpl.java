package com.test.demo.jdbc;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by ryan on 2017/6/5.
 */
//@Component
//@Transactional(propagation = Propagation.REQUIRED)
public class PersonServiceImpl implements PersonService {

  //  @Resource
//  PlatformTransactionManager txManager;
//  @Resource
//  TransactionDefinition txDefinition;
  @Resource
  PersonDao personDao;
//  TransactionTemplate txTemplate;
//
//  @Resource
//  private void setTransactionManager(PlatformTransactionManager txManager) {
//    this.txTemplate = new TransactionTemplate(txManager);
//  }

  @Override
  public void addPerson(Person person) {
    // 第一种方式 事务管理的代码散落在业务逻辑中，破坏了原有代码的条理性
//    TransactionStatus txStatus = txManager.getTransaction(txDefinition);
//
//    try {
//      personDao.addPerson(person);
//      txManager.commit(txStatus);
//      System.out.println("addPerson success");
//    } catch (Exception e) {
//      txManager.rollback(txStatus);
//      System.out.println("addPerson error");
//    }
    // 通过transationTemplate 可以省掉提交事务 和 创建事务这两步
//    txTemplate.execute(new TransactionCallbackWithoutResult() {
//      @Override
//      protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
//        personDao.addPerson(person);
//        System.out.println("addPerson success");
//      }
//    });
    // 最后一种方式，通过@transactional 注解 或 aop事务配置方式，可以实现0事务代码
    personDao.addPerson(person);
  }
}
