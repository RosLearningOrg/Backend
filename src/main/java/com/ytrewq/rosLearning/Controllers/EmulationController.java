package com.ytrewq.rosLearning.Controllers;

import com.ytrewq.rosLearning.DTOs.EmulationDto;
import com.ytrewq.rosLearning.Entities.*;
import com.ytrewq.rosLearning.Exeptions.AppException;
import com.ytrewq.rosLearning.Forms.EmulationForm;
import com.ytrewq.rosLearning.Services.CourseService;
import com.ytrewq.rosLearning.Services.EmulationService;
import com.ytrewq.rosLearning.Services.TaskService;
import com.ytrewq.rosLearning.Services.ThemeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/emulations")
public class EmulationController {
    @Autowired
    EmulationService emulationService;
    @Autowired
    CourseService courseService;
    @Autowired
    ThemeService themeService;
    @Autowired
    TaskService taskService;

    ModelMapper modelMapper = new ModelMapper();

    @PostMapping("/admin/createEmulation")
    public EmulationDto createEmulation(@RequestBody EmulationForm form) {
        Emulation emulation = new Emulation();
        emulation.setPrivate_title(form.getPrivate_title());
        emulation.setDateOfCreation(LocalDateTime.now());
        emulation.setTimerTime(form.getTimerTime());
        emulation.setTimerDescription(form.getTimerDescription());
        emulation.setScreenImageURL(form.getScreenImageURL());
        emulation.setBlockSchemeJSON(form.getBlockSchemeJSON());
        emulation.setBlockCodeJS(form.getBlockCodeJS());
        emulation.setByteArrayInterface(form.getByteArrayInterface());
        return emulationService.save(emulation);
    }
    @GetMapping("/admin/removeTaskEmulation")
    public Map<String, String> removeTaskEmulation(@RequestParam(name = "task_id") int taskId,
                                                  @RequestParam(name = "emulation_id") int emulationId) {

        Task task = taskService.getTaskById(taskId);
        if (task == null) {
            throw new AppException("Task not found.");
        }


        if (!emulationService.existsById(emulationId)) {
            throw new AppException("Emulation not found.");
        }

        taskService.removeTaskEmulation(task, emulationId);

        HashMap<String, String> map = new HashMap<>();
        map.put("result", "all_ok");
        return map;
    }
    @GetMapping("/admin/addTaskEmulation")
    public Map<String, String> addTaskEmulation(@RequestParam(name = "task_id") int taskId,
                                                   @RequestParam(name = "emulation_id") int emulationId) {

        Task task = taskService.getTaskById(taskId);
        if (task == null) {
            throw new AppException("Task not found.");
        }

        Emulation emulation = emulationService.getEmulationById(taskId);

        if (!emulationService.existsById(emulationId)) {
            throw new AppException("Emulation not found.");
        }

        taskService.addTaskEmulation(task, emulation);

        HashMap<String, String> map = new HashMap<>();
        map.put("result", "all_ok");
        return map;
    }
    @GetMapping("/user/getTaskEmulation")
    public EmulationDto getTaskEmulationUser(@AuthenticationPrincipal User user,
                                             @RequestParam(name = "course_id") int courseId,
                                             @RequestParam(name = "theme_id") int themeId,
                                             @RequestParam(name = "task_id") int taskId) {
        if (!courseService.existsById(taskId)) {
            throw new AppException("Course is not exists");
        }
        if (!themeService.existsById(themeId)) {
            throw new AppException("Theme is not exists");
        }
        Theme theme = themeService.getCourseTheme(user, courseId, themeId);
        if (theme == null) {
            throw new AppException("Task not allow for user");
        }
        Task task = taskService.getThemeTask(theme, themeId);
        if (task == null) {
            throw new AppException("Task is not exists");
        }
        return modelMapper.map(task.getEmulation(), EmulationDto.class);
    }

    @GetMapping("/admin/getTaskEmulation")
    public EmulationDto getTaskEmulationUser(@RequestParam(name = "task_id") int taskId) {
        Task task = taskService.getTaskById(taskId);
        if (task == null) {
            throw new AppException("Task is not exists");
        }
        return modelMapper.map(task.getEmulation(), EmulationDto.class);
    }

    @GetMapping("/admin/getAllEmulations")
    public List<EmulationDto> getAllEmulations() {
        return emulationService.getAllEmulations();
    }
}