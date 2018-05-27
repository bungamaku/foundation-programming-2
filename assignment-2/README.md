# Assignment 2: Animal, Cage, and Sounds of Javari Park

CSGE601021 Programming Foundations 2 @ Faculty of Computer Science Universitas
Indonesia, Term 2 2017/2018

* * *

This document contains the description and general information required for
completing the **second assignment** of Programming Foundations 2 course. The
assignment is about creating a program for organising animals into their cages.

This assignment covers programming topics as follows:

- Object-oriented programming in Java
- Contiguous data containers such as array, multidimensional array, and
`ArrayList`

This assignment is published on **Friday, March 16 2018**. The due date for
pushing latest commit for this assignment is on **Friday, April 6 2018**.
Please refer to [Submission](#submission) section to see the actual due
date and time.

## Table of Contents

1. [Description](#description)
2. [Preparation](#preparation)
3. [Input/Output Examples](#inputoutput-examples)
4. [Checking](#checking)
5. [Submission](#submission)
6. [Checklists](#checklists)

## Description

You are a programmer who are assigned at Javari Park. As you may know, Javari
Park has welcomed a train full of animals, not only a cat. They were hamster,
lion, parrot, and eagle. Each animal has its own characteristic. One of your
task is categorising the characteristics in the form of classes.

Generally, each registered animal has name, body length, and information about
its cage. For every type of animals, you must keep the information of the number
of registered animals, including their specifications. These informations were
owned by the classes of animals. Their specification would be listed below.

### Animals

**Cats** are friendly to human that everybody can visit their cages in Javari
Park. Their fur must be brushed to clean it from fleas. They love it so much
that they cutely make a voice of *“Nyaaan...”*. Besides, when they were
cuddled by visitors, they also make voices such as: *“Miaaaw..”*, *”Purrr..“*,
*“Mwaw!”*, and *“Mraaawr!”*. Nobody know’s what sound they will make each
time they are cuddled.

The next animal is **Hamsters**. They are rodents that could gnaw. Each time
they gnaw, they will produce noise that sounds like *"Ngkkrit.. Ngkkrrriiit"*.
They can also run inside the hamster wheel and you will hear sound like
*"Trrr... Trrr..."*.

**Parrots** are the favourite pet of pirates and supposed to be smart where
they can mimic human speeches. They can fly flow and say *"TERBAAANG..."* and
imitate person's speech. When they imitate person's speech, they will say it
a bit louder than the original speech. For example, if a person say *"Hello!"*,
the parrots will reply *"HELLO!"*. However, if they do not have anyone to talk,
they only mumble *"HM?"*.

There is another bird with type **Eagle**. Eagle cannot be cuddled by any random
persons. Otherwise, it will attack the person. Eagle can fly high and can
produce voice *"Kwaakk...."*.

The last type of animal is **Lion**. They like to hunt and produce sound of
*"Err...."*. It is difficult to groom lion. When their mood is good, they
will produce gentle sound of *"Hauhhmm!"* when their mane is brused. But when
they feel disturbed, they will roar loadly *"HAAHUM!!"*.

The animals should have cage. Javari Park has any size of cages to fit the body
of animals. The cages are made specifically from titanium with the size of pad
would be adjusted with length of animals' body.

### Cages

There are two type of cages: Indoor Cage and Outdoor Cage. Indoor cage will
contain pet animals whereas outdoor cage will contain wild animals.

Each type has three possible sizes: A, B, C. The details are as follows:

> Indoor Cage

- Indoor A has area of **60 cm x 60 cm** to fit an animal with body length `<`
**45 cm**
- Indoor B has area of **60 cm x 90 cm** to fit an animal with body length
**between 45 cm and 60 cm**
- Indoor C has area of **60 cm x 120 cm** to fit an animal with body length `>`
**60 cm**

> Outdoor Cage

- Outdoor A has area of **120 cm x 120 cm** to fit an animal with body length
`<` **75 cm**
- Outdoor B has area of **120 cm x 150 cm** to fit an animal with body length
**between 75 cm and 90 cm**
- Outdoor C has area of **120 cm x 180 cm** to fit an animal with body length
`>` **90 cm**

When you arrange the cages, you must classify the cages based on the type of
animals. **For wild animals such as lion and eagle**, their cages are located
at outdoor area. Similarly, **for pet animals such as cat, hamster, and
parrot**, their cages are located at indoor area.

After you determined the cages for each animals, your next task is to arrange
the placement of cages into **3 levels of row** which levels are ground,
middle, and upper. **You are not allowed to build extra levels.** When you
are done with the arrangement, **move the cages** from the highest level to
the lowest level. The last step is you have to reverse the order of the cages
in each level, by using your own methods (i.e. not using built-in methods in
Java).

Your work in this assignment can be summarised as follows:

1. Create the suitable classes for this case
2. Create other classes to help your comprehension (optional)
3. Create the relationship between classes
4. Specify instance variables/methods for every classes you create
5. Determine whether the instance variables/methods should be static or
non-static
6. Design cages for every type and size
7. Create the class to arrange the placement of cages into 3 levels and
apply this for each type of animals by using array and `ArrayList`, then
call this behaviour without instantiating any object of this class
8. Show the result of arrangement of cages
9. In the class you create in task (7) above, make another behaviour/method
to shift the levels of row and reverse the order of the cages in each level,
and call this behaviour without instantiating any object of this class
10. Show the result of rearrangement of cages

## Preparation

Please follow the instructions in the [root (main) README][RootReadme].
**Make sure you write all Java source code files in `src/main/java`
directory!**

## Input/Output Examples

The main program in this assignment must be designed to handle user input
from **standard input** (e.g. prompts from methods calls on a `Scanner`
object). All output must be displayed to **standard output**.

> Attention: String enclosed within double `*` symbols are input given by user

```
Welcome to Javari Park!
Input the number of animals
cat: **10**
Provide the information of cat(s):
**Katty|42,Ringgo|78,Diva|41,Pikachu|46,Giant|72,Dreamy|60,Kitten|39,Gemes|76,Bilbo|50,Bimo|65**
lion: **2**
Provide the information of lion(s):
**Simba|74,Mambo|80**
eagle: **0**
parrot: **0**
hamster: **3**
Provide the information of hamster(s):
**Rainbow|30,Ronald|25,Aster|27**
Animals have been successfully recorded!

=============================================
Cage arrangement:
location: indoor
level 3: Kitten (39 - A), Gemes (76 - C), Bilbo (50 - B), Bimo (65 - C),
level 2: Pikachu (46 - B), Giant (72 - C), Dreamy (60 - C),
level 1: Katty (42 - A), Ringgo (78 - C), Diva (41 - A),

After rearrangement...
level 3: Dreamy (60 - C), Giant (72 - C), Pikachu (46 - B),
level 2: Diva (41 - A), Ringgo (78 - C), Katty (42 - A),
level 1: Bimo (65 - C), Bilbo (50 - B), Gemes (76 - C), Kitten (39 - A),

location: outdoor
level 3:
level 2: Mambo (80 - B),
level 1: Simba (74 - A),

After rearrangement...
level 3: Mambo (80 - B),
level 2: Simba (74 - A),
level 1:

location: indoor
level 3: Aster (27 - A),
level 2: Ronald (25 - A),
level 1: Rainbow (30 - A),

After rearrangement...
level 3: Ronald (25 - A),
level 2: Rainbow (30 - A),
level 1: Aster (27 - A),

NUMBER OF ANIMALS:
cat:10
lion:2
parrot:0
eagle:0
hamster:3

=============================================
Which animal you want to visit?
(1: Cat, 2: Eagle, 3: Hamster, 4: Parrot, 5: Lion, 99: Exit)
**1**
Mention the name of cat you want to visit: **Bonbon**
There is no cat with that name! Back to the office!

Which animal you want to visit?
(1: Cat, 2: Eagle, 3: Hamster, 4: Parrot, 5: Lion, 99: Exit)
**1**
Mention the name of cat you want to visit: **Katty**
You are visiting Katty (cat) now, what would you like to do?
1: Brush the fur 2: Cuddle
**1**
Time to clean Katty's fur
Katty makes a voice: Nyaaan...
Back to the office!

Which animal you want to visit?
(1: Cat, 2: Eagle, 3: Hamster, 4: Parrot, 5: Lion, 99: Exit)
**1**
Mention the name of cat you want to visit: **Katty**
You are visiting Katty (cat) now, what would you like to do?
1: Brush the fur 2: Cuddle
**2**
Katty makes a voice: Purrr..
Back to the office!

/* Assume there are Leo the eagle and Greeny the parrot for this simulation */

Which animal you want to visit?
(1: Cat, 2: Eagle, 3: Hamster, 4: Parrot, 5: Lion, 99:exit)
**2**
Mention the name of eagle you want to visit: **Leo**
You are visiting Leo (eagle) now, what would you like to do?
1: Order to fly
**2**
You do nothing...
Back to the office!

Which animal you want to visit?
(1: Cat, 2: Eagle, 3: Hamster, 4: Parrot, 5: Lion, 99:exit)
**2**
Mention the name of eagle you want to visit: **Leo**
You are visiting Leo (eagle) now, what would you like to do?
1: Order to fly
**1**
Leo makes a voice: kwaakk…
You hurt!
Back to the office!

Which animal you want to visit?
(1: Cat, 2: Eagle, 3: Hamster, 4: Parrot, 5: Lion, 99:exit)
**3**
Mention the name of hamster you want to visit: **Ronald**
You are visiting Ronald (hamster) now, what would you like to do?
1: See it gnawing 2: Order to run in the hamster wheel
**1**
Ronald makes a voice: ngkkrit.. ngkkrrriiit
Back to the office!

Which animal you want to visit?
(1: Cat, 2: Eagle, 3: Hamster, 4: Parrot, 5: Lion, 99:exit)
**3**
Mention the name of hamster you want to visit: **Ronald**
You are visiting Ronald (hamster) now, what would you like to do?
1: See it gnawing 2: Order to run in the hamster wheel
**2**
Ronald makes a voice: trrr…. trrr...
Back to the office!

Which animal you want to visit?
(1: Cat, 2: Eagle, 3: Hamster, 4: Parrot, 5: Lion, 99:exit)
**4**
Mention the name of parrot you want to visit: **Greeny**
You are visiting Greeny (parrot) now, what would you like to do?
1: Order to fly 2: Do conversation
**1**
Parrot Greeny flies!
Greeny makes a voice: FLYYYY…..
Back to the office!

Which animal you want to visit?
(1: Cat, 2: Eagle, 3: Hamster, 4: Parrot, 5: Lion, 99:exit)
4
Mention the name of parrot you want to visit: **Greeny**
You are visiting Greeny (parrot) now, what would you like to do?
1: Order to fly 2: Do conversation
**2**
You say: **hello cute bird..**
Greeny says: HELLO CUTE BIRD..
Back to the office!

Which animal you want to visit?
(1: Cat, 2: Eagle, 3: Hamster, 4: Parrot, 5: Lion, 99:exit)
**4**
Mention the name of parrot you want to visit: **Greeny*
You are visiting Greeny (parrot) now, what would you like to do?
1: Order to fly 2: Do conversation
**3**
Greeny says: HM?
Back to the office!

Which animal you want to visit?
(1: Cat, 2: Eagle, 3: Hamster, 4: Parrot, 5: Lion, 99:exit)
**5**
Mention the name of lion you want to visit: **Simba**
You are visiting Simba (lion) now, what would you like to do?
1: See it hunting 2: Brush the mane 3: Disturb it
**1**
Lion is hunting..
Simba makes a voice: err...!
Back to the office!

Which animal you want to visit?
(1: Cat, 2: Eagle, 3: Hamster, 4: Parrot, 5: Lion, 99:exit)
**5**
Mention the name of lion you want to visit: **Simba**
You are visiting Simba (lion) now, what would you like to do?
1: See it hunting 2: Brush the mane 3: Disturb it
**2**
Clean the lion’s mane..
Simba makes a voice: Hauhhmm!
Back to the office!

Which animal you want to visit?
(1: Cat, 2: Eagle, 3: Hamster, 4: Parrot, 5: Lion, 99:exit)
**5**
Mention the name of lion you want to visit: **Simba**
You are visiting Simba (lion) now, what would you like to do?
1: See it hunting 2: Brush the mane 3: Disturb it
**3**
Simba makes a voice: HAUHHMM!
Back to the office!
```

## Checking

You can check whether your work contain code style issues by executing the
following Gradle task:

```bash
gradle :assignment-2:checkstyleMain
```

To compile all Java source code in `src/main/java`:

```bash
gradle :assignment-2:classes
```

## Submission

Please save & push your latest work (commit) into your online Git
repository on GitLab **no later than 21:00 at 06/04/2018. Do not
forget to invite your TA as a Master of your GitLab project. The
teaching team will only grade your work based on the latest commit
that has been pushed no later than the specified date & time.**

## Checklists

### Mandatory Tasks Checklist

- [ ] Make at least 1 commit that contains your progress in completing
assignment 2
- [ ] Push your commits to online Git repository at your GitLab project
- [ ] Implement class(es) representing each animal types and their behaviours
correctly
- [ ] Implement class(es) representing each cage types correctly
- [ ] Implement class(es) for handling cages arrangement correctly
- [ ] Implement class for running the main program and simulate the entire
case
- [ ] Demonstrate your work to your TA

### Additional Tasks Checklist

- [ ] Make sure there are no code style issues in your source code
- [ ] Organise classes in your work into logical Java **packages**
- [ ] Your work can handle testcase(s) provided by your TA during demo
session
    - Hint: Please think of possible edge/corner cases that might arise
    during demo session and ensure your program can handle them

[RootReadme]: ../README.md#initial-setup
