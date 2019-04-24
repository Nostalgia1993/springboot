package com.example.service.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Post;
import com.example.mapper.PostMapper;
import com.example.service.PostService;
import com.example.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author notalgia
 * @since 2019-04-23
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

    @Autowired
    RedisUtils redisUtils;

    public void initIndexWeekRank(){
        //缓存最近7天的文章评论数
        List<Post> posts = this.list(new QueryWrapper<Post>().ge("created", DateUtil.offsetDay(new Date(), -7)));
        for (Post post : posts) {
            String key = "day_rank:"+DateUtil.format(post.getCreated(),DatePattern.PURE_DATE_PATTERN);
            //设置有效期
            long expireTime = (7-DateUtil.between(new Date(),post.getCreated(),DateUnit.DAY))*24*60*60;
            //缓存文章到redis中
            redisUtils.zSet(key,post.getId(),post.getCommentCount());
            


        }


    }








}
