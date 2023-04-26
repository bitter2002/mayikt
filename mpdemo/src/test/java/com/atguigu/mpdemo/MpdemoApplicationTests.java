package com.atguigu.mpdemo;

import com.atguigu.mpdemo.mapper.UserMapper;
import com.atguigu.mpdemo.entity.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.plaf.PanelUI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MpdemoApplicationTests {
    @Autowired
    private UserMapper userMapper;

    //查询student表中所有数据
    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    //添加操作
    @Test
    public void addStudent() {
        User user = new User();
        user.setAge(19);
        user.setName("gouzi");
        user.setEmail("23@qq.com");
        int insert = userMapper.insert(user);
        System.out.println("insert:" + insert);
    }

    //修改操作
    @Test
    public void updateUser() {
        User user = new User();
        user.setId(3L);
        user.setAge(29);
        int row = userMapper.updateById(user);
        System.out.println(row);
    }

    //测试乐观锁
    @Test
    public void testOptimisticLocker() {
        //根据id查询数据
        User user = userMapper.selectById(1627171449443729409L);
        //进行修改
        user.setAge(120);
        userMapper.updateById(user);
    }

    //多个id批量查询
    @Test
    public void testSelectDemo() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        System.out.println(users);
    }

    @Test
    public void testSelectByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Jone");
        map.put("age", 18);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    //分页查询
    @Test
    public void testPage() {
        //1.创建一个page对象
        //传两个参数
        Page<User> page = new Page<>(1, 3);
        //调用mp分页查询方法
        userMapper.selectPage(page, null);

        //通过page对象获取分页数据
        System.out.println(page.getCurrent());//当前页
        System.out.println(page.getRecords());//每页数据list集合
        System.out.println(page.getSize());//每页显示记录数
        System.out.println(page.getTotal());//总记录数
        System.out.println(page.getPages());//总页数

        System.out.println(page.hasNext());//下一页
        System.out.println(page.hasPrevious());//上一页
    }

    //物理删除
    @Test
    public void testDeleteById() {
        int result = userMapper.deleteById(1626831924284657666L);
        System.out.println("result:"+result);
    }
    //批量删除
    @Test
    public void testDeleteBatchIds() {
        int result = userMapper.deleteBatchIds(Arrays.asList(1626816225369677825L, 1626816199356624897L));
        System.out.println(result);
    }
    //逻辑删除

    @Test
    public void testLogicDelete() {
        int result = userMapper.deleteById(1626807241791283202L);
        System.out.println(result);
    }

    //mp实现复杂查询操作
    @Test
    public void testSelectQuery(){
        //创建QueryWrapper对象
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //通过QueryWrapper设置条件
        //ge、gt、le、lt、isNull、isNotNull
        //查询age>=20的数据
        queryWrapper.ge("age",20);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        //eq、ne

        //between、notBetween

        //like、notLike、likeLeft、likeRight

        //orderByDesc
    }
}
