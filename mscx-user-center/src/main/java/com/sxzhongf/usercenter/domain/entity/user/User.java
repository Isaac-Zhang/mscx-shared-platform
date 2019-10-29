package com.sxzhongf.usercenter.domain.entity.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;
import javax.persistence.*;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User
//    implements Comparable<User>
{
    /**
     * Id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 微信id
     */
    @Column(name = "wx_id")
    private String wxId;

    /**
     * 微信昵称
     */
    @Column(name = "wx_nickname")
    private String wxNickname;

    /**
     * 角色
     */
    private String roles;

    /**
     * 头像地址
     */
    @Column(name = "avatar_url")
    private String avatarUrl;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 积分
     */
    private Integer bonus;

//    public static void main(String[] args) {
//        User user1 = new User();
//        user1.setBonus(10);
//
//        User user2 = new User();
//        user2.setBonus(20);
//
//        User user3 = new User();
//        user3.setBonus(30);
//
//        User user4 = new User();
//        user4.setBonus(40);
//
//        User user5 = new User();
//        user5.setBonus(30);
//
//        User user6 = new User();
//        user6.setBonus(60);
//
//
//        List<User> list = new ArrayList<>();
//        list.add(user3);
//        list.add(user1);
////        list.add(user2);
////        list.add(user3);
////        list.add(user5);
////        list.add(user6);
////        list.add(user4);
//
//
//        Collections.sort(list);
//
//        System.out.println(list.get(0).getBonus()+"-----User:"+list.get(0));
//    }
//
//    @Override
//    public int compareTo(User o) {
//        User t = this;
//        if(o.getBonus()==30){
//            return -1;//当前元素>20
//        }
//
//        int r = this.getBonus().compareTo(o.getBonus());
//        return -r;
//    }
}