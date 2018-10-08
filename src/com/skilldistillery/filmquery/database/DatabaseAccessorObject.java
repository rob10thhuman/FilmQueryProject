package com.skilldistillery.filmquery.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//import com.mysql.jdbc.PreparedStatement;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film getFilmById(int filmId) throws SQLException {
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(URL, user, pass);

		Film film = null;
		String sql = "select film.id, title, release_year, rating, description, language.name from film join language on film.language_id = language.id where film.id= ?";

		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		stmt.setInt(1, filmId);
		ResultSet filmResult = stmt.executeQuery();
		if (filmResult.next()) {
			film = new Film();
			film.setFilmId(filmResult.getInt(1));
			film.setTitle(filmResult.getString(2));
			film.setReleaseYear(filmResult.getInt(3));
			film.setRating(filmResult.getString(4));
			film.setDescription(filmResult.getString(5));
			film.setLanguage(filmResult.getString(6));
		}

		filmResult.close();
		stmt.close();
		conn.close();

		return film;
	}

	@Override
	public Actor getActorById(int actorId) throws SQLException {
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(URL, user, pass);

		Actor actor = null;
		String sql = "select id, first_name, last_name from actor where id = ?";

		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		stmt.setInt(1, actorId);
		ResultSet actorResult = stmt.executeQuery();
		if (actorResult.next()) {
			actor = new Actor();
			actor.setFirstName(actorResult.getString(2));
			actor.setLastName(actorResult.getString(3));
		}

		actorResult.close();
		stmt.close();
		conn.close();
		return actor;
	}

	@Override
	public List<Actor> getActorsByFilmId(int filmId) throws SQLException {
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(URL, user, pass);
		List<Actor> actorList = new ArrayList<>();

		String sql = "select actor.first_name, actor.last_name from actor join film_actor on actor.id = film_actor.actor_id where film_actor.film_id = ?";

		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		stmt.setInt(1, filmId);
		ResultSet actorResult = stmt.executeQuery();
		while (actorResult.next()) {
			Actor actor = new Actor();
			actor.setFirstName(actorResult.getString(1));
			actor.setLastName(actorResult.getString(2));
			actorList.add(actor);
		}

		actorResult.close();
		stmt.close();
		conn.close();
		return actorList;
	}

	@Override
	public List <Film> getFilmByKeyword(String filmKeyword) throws SQLException {
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(URL, user, pass);
		
		List<Film> filmList = new ArrayList<>();

		Film film = null;
		
		String sql = "select film.id, title, release_year, rating, description, language.name from film join language on film.language_id = language.id where (title like ?) or (description like ?)";
		
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		stmt.setString(1, "%" + filmKeyword + "%");
		stmt.setString(2, "%" + filmKeyword + "%");
		ResultSet filmResult = stmt.executeQuery();
		
		while (filmResult.next()) {
			Film film1 = new Film();
			film1.setFilmId(filmResult.getInt(1));
			film1.setTitle(filmResult.getString(2));
			film1.setReleaseYear(filmResult.getInt(3));
			film1.setRating(filmResult.getString(4));
			film1.setDescription(filmResult.getString(5));
			film1.setLanguage(filmResult.getString(6));
			filmList.add(film1);
		}
//		if (filmResult.next()) {
//			film = new Film();
//			film.setFilmId(filmResult.getInt(1));
//			film.setTitle(filmResult.getString(2));
//			film.setReleaseYear(filmResult.getInt(3));
//			film.setRating(filmResult.getString(4));
//			film.setDescription(filmResult.getString(5));
//			film.setLanguage(filmResult.getString(6));
//		}
		
		//likely need to change this to an array list 

		filmResult.close();
		stmt.close();
		conn.close();

		return filmList;
	}

}
