📌 Project Overview

Project 1 — Number Guessing Game is the first milestone of the DecodeLabs Industrial Training Program (Batch 2026), focused on mastering Control Flow, Program State Management, and Real-Time User Interaction in Java.

While the base requirement was a console-driven guessing game but wil create a GUI based system, this implementation is engineered at a professional, production-grade level, multi-class separation of concerns, multi-round session persistence, a live scoreboard system, and full defensive input validation.
The project bridges two fundamental pillars of software engineering:

Backend Logic — Stochastic number generation, iterative deduction loops, conditional branching, and state management via java.util.Random and Java control structures.
Frontend Interaction — A fully reactive JavaFX GUI where every user action — typing a guess, clicking Submit, winning a round, or replaying — triggers a real-time UI response without any page reload or restart.

Every class has a single, clearly defined responsibility. The GameModel never touches the UI. The GameView never contains logic. The GameController is the only bridge. This is not just a college project — this is how real Java desktop applications are structured in the industry.

🧩 What This Project Actually Does — Full GUI Flow
This is not a "type a number, press Enter" terminal program. Here is the complete end-to-end flow of what happens when a user interacts with the application:


