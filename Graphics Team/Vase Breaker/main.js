/*
*	This is the main javascript file for the vase breaker project.
*/





//(function() {
	"use strict";


		let numVases = 0; //increases by one everytime a vase is clicked, and will accumulate
		let time = 0; // increases by one every second until gameState is false
		let gameState = true; // will become false when manager is present, and a vase is clicked
		let managerPresence = false; // appears(and become true) every five seconds, and remains for two seconds
		let vaseSpeed = 5; // takes five seconds to cross the screen
		let lightsFlicker = false; //will be true a second before the managerPresence is true.

		//
		//	Init will run when the web page loads.
		//

		window.addEventListener("load", init);

		/**
	    *	Is to be called when the page loads. initiates all the event listener in the starting
	    * 	screen
	    */
  		function init() {
			setInterval(spawnVase, 2000);
  		}


		function vaseOnClick() {
			//when clicked, broken vase image(Google it)
			//it will not disappear. it will only stay on the conveyer
			// every time tshis function is triggered numVase++
			//hitBox = rectangle
			this.parentElement.removeChild(this);
		}

		/**
		*	spawn random new vase on to the conveyer belt
		*/
		function spawnVase() {
			let vase = document.createElement("button");
			vase.classList.add("vase");
			vase.addEventListener("click", vaseOnClick);
			vase.title = -200;
			vase.style.left = vase.title + "px";
			document.getElementById("vases").appendChild(vase);
			let i = setInterval(function() { moveVase(vase); }, 50);
			clearInterval(i);

		}

		function moveVase(vase) {
			//position time  -> a displacement funtion with respect to time?
			//check if off the Page completely
			//	despawn
			if(vase.title > document.width) {
				vase.parentElement.removeChild(vase);
			}
			//move
			//
			vase.title = parseInt(vase.title) + 5;
			vase.style.left = vase.title + "px";
		}

		function scoreBoard() {
			 //timePassed
			 //score
		}

		function manager() {
		   //managerPresence
			 //lights flicker
		}


//s})();
