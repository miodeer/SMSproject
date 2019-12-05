package cn.ekgc.sms.service.impl;

import cn.ekgc.sms.dao.StudentDao;
import cn.ekgc.sms.pojo.entity.Student;
import cn.ekgc.sms.pojo.vo.SystemPage;
import cn.ekgc.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;

	/**
	 * 学生分页信息
	 * @param systemPage
	 * @return
	 * @throws Exception
	 */
	public SystemPage<Student> getStudentPage(SystemPage<Student> systemPage) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		//分页条件
		paramMap.put("begin", systemPage.getBegin());
		paramMap.put("size", systemPage.getSize());

		//学生列表
		List<Student> list = studentDao.findStudentListByQuery(paramMap);
		//获得总条数
		Long totalSize = (long) studentDao.findStudentListByQuery(null).size();

		systemPage.setList(list);
		systemPage.setTotalSize(totalSize);
		systemPage.setTotalPage();
		return systemPage;
	}

	/**
	 * 存储学生信息
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public boolean saveStudent(Student student) throws Exception {
		try {
			studentDao.saveStudent(student);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 查询学生信息
	 * @param studentId
	 * @return
	 * @throws Exception
	 */
	public Student getStudentById(Long studentId) throws Exception {
		return studentDao.findStudentById(studentId);
	}
}
