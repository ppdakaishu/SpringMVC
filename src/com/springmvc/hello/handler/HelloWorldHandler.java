package com.springmvc.hello.handler;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.hello.entity.Address;
import com.springmvc.hello.entity.User;
import com.springmvc.hello.views.HelloExcelView;


@Controller
@RequestMapping(value="/springmvc")
@SessionAttributes(value= {"abc"}, types={User.class})
public class HelloWorldHandler {
	
	private final String SUCCESS = "success";

	/**
	 * 1. 使用 @RequestMapiing 注释来映射请求的 URL
	 * 2. 返回值会通过试图解析器解析为实际的物理试图，对于 InternalResourceViewResolver 试图解析器，会做如下解析 ： 
	 * 		通过 prefix + returnVal + suffix 得到实际的物理试图，然后做转发操作
	 * */
	@RequestMapping(value="/hello", 
					method=RequestMethod.GET, 
					params={"username","password"}, 
					headers={"Accept-Language=zh-CN","Host=localhost:8080"})
	public String hello() {
		System.out.println("hello springmvc");
		return SUCCESS;
	}
	
//	@RequestMapping("/antStyle??")
//	@RequestMapping("/antStyle/**")
	@RequestMapping("/antStyle/*")
	public String antStyle() {
		System.out.println("Ant Style");
		return SUCCESS;
	}
	
	/**
	  *  可以来映射 URL 中的占位符到目标方法的参数中
	 * */
	@RequestMapping(value="/pathVariable/{param}")
	public String pathVariable(@PathVariable(value="param") String param) {
		System.out.println("pathVariable test [ param = " + param + " ]");
		return SUCCESS;
	}
	
	@RequestMapping(value="/restGet/{param}", method=RequestMethod.GET)
	public String restGet(@PathVariable(value="param") String param) {
		System.out.println("正在获取参数为 [ param = " + param + " ] 的数据");
		return SUCCESS;
	}
	
	@RequestMapping(value="/restPost", method=RequestMethod.POST)
	public String restPost() {
		System.out.println("正在向数据库中添加数据");
		return SUCCESS;
	}
	
	/** 无法直接使用 return SUCCESS 完成页面的跳转，因为tomcat8以后，JSP接口不允许接收来自于PUT、DELETE的访问 */
	/** 使用重定向实现页面跳转 */
	@RequestMapping(value="/restDelete/{param}", method=RequestMethod.DELETE)
	public String restDelete(@PathVariable(value="param") String param) {
		System.out.println("正在删除参数为 [ param = " + param + " ] 的数据");
		return "redirect:/springmvc/restGet/oop";
//		return SUCCESS;
	}

	@RequestMapping(value="/restPut/{param}", method=RequestMethod.PUT)
	public String restPut(@PathVariable(value="param") String param) {
		System.out.println("正在更新参数为 [ param = " + param + " ] 的数据");
		return "redirect:/springmvc/restGet/oop";
//		return SUCCESS;
	}
	
	/**
	 * 通过处理方法的形参与请求参数进行绑定。形参声明前加上 @RequestParam(value="前端部件的name属性")
	 * */
	@RequestMapping(value="/requestParam", method=RequestMethod.POST)
	public String requestParam(@RequestParam(value="username") String name,
							   @RequestParam(value="password", required=false, defaultValue="123") String ps) {
		System.out.println("username : " + name);
		System.out.println("password : " + ps);
		return SUCCESS;
	}
	
	/**
	 * 映射请求参数头，同 @RequestParam
	 * */
	@RequestMapping(value="/requestHeader")
	public String requestHeader(@RequestHeader(value="Accept-Language") String al) {
		System.out.println("Accept-Language : " + al);
		return SUCCESS;
	}
	
	/**
	 * 映射一个Cookie，同 @RequestParam
	 * */
	@RequestMapping(value="/cookieValue")
	public String cookieValue(@CookieValue(value="JSESSIONID") String al) {
		System.out.println("JSESSIONID : " + al);
		return SUCCESS;
	}

	/**
	 * Spring MVC 会按请求参数名和POJO属性名进行自动匹配
	 * 自动为该对象填充属性值，支持级联属性。如 user.username 、 user.address.city
	 * */
	@RequestMapping(value="/pojo")
	public String pojo(User user) {
		System.out.println("User : " + user);
		return SUCCESS;
	}
	
