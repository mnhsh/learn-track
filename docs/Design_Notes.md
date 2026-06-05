## ArrayList vs Array
- I've used ArrayList for the dynamic sizing, array have fix size it would require me to guess how many courses or students the system will hold.
- ArrayList provides build in methods like .add(), .isEmpty() and easy iteration which makes the code much cleaner than tracking the index manually with arrays.

## Usage of Static Members
Static members are primary used in IdGenerator class to maintain a single counter for generating unique IDs across the entire application.

## Inheritance and its Benefits
I've used inheritance to create a base class Person which contains common attributes and methods for Student class. This allows for code reuse and a cleaner design, as  Student can share the same properties like name and email without duplicating code.