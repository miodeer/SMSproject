package cn.ekgc.sms.transport;

import cn.ekgc.sms.pojo.entity.Student;
import cn.ekgc.sms.pojo.vo.SystemPage;

public interface StudentTransport {
	//根据分页信息查询学生列表
	SystemPage<Student> getStudentPage(SystemPage<Student> systemPage) throws Exception;

	//保存学生信息
	boolean saveStudent(Student student) throws Exception;

	//根据id查询信息
	Student getStudentById(Long studentId) throws Exception;
}
