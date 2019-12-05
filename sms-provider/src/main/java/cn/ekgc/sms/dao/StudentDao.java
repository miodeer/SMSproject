package cn.ekgc.sms.dao;

import cn.ekgc.sms.pojo.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {
	//dao层获取学生列表
	List<Student> findStudentListByQuery(Map<String, Object> paramMap) throws Exception;
	//dao层存储学生信息
	void saveStudent(Student student) throws Exception;
	//dao层查找学生信息
	Student findStudentById(Long studentId) throws Exception;
}
