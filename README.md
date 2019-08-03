# LMS-Textfile-Database
There are three main parts to this assignement, Author, Publisher and Book. They each have a Service, Dao, and Controller layer. I created three objects to store the information. This assignment is designed to mimic an actual program that uses JDBC or other services similar. 

Publisher class only has a name and id. Publisher has the standard CRUD operations with one small twist where if publisher gets removed then the related books and authors get removed

Author class only has name and ID. Author has the standard CRUD operations wtih one small twist where if author gets removed then the related books and publisher gets removed.

Book class only has name, bookid, authorid, and publisherid. Book has the standard CRUD operations with one small twist where if book gets removed then the related authors and publishers get removed.

After each CRUD operations, the database is updated so we can have multiple author services accesses the same database and not have mixed up data
