package controller;

import entity.User;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import service.UserService;
import util.Pagination;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by alienware on 2017/3/1.
        */
    @Controller
    @RequestMapping(value="/user")
    public class UserController {

    @Resource
    private UserService userService;

    /**
     *  直接分页获取用户
     *  例如首页应该调用 {deployment_name}/users/list/1/15 就是申请获得第一页 一页显示15条
     *  return json序列化的Pagination对象
     */
//    @RequestMapping(value="/list/{pageIndex}/{pageSize}",method= RequestMethod.GET)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    public Pagination getUsers(@PathVariable("pageIndex")int pageIndex,@PathVariable("pageSize") int pageSize){
//        return userService.getUsers(pageIndex,pageSize);
//    }

    /**
     *  分页按用户输入的会员名模糊查询返回
     *  例如首页应该调用 {deployment_name}/users/searchByName/girl/1/15 就是申请获得第一页 会员名包含"girl"的会员信息
     *  return json序列化的Pagination对象
     */
//    @RequestMapping(value="/searchByName/{userName}/{pageIndex}/{pageSize}",method=RequestMethod.GET)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    public Pagination getUser(@PathVariable("userName") String userName,@PathVariable("pageIndex") int pageIndex ,@PathVariable("pageSize") int pageSize){
//        return userService.getUsers(userName,pageIndex,pageSize);
//    }

    /**
     *  分页按用户输入的用户名模糊查询返回
     *  例如首页应该调用 {deployment_name}/users/searchByLevel/6/1/15 就是申请获得第一页 会员等级为6的会员信息
     *  return json序列化的Pagination对象
     */
//    @RequestMapping(value="/searchByLevel/{userLevel}/{pageIndex}/{pageSize}",method=RequestMethod.GET)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    public Pagination getUser(@PathVariable("userLevel") int userLevel,@PathVariable("pageIndex") int pageIndex ,@PathVariable("pageSize") int pageSize){
//        return userService.getUsers(userLevel,pageIndex,pageSize);
//    }



    /**
     * 会员信息录入 (单条数据插入)
     * 管理员使用
     */
//    @RequestMapping(value="/add",method=RequestMethod.POST)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    public boolean  addUser(User user){
//        if(userService.addUser(user)) {
//            System.out.println("");
//            return true;
//        }
//        else {
//            return false;
//        }
//    }

//    @RequestMapping(value="/addUsers",method=RequestMethod.POST)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    public int addUser(@RequestParam("file") MultipartFile file){
//        List<User> userList =new ArrayList<User>();
//        int count =0;
//
//        try {
//            Workbook wb = new HSSFWorkbook(file.getInputStream());
//            Sheet sheet = wb.getSheetAt(0);
//            for( int i = 0; i <= sheet.getLastRowNum(); i++ ){
//                Row row = sheet.getRow(i);
//                User user = new User();
//                user.setUserName(row.getCell(0).getStringCellValue());
//                user.setUserPhone(row.getCell(1).getStringCellValue());
//                user.setUserEmail(row.getCell(2).getStringCellValue());
//                user.setUserLevel((int)row.getCell(3).getNumericCellValue());
//                user.setUserScore((int)row.getCell(4).getNumericCellValue());
//                user.setUserPassword(row.getCell(5).getStringCellValue());
//                user.setUserSex(row.getCell(6).getStringCellValue());
//                userList.add(user);
//                count++;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        //开始插入用户
//        userService.addUser(userList);
//        return count;
//    }

    /**
     * 会员微信自主注册
     * 处理逻辑 1. 插入会员上传的图片并获得存入服务器的地址 2. 获得对应image_url表的
     *          3. 持久化userId和imageURl的关系
     * @return
     */
    @RequestMapping(value="/register",method=RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public boolean addUsers(User user,@RequestParam("userImg") MultipartFile userImg, HttpServletRequest request){
        boolean result =false;
        //Todo

        return result;
    }

    /**
     * 用户微信绑定
     * @param user
     * @param userImg
     * @param request
     * @return
     */
    @RequestMapping(value="/bind",method=RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public boolean bindUsers(User user,@RequestParam("userImg") MultipartFile userImg, HttpServletRequest request){
        boolean result =false;
        //Todo

        return result;
    }



    @RequestMapping(value="/testfile")
    public String testFile(){
        return "test_file_upload";
    }

    /**
     * file upload
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile tmpFile, HttpServletRequest request) {
        System.out.println("uploaded method is invoked");
        String path_saved =null;
        if (tmpFile != null) {
            path_saved=saveFileToServer(tmpFile,request);
        }

        return path_saved;
    }

    /**
     *   抽象用户图片上传头像文件的处理方法
     *   input:(MultipartFile tmpFile, User user,HttpServletRequest request)
     *   return: 存入的图片路径 （基于应用上下文的相对路径）
     */
    private String saveFileToServer(MultipartFile tmpFile, HttpServletRequest request){
        String path_saved =null;
        // 获取物理路径
        String targetDirectory = request.getSession().getServletContext().getRealPath("/uploads/users");
        // 上传的文件名
        String tmpFileName = tmpFile.getOriginalFilename();
        int dot = tmpFileName.lastIndexOf('.');
        //文件后缀名
        String ext = "";
        if ((dot > -1) && (dot < (tmpFileName.length() - 1))) {
            ext = tmpFileName.substring(dot + 1);
        }
        // 其他文件格式不处理
        if ("png".equalsIgnoreCase(ext) || "jpg".equalsIgnoreCase(ext) || "gif".equalsIgnoreCase(ext)) {
            // 重命名上传的文件名
            String targetFileName = renameFileName(tmpFileName);
            // 保存的新文件
            File target = new File(targetDirectory, targetFileName);

            try {
                // 保存文件
                FileUtils.copyInputStreamToFile(tmpFile.getInputStream(), target);
            } catch (IOException e) {
                e.printStackTrace();
            }

            path_saved=request.getContextPath() + "/uploads/users" + targetFileName;
            System.out.println("file path:"+path_saved);

        }else{
            System.out.println("tmpFile is null");
        }

        return path_saved;
    }

    public  String renameFileName(String fileName) {
        String formatDate = new SimpleDateFormat("yyMMddHHmmss").format(new Date()); // 当前时间字符串
        int random = new Random().nextInt(10000);
        String extension = fileName.substring(fileName.lastIndexOf(".")); // 文件后缀

        return formatDate + random + extension;
    }


    /***************************************************************************************************************************************/
    /**
     * 导入excel文件批量传入会员数据
     * @param file excel文件
     * @return
     */
    @RequestMapping(value="/addUsers",method=RequestMethod.POST)
    public String addUser(@RequestParam("file") MultipartFile file){
        List<User> userList =new ArrayList<User>();
        int count =0;
        try {
            Workbook wb = new HSSFWorkbook(file.getInputStream());
            Sheet sheet = wb.getSheetAt(0);
            for( int i = 0; i <= sheet.getLastRowNum(); i++ ){
                Row row = sheet.getRow(i);
                User user = new User();
                user.setUserName(row.getCell(0).getStringCellValue());
                user.setUserPhone(row.getCell(1).getStringCellValue());
                user.setUserEmail(row.getCell(2).getStringCellValue());
                user.setUserLevel((int)row.getCell(3).getNumericCellValue());
                user.setUserScore((int)row.getCell(4).getNumericCellValue());
                user.setUserPassword(row.getCell(5).getStringCellValue());
                user.setUserSex(row.getCell(6).getStringCellValue());
                userList.add(user);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //开始插入会员
        userService.addUser(userList);
        return "redirect:/user/list";
    }

    /**
     * 添加用户信息
     * @return
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    public String addUser(User user){
        userService.addUser(user);
        return "redirect:/user/list";
    }

    /**
     * 按条件获取会员列表
     * @param currentPage 当前页
     * @param pageSize 每页条数
     * @param radio 单选按钮的值（1：代表按会员名查 2：代表按按会员等级查
     * @param condition 搜索条件
     * @param map
     * @return
     */
    @RequestMapping(value="/list")
    public String getUsers
        (@RequestParam(value = "currentPage",defaultValue = "1") int currentPage ,
         @RequestParam(value = "pageSize",required = false,defaultValue = "15") Integer pageSize,
         @RequestParam(value = "radio", required = false) Integer radio,
         @RequestParam(value = "condition",required = false) String condition,
         ModelMap map){

        //定义查询参数
        StringBuilder queryParames = new StringBuilder();
        queryParames.append("list");
        queryParames.append("?pageSize=" + pageSize);

        //分页类
        Pagination pagination = null;

        //如果条件不为空，且单选按钮有值
        if(null != radio && null !=condition && "" != condition){
            queryParames.append("&radio=" + radio);
            queryParames.append("&condition=" +condition );

            if (radio == 1){
                pagination = userService.getUsers(condition,currentPage,pageSize);

            }else if(radio == 2){
                pagination = userService.getUsers(Integer.parseInt(condition),currentPage,pageSize);
            }

            map.addAttribute("radio",radio);
            map.addAttribute("condition",condition);
        }else{
            pagination = userService.getUsers(currentPage,pageSize);
        }
        map.addAttribute("pagination",pagination);
        map.addAttribute("queryParames",queryParames);
        //System.out.println(queryParames);
        return "/user/list";
    }

    /***********************************************************************************************************************************/





}
