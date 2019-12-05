package cn.ekgc.sms.transport;

import cn.ekgc.sms.pojo.entity.Classroom;
import cn.ekgc.sms.pojo.vo.SystemPage;

public interface ClassroomTransport {
	//根据分页信息查询班级列表
	SystemPage<Classroom> getClassroomPage(SystemPage<Classroom> systemPage) throws Exception;
}
