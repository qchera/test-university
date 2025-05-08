- *Embedded H2 DB is used as the relational database, so the SQL scripts are tailored specifically for H2 and differ from those used in MySQL or PostgreSQL*  
- *If project would be bigger I'd use regexps, but here I simplify*

## Examples of requests and answers

### 1. Who is a head of department
```text
> Who is head of department Computer Science
Head of Computer Science department is Walter White
```
### 2. Department stats
```text
> Show Computer Science statistics.
assistants - 2; associate professors - 0; professors - 1
```
### 3. Average salary for the department
```text
> Show the average salary for the department Computer Science.
The average salary of Computer Science is 17333.33
```
### 4. Count of employees in certain department
```text
> Show count of employee for Computer Science.
3
```
### 5. Global search by name
```text
> Global search by Doe.
John Doe, Jane Doe
```
```text
> Global search by e.
John Doe, Jane Doe, Walter White, Jesse Pinkman
```
### 6. Вихід з циклу
```text
> exit
Bye!
```
