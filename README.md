## Jets Project 

### Overview
This program is a Jets Application that populates an airfield with jets (model, speed, range, and price) that are imported from a text file into a List. When the user starts the program they are presented with a menu that has nine options: 

1. List fleet
2. Fly all jets
3. View fastest jet
4. View jet with longest range
5. Load all Cargo Jets
6. Dogfight!
7. Add a jet to Fleet
8. Remove a jet from Fleet
9. Quit

Option one will initially display the Jets that were imported from the text file for the user. Option two will ask all the Jets that are in the airfield to fly, meaning it displays that each jet is flying with the specific amount of time left based on that jets range and speed. Option three displays the fastest jet. Option four display the jet with the longest range. Option five will display only the Cargo Jets loading their cargo. Option six will display only the Fighter Jets preparing for a Dogfight. Option seven the user is presented with the option to add a type of jet (Fighter Jet, Cargo Jet, or Passenger Jet) and input the model, speed, range, and price of that jet. Once the user adds a jet, the other options are updated with the new jet. Option eight allows the use to select any of the jets to remove based on its index number. Lastly, option nine allows the user to quit the application.

### Technologies Used
* Java
* Eclipse
* Git / GitHub
* Terminal

### Topics 
* Lists & Array Lists
* Constructors
* Static Fields
* Instance Fields
* Getters and Setters
* toString
* Hashcode and Equals
* FileReader
* BufferedReader
* Objects
* Switches
* for and foreach Loops
* while Loops
* Inheritance
* Interfaces
* Override
* Scanner
* Instanceof


### Lessson's Learned
* Learned how to use a FileReader and BufferedReader to import data from a text file and put it into an Array List.
* Learned how important it is so follow a UML to prevent the unnecessary duplication of code.
* Learned how to implement instanceof so only certain types of jets would call certain methods. For example, I used "instanceof CargoPlane" to display only Cargo Jets when a user selects menu option five ("Load all Cargo Jets").

