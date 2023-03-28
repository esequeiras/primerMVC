package com.cenfotec.componentes;

import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cenfotec.componentes.beans.PrimerBean;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private PrimerBean primerBean;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		primerBean = new PrimerBean();
		primerBean.setName("Mario");
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("nombre", primerBean);
		
		return "home";
	}

	@RequestMapping(value = "/primeraPagina")
	public String primeraPagina(Model model) {

		return "primeraPagina";
	}
	@RequestMapping(value = "/segundaPagina")
	public String segundaPagina(@RequestParam("primerValor") int id,@RequestParam("segundoValor") int num2 ,Model model) {
		model.addAttribute("primerValor",id);
		model.addAttribute("segundoValor",num2);



		return "segundaPagina"; //es el nombre de la vista
	}
    @RequestMapping(value = "/nueva")
    public String nueva(Model model) {
		//int cont=diasEntreDosFechas();
		LocalDate date = LocalDate.parse("2023-01-01");
		ArrayList<String> datos=new ArrayList<>();
		LocalDate newDate = date.plusDays(1);
		int cont=0;
		LocalDate fechaActual=LocalDate.now();
		String timestamp = String.valueOf(DateTimeFormatter.ofPattern(" hh.mm.ss a"));

		while(!(newDate.getYear()==fechaActual.getYear()&&newDate.getMonth()==fechaActual.getMonth()&& newDate.getDayOfMonth()==fechaActual.getDayOfMonth())){
			 newDate = date.plusDays(cont);
			datos.add("Dia:  "+cont+"  de  "+newDate.getMonth()+ "  Hora: "+LocalTime.now());
			cont++;
		}
        model.addAttribute("lista",datos);
        return "nueva"; //es el nombre de la vista
    }

}
