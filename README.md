# Text-based-Adventure

A CS2440's project Text-based Adventure game that walk through the Appalachian State University's Computer Science department

Things implemented:

1) HashMap in the Puzzle class
2) Rooms with Monster in 'room309'
3) Rooms with objects you can pick up in 'lounge'
4) Characters have names and descriptions
5) Commands
6) Monsters are able to harm the player
7) Ability to fight and heal
8) Players have limits on how many things they can carry

# Character Class
Objective: Allow users to have a character in the game. Characters can have a name, inventory, health, coins, and a character description. 

# Game Class
Objective: main method, handle commands from user. 

# Inventory Class
Objective: users are able to add items they buy or pick up in different rooms into an array of strings. Users are able to use items and that would remove the item from the inventory

# Map Class 
Objective: to have the four directions: north, south, east, west that users can get to

# Monster Class
Objective: to create a monster with health and allow users to fight that monster. Health based on attacks are randomized. Users are able to heal within this class if they have potions in their inventory. Users also have an option to run away from monsters. However, they cannot do that if the monster isn't weak enough. 

Restrictions: If health is full, potion will disappear but health will still be full

# Pokemon Class
Objective: Have users fight Pokemons if the program crashes.

Implementation: Similar to the Monster class. 

# Puzzle Class
Objective: Users can play a game that quizzes them on decimal to binary conversion

Implementation: Used a HashMap 

# Store Class
Objective: Allow users to buy items if they entered the store. There is a menu of different things that users can choose from with different price tags. When the user buy an item, the amount of money will be subtracted from the total amount of coins users have. Buying an item will put that item in their inventory.



