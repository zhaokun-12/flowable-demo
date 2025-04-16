package com.haiyang.flowablespringboot.handler;

import cn.hutool.extra.spring.SpringUtil;
import org.flowable.engine.TaskService;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;


public class AutoTaskApproveListener implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        String reqName = (String)delegateTask.getVariable("reqName");
        if (reqName.contains("3")) {
            // 自动完成任务
            SpringUtil.getBean(TaskService.class).complete(delegateTask.getId());
            System.out.println("自动完成审批了。。。 reqName:" + reqName);
        }
    }
}
