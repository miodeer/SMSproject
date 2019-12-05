package cn.ekgc.sms.transport.impl;

import cn.ekgc.sms.pojo.entity.Classroom;
import cn.ekgc.sms.pojo.vo.SystemPage;
import cn.ekgc.sms.service.ClassroomService;
import cn.ekgc.sms.transport.ClassroomTransport;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

@Service(version = "3.0.0")
public class ClassroomTransportImpl implements ClassroomTransport {
	@Resource(name = "classroomService")
	private ClassroomService classroomService;

	//调用service层获取班级列表
	public SystemPage<Classroom> getClassroomPage(SystemPage<Classroom> systemPage)
			throws Exception {
		return classroomService.getClassroomPage(systemPage);
	}
}
