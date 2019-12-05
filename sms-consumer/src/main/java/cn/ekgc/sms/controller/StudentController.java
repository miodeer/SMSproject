package cn.ekgc.sms.controller;

import cn.ekgc.sms.pojo.entity.Classroom;
import cn.ekgc.sms.pojo.entity.Student;
import cn.ekgc.sms.pojo.vo.SystemPage;
import cn.ekgc.sms.transport.ClassroomTransport;
import cn.ekgc.sms.transport.StudentTransport;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("studentController")
@RequestMapping("/student")
public class StudentController {
	@Reference(version = "3.0.0")
	private StudentTransport studentTransport;
	@Reference(version = "3.0.0")
	private ClassroomTransport classroomTransport;

	@RequestMapping(value = "/index", method=RequestMethod.GET)
	public String forwardStudentIndex() throws Exception {
		return "student/student_index";
	}

	/**
	 * 学生列表分页显示
	 * @param pageNum
	 * @param pageSize
	 * @param draw
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public SystemPage<Student> getStudentPage(Integer pageNum, Integer pageSize, Integer draw)
			throws Exception {
		SystemPage<Student> systemPage = new SystemPage<Student>(pageNum, pageSize, draw);
		systemPage = studentTransport.getStudentPage(systemPage);
		return systemPage;
	}

	/**
	 * 添加页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String forwardAddForm() throws Exception {
		return "student/student_add";
	}

	/**
	 * 提交添加信息
	 * @param student
	 * @param classroomId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public boolean saveStudent(Student student, Long classroomId)
			throws Exception {
		//班级信息
		Classroom classroom = new Classroom();
		classroom.setClassroomId(classroomId);
		student.setClassroom(classroom);

		Integer genderCode = Integer.parseInt(student.getIdCard().substring(16, 17));
		if (genderCode % 2 == 0) {
			student.setGender("F");
		} else {
			student.setGender("M");
		}
		return studentTransport.saveStudent(student);
	}

	/**
	 * 更改学生信息
	 * @param studentId
	 * @param map
	 * @return
	 * @throws Exception
	 */
//	@RequestMapping(value = "/update/{studentId}", method = RequestMethod.GET)
//	public String forwardUpdatePage(@PathVariable("studentId") Long studentId, ModelMap map)
//			throws Exception {
//		Student student = studentTransport.getStudentById(studentId);
//
//		//设定不分页查询条件
//		SystemPage<Classroom> systemPage = new SystemPage<>(null, null, null);
//		systemPage.setBegin(null);
//		systemPage.setSize(null);
//
//		//班级信息
//		List<Classroom> classroomList = classroomTransport.getClassroomPage(systemPage).getList();
//
//		map.put("student", student);
//		map.put("classroomList", classroomList);
//		return "student/student_update";
//	}

}
