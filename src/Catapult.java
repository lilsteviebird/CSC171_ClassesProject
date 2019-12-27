import java.util.*;
/*
Steven Li
31647656
Project 1
Lab Days: Tuesday, Thursday 9:40-10:55
I did not collaborate with anyone on this assignment

Class that makes Catapult game
 */

public class Catapult {
	public int xDist;
	public int yHeight;
	public static double gravity = 9.8;
	public static int score = 10;
	public static int round = 1;

	public Catapult() {

	}

	//returns the height of the catapult launch
	public static int launchHeight(double angle, double speed, int xDist) {

		double numer = gravity*Math.pow(xDist, 2);
		double denom = 2*Math.pow((speed*Math.cos(Math.toRadians(angle))),2);
		double firstPart = xDist*Math.tan(Math.toRadians(angle));
		return (int)(firstPart - (numer/denom));

	}

	public int getxDist() {
		return this.xDist;
	}
	public int getyHeight() {
		return this.yHeight;
	}
	public void setxDist(int xDist) {
		this.xDist = xDist;
	}
	public void setyHeight(int yHeight) {
		this.yHeight = yHeight;
	}

	//plays game. Will ask user if they want to continue after every round.
	public void playGame() {
		Scanner scn = new Scanner(System.in);
		boolean running = true;
		System.out.println("Would you like to play a game? Press 1 to "
				+ "play easy mode and 2 to play hard mode, and any other number to exit.");
		int playOr = scn.nextInt();
		if(playOr == 1) {
			while(running) {
				if(round == 1) {
					System.out.println("This is round " + round+ " of the catapult game! You'll give me an angle you'd like to set "
							+ "your catapult too\nand a speed you'd like to fire at. I'll tell you if you end up launching "
							+ "your projectile over the enemy wall! \nBut don't worry, I'll also give you the height of the wall and how far away the wall is! "
							+ "You'll get points over how precise you launch the projectile. But be warned\n "
							+ "if you don't get it over you'll get minus points. Reach a total score of zero, and the game is over.\n");
				}
				System.out.println("\n\nThis is round " + round);
				System.out.println("Your current score is " + score);

				this.xDist = (int) (Math.random()*51) + 1;
				this.yHeight = (int) (Math.random()*71) + 1;
				System.out.println("The wall is " + this.yHeight+ " meters tall and is " + this.xDist + " meters away");
				System.out.printf("\nGive me an angle: ");
				int angleGiven = scn.nextInt();
				System.out.printf("\nGive me a speed: ");
				int speedGiven = scn.nextInt();

				//Gives points in comparison 
				if(launchHeight(angleGiven, speedGiven, this.xDist) == this.yHeight || launchHeight(angleGiven, speedGiven, this.xDist) > this.yHeight) {
					if(launchHeight(angleGiven, speedGiven, this.xDist)-this.yHeight <=3) {
						System.out.println("You made it over perfectly. That's five points");
						System.out.println("Your catapult launched at a height of " + launchHeight(angleGiven, 
								speedGiven, this.xDist) + " meters!");
						score +=5;
					}else if(launchHeight(angleGiven, speedGiven, this.xDist)-this.yHeight > 3 && launchHeight(angleGiven, speedGiven, this.xDist)-this.yHeight <=10) {
						System.out.println("I guess you made it, not very close though"
								+ "I'll give you two points");
						System.out.println("Your catapult launched at a height of" + launchHeight(angleGiven, 
								speedGiven, this.xDist) + " meters!");
						score+=2;
					}else if(launchHeight(angleGiven, speedGiven, this.xDist)-this.yHeight > 10) {
						System.out.println("Techinically you made it, but you're just launching stuff however you want now. One point");
						System.out.println("Your catapult launched at a height of" + launchHeight(angleGiven, 
								speedGiven, this.xDist) + " meters!");
						score++;
					}
					System.out.println("Would you like to keep playing? Press 1 for yes");
					int continueOr = scn.nextInt();
					if(continueOr != 1) {
						running = false;
						System.out.println("Okay, your final score was " + score+". Goodbye!");
					}else {
						round++;
					}
				}else {
					if(score <= 0) {
						System.out.println("You lost! Your score is " + score);
						System.out.println("Type 1 if you'd like to play again, any other number to leave.");
						int finalChoice = scn.nextInt();
						if(finalChoice != 1) {
							running = false;
							System.out.println("Okay goodbye!");
						}
					}
					round++;
					score--;
					//if user doesn't make it over the wall
					if(launchHeight(angleGiven, speedGiven, this.xDist)-this.yHeight <= 0) {
						System.out.println("You didn't even make it to the wall you buffoon. That's minus 1");
						System.out.println("Would you like to keep playing? Press 1 for yes");
						int continueOr = scn.nextInt();
						if(continueOr != 1) {
							running = false;
							System.out.println("Okay, your final score was " + score+". Goodbye!");
						}
					}
				}
			}

		}
		//hard mode
		else if(playOr == 2) {
			while(running) {
				if(round == 1) {
					System.out.println("ahahahaha foolish mortal. You must launch projectiles over a wall now, "
							+ "by giving me a speed and angle.\nBut now you are fighting EarthBenders!\n"
							+ "(Please don't copyright me) and the wall moves towards you while you foolishly "
							+ "sit there idly trying to figure out the launch speed. Get hit by the wall?"
							+ "\n You instantly lose and die");
					System.out.println("Are you ready to play? Press any number to start");
					//This is just to stall
					int iDontCare = scn.nextInt();
				}
				System.out.println("\n\nThis is round " + round);
				System.out.println("Your current score is " + score);

				this.xDist = (int) (Math.random()*51) + 1;
				this.yHeight = (int) (Math.random()*71) + 1;
				System.out.println("The wall is " + this.yHeight+ " meters tall and is " + this.xDist + " meters away");
				int rate = (int) (Math.random()*3) + 1;
				System.out.println("The wall will move towards you at " + rate + " meters per second");
				System.out.println("The wall starts moving now!");
				//keeps track of elapsed time
				long start = System.currentTimeMillis();
				System.out.printf("\nGive me an angle: ");
				int angleGiven = scn.nextInt();
				System.out.printf("\nGive me a speed: ");
				int speedGiven = scn.nextInt();
				long end = System.currentTimeMillis();

				float sec = (end - start)/1000F;

				int distanceElapsed = (int)(rate * sec);
				
				this.xDist = this.xDist - distanceElapsed;
				//if the wall has reached the catapult, user instantly loses
				if(this.xDist <= 0) {
					System.out.println("Good night, the wall must've felt nice");
					score = 0;
					running = false;
				}

				//Gives points in comparison 
				else if(launchHeight(angleGiven, speedGiven, this.xDist) == this.yHeight || launchHeight(angleGiven, speedGiven, this.xDist) > this.yHeight) {
					if(launchHeight(angleGiven, speedGiven, this.xDist)-this.yHeight <=3) {
						System.out.println("The wall moved in an additional " + distanceElapsed + " meters");
						System.out.println("You made it over perfectly. That's five points");
						System.out.println("Your catapult launched at a height of " + launchHeight(angleGiven, 
								speedGiven, this.xDist) + " meters!");
						score +=5;
					}else if(launchHeight(angleGiven, speedGiven, this.xDist)-this.yHeight > 3 && launchHeight(angleGiven, speedGiven, this.xDist)-this.yHeight <=10) {
						System.out.println("The wall moved in an additional " + distanceElapsed + " meters");
						System.out.println("I guess you made it, not very close though"
								+ "I'll give you two points");
						System.out.println("Your catapult launched at a height of" + launchHeight(angleGiven, 
								speedGiven, this.xDist) + " meters!");
						score+=2;
					}else if(launchHeight(angleGiven, speedGiven, this.xDist)-this.yHeight > 10) {
						System.out.println("The wall moved in an additional " + distanceElapsed + " meters");
						System.out.println("Techinically you made it, but you're just launching stuff however you want now. One point");
						System.out.println("Your catapult launched at a height of " + launchHeight(angleGiven, 
								speedGiven, this.xDist) + " meters!");
						score++;
					}
					System.out.println("Would you like to keep playing? Press 1 for yes");
					int continueOr = scn.nextInt();
					if(continueOr != 1) {
						running = false;
						System.out.println("Okay, your final score was " + score+". Goodbye!");
					}else {
						round++;
					}
				}else {
					if(score <= 0) {
						System.out.println("You lost! Your score is " + score);
						System.out.println("Type 1 if you'd like to play again, any other number to leave.");
						int finalChoice = scn.nextInt();
						if(finalChoice != 1) {
							running = false;
							System.out.println("Okay goodbye!");
						}
					}
					round++;
					score--;
					//if user doesn't make it over the wall
					if(launchHeight(angleGiven, speedGiven, this.xDist)-this.yHeight <= 0) {
						System.out.println("You didn't even make it to the wall you buffoon. That's minus 1");
						System.out.println("Would you like to keep playing? Press 1 for yes");
						int continueOr = scn.nextInt();
						if(continueOr != 1) {
							running = false;
							System.out.println("Okay, your final score was " + score+". Goodbye!");
						}
					}
				}
			}


		}
		else {
			System.out.println("Goodbye!");
		}
	}




}
