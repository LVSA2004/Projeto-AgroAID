package br.com.fiap.AgroAID.controller;

import br.com.fiap.AgroAID.model.Clima;
import br.com.fiap.AgroAID.service.ClimaService;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/clima")
public class ClimaController {

    @Autowired
    ClimaService service;

    @Autowired
    MessageSource message;

    private OWM owm = new OWM("c0f79194c5cdfe6db72de0f4c5e49855");

    Logger log = LoggerFactory.getLogger(ClimaController.class);

    @GetMapping
    public String index(Model model, @AuthenticationPrincipal OAuth2User user, @ModelAttribute Clima clima){
        model.addAttribute("username", user.getAttribute("name"));
        model.addAttribute("avatar_url", user.getAttribute("avatar_url"));
        model.addAttribute("clima", clima);
        model.addAttribute("climalist", service.findAll());
        return "clima/index";
    }

    @PostMapping
    public String getWeatherByCity(@ModelAttribute Clima clima,  RedirectAttributes redirect) throws APIException {
        String cityName = clima.getCidade();
        log.info("Buscar cidade com o nome: " + cityName);
        try {
            CurrentWeather currentWeather = owm.currentWeatherByCityName(cityName);
            clima.setTemperature(currentWeather.getMainData().getTemp());
            clima.setTempMin(currentWeather.getMainData().getTempMin());
            clima.setTempMax(currentWeather.getMainData().getTempMax());
            clima.setHumidity(currentWeather.getMainData().getHumidity());
            clima.setSpeed(currentWeather.getWindData().getSpeed());
            clima.setDegree(currentWeather.getWindData().getDegree());
            service.save(clima);
            redirect.addFlashAttribute("success", message.getMessage("clima.created.success", null, LocaleContextHolder.getLocale()));
        } catch (APIException e) {
            log.error("Erro ao obter dados de clima para a cidade: " + cityName, e);
            redirect.addFlashAttribute("error", message.getMessage("clima.error", null, LocaleContextHolder.getLocale()));
        }
        return "redirect:/clima";
    }
    
}
