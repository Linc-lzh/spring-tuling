package cn.tulingxueyuan.service.impl;

import cn.tulingxueyuan.dao.IUserDao;
import cn.tulingxueyuan.entity.User;
import cn.tulingxueyuan.service.ILogService;
import cn.tulingxueyuan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDao userDao;

    @Autowired
    ILogService logService;
    /**
     * 转账
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void trans(){
        logService.log();
        sub();  // 张三扣钱
        save();
    }

    /**
     * 扣钱
     */
    // @Transactional(propagation = Propagation.SUPPORTS)   // 只适用于该事务方法是一个查询
    @Transactional(timeout = 2)
    public  void sub() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("张三扣钱");
        userDao.sub();
    }

    /**
     * 存钱
     * @return
     */
    @Transactional
    public void save(){
        System.out.println("李四加钱");
        int i=1/0;
        userDao.save();
    }




    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User getUser(){
       return userDao.getUser();
    }

    @Transactional(readOnly = true)
    public void getUsers(){
          userDao.getUser();
        userDao.getUser();
        userDao.getUser();
    }


    //@Transactional(rollbackFor = {Exception.class})
    //@Transactional(noRollbackFor = {RuntimeException.class})
    public void tranException() throws Exception {
        userDao.sub();
        throw  new RuntimeException("测试");
    }
}
