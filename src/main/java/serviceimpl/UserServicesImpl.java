package serviceimpl;

import dao.AdminDao;
import dao.UserDao;
import entity.PersonEntity;
import entity.User;
import entity.UserPagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.UserService;
import util.FaceIdentifyUtil;
import util.Pagination;

import javax.annotation.Resource;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by alienware on 2017/3/1.
 */
@Service("userService")
@Transactional
public class UserServicesImpl implements UserService{
    @Resource
    private UserDao userDao;

    /**
     *  1. 获得当前的全部会员数量totalCount
     *  2. 创建承载会员对象的分页组件并传入 pageIndex -> 需要的某页 ; pageSize -> 需要的一页显示的数量 ;totalCount -> 总数量
     *  3. 请求相应页的会员信息并返回List
     *  4. 分页组件的总页数的更新控制(在此之前必须先把获取到的List赋值到Pagination.items属性上)
     */
    @Override
    public Pagination getUsers(int pageIndex, int pageSize) {
        int totalCount = userDao.getTotalCount();
        Pagination pagination = new UserPagination(pageIndex,pageSize,totalCount);
        List<User> users =userDao.list((pageIndex-1)*pageSize,pageSize);
        pagination.setItems(users);

        pagination.countTotalPageNum();

        return pagination;
    }

    /**
     *
     * @param uname 查询的会员名 非限定
     * @param pageIndex 以第几页进行显示
     * @param pageSize 每页显示的页数
     * @return Pagination
     */
    @Override
    public Pagination getUsers(String uname, int pageIndex, int pageSize) {
        int totalCount = userDao.getCount(uname);
        Pagination pagination = new UserPagination(pageIndex,pageSize,totalCount);
        List<User> users = userDao.serachByUname(uname,(pageIndex-1)*pageSize,pageSize);

        pagination.setItems(users);

        pagination.countTotalPageNum();
        return pagination;
    }

    @Override
    public Pagination getUsers(int level,int pageIndex, int pageSize) {
        int totalCount = userDao.getCountByLevel(level);
        Pagination pagination = new UserPagination(pageIndex,pageSize,totalCount);
        List<User> users = userDao.searchUsersByLevel(level,(pageIndex-1)*pageSize,pageSize);

        pagination.setItems(users);

        pagination.countTotalPageNum();
        return pagination;

    }


    @Override
    public boolean addUser(User user) {
        boolean result =false;
        if(userDao.add(user)!= -1){
            result=true;
        }
        return result;
    }

    @Override
    public int addUser(List<User> userList) {
        return userDao.addList(userList);
    }

    @Override
    public boolean deleteUser(int userId) {
        return userDao.del(userDao.findById(userId))==-1?false:true;
    }

    @Override
    public boolean deleteUser(List<Integer> uIds) {

        return userDao.delUsers(uIds)== uIds.size()?true:false;
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.update(user)!=-1?true:false;
    }

    @Override
    public User getUserByUid(int userId) {
        return userDao.findById(userId);
    }

    @Override
    public User getUserByOpenId(String openId) {

        return userDao.findUserByOpenId(openId);
    }

    @Override
    public User getUserByUnameAndPwd(String name, String password) {
        return userDao.getUserByNameAndPwd(name,password);
    }

    @Override
    public boolean UserNameUsed(String name) {
        return userDao.getCountByUname(name)>0;
    }

    @Override
    public boolean judgeUser(User user) {
        if(UserNameUsed(user.getUserName())) {
            return false;
        }
        if(userDao.getCountbyEmail(user.getUserEmail()) > 0) {
            return false;
        }
        if(userDao.getCountbyPhone(user.getUserPhone()) > 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean createUserPersonId(User user) {
        PersonEntity personEntity = new PersonEntity();
        String peresistedId=null;
        try {
            user.setPersonId(FaceIdentifyUtil.createaperson("zp",user.getUserName(), user.getUserSex()));
            peresistedId=FaceIdentifyUtil.addface(user.getUserImageUrl(),user.getPersonId(), "zp");
            if(peresistedId!=null){
                if((userDao.update(user))!=-1)
                {
                    return true;
                }
            }
            // System.out.println(peresistedId);
            // System.out.println(peresistedId);

        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User identifyUser(String url) {
        User user = null;
        try {
            FaceIdentifyUtil.traingroup("zp");
            PersonEntity personEntity = new PersonEntity();
            personEntity = FaceIdentifyUtil.factdect(url);
            personEntity=FaceIdentifyUtil.faceident("zp",personEntity.getFaceid(),1,0.5);

            if(personEntity.getPersonid()!=null)
            {

                return userDao.findUserByPersonId(personEntity.getPersonid());
            }
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return user;
    }
}
