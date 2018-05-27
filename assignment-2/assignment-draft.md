# Assignment 2 DDP-2

# Animal, Cage, and Sounds of Javari Park

**Publish: Friday, 16 March 2018**

**Deadline: Friday, 6 April 2018**

You are a programmer who are assigned at Javari Park. As you may know, Javari Park has welcomed a train full of animals, not only a cat. They were hamster, lion, parrot, and eagle. Each animal has its own characteristic. One of your task is categorizing the characteristics in the form of classes.

Generally, each registered animal has name, body length, and information about its cage. For every type of animals, you must keep the information of the number of registered animals, including their specifications. These informations were owned by the classes of animals. Their specification would be listed below.

Cat, is very human-friendly that everybody can visit its cage in Javari Park. Their fur must be brushed to clean it from fleas. They love it so much that they cutely make a voice of &quot;Nyaaan….&quot;. Besides, when they were cuddled by visitors, they also make voices such as:: &quot;Miaaaw..&quot;, &quot;Purrr..&quot;, &quot;Mwaw!&quot;, and &quot;Mraaawr!&quot;. Nobody know&#39;s what sound they will make each time they are cuddled.

The next animal is hamster. This rodents could gnaw. Everytime they gnaw, there will be a noise of &quot;ngkkrit.. ngkkrrriiit&quot; heard by the caretakers. They also could run inside the hamster wheel that you can hear the sound like &quot;trrr…. trrr….&quot;.

Parrot, the favourite pet of pirates, was claimed as a smart bird which also can resemble human words. This bird could fly low and say &quot;TERBAAAANG….&quot;. They also can resemble your words or your commands. However, they will say it a bit loud, for example if you told them &quot;hello!&quot;, they will resemble it as &quot;HELLO!&quot;. However, when they don&#39;t have anyone to talk, they only mumble : &quot;HM?&quot;

Another bird was eagle. Eagle cannot be cuddled by any random persons. Otherwise, it will attack the person. Eagle can fly high and you can hear its voice &quot;kwaakk…&quot;.

The last type of animals was lion. It likes to hunting at the same time it makes a sound of &quot;err…&quot;. The groom for lion was not easy. Its mane should be brushed and it makes a gentle sound of: &quot;Hauhhmm!&quot;. But, when it feels disturbed, it will roar loudly : &quot;HAAHUM!!&quot;.

This animals should have cage. Javari Park has any size of cages to fit the body of animals. The cages was made specially from titanium with the size of pad would be adjusted with length of animals&#39; body. Pet&#39;s cage would be placed indoor, and wild animal&#39;s cage would be placed outdoor. Cat, parrot, and hamster were classified as pet. Eagle and lion were classified as wild animals.

These are the size of pet&#39;s cage:

- indoor A has area of 60cm x 60cm to fit the body&#39;s length &lt;45
- indoor B has area of 60cm x 90cm to fit the body&#39;s length 45-60
- indoor C has area of 60cm x 120cm to fit the body&#39;s length above 60

These are the size of wild animal&#39;s cage:

- outdoor A has area of 120cm x 120cm to fit the body&#39;s length &lt;75
- outdoor B has area of 120cm x 150cm to fit the body&#39;s length 75-90
- outdoor C has area of 120cm x 180cm to fit the body&#39;s length above 90

When you arrange the cages, you must classified the cages based on the type of animals. In the outdoor place, there are sites for lions&#39; cage and eagles&#39; cage. In the indoor place, there are sites for cats&#39; cage, hamsters&#39; cage, and parrots&#39; cage.

After you determine the cage size for every animals, your next task is to arrange the placement of cages into **3 levels of row** which levels are ground, middle, and upper. **You are not allowed to build the extra levels**. When you were done with the arrangement, **move the cages** from the highest level to the lowest level.  The last step is you have to reverse the order of the cages in each level, by using your own methods (not a Java built-in methods).

Summary of works:

