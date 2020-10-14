# mkb
MKB exercise

Test case №1:

     1. Navigate to https://online.mkb.ru (https://online.mkb.ru/)
     2. Page should load within 10 sec
     3. Type login Avtotest
     4. Type password 123456
     5. Click Login
     6. Check actual result: Invalid login/passord error message should be displayed
     7. Repeat steps 4,5 (3 times)
     8. Check actual result: 15 min blocking message should be shown
     
     
To run this test:

     1. Clone project
     2. Install maven (brew install maven)
     3. Run from main folder: mvn test
