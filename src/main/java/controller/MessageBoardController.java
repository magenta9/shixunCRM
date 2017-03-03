package controller;

import entity.MessageBoard;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.MessageBoardService;
import util.Pagination;

import javax.annotation.Resource;

/**
 * Created by magenta9 on 2017/3/2.
 */
@Controller
@RequestMapping(value="/message")
public class MessageBoardController {
    @Resource
    private MessageBoardService messageBoardService;

    /**
     * 分页获取留言
     * 类似UserController
     */
//    @RequestMapping(value = "/{pageIndex}/{pageSize}", method = RequestMethod.GET)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    public Pagination getMessages(@PathVariable("pageIndex")int pageIndex, @PathVariable("pageSize") int pageSize) {
//        return messageBoardService.getMessages(pageIndex, pageSize);
//    }
//
//    @RequestMapping(value = "/unsolved/{pageIndex}/{pageSize}", method = RequestMethod.GET)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    public Pagination getMessagesUnsolved(@PathVariable("pageIndex")int pageIndex, @PathVariable("pageSize") int pageSize) {
//        return messageBoardService.getMessagesNotSolved(pageIndex, pageSize);
//    }
//
//    @RequestMapping(value = "/unhandle/{pageIndex}/{pageSize}", method = RequestMethod.GET)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    public Pagination getMessagesUnHandle(@PathVariable("pageIndex")int pageIndex, @PathVariable("pageSize") int pageSize) {
//        return messageBoardService.getMessagesNeedTreat(pageIndex, pageSize);
//    }


    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public boolean  addMessage(MessageBoard messageBoard){
        if(messageBoardService.addMessage(messageBoard)) {
            System.out.println("add a message");
            return true;
        }
        else {
            return false;
        }
    }

    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public boolean updateMessage(MessageBoard messageBoard){
        if(messageBoardService.updateMessage(messageBoard)) {
            System.out.println("update a message");
            return true;
        }
        else {
            return false;
        }
    }


    /**
     * 根据条件查找会员留言
     * @param currentPage 当前页
     * @param pageSize 页面显示条数
     * @param category 分类信息 （0：未处理  1：处理中 2：已处理）
     * @param condition 查询条件（主要为会员的姓名）
     * @param map
     * @return
     */
    @RequestMapping(value="/list")
    public String getMessages
            (@RequestParam(value = "currentPage",defaultValue = "1") int currentPage ,
             @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
             @RequestParam(value = "category", required = false) Integer category,
             @RequestParam(value = "condition",required = false) String condition,
             ModelMap map){
        //定义查询参数
        StringBuilder queryParames = new StringBuilder();
        queryParames.append("list");
        queryParames.append("?pageSize=" + pageSize);

        //分页类
        Pagination pagination = null;

        //如果条件不为空
        if(null != category){
            queryParames.append("&category=" + category);
            pagination = messageBoardService.getMessagebyState(currentPage,pageSize,category);
            map.addAttribute("category",category);
        }else{
            pagination = messageBoardService.getMessages(currentPage, pageSize);;
        }

        if(null != condition && "" != condition){
            queryParames.append("&condition=" + condition );
            map.addAttribute("condition",condition);
            pagination =  messageBoardService.getMessagebyName(currentPage,pageSize,condition);
        }
        map.addAttribute("pagination",pagination);
        map.addAttribute("queryParames",queryParames);
        return "/message/list";
    }

}
