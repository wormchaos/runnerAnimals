package com.wormchaos.service.impl;

import com.wormchaos.dao.ActivityMapper;
import com.wormchaos.dto.rsp.ActivityRsp;
import com.wormchaos.entity.Activity;
import com.wormchaos.service.ActivityService;
import com.wormchaos.utils.MyBeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wormchaos on 2019-5-23.
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Resource
    private ActivityMapper activityMapper;

    @Override
    public List<ActivityRsp> getActivityList(Long userId) {
        List<Activity> activityList = activityMapper.findAll();
//        List<ActivityRsp> rsp = MyBeanUtils.copyPropertiesList(activity, ActivityRsp.class);
        List<ActivityRsp> rspList = new ArrayList<>();
        ActivityRsp rsp;
        for (Activity activity : activityList) {
            rsp = new ActivityRsp();
            rsp.setStartDate(activity.getActivityBeginTime());
            rsp.setEndDate(activity.getActivityEndTime());
            rspList.add(rsp);
        }
        return rspList;
    }
}
