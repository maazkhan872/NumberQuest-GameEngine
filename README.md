📌 Project Overview

Project 1 — Number Guessing Game is the first milestone of the DecodeLabs Industrial Training Program (Batch 2026), focused on mastering Control Flow, Program State Management, and Real-Time User Interaction in Java.

While the base requirement was a console-driven guessing game, this implementation is engineered at a professional, production-grade level — built with a JavaFX GUI, a clean MVC (Model-View-Controller) architecture, multi-class separation of concerns, multi-round session persistence, a live scoreboard system, and full defensive input validation.
The project bridges two fundamental pillars of software engineering:

Backend Logic — Stochastic number generation, iterative deduction loops, conditional branching, and state management via java.util.Random and Java control structures.
Frontend Interaction — A fully reactive JavaFX GUI where every user action — typing a guess, clicking Submit, winning a round, or replaying — triggers a real-time UI response without any page reload or restart.

Every class has a single, clearly defined responsibility. The GameModel never touches the UI. The GameView never contains logic. The GameController is the only bridge. This is not just a college project — this is how real Java desktop applications are structured in the industry.

🧩 What This Project Actually Does — Full GUI Flow
This is not a "type a number, press Enter" terminal program. Here is the complete end-to-end flow of what happens when a user interacts with the application:

APPLICATION LAUNCH                            
  JavaFX Stage loads → GameView.fxml  
  rendered → GameController initialized → GameModel.newGame()   
  called → Random target (1–100) silently generated  

                      GAME SCREEN (GUI)                           
                                                                  
   ┌────────────────────────────────────────────────────────┐    
   │  🎯  Guess the Number between 1 and 100                │    
   │                                                        │    
   │  Attempts Left: ██████████  10                         │    
   │  Round: 1        Score: 0                              │    
   │                                                        │    
   │  [ Enter your guess...        ]   [ SUBMIT ]           │    
   │                                                        │    
   │  Feedback: ── Waiting for your first guess ──          │    
   └────────────────────────────────────────────────────────┘    

                              │
              ┌───────────────┼───────────────┐
              ▼               ▼               ▼
       [Invalid Input]   [Wrong Guess]   [Correct Guess]
              │               │               │
              ▼               ▼               ▼
     ┌──────────────┐  ┌───────────────┐  ┌──────────────────┐
     │ Red warning  │  │ Feedback label│  │ Win animation    │
     │ label shows  │  │ updates:      │  │ triggers 🎉      │
     │ "Please enter│  │ 📉 Too High!  │  │ ScoreBoard.java  │
     │  a valid     │  │    or         │  │ calculates score │
     │  number"     │  │ 📈 Too Low!   │  │ based on         │
     │              │  │               │  │ attempts used    │
     │ Input clears │  │ Attempt bar   │  │                  │
     │ Focus back   │  │ decrements    │  │ "Play Again?"    │
     │ to TextField │  │ visually      │  │ dialog appears   │
     └──────────────┘  └───────────────┘  └──────────────────┘
                              │                    │
                    [0 Attempts Left]        [Y] Play Again
                              │                    │
                              ▼                    ▼
                     ┌──────────────┐    ┌──────────────────┐
                     │ Game Over    │    │ New round starts  │
                     │ screen shows │    │ New random target │
                     │ final score  │    │ generated        │
                     │ "Try Again?" │    │ Attempts reset   │
                     └──────────────┘    │ Score carries    │
                                         │ forward          │
                                         └──────────────────┘
