/* 
* video.js
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

var Video = function(){
	this.element = jQuery("#video");
	
	//Getting a reference to the HTML5 video element.
	this.videoElement = this.element.find("video")[0];
};

/*
 * Extending Component (this is inside /WebContent/eddie/apps/videoexample/libs/component.js)
 * component.js takes care of a lot of boilerplate stuff. Like calling functions on the component from
 * the server. 
 */
Video.prototype = Object.create(Component.prototype);

//Calls play on HTML5 video element
Video.prototype.play = function(){
	this.videoElement.play();
};

//Calls pause on HTML5 video element
Video.prototype.pause = function(){
	this.videoElement.pause();
};