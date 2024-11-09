package com.ytrewq.rosLearning.Controllers;

import com.ytrewq.rosLearning.Entities.Emulation;
import com.ytrewq.rosLearning.Forms.EmulationForm;
import com.ytrewq.rosLearning.Services.EmulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/emulations")
public class EmulationController {
    @Autowired
    EmulationService emulationService;

    @PostMapping("/admin/createEmulation")
    public Map<String, String> createEmulation(@RequestBody EmulationForm form) {
        Emulation emulation = new Emulation();
        emulation.setPrivate_title(form.getPrivate_title());
        emulation.setDateOfCreation(LocalDateTime.now());
        emulation.setTimerTime(form.getTimerTime());
        emulation.setTimerDescription(form.getTimerDescription());
        emulation.setScreenImageURL(form.getScreenImageURL());
        emulation.setBlockSchemeJSON(form.getBlockSchemeJSON());
        emulation.setBlockCodeJS(form.getBlockCodeJS());
        emulation.setByteArrayInterface(form.getByteArrayInterface());
        emulationService.save(emulation);

        HashMap<String, String> map = new HashMap<>();
        map.put("result", "all_ok");
        return map;
    }
}
