package controller;

import entity.MessageBoard;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.MessageBoardService;
import service.WechatService;
import util.Pagination;
import util.StringUtils;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by magenta9 on 2017/3/2.
 */
@Controller
@RequestMapping(value="/message")
public class MessageBoardController {
    @Resource
    private MessageBoardService messageBoardService;

    @Resource
    private WechatService wechatService;

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


//    @RequestMapping(value="/add",method=RequestMethod.POST)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    public boolean  addMessage(MessageBoard messageBoard){
//        if(messageBoardService.addMessage(messageBoard)) {
//            System.out.println("add a message");
//            return true;
//        }
//        else {
//            return false;
//        }
//    }

//    @RequestMapping(value="/update",method=RequestMethod.POST)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    public boolean updateMessage(MessageBoard messageBoard){
//        if(messageBoardService.updateMessage(messageBoard)) {
//            System.out.println("update a message");
//            return true;
//        }
//        else {
//            return false;
//        }
//    }


    /**************************************************************************************************************/
    /**
     * 根据ID查询会员留言，这个方法会在所有方法执行前被调用
     * @param messageId  会员留言ID
     * @param map
     */
    @ModelAttribute
    public void getUser(@RequestParam(value = "messageId",required = false)Integer messageId, Map<String,Object> map){
        if(messageId != null){
            MessageBoard messageBoard = messageBoardService.getMessageBoardById(messageId);
            map.put("messageBoard",messageBoard);
        }
    }

    /**
     * 修改MessageBoard的状态信息
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update
    (MessageBoard messageBoard,
     @RequestParam(value = "currentPage",defaultValue = "1") int currentPage ,
     @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
     @RequestParam(value = "category", required = false) Integer category,
     @RequestParam(value = "condition",required = false) String condition,
     ModelMap map)
    {
        messageBoardService.updateMessage(messageBoard);

        if(messageBoard.getState() == 1){
            wechatService.SendMessage(messageBoard.getUserId(),"您反馈的信息正在处理！");
        }
        if(messageBoard.getState() == 2){
            wechatService.SendMessage(messageBoard.getUserId(),"您反馈的信息我们已处理完毕，感谢您的意见！");
        }

        map.addAttribute("currentPage",currentPage);
        map.addAttribute("pageSize",pageSize);
        if(null != category){
            map.addAttribute("category",category);
        }

        if(!StringUtils.isEmpty(condition)){
            map.addAttribute("condition",condition);
        }

        return "redirect:/message/list";
    }



    /**
     * 根据条件查找会员留言
     * @param tab 表示选项是否选中，1代表会员留言被选中
     * @param currentPage 当前页
     * @param pageSize 页面显示条数
     * @param category 分类信息 （0：未处理  1：处理中 2：已处理）
     * @param condition 查询条件（主要为会员的姓名）
     * @param map
     * @return
     */
    @RequestMapping(value="/list")
    public String getMessages
            (@RequestParam(value = "tab",defaultValue = "1") int tab,
             @RequestParam(value = "currentPage",defaultValue = "1") int currentPage ,
             @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
             @RequestParam(value = "changePageSize",required = false) Integer changePageSize,
             @RequestParam(value = "category", required = false) Integer category,
             @RequestParam(value = "condition",required = false) String condition,
             ModelMap map){
        //定义查询参数
        StringBuilder queryParames = new StringBuilder();
        queryParames.append("list");
        if(null != changePageSize && changePageSize > 0){
            currentPage = 1;
            pageSize = changePageSize;
        }
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

        if(!StringUtils.isEmpty(condition)){
            queryParames.append("&condition=" + condition );
            map.addAttribute("condition",condition);
            pagination =  messageBoardService.getMessagebyName(currentPage,pageSize,condition);
        }
        map.addAttribute("pagination",pagination);
        map.addAttribute("queryParames",queryParames);
        map.addAttribute("tab",tab);
        return "/message/list";
    }

    /************************************************************************************************************/

}