1. Build the suitable classes for this case.
2. Build other classes to help your comprehension (optional).
3. Build the relationship between classes.
4. Specify instance variable/method for every classes you made.
5. Determine whether the instance variable/method should be static/non-static.
6. Design cage for every animals (A/B/C; indoor/outdoor)
7. Build the class to arrange the placement of cages into 3 levels, and apply this for each type of animals, by using array and ArrayList, then call this behavior without initiate any object of this class.
8. Show the result of arrangement of cages.
9. In the class you build (task no.7), make another behavior to shift the levels of row and reverse the order of the cages in each level, and call this behavior without initiation of any object.
10. Show the result of rearrangement of cages.

Example of input/output (question asked from your program was highlighted with Bold font, and the input from users with normal font):

**Welcome to Javari Park!**

**Input the number of animals**

**cat:** 10

**Provide the information of cat(s):**

Katty|42,Ringgo|78,Diva|41,Pikachu|46,Giant|72,Dreamy|60,Kitten|39,Gemes|76,Bilbo|50,Bimo|65

**lion:** 2

**Provide the information of lion(s):**

Simba|74,Mambo|80

**eagle:** 0

**parrot:** 0

**hamster:** 3

**Provide the information of hamster(s):**

Rainbow|30,Ronald|25,Aster|27

**Animals has been successfully recorded!**

**=============================================**

**Cage arrangement:**

**location: indoor**

**level 3: Kitten (39 - A), Gemes (76 - C), Bilbo (50 - B), Bimo (65 - C),**

**level 2: Pikachu (46 - B), Giant (72 - C), Dreamy (60 - C),**

**level 1: Katty (42 - A), Ringgo (78 - C), Diva (41 - A),**

** After rearrangement...**

**level 3: Dreamy (60 - C), Giant (72 - C), Pikachu (46 - B),**

**level 2: Diva (41 - A), Ringgo (78 - C), Katty (42 - A),**

**level 1: Bimo (65 - C), Bilbo (50 - B), Gemes (76 - C), Kitten (39 - A),**

**location: outdoor**

**level 3:**

**level 2: Mambo (80 - B),**

**level 1: Simba (74 - A),**

** After rearrangement...**

**level 3: Mambo (80 - B),**

**level 2: Simba (74 - A),**

**level 1:**

**location: indoor**

**level 3: Aster (27 - A),**

**level 2: Ronald (25 - A),**

**level 1: Rainbow (30 - A),**

** After rearrangement...**

**level 3: Ronald (25 - A),**

**level 2: Rainbow (30 - A),**

**level 1: Aster (27 - A),**

**ANIMALS NUMBER:**

**cat:10**

**lion:2**

**parrot:0**

**eagle:0**

**hamster:3**

**=============================================**

**Which animal you want to visit?**

**(1: Cat, 2: Eagle, 3: Hamster, 4: Parrot, 5: Lion, 99:exit)**

1

**Mention the name of cat you want to visit:** Bonbon

**There is no cat with that name! Back to the office!**

**Which animal you want to visit?**

**(1: Cat, 2: Eagle, 3: Hamster, 4: Parrot, 5: Lion, 99:exit)**

1

**Mention the name of cat you want to visit:** Katty

**You are visiting Katty (cat) now, what would you like to do?**

**1: Brush the fur 2: Cuddle**

1

**Time to clean Katty&#39;s fur**

**Katty makes a voice: Nyaaan...**

**Back to the office!**

**Which animal you want to visit?**

**(1: Cat, 2: Eagle, 3: Hamster, 4: Parrot, 5: Lion, 99:exit)**

1

**Mention the name of cat you want to visit:** Katty

**You are visiting Katty (cat) now, what would you like to do?**

**1: Brush the fur 2: Cuddle**

2

**Katty makes a voice: Purrr..**

**Back to the office!**

/\*assume there was Leo the eagle, and Greeny the parrot for this simulation\*/

**Which animal you want to visit?**

**(1: Cat, 2: Eagle, 3: Hamster, 4: Parrot, 5: Lion, 99:exit)**

2

