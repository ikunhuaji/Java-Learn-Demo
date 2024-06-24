# Java 学习代码记录
## 大二智能设备开发学习

------

### 1 线程与多线程

- [Socket 主机客户端连接示例 demo](https://github.com/ikunhuaji/Java-Learn-Demo/tree/master/Webnet)
  - **demo1:** 建立连接并接收客户端传来的信息
  - **demo2:** 启动多线程，实现服务端一对多，自定义客户端信息
  - **demo3:**  课上连接老师服务端用的客户端代码
  - **demo4:** 基于 UDP 的 DatagramSocket 实现客户端与服务端的互相传信息
  - **homework1:** 心跳超时检测作业
- [ServerSocket 与多线程 老师demo](https://github.com/ikunhuaji/Java-Learn-Demo/tree/master/sockettest1)
  - **demo1:** ServerSocket 建立服务端客户端连接
  - **demo2:** 启动多线程，实现服务端一对多，自定义客户端信息
  - **demo3:** 老师的服务端以及超时结束线程
  - **demo4:** 屏幕捕捉窗口
- [初识 Servlet 创建注册界面](https://github.com/ikunhuaji/Java-Learn-Demo/tree/master/webee1)
  - **RegistServlet:** 注册服务 Servlet
  - **index.html:** 主界面
  - **web.xml 中** < servlet > 与 < servlet-mapping > 使用
    - **< servlet >** 中 **< servlet-name >** 和 **< servlet-class >**
    - **< servlet-mapping >** 中 **< servlet-name >** 和 **<url-pattern>**
- [重定向与转发请求 登录界面](https://github.com/ikunhuaji/Java-Learn-Demo/tree/master/webrr)
  - GenericServlet 通用 Servlet 类 , HttpServlet TCP 协议 Servlet类
  - **index.jsp** < a > href 传输数据给 LoginServlet , @WebServlet 注解 Servlet 的 url-pattern
  - **LoginServlet** doGet 中 getParameter 获取 HttpServletRequest 数据
    - **response.sendRedirect** 重定向 无法通过 getParameter 获取原参数
    - **request.getRequestDispatcher("?").forward(request,response)** 转发请求 可获取原参数
  - **ShowServlet** 