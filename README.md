Small employee inventory software, programmed in java. The features are:

- It has a limit of ten logs.

- It does not use a database, that is, the information is volatile.

- It doesn't have GUI.

- It has a pre-authentication with three types of user (common, top and admin).

- The credentials are: 
    - User: common | password: common123
    - user: top | password: top123
    - user: admin  | password: admin123

- The common user cannot view the employee's minimum salary, maximum salary, 
user name, user type, and password fields. To create a record with this user, 
you cannot create the employee's username, user type, and password. To update 
a log with this user, cannot update the employee's minimum salary, maximum salary,
user name, user type, and password fields. 

- The top user or administrator can see all fields except the password field. 
This users can create the logs with all fields.

- The top user when update the log, cannot update the employee's user name,
user type, and password fields.

- The admin user can update all fields.

- Before creating a record, the program performs the following validations:
	- No field can be empty.
	- No field can be omitted except the date of departure.
	- In the document type field you can only enter CC, CE, PASSPORT, 
	PEP and VISA.
	- In the email field you can only enter emails with the domain 
	@desarrolla.co.

- IMPORTANT!!: This version does not have a validation for the type of data 
entered by the user, that is, data of type Int cannot be entered in a variable
of type String, so the program fails.
