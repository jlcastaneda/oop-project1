Java files:

	Admin.java
		Class that handles information for Admin users.
	AdminMenu.java
		Menu class that is accessed if user is an admin.
	Book.java
		Handles information about the books in inventory.
	BookInventory.java
		Allows user to see the books that are currently available in the store.
	CheckedOut.java
		Contains information on the books that are checked out. Also contains functions that allow user to return
		books they checked out.
	Faculty.java
		
	History.java
		Handles the history for the user.
	LoginRegister.java
		Allows user to login to the system or register a new account. Separate login depending on user or admin.
	Member.java
		Base class for both Student and Admin. Handles the user's information.
	Student.java
		Class that handles information for Student users.
	UserMenu.java
		Displays the menu that the user can use (if not an admin).

Text files:

	AdminUsers.txt
		Contains information on admin members. Updates when a new admin member is registered.
	BookData.txt
		Text file containing information on the books. Quantity is updated if a user checks out or returns
		a book.
	Members.txt
		Contains information on members. Updated when new user is created.