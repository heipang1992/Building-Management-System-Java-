Develop a simple building management system (BMS) for maintaining different kinds of building records.

BMS provide the following functions:
1. Create a building record (Apartment, House or any new kind of Building in the coming future).
2. Modify a building record (Apartment, House or any new kind of Building in the coming future)
3. Display Building details (such as building id, corresponding attributes and rooms) by a given building id (input building id=* to display all building records) 
4. Add, update or delete rooms in a building record
5. Undo last command
6. Redo the last undone command
7. Show undo/redo list

<img width="374" alt="image" src="https://user-images.githubusercontent.com/127038426/232799052-e471e15a-d8bb-413f-9c73-4ca15dc16482.png">


Code with the following design patterns:
1. <mark>Command pattern</mark> to provide the “add building”, “display buildings”, “modify building”, “add 
room”, "delete room", "modify room", “undo”, “redo” and “list undo/redo list” functions
2. Factory pattern or Abstract Factory Pattern to create different kinds of Command objects
and different kinds of Building objects (e.g. Apartment object, House object, etc.)
3. Memento pattern to provide “Undo” and “Redo” functions on "modify building" and "modify 
room".

![Commands](https://user-images.githubusercontent.com/127038426/232799241-8bd9acb6-5beb-428d-8612-9746a94c2446.png)

![Buildings](https://user-images.githubusercontent.com/127038426/232799297-ba5c346e-7a6e-490e-9ea4-557a08f5d324.png)
