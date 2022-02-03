package com.tappyplanner.controllers;

import com.tappyplanner.models.Task;
import com.tappyplanner.models.data.TaskRepository;
import com.tappyplanner.models.dto.UpdateFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private TaskRepository taskRepository;


    @PostMapping("/home")
    String displayhome(Model model) {
        model.addAttribute("items", taskRepository.findAll());
        return "user/home";
    }


    @GetMapping("/home")
    String renderhome(Model model) {
        model.addAttribute("items", taskRepository.findAll());
        return "user/home";
    }

    @GetMapping("/create")
    String displayform(Model model) {
        return "user/create";
    }

    @PostMapping("/create")
    public String createTask(@ModelAttribute Task newTask) {
        taskRepository.save(newTask);
        return "redirect:/home";
    }

    @GetMapping("/delete")
    public String displayDeleteForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("tasks", taskRepository.findAll());
        return "user/delete";
    }

    @PostMapping("/delete")
    public String deleteProcess(@RequestParam(required = false) int[] taskIds) {
        if (taskIds != null) {
            for (int id : taskIds) {
                taskRepository.deleteById(id);
            }
        }
        return "redirect:/home";
    }

    @GetMapping("/update")
    public String displayUpdateForm(Model model) {
        model.addAttribute("title", "Update Events");
        model.addAttribute("tasks", taskRepository.findAll());
        model.addAttribute("taskIds", getAllTaskId());
        return "user/update";
    }

    @PostMapping(value = "/update")
    public String updateProcess(UpdateFormDTO updateFormDto) {
        Optional<Task> taskOptional = taskRepository.findById(updateFormDto.getId());
        if (taskOptional.isPresent()){
            Task task = taskOptional.get();
            task.setName(updateFormDto.getName());
            task.setDescription(updateFormDto.getDescription());
            System.out.println("task object : "+ task);
            taskRepository.save(task);
            System.out.println("task is update for this Id - "+ updateFormDto.getId());
        } else {
            System.out.println("no task is available for this Id - "+ updateFormDto.getId());
        }
        return "redirect:/home";
    }

    public List<Integer> getAllTaskId(){
        Iterable<Task> tasks = taskRepository.findAll();
        List<Integer> idList = new ArrayList<>();
        for (Task task: tasks) {
            idList.add(task.getId());
        }
        return idList;
    }

 }