**Mention the name of eagle you want to visit:** Leo

**You are visiting Leo (eagle) now, what would you like to do?**

**1: Order to fly**

2

**You do nothing...**

**Back to the office!**

**Which animal you want to visit?**

**(1: Cat, 2: Eagle, 3: Hamster, 4: Parrot, 5: Lion, 99:exit)**

2

**Mention the name of eagle you want to visit:** Leo

**You are visiting Leo (eagle) now, what would you like to do?**

**1: Order to fly**

1

**Leo makes a voice: kwaakk…**

**You hurt!**

**Back to the office!**

**Which animal you want to visit?**

**(1: Cat, 2: Eagle, 3: Hamster, 4: Parrot, 5: Lion, 99:exit)**

3

**Mention the name of hamster you want to visit:** Ronald

**You are visiting Ronald (hamster) now, what would you like to do?**

**1: See it gnawing 2: Order to run in the hamster wheel**

1

**Ronald makes a voice: ngkkrit.. ngkkrrriiit**

**Back to the office!**

**Which animal you want to visit?**

**(1: Cat, 2: Eagle, 3: Hamster, 4: Parrot, 5: Lion, 99:exit)**

3

**Mention the name of hamster you want to visit:** Ronald

**You are visiting Ronald (hamster) now, what would you like to do?**

**1: See it gnawing 2: Order to run in the hamster wheel**

2

**Ronald makes a voice: trrr…. trrr...**

**Back to the office!**

**Which animal you want to visit?**

**(1: Cat, 2: Eagle, 3: Hamster, 4: Parrot, 5: Lion, 99:exit)**

4

**Mention the name of parrot you want to visit:** Greeny

**You are visiting Greeny (parrot) now, what would you like to do?**

**1: Order to fly 2: Do conversation**

1

**Parrot Greeny flies!**

**Greeny makes a voice: FLYYYY…..**

**Back to the office!**

**Which animal you want to visit?**

**(1: Cat, 2: Eagle, 3: Hamster, 4: Parrot, 5: Lion, 99:exit)**

4

**Mention the name of parrot you want to visit:** Greeny

**You are visiting Greeny (parrot) now, what would you like to do?**

**1: Order to fly 2: Do conversation**

2

**You say:** hello cute bird..

**Greeny says: HELLO CUTE BIRD..**

**Back to the office!**

**Which animal you want to visit?**

**(1: Cat, 2: Eagle, 3: Hamster, 4: Parrot, 5: Lion, 99:exit)**

4

**Mention the name of parrot you want to visit:** Greeny

**You are visiting Greeny (parrot) now, what would you like to do?**

**1: Order to fly 2: Do conversation**

3

**Greeny says: HM?**

**Back to the office!**

**Which animal you want to visit?**

**(1: Cat, 2: Eagle, 3: Hamster, 4: Parrot, 5: Lion, 99:exit)**

5

**Mention the name of lion you want to visit:** Simba

**You are visiting Simba (lion) now, what would you like to do?**

**1: See it hunting 2: Brush the mane 3: Disturb it**

1

**Lion is hunting..**

**Simba makes a voice: err…!**

**Back to the office!**

**Which animal you want to visit?**

**(1: Cat, 2: Eagle, 3: Hamster, 4: Parrot, 5: Lion, 99:exit)**

5

**Mention the name of lion you want to visit:** Simba

**You are visiting Simba (lion) now, what would you like to do?**

**1: See it hunting 2: Brush the mane 3: Disturb it**

2

**Clean the lion&#39;s mane..**

**Simba makes a voice: Hauhhmm!**

**Back to the office!**

**Which animal you want to visit?**

**(1: Cat, 2: Eagle, 3: Hamster, 4: Parrot, 5: Lion, 99:exit)**

5

**Mention the name of lion you want to visit:** Simba

**You are visiting Simba (lion) now, what would you like to do?**

**1: See it hunting 2: Brush the mane 3: Disturb it**

3

**Simba makes a voice: HAUHHMM!**

**Back to the office!**
