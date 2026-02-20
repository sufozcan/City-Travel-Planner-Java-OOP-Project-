# City Travel Planner (Java OOP Project)

A sophisticated Java console application designed to provide personalized travel recommendations and itinerary management, built with a strong emphasis on Object-Oriented Programming (OOP) principles.

## Project Overview
This project was developed for the **STAT 295 (Object-Oriented Programming)** course at **METU**. The application assists users in planning trips to major European cities by offering data-driven suggestions for accommodations, activities, and dining based on user-specific budgets, dates, and preferences.

##  Technical Features & Architecture
* **OOP Paradigms:** Implemented **Abstraction, Encapsulation, Inheritance, and Polymorphism** across 15+ interrelated classes.
* **Data Persistence:** Utilized the **Gson library** for JSON parsing to store and manage user accounts, trip plans, and city data permanently.
* **Activity Classification:** Developed a specialized hierarchy for activities:
    * **Cultural:** Venue details, pricing, and guide info.
    * **Adventure:** Difficulty levels and required equipment.
    * **Nightlife:** Vibe descriptions and age restrictions.
    * **Relaxation:** Massage options and location types.
* **Social Features:** Users can share their plans publicly, view others' itineraries, and leave ratings/comments.

## Core Class Structure (UML-Based)
* `User`: Handles authentication, preferences, and personalized trip history.
* `TripPlan`: The central logic unit for managing dates, budgets, and generated itineraries.
* `City`: A data-rich class containing seasonal climate data, local food, and transportation options.
* `AppController`: Manages the overall application flow and user interaction.

## Key Insights from the Project
* **Dynamic Budgeting:** The system calculates real-time recommendations by matching user budget constraints with city-specific pricing data.
* **Seasonal Intelligence:** Recommends the "Best Time to Visit" based on seasonal climates and local events.
* **Cross-Platform Compatibility:** Resolved environment-specific issues (e.g., macOS/Windows pathing) to ensure robust performance.

## Installation & Usage
1.  **Requirements:** JDK 11 or higher.
2.  **External Library:** Make sure `gson-2.13.1.jar` is in your library path.
3.  **Compile:** ```bash
    javac -cp lib/gson-2.13.1.jar *.java
    ```
4.  **Run:**
    ```bash
    java -cp .:lib/gson-2.13.1.jar Main
    ```

---
*Developed as a collaborative final project for the Department of Statistics, Middle East Technical University.*
