package com.kh013j.restcontrollers;

import com.kh013j.controllers.OrderController;
import com.kh013j.model.domain.CallForWaiter;
import com.kh013j.model.domain.Tables;
import com.kh013j.model.domain.User;
import com.kh013j.model.service.CallForWaiterService;
import com.kh013j.model.service.interfaces.OrderService;
import com.kh013j.model.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/")
public class WaiterRestController {
    @Autowired
    OrderService orderService;
    @Autowired
    private CallForWaiterService service;

    @Autowired
    private SimpMessagingTemplate template;
    @Autowired
    private UserService userService;

    @GetMapping("tableStatus")
    public List<Tables> getTableInfoForWaiter(){
        return orderService.findTableInfoForWaiter();
    }

    @GetMapping("tableQuantity")
    public int getTableQuantity(){
        return new Tables().getQuantityOfTables();
    }

    @PostMapping("callWaiterClient")
    public void callForWaiter(@RequestParam int table, HttpServletRequest headerAccessor) {
        String sessionId  = (String)
                headerAccessor.getSession().getId();
        List<CallForWaiter> callForWaiterList = service.findAll();
        callForWaiterList.add(new CallForWaiter(new Tables(table),
                new Timestamp(System.currentTimeMillis()), sessionId));
    }

    @PostMapping("acceptCalling/{tablenumber}")
    public void acceptCalling(@PathVariable("tablenumber") int table, @RequestBody String username) {
            User user = userService.findByEmail(username);
            CallForWaiter call = service.mackAsClosed(table, user);
            template.convertAndSendToUser(Integer.toString(table),
                    "/callBackInfo", call.getWaiter());
    }
    @PostMapping("getTable/{tablenumber}")
    public User getTable(@PathVariable("tablenumber") int table, @RequestBody String username){
            User user = userService.findByEmail(username);
            orderService.setWaiter(table, user);
            return user;
    }
}
