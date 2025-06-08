## User stories
## Admin user stories
As an administrator, I want to manage users: creating, updating and deleting users, as well as assign roles to them, so that the system includes only authorized personnel, maintaining
the security of the application.

**Acceptance criteria:**
- The administrator can login and logout of the application.
- The administrator can add a new doctor to the portal.
- The administrator can update user information, including username, password, and role.
- The administrator can delete a doctor/patient from the system.
- The administrator can view a list of all users in the system, including their roles and statuses.
- The administrator can search for users by username or role.
- The administrator can reset a user's password if necessary.
- The administrator can lock or unlock a user account to prevent unauthorized access.
- The administrator can view user activity logs to monitor actions taken by users in the system.
- The administrator can execute MySql queries to manage the database directly, if necessary.

**Priority:** High

**Story points:** 8

**Notes:** This user story is crucial for maintaining the security and integrity of the application, ensuring that only 
authorized personnel can access sensitive information and perform critical actions.

## Patient user stories
As a patient, I want to manage all my appointments, to ensure that I can keep track of my medical visits, update my 
personal information, re-schedule my previous appointments and view my medical records
### Acceptance criteria
- The patient can view a list of doctors without logging in, to explore before registering.
- The patient can sign up and create a new account, using email and password to book appointments.
- The patient can log in to view a list of all their appointments, including date, time, and doctor.
- The patient can create a new appointment with a doctor, specifying the date and time.
- The patient can update their personal information, such as name, address, and contact details.
- The patient can cancel an appointment if necessary, with a confirmation prompt.
- The patient can view their medical records, including past appointments and prescriptions.
- The patient can re-schedule a previous appointment by selecting a new date and time.

**Priority:** High

**Story points:** 8

**Notes:** This user story is essential to ensure that patients can effectively manage their healthcare appointments and personal information.


## Doctor user stories
As a doctor, I want to manage my appointments, to ensure that I can keep track of my medical visits, 
update my personal information and cancel appointments if necessary.
### Acceptance criteria
- The doctor can log in and view a list of all their appointments, including date, time, and patient.
- The doctor can log out to protect their account.
- The doctor can log in and view a list of all their appointments, including date, time, and patient.
- The doctor can create a new appointment with a patient, specifying the date and time.
- The doctor can update their professional information, such as name, address, and contact details.
- The doctor can cancel an appointment if necessary, with a confirmation prompt.

**Priority:** High

**Story points:** 8

**Notes:** This user story is essential to ensure doctors can effectively access the application and
manage their appointments and personal information, ensuring efficient patient care.
