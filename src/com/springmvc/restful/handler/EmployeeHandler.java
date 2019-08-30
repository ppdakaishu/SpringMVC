package com.springmvc.restful.handler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.springmvc.restful.entity.Employee;
import com.springmvc.restful.entity.Person;
import com.springmvc.restful.exception.ResponseStatusExceptionResolver;
import com.springmvc.restful.service.DepartmentService;
import com.springmvc.restful.service.EmployeeService;

import sun.security.util.Password;

@Controller
@RequestMapping(value="employeeHandler")
public class EmployeeHandler {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
//	@Autowired
//	private ResourceBundleMessageSource messageSource;
	
	public EmployeeHandler() {
		System.out.println("EmployeeHandler....................");
	}
	
	@RequestMapping(value="simpleMappingException")
	public String SimpleMappingException(@RequestParam(value="val") int val) {
		String[] array = new String[10];
		for(int i = 0; i < 10; i++) {
			array[i] = "array [ " + i + " ]";
		}
		System.out.println(array[val]);
		return "success";
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="ResponseStatus标记方法")
	@RequestMapping(value="/responseStatus")
	public String ResponseStatus(@RequestParam(value="val") int val) {
		if(val != 10) {
			throw new ResponseStatusExceptionResolver();
		}
		System.out.println("responseStatus...");
		return "success";
	}
	
	/*
	@ExceptionHandler({NumberFormatException.class})
	public ModelAndView handlerNumberFormatException(Exception ex) {
		System.out.println("出现异常 ： [ NumberFormatException ] "  + ex);
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("exception", ex);
		return mv;
	}
	*/
	
	@RequestMapping(value="/exceptionHandler")
	public String exceptionHandler(@RequestParam(value="val") String val) {
		System.out.println(Integer.parseInt(val));
		return "success";
	}
	
	/** 文件上传 */
	@RequestMapping(value="/multipart")
	public String fileUpload(@RequestParam(value="desc") String desc, @RequestParam(value="file") MultipartFile file) throws IOException {
		System.out.println("Desc : [ " + desc + " ]");
		System.out.println("originalFileName : [ " + file.getOriginalFilename() + " ]");
		System.out.println("fileName : [ " + file.getName() + " ]");
		System.out.println("inputStream : [ " + file.getInputStream() + " ]");
		return "success";
	}
	
//	@RequestMapping(value="/i18n")
//	public String i18n(Locale locale) {
//		String user = messageSource.getMessage("i18n.user", null, locale);
//		String password = messageSource.getMessage("i18n.password", null, locale);
//		System.out.println("user : [ " + user + " ], password : [ " + password + " ]");
//		return "i18n";
//	}
	
	/** 文件下载 */
	@RequestMapping(value="/responseEntity")
	public ResponseEntity<byte[]> responseEntity(HttpSession session) throws IOException {
		ServletContext servletContext = session.getServletContext();
		InputStream in = servletContext.getResourceAsStream("/WEB-INF/images/downLoadFile.txt");
		byte[] body = new byte[in.available()];
		in.read(body);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=downLoadFile.txt");
		
		HttpStatus status = HttpStatus.OK;
		
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, headers, status);
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value="/httpMessageConverter")
	public String httpMessageConverter(@RequestBody String body) {
		System.out.println(body);
		return "httpMessageConverter Test.  Time : [ " + new Date() + " ]";
	}
	
	@RequestMapping(value="/jsonTestT")
	public @ResponseBody Person jsonTestT(@RequestBody Person[] persons) {
		for(Person person : persons) {
			System.out.println("name : [ " + person.getName() + " ], password : [ " + person.getPassword() + " ]");
		}
		return new Person("x","xx");
	}
	
	@RequestMapping(value="/jsonTestO")
	public @ResponseBody Collection<Employee> jsonTestO(@RequestParam(value="employeeId", required=false) String data) {
		System.out.println(data);
		return employeeService.getEmployees();
	}
	
	/*
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		//setDisallowedFields : 注册不允许绑定的字段。默认值为无。
		//setAllowedFields : 注册允许绑定的字段。默认为所有字段。
		webDataBinder.setDisallowedFields("age");
	}
	*/
	
	@RequestMapping(value="/conversionService")
	public String converters(@RequestParam("employeeStr") Employee employee) {
		System.out.println(employee);
		employeeService.save(employee);
		return "redirect:/employeeHandler/emps";
	}
	
	/*
	@ModelAttribute
	public void getEmployee(@RequestParam(value="id", required=false) Integer employeeId, Map<String, Object> map) {
		if(employeeId != null) {
			Employee employee = employeeService.getEmployee(employeeId);
			System.out.println("获取 id 为 [ " + employeeId + " ] 的 employee 对象");
			map.put("employee", employee);
		}
	}
	*/
	
	/** 提交修改员工 重定向至展示员工列表*/
	@RequestMapping(value="/emp", method=RequestMethod.PUT)
	public String update(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employeeHandler/emps";
	}
	
	/** 修改时打开添加员工页面 */
	@RequestMapping(value="/emp/{id}", method=RequestMethod.GET)
	public String input(@PathVariable(value="id") Integer id, Map<String, Object> map) {
		Map<String, String> genders = new HashMap<String, String>();
		genders.put("0", "Male");
		genders.put("1", "Female");
		
		map.put("departments", departmentService.getDepartments());
		map.put("genders", genders);
		map.put("employee", employeeService.getEmployee(id));
		return "input";
	}
	
	/** 删除员工 重定向至展示员工列表 */
	@RequestMapping(value="/emp/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") Integer id) {
		employeeService.deleteEmployee(id);
		return "redirect:/employeeHandler/emps";
	}
	
	/** 提交添加员工 重定向至展示员工列表 */
	@RequestMapping(value="/emp", method=RequestMethod.POST)
	public String save(@Valid Employee employee, BindingResult result, Map<String, Object> map) {
		System.out.println(employee);
		if(result.getFieldErrorCount() > 0) {
			for(FieldError error : result.getFieldErrors()) {
				System.out.println(error.getField() + " : " + error.getDefaultMessage());
			}
			//如果跳转至input界面, 需加上如下代码 ： 
			/*
			Map<String, String> genders = new HashMap<String, String>();
			genders.put("0", "Male");
			genders.put("1", "Female");
			map.put("departments", departmentService.getDepartments());
			map.put("genders", genders);
			return "input";
			*/
			return "error";
		}
		
		employeeService.save(employee);
		return "redirect:/employeeHandler/emps";
	}
	
	/** 打开添加员工页面 */
	@RequestMapping(value="/emp", method=RequestMethod.GET)
	public String input(Map<String, Object> map) {
		Map<String, String> genders = new HashMap<String, String>();
		genders.put("0", "Male");
		genders.put("1", "Female");
		
		map.put("departments", departmentService.getDepartments());
		map.put("genders", genders);
		map.put("employee", new Employee());
		return "input";
	}
	
	/** 展示员工列表 */
	@RequestMapping(value="/emps")
	public String list(Map<String, Object> map) {
		map.put("employees", employeeService.getEmployees());
		return "list";
	}
	
}
