package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
//    app.test();
		app.launch();
	}

	private void test() throws SQLException {
		Film film = db.getFilmById(3);
		Actor actor = db.getActorById(4);
		List<Actor> actorByFilmId = db.getActorsByFilmId(3);

		System.out.println(film);
		System.out.println(actor);
		for (Actor actor2 : actorByFilmId) {
			System.out.println(actor2);
		}
	}

	private void launch() throws SQLException {
		Scanner input = new Scanner(System.in);
		boolean keepGoing = true;
		while (keepGoing) {

			startUserInterface();
			int choice = input.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Look up by id!");
				lookupById();
				break;
			case 2:
				System.out.println("Lookup by keyword!");
				lookupByKeyword();
				break;
			default:
				System.out.println("Goodbye!");
				keepGoing = false;
//			System.exit(0);
			}
		}
		input.close();
	}

	private void startUserInterface() {
		System.out.println("Welcome to the INTERFACE!");
		System.out.println("Would you like to: ");
		System.out.println("1: Look up a film by id?");
		System.out.println("2: Look up a film by keyword?");
		System.out.println("3: Exit the app.");
		System.out.print("Enter option here: >>");
	}

	private void lookupById() throws SQLException {
		Scanner kb = new Scanner(System.in);
		System.out.print("Please enter the film ID >>");
		int filmId = kb.nextInt();
		Film film = db.getFilmById(filmId);

		if (film != null) {
			System.out.println(film);
		} else {
			System.out.println("Film not found!");
		}

	}

	private void lookupByKeyword() throws SQLException {
		Scanner kb = new Scanner(System.in);
		System.out.print("Please enter the film keyword >>");
		String filmKeyword = kb.next();
		List<Film> film = db.getFilmByKeyword(filmKeyword);
//		System.out.println(film.getFilmId());

		if (film != null) {

//			System.out.println(film);
			List<Film> filmList = db.getFilmByKeyword(filmKeyword);
			for (Film filmList2 : filmList) {
				System.out.println(filmList2);
				System.out.println("");
				List<Actor> actorByFilmId = db.getActorsByFilmId(Film.getFilmId());
				System.out.println("Film actors are:");
				for (Actor actor2 : actorByFilmId) {
					System.out.println(actor2);
				}
				System.out.println("");
			}

		} else {
			System.out.println("Keyword not found!");
		}

	}

}
