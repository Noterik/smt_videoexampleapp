/* 
* VideoexampleApplication.java
* 
* Example application to show how a video can be controlled from another screen. 
* 
* Copyright (c) 2015 Noterik B.V.
* 
* This file is part of Lou, related to the Noterik Springfield project.
*
* Lou is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* Lou is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with Lou.  If not, see <http://www.gnu.org/licenses/>.
*/
package org.springfield.lou.application.types;

import org.springfield.lou.application.Html5Application;
import org.springfield.lou.screen.Screen;

public class VideoexampleApplication extends Html5Application{
	
	//The "Main" screen, contains the video
	private Screen videoScreen = null;
	
	//Another screen used for controlling the video
	private Screen controllerScreen;
	
	//Boolean to indicate if the video is playing
	private boolean playing = false;
	
	public VideoexampleApplication(String id) {
		super(id); 
	}
	
	public void onNewScreen(Screen s){
		
		//Check if we already have a video screen.
		if(videoScreen == null){
			videoScreen = s;
			initVideoScreen();
		//Already have a video screen, so make this one a controller.
		}else{
			controllerScreen = s;
			initControllerScreen();
		}
		
	}
	
	private void initVideoScreen(){
		//Loads /WebContent/eddie/apps/videoexample/components/css/style.css on the videoScreen
		this.loadStyleSheet(videoScreen, "style");
		
		/*
		 * Loads the contents /WebContent/eddie/apps/videoexample/components/video on the videoScreen
		 * Check /WebContent/eddie/apps/videoexample/components/video/video.js for how to call methods
		 * on the HTML5 video object
		 */

		this.loadContent(videoScreen, "video", "video");
	}
	
	private void initControllerScreen(){
		this.loadContent(controllerScreen, "controller", "controller");
		
		//Binds a listener to the play button on the controller screen. Calls the function "playButtonClicked" in this object. 
		controllerScreen.setDiv("play", "bind:click", "playButtonClicked", this);
	}
	
	//Callback thats being called by the "bind" done on line 69
	public void playButtonClicked(Screen s, String content){
		playing = !playing;
		
		if(playing){
			
			//Change the content of player button according to playing state. 
			
			this.setContent("play", "PAUSE");
			videoScreen.putMsg("video", "", "play()");
		}else{
			this.setContent("play", "PLAY");
			videoScreen.putMsg("video", "", "pause()");
		}
	}
}
