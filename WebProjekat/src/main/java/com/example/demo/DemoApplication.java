package com.example.demo;


import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Calendar;
import java.util.GregorianCalendar;
import static com.example.demo.entity.Pol.Zenski;
import static com.example.demo.entity.Uloga.MENADZER;

/*
   @SpringBootApplication anotacija nastala je od @EnableAutoConfiguration anotacije koja
   upravlja konfiguracijom aplikacije.
 */

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	/* Da bismo testirali repozitorijum, direktno smo pozvali u glavnoj klasi metode,
	   inace bi pozivi bili u npr. nekom od servisa.
	 */

	@Autowired
	private KorisnikRepository korisnikRepository;

	@Override
	public void run(String... args) {


		Korisnik korisnik = new Korisnik();
		korisnik.setKorisnickoIme("pero123");
		korisnik.setLozinka("adminadmin");
		korisnik.setIme("Pera");
		korisnik.setPrezime("Peric");
		korisnik.setPol(Zenski);

		Calendar cal = new GregorianCalendar();
		cal.set(2001, 7, 31);
		korisnik.setDatumRodjenja(cal.getTime());

		korisnik.setUloga(MENADZER);


		// čuvamo objekat u bazi
		this.korisnikRepository.save(korisnik);

		/* for (Korisnik k : korisnik){
			System.out.println(k);
		}*/
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
