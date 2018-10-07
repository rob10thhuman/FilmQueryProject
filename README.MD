####README FOR FILM QUERY ####

1. User story 1: menu created
   This was a straightforward task. I currently have it prompting for an
   integer input, then running through a switch that corresponds to a method
   appropriate for the given choice (and a system exit for exit).
2. User story 2: look up by film id
   This is a more involved task that required several steps. Good practice for
   me personally in the application of methods, sql, setters, code reading.
   Re: the not found, I used an if statement that returns the message on a null
   finding.
3. User story 3: look up by keyword
   This was a much more involved task. I used the film id structure, then
   modified it with "like". The portion of the task where I needed to search
   the title or description was fun to work through. It required me to have
   an understanding of the procedure in place and work through the exception
   regarding the number of parameters and how exactly to run that through to
   sql.
4. User story 4: display language of film
   This is another layered task. I worked through it and then had to work
   through the exceptions, figuring out where and why (e.g., adding a setter
   for language) and how to use the joins and queries
5. User story 5: add actors to display
   I am working through this one right now. This is complicated (so far).


Known issues:
- Need to modify the keyword user story to return an array list as it's currently returning only one result (the first).
- I want to put this menu in a loop