	/**
	 * 可以使用 Servlet 原生的 API 作为目标参数
	 * @throws IOException 
	 * */
	@RequestMapping(value="/servletAPI")
	public void servletAPI(HttpServletRequest request, HttpServletResponse response, Writer out) throws IOException {
		System.out.println(request);
		System.out.println(response);
		System.out.println(request.getParameter("id"));
		out.write("hello servletAPI");
//		return SUCCESS;
	}
	
	@RequestMapping(value="/modelAndView")
	public ModelAndView modelAndView() {
		//创建 ModelAndView 对象
		ModelAndView mv = new ModelAndView();
		//设置试图
		mv.setViewName(SUCCESS);
		//添加模型数据
		//ModelAndView 模型数据的值，放到Request范围当中
		mv.addObject("name","chenbowen");
		return mv;
	}
	
	@RequestMapping(value="/map")
	public String map(Map<String, Object> map) {
		map.put("usernameMap", Arrays.asList("chenbowenMap","chenbowenMap1","chenbowenMap2"));
		return SUCCESS;
	}
	
	@RequestMapping(value="/model")
	public String map(Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("usernameModels","chenbowenModels");
		model.addAllAttributes(map);
		
		model.addAttribute("usernameModel", "chenbowenModel");
		return SUCCESS;
	}
	
	@RequestMapping(value="/modelMap")
	public String map(ModelMap modelmap) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("usernameModelMaps","chenbowenModelMaps");
		modelmap.addAllAttributes(map);
		
