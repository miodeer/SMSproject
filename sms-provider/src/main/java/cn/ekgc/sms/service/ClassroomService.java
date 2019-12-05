package cn.ekgc.sms.service;

import cn.ekgc.sms.pojo.entity.Classroom;
import cn.ekgc.sms.pojo.vo.SystemPage;

public interface ClassroomService {
	//获取班级列表
	SystemPage<Classroom> getClassroomPage(SystemPage<Classroom> systemPage) throws Exception;
}
