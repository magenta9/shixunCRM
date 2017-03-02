package controller;

import entity.MessageBoard;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.MessageBoardService;
import util.Pagination;

import javax.annotation.Resource;

/**
 * Created by magenta9 on 2017/3/2.
 */
@Controller
@RequestMapping("value=/message")
public class MessageBoardController {
    @Resource
    private MessageBoardService messageBoardService;

    /**
     * 分页获取留言
     * 类似UserController
     */
    @RequestMapping(value = "/{pageIndex}/{pageSize}", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Pagination getMessages(@PathVariable("pageIndex")int pageIndex, @PathVariable("pageSize") int pageSize) {
        return messageBoardService.getMessages(pageIndex, pageSize);
    }

    @RequestMapping(value = "/unsolved/{pageIndex}/{pageSize}", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Pagination getMessagesUnsolved(@PathVariable("pageIndex")int pageIndex, @PathVariable("pageSize") int pageSize) {
        return messageBoardService.getMessagesNotSolved(pageIndex, pageSize);
    }

    @RequestMapping(value = "/unsolved/{pageIndex}/{pageSize}", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Pagination getMessagesUnHandle(@PathVariable("pageIndex")int pageIndex, @PathVariable("pageSize") int pageSize) {
        return messageBoardService.getMessagesNeedTreat(pageIndex, pageSize);
    }

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


}
