package cn.ekgc.sms.transport.impl;

import cn.ekgc.sms.pojo.entity.Student;
import cn.ekgc.sms.pojo.vo.SystemPage;
import cn.ekgc.sms.service.StudentService;
import cn.ekgc.sms.transport.StudentTransport;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

@Service(version = "3.0.0", timeout = 5000)
public class StudentTransportImpl implements StudentTransport {
	@Resource(name = "studentService")
	private StudentService studentService;

	//调用service层获取学生列表
	public SystemPage<Student> getStudentPage(SystemPage<Student> systemPage)
			throws Exception {
		return studentService.getStudentPage(systemPage);
	}

	//调用service层存储学生信息
	public boolean saveStudent(Student student) throws Exception {
		return studentService.saveStudent(student);
	}

	//调用service层查找学生信息
	public Student getStudentById(Long studentId) throws Exception {
		return studentService.getStudentById(studentId);
	}
}
