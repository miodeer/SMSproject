package cn.ekgc.sms.service;

import cn.ekgc.sms.pojo.entity.Student;
import cn.ekgc.sms.pojo.vo.SystemPage;

public interface StudentService {
	//获取学生列表
	SystemPage<Student> getStudentPage(SystemPage<Student> systemPage) throws Exception;
	//存储学生信息
	boolean saveStudent(Student student) throws Exception;
	//根据id获取学生信息
	Student getStudentById(Long studentId) throws Exception;
}
