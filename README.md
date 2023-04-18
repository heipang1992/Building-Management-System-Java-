Develop a simple building management system (BMS) for maintaining different kinds of building records.

BMS provide the following functions:
1. Create a building record (Apartment, House or any new kind of Building in the coming future).
2. Modify a building record (Apartment, House or any new kind of Building in the coming future)
3. Display Building details (such as building id, corresponding attributes and rooms) by a given building id (input building id=* to display all building records) 
4. Add, update or delete rooms in a building record
5. Undo last command
6. Redo the last undone command
7. Show undo/redo list

Code with the following design patterns:
1. <mark>Command pattern</mark> to provide the “add building”, “display buildings”, “modify building”, “add 
room”, "delete room", "modify room", “undo”, “redo” and “list undo/redo list” functions
2. Factory pattern or Abstract Factory Pattern to create different kinds of Command objects
and different kinds of Building objects (e.g. Apartment object, House object, etc.)
3. Memento pattern to provide “Undo” and “Redo” functions on "modify building" and "modify 
room".
