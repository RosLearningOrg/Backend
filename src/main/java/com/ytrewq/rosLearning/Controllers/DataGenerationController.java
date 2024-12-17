package com.ytrewq.rosLearning.Controllers;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.ytrewq.rosLearning.Entities.Course;
import com.ytrewq.rosLearning.Entities.Task;
import com.ytrewq.rosLearning.Entities.Theme;
import com.ytrewq.rosLearning.Entities.ThemeMaterial;
import com.ytrewq.rosLearning.Services.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class DataGenerationController {
    @Autowired
    CourseService courseService;
    @Autowired
    UserService userService;
    @Autowired
    ThemeService themeService;
    @Autowired
    ThemeMaterialService themeMaterialService;
    @Autowired
    TaskService taskService;

    @GetMapping("/generateData")
    public Map<String, String> generateData(@RequestParam(name = "course_name") String courseName) throws UnirestException {
        String qAuthToken = "top_secret";

        HttpResponse<JsonNode> authResponse =
                Unirest.post(
                        "https://iam.api.cloud.yandex.net/iam/v1/tokens"
                ).body(
                        new JSONObject(
                                Map.of("yandexPassportOauthToken",
                                        qAuthToken)
                        )
                ).asJson();

        String iamToken = authResponse.getBody().getObject().get("iamToken").toString();


        var generateMap = new HashMap<>();
        generateMap.put("modelUri", "top_secret_2");
        var optionsMap = new HashMap<>();
        optionsMap.put("maxTokens", 2000);
        optionsMap.put("temperature", 0.3);
        generateMap.put("completionOptions", optionsMap);
        Map<String, String>[] messages = new Map[1];
        messages[0] = new HashMap<>();
        messages[0].put("role", "system");
        messages[0].put("text", "Напиши примеры 3х тем с краткими описаниями для курса по теме \"" + courseName + "\", для каждой темы напиши по 5 примеров задач с названиями и описаниями. Для курса тоже напиши описание. Для каждой темы напиши по 2 материала (название, краткое описание, материал). Результат сформируй в формате json:\\n{\\n\"course_description\": \"...\",\\n\"topics\": [\\n{\\n\"topic_name\": \"...\",\\n\"description\": \"...\",\\n\"tasks\": [{\"task_name\": \"...\", \"description\": \"...\"},],\\n\"materials\": [{\"material_name\": \"...\", \"small_description\": \"...\", \"description\": \"...\"},],\\n},]\\n}");
        generateMap.put("messages", messages);


        HttpResponse<JsonNode> generateResponse =
                Unirest.post(
                        "https://llm.api.cloud.yandex.net/foundationModels/v1/completion"
                ).header("Authorization", "Bearer " + iamToken
                ).body(new JSONObject(generateMap)
                ).asJson();

        int totalTokens = generateResponse.getBody().getObject().getJSONObject("result").getJSONObject("usage").getInt("totalTokens");
        String answer = generateResponse.getBody().getObject().getJSONObject("result").getJSONArray("alternatives").getJSONObject(0).getJSONObject("message").getString("text");
        JSONObject body = new JSONObject(answer.substring(3, answer.length() - 3));

        Course course = new Course(courseName, LocalDateTime.now(), body.getString("course_description"), null);
        courseService.save(course);

        JSONArray themes = body.getJSONArray("topics");
        JSONObject themeObj;
        JSONArray theme_materials;
        JSONArray theme_tasks;
        Theme theme;
        Task task;
        ThemeMaterial material;

        for (int i = 0; i < themes.length(); i++) {
            themeObj = themes.getJSONObject(i);
            theme = new Theme(themeObj.getString("topic_name"), LocalDateTime.now(), themeObj.getString("description"), null, null);
            themeService.save(theme);
            themeService.addCourseTheme(course, theme);
            theme_tasks = themeObj.getJSONArray("tasks");
            for (int j = 0; j < theme_tasks.length(); j++) {
                task = new Task(theme_tasks.getJSONObject(j).getString("task_name"), LocalDateTime.now(), theme_tasks.getJSONObject(j).getString("description"), null);
                taskService.save(task);
                taskService.addThemeTask(theme, task);
            }
            theme_materials = themeObj.getJSONArray("materials");
            for (int j = 0; j < theme_materials.length(); j++) {
                material = new ThemeMaterial(theme_materials.getJSONObject(j).getString("material_name"), "Учебник", "https://example.org/", theme_materials.getJSONObject(j).getString("small_description"), theme_materials.getJSONObject(j).getString("description"));
                themeMaterialService.save(material);
                themeMaterialService.addThemeMaterial(theme, material);
            }
        }
        System.out.println(totalTokens);
        HashMap<String, String> map = new HashMap<>();
        map.put("result", "all_ok");
        return map;
    }
}
