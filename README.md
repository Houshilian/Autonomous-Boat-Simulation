# Autonomous-Boat-Simulation
Autonomous Boat (AB) Simulation Algorithm and UI.

![image](https://github.com/Houshilian/Autonomous-Boat-Simulation/blob/main/Boat.png)

### Algorithm: 
- Create supporting classes to perform AB calculations as described in the lecture notes.
  * Boat – location, direction, speed, etc.
  * Ocean Grid – a 2D representation of an ocean/water surface.
  * ABRule – Governs the movement of a Boat instance within the ocean space.
  * Simulation:
  * - Set initial conditions.
  * - Add a run() method that begins execution of a simulation loop.
  * - Simulation loop: Advance time by a unit amount and re-evaluate the boat position/motion, and ocean state.
  * - Add instrumentation points to gather desired statistics.
  * - Consider how oil may flow within the ocean grid over time.

### UI:
- Create 1-2 Use Cases plus a Sequence Diagram that describe your program’s operation (rule selection, process start/stop, display control).

- Extend from the ABApp abstract class (found in Files>Assign5>ABApp.zip) and make your own User Interface application.
  * Add a ComboBox to select an available rule (have at least three rules).
  * Add a start button to generate a full simulation, and a stop button for early processing termination (add other options as desired).
  * Display the progress/results of your AB simulation onto a graphical panel display.
