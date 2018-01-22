package com.lmig.gfc.oregon_trail.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.oregon_trail.models.Traveler;
import com.lmig.gfc.oregon_trail.models.Wagon;

@Controller
public class HomeController {
	
	private Traveler traveler1;
	private Traveler traveler2;
	private Wagon wagon;
	
	public ArrayList<Traveler> passengerList = new ArrayList<Traveler>(); 
	
	
	public HomeController() {
		this.makeTraveler();
		this.makeWagon();
		this.passengerList.add(traveler1);
		this.passengerList.add(traveler2);
	}
	
	
	@RequestMapping("/index")
	public ModelAndView defaultPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("myTraveler1", this.traveler1);
		mv.addObject("myTraveler2", this.traveler2);
		mv.addObject("myWagon", this.wagon);
		return mv;
	}
	
	@RequestMapping("/hunt")
	public ModelAndView huntPage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("myTraveler1", this.traveler1);
		mv.addObject("myTraveler2", this.traveler2);
		mv.setViewName("index");
		traveler1.hunt();
		traveler2.hunt();
		return mv;
	}
	
	@RequestMapping("/eat")
	public ModelAndView eatPage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("myTraveler1", this.traveler1);
		mv.addObject("myTraveler2", this.traveler2);
		mv.setViewName("index");
		traveler1.eat();
		traveler2.eat();
		return mv;
	}
	
	//make traveler
	public void makeTraveler() {
		this.traveler1 = new Traveler(80, "Henrietta", true);
		this.traveler2 = new Traveler(100, "Juan", true);
	}
	
	//make wagon
	public void makeWagon() {
		this.wagon = new Wagon(5);
	}
	
	public ArrayList<Traveler> getTraveler() {
		return this.passengerList;
	}
	
	@RequestMapping("/reset")
	public ModelAndView resetPage() {
		ModelAndView mv = new ModelAndView();
		this.makeTraveler();
		this.makeWagon();
		mv.addObject("myTraveler1", this.traveler1);
		mv.addObject("myTraveler2", this.traveler2);
		mv.setViewName("index");
		return mv;
	}
	
}
