package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// url : Localhost:8080/imc?poids=56&taille=1.90
public class imcController {
	@RequestMapping("/")
	public String root() {
		return "bienvenu. "+"\n"+"das url taper : /imc?taille= &poids=";
	}
	@RequestMapping("/imc")
	public String imc(@RequestParam(name = "poids") float poids,
			@RequestParam(name="taille") float taille) {
		String res="";
		float imc = poids/(taille*taille);
		if(imc<10.5) {
			res = res+"vous etes en insuffisantepondérale";
		}
		if(imc>10.5 && imc<=25) {
			res =  res+"vous etes normale";
		}
		else if(imc>25 && imc<=30) {
			res =  res+"vous etes en surpoids";
		}
		else if(imc>30 && imc<=35) {
			res =  res+"vous etes en obesite moderer";
		}
		else if(imc>35 && imc<=40) {
			res =  res+"vous etes en obesite";
		}
		else {
			res =  res+"vous etes en obésité morbide";
		}
		
		return res;
	}
}

