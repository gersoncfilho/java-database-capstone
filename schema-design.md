## MySql Database design
### Tables:
- doctors
- roles
- appointments
- patients
- admin
- payments
- addresses
- clinic_locations
- payment_methods

### Table: doctors
- id: INT, Primary Key, Auto Increment
- role_id: INT, Foreign Key → roles(id)
- name: VARCHAR(255), Not Null
- specialization: VARCHAR(255), Not Null
- email: VARCHAR(255), Not Null, Unique
- password: VARCHAR(255), Not Null
- last_login: DATETIME, Null
- 
### Table: roles
- id: INT, Primary Key, Auto Increment
- role: INT, Not Null (0 = Admin, 1 = Doctor, 2 = Patient)
- created_at: DATETIME, Not Null, Default CURRENT_TIMESTAMP

### Table: appointments
- id: INT, Primary Key, Auto Increment
- doctor_id: INT, Foreign Key → doctors(id)
- patient_id: INT, Foreign Key → patients(id)
- appointment_time: DATETIME, Not Null
- created_at: DATETIME, Not Null, Default CURRENT_TIMESTAMP
- updated_at: DATETIME, Not Null, Default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
- clinic_location_id: INT, Foreign Key → clinic_locations(id)
- status: INT (0 = Scheduled, 1 = Completed, 2 = Cancelled)

### Table: patients
- id: INT, Primary Key, Auto Increment
- role_id: INT, Foreign Key → roles(id)
- name: VARCHAR(255), Not Null
- email: VARCHAR(255), Not Null, Unique
- password: VARCHAR(255), Not Null
- phone: VARCHAR(20), Not Null
- address_id: INT, Foreign Key → addresses(id)
- date_of_birth: DATE, Not Null
- last_visit: DATETIME, Null

### Table: admin
- id: INT, Primary Key, Auto Increment
- role_id: INT, Foreign Key → roles(id)
- username: VARCHAR(255), Not Null, Unique
- password: VARCHAR(255), Not Null
- email: VARCHAR(255), Not Null, Unique
- created_at: DATETIME, Not Null, Default CURRENT_TIMESTAMP
- last_login: DATETIME, Null

### Table: payments
- id: INT, Primary Key, Auto Increment
- appointment_id: INT, Foreign Key → appointments(id)
- amount: DECIMAL(10, 2), Not Null
- payment_date: DATETIME, Not Null, Default CURRENT_TIMESTAMP
- status: INT (0 = Pending, 1 = Completed, 2 = Failed)
- payment_method_id: INT, Foreign Key → payment_methods(id)

### Table: addresses
- id: INT, Primary Key, Auto Increment
- street: VARCHAR(255), Not Null
- number: VARCHAR(20), Not Null
- city: VARCHAR(100), Not Null
- state: VARCHAR(100), Not Null
- zip_code: VARCHAR(20), Not Null
- type: INT (0 = Home, 1 = Work, 2 = Other)

## Table: clinic_locations
- id: INT, Primary Key, Auto Increment
- name: VARCHAR(255), Not Null
- address_id: INT, Foreign Key → addresses(id)
- phone: VARCHAR(20), Not Null
- email: VARCHAR(255), Not Null, Unique
- created_at: DATETIME, Not Null, Default CURRENT_TIMESTAMP

## Table: payment_methods
- id: INT, Primary Key, Auto Increment
- method: VARCHAR(50), Not Null (e.g., "Credit Card", "PayPal")
- created_at: DATETIME, Not Null, Default CURRENT_TIMESTAMP
- is_active: BOOLEAN, Not Null, Default TRUE

## MongoDb Collection design
### Collection: prescriptions

```json
{
  "_id": "ObjectId('64abc123456')",
  "patientName": "John Smith",
  "appointmentId": 51,
  "medication": "Paracetamol",
  "dosage": "500mg",
  "doctorNotes": "Take 1 tablet every 6 hours.",
  "refillCount": 2,
  "pharmacy": {
    "name": "Walgreens SF",
    "location": "Market Street"
  }
}
```

### Collection: feedbacks

```json
{
  "_id": "ObjectId('64abc123457')",
  "patientName": "Jane Doe",
  "appointmentId": 52,
  "rating": 4,
  "comments": "Great service, but the wait time was a bit long.",
  "doctorId": 3,
  "createdAt": "2023-10-01T12:00:00Z"
}
```

### Collection: logs
```json
{
  "_id": "ObjectId('64abc123458')",
  "userId": 1,
  "action": "Login",
  "timestamp": "2023-10-01T12:00:00Z",
  "details": {
    "action": "User logged in",
    "location": "San Francisco, CA",
    "userRole": "Admin"
    }
}
```

### Collection: messages
```json
{
  "_id": "ObjectId('64abc123459')",
  "senderId": 1,
  "receiverId": 2,
  "content": "Hello, I would like to reschedule my appointment.",
  "timestamp": "2023-10-01T12:00:00Z",
  "status": "Sent"
}
```