		modelmap.addAttribute("usernameModelMap", "chenbowenModelMap");
		return SUCCESS;
	}
	
	@RequestMapping(value="/sessionAttributes")
	public String sessionAttributes(Map<String, Object> map) {
		map.put("sessionAttributes","sessionAttributes");
		return SUCCESS;
	}
	
	@RequestMapping(value="/sessionAttributesJump")
	public String sessionAttributesJump(Map<String, Object> map) {
		return "sessionAttributes";
	}
	
	/**
	 * 运行流程 ： 
	 * 		1. 执行 @ModelAttribute 注释修饰的方法 ： 从数据库取出对象, 把对象放入到了 Map 中， 键为 : user
	 * 		2. Spring MVC 从 Map 中取出  User 对象, 并把表单的请求参数赋给该 User 对象的对应属性.
	 * 		3. Spring MVC 把上述对象传入目标方法的参数.
	 * 
	 * SpringMVC 确定目标方法 POJO 类型入参的过程
	 * 		1. 确定一个 key : 
	 * 			1) 若目标方法的 POJO 类型的参数没有使用 @ModelAttribute 作为修饰, 则 key 为 POJO 类名第一个字母的小写.
	 * 			2) 若使用了 @ModelAttribute 来修饰, 则 key 为 @ModelAttribute 注解的 value 属性值. 
	 * 		2. 在 implicitModel 中查找 key 对应的对象, 若存在, 则作为入参传入
	 * 			1) 若在 @ModelAttribute 标记的方法中在 Map 中保存过, 且 key 和 1 确定的 key 一致, 则会获取到. 
	 * 		3. 若 implicitModel 中不存在 key 对应的对象, 则检查当前的 Handler 是否使用 @SessionAttributes 注解修饰, 
	 * 			若使用了该注解, 且 @SessionAttributes 注解的 value 属性值中包含了 key, 则会从 HttpSession 中来获取 key 所
	 * 			对应的 value 值, 若存在则直接传入到目标方法的入参中. 若不存在则将抛出异常. 
	 * 		4. 若 Handler 没有标识 @SessionAttributes 注解或 @SessionAttributes 注解的 value 值中不包含 key, 则
	 * 		      会通过反射来创建 POJO 类型的参数, 传入为目标方法的参数. 
	 * 		5. SpringMVC 会把 key 和 POJO 类型的对象保存到 implicitModel 中, 进而会保存到 request 中. 
	 * 
	 * 源码分析流程 ： 
	 * 		1. 调用  @ModelAttribute 注解修饰的方法. 实际上是把 @ModelAttribute 方法中的 Map 中的数据放到了 implicitModel 中.
	 * 		2. 解析请求处理器的目标参数, 实际上该目标参数来自于 WebDataBinder 对象的 Target 属性
	 * 			1) 创建 WebDataBinder 对象 ： [ 包含 objectName 及 target 属性 ]
	 * 				1> 确定  objectName 属性 ： 若传入的 attrName 属性值为"", 则 objectName 为类名第一个字母小写. 
	 * 					注意 ： 若目标方法的 POJO 属性使用了 @ModelAttribute 来修饰, 则 attrName 值即为 @ModelAttribute 的
	 * 						   value 属性值. [ 若没有用  @ModelAttribute 来修饰， 则  attrName 为类名第一个字母小写 ]
	 * 				2> 确定 target 属性
	 * 					① 在 implicitModel 中查找 attrName 对应的属性值
	 * 						若 implicitModel 中存在 attrName 对应的属性值, 则确定 target. 
	 * 						若 implicitModel 中不存在 attrName 对应的属性值, 则检查当前 Handler[ 处理器 ] 是否使用了
	 * 						@SessionAttribute 进行修饰, 
	 * 							若使用了 @SessionAttribute 进行修饰, 则尝试从 Session 中获取 attrName 所对应的属性值. 
	 * 								若 Session 中存在对应的属性值, 则确定 target. 
	 * 								若 Session 中没有对应的属性值 , 则抛出异常.
	 * 							若未使用 @SessionAttribute 进行修饰, 或 @SessionAttribute 中没有使用 value 值指定的 key 
	 * 							和 attrName 相匹配,
	 * 								则通过反射创建POJO, 
	 * 			2) SpringMVC 把表单的请求参数赋给了  WebDataBinder 的 target 对应的属性. 
	 * 			3) SpringMVC 会把 WebDataBinder 的 attrName 和 target 给到 implicitModel. 进而传到 request 域对象中. 
	 * 			4) 把 WebDataBinder 的 target 作为参数传递给目标方法入参. 
	 * 								
	 * 					
	 * */
	@RequestMapping(value="/modelAttribute")
	public String modelAttribute(@ModelAttribute(value="updateUser") User user) {
		System.out.println("修改 User 并准备存入数据库 ： " + user);
		return SUCCESS;
	}
	
	/**
	 * 1. 有 @ModelAttribute 标记的方法，会在每个目标方法执行之前被 SpringMVC 调用
	 * 2. @ModelAttribute 注解也可以来修饰目标方法 POJO 类型的入参, 其 value 属性值有如下的作用 : 
	 * 		1) SpringMVC 会使用 value 属性值在 implicitModel 中查找对应的对象, 若存在则会直接传入到目标方法的入参中.
	 * 		2) SpringMVC 会以 value 为 key, POJO 类型的对象为 value, 存入到 request 中. 
	 * */
	@ModelAttribute
	public void getUser(@RequestParam(value="userId", required=false) Integer userId, Map<String, Object> map) {
		if(userId != null) {
			Address address = new Address("Cd", "Sc");
			User user = new User(1, "chenbowen", "123456", "70129526@qq.com", address);
			System.out.println("模拟从数据库中获取一个对象 ： " + user);
			map.put("user", user);
		}
	}
	
	@RequestMapping("/beanNameViewResolver")
	public String testView() {
		System.out.println("test beanNameViewResolver [ 自定义视图 ] ");
		return "helloView";
	}
	
	@RequestMapping(value = "/excelView")    
	public ModelAndView excelView() {
		System.out.println("test excelView");
		Map<String, Object> model = new HashMap<>();
		model.put("userList", getUserList());
		return new ModelAndView(new HelloExcelView(), model);
	}
	
	private List<User> getUserList(){
		Address address = new Address("Chengdu", "Sichuan");
		User user = new User(1, "chenbowen", "ww10250230", "70129526@qq.com", address);
		List<User> UserList = new ArrayList<User>();
		UserList.add(user);
		return UserList;
	}
	
	@RequestMapping(value = "/redirect")    
	public String redirect(Map<String, Object> map) {
		System.out.println("test redirect");
		map.put("name", "chenbowen");
//		return SUCCESS; //直接返回SUCCESS, 请求域 [ ${requestScope.name} ] 中有值
		return "redirect:/success"; //通过SpringMVC配置文件中mvc:view-controller转发到success.jsp页面
									//success.jsp, 请求域 [ ${requestScope.name} ] 中没有值
	}
	
	@RequestMapping(value = "/forward")    
	public String forward(Map<String, Object> map) {
		System.out.println("test redirect");
		map.put("name", "chenbowen");
//		return SUCCESS; //直接返回SUCCESS, 请求域 [ ${requestScope.name} ] 中有值
		return "forward:/success"; //通过SpringMVC配置文件中mvc:view-controller转发到success.jsp页面
									//success.jsp, 请求域 [ ${requestScope.name} ] 中有值
	}

}

