package com.revature.miniproject;

import java.util.ArrayList;
import java.util.List;

import io.javalin.Javalin;

public class BookDriver {
	 static List<AudioBook> audiobooks = new ArrayList<AudioBook>();
	
	public static void main(String[] args) {
		
		Javalin app = Javalin.create();
		
		app.start(4444);
		
		app.post("/audiobooks", ctx -> {
			
			AudioBook audioBook = new AudioBook();
			audioBook.title = ctx.formParam("title");
			audioBook.genre = ctx.formParam("genre");
			audioBook.author = ctx.formParam("author");
			audioBook.narrator = ctx.formParam("narrator");
			
			String enteredAudioBookPlusDescription = "";
			
			for(AudioBook wishlistedAudioBook : audiobooks) {
				if(wishlistedAudioBook  != null) {
					enteredAudioBookPlusDescription += wishlistedAudioBook.title + wishlistedAudioBook.genre + wishlistedAudioBook.author + wishlistedAudioBook.narrator + "<br>";
				}
			}
			
			ctx.html(enteredAudioBookPlusDescription);
		});
		
	}
	
	
	
	
}
