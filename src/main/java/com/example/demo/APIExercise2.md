### Updating and deleting the Student object

1. Make sure that it's possible to connect with the API and that the students can be updated in and deleted from the database.
2. Use the response entity to send back custom status codes.
It needs to have the following options:
    - Getting all students --> Wrap in status ok
    - Getting a student by ID --> Wrap in status ok, when not found, return 404
    - Adding a student --> Wrap in status created
    - Finding a student by name using our findByName method --> Wrap in status ok, when not found, return 404
    - Updating a student --> Wrap in status ok, when not found, return 404
    - Deleting a student --> Return empty status ok, or empty not found
