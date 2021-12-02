package com.revature.miniproject;

import java.util.LinkedList;
import java.util.List;

import io.javalin.Javalin;

public class BookDriver {
	
	static List<AudioBook> audiobooks = new LinkedList<AudioBook>();
	 
	
	public static void main(String[] args) {
		
		Javalin app = Javalin.create();
		
		app.start(4444); //Javalin app is started in port 4444
		
		app.post("/audiobooks", ctx -> {
			System.out.println(ctx.formParamMap());
			AudioBook audioBook = new AudioBook();
			audioBook.title = ctx.formParam("title");
			audioBook.genre = ctx.formParam("genre");
			audioBook.author = ctx.formParam("author");
			audioBook.narrator = ctx.formParam("narrator");
			
			audiobooks.add(audioBook);
			
			String enteredAudioBookPlusDescription = "";
			
			for(AudioBook eachAudioBook : audiobooks) { //trying to create a for each loop to iterate through each new audiobook added by the user to the linked list and show the list under the HTML form
				if(eachAudioBook  != null) { //setting up a restriction for the text box, to exclude null being able to be printed
					ctx.result(enteredAudioBookPlusDescription += "AudioBook title: " + eachAudioBook.title + ", " + "  Genre: " + eachAudioBook.genre + ", " + "  Author: " + eachAudioBook.author + ", " + "  Narrator: " + eachAudioBook.narrator + "." + "<br>");
				}
			}
			
			ctx.html(enteredAudioBookPlusDescription);
		});
		
	}
	
	
	
	
}
