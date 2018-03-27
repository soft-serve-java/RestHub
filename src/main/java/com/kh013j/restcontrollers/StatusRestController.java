package com.kh013j.restcontrollers;

import com.kh013j.model.domain.Status;
import com.kh013j.model.service.interfaces.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/status")
@CrossOrigin("*")
public class StatusRestController {

    private StatusService statusService;

    @Autowired
    public StatusRestController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("/name")
    public List<Status> getByNameCookStatus(@RequestParam String name){
        return statusService.cookStatuses().stream()
                .filter(status -> status.getName().equals(name))
                .collect(Collectors.toList());
    }

    @GetMapping
    public List<Status> getAll(){
        List<Status> statuses = statusService.cookStatuses();
        statuses.addAll(statusService.waiterStatuses());
        return statuses;
    }

    @GetMapping("/cook")
    public List<Status> getAllCookStatutes(){
        return statusService.cookStatuses();
    }

    @GetMapping("/waiter")
    public List<Status> getAllWaiterStatuses(){
        return statusService.cookStatuses();
    }

    @PostMapping("/next")
    public Status getNext(@RequestBody Status status){
        return statusService.nextStatus(status);
    }


}
