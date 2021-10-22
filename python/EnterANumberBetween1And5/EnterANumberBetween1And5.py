#******************************************************************************
# Copyright (C) 2021 Eric Pogue.
#
# This file is under the MIT
#
# You are free to reuse the **unmodified** code in this file in your projects
# as long as you give credit to the author in your source code.
#
#******************************************************************************

# Algorithmic Thinking
# Functions
# Sequence
# Selection
# Repetition
# Licensing
# Reuse

def introduction():
	print("Introduction:... ")

def getAValidNumberBetteen1And5():
	UserResponse2String = str(input(("Enter a number between 1 and 5.\n")))
	print("You entered: " + UserResponse2String)

	if not UserResponse2String.isnumeric():
		print("This is not a number.")
		return -1
	else:
		print("This is a valid number.")
		UserResponse2Int = int(UserResponse2String)
		if (UserResponse2Int >= 1) and (UserResponse2Int <= 5):
			print("You have entered a number between 1 and 5. Great job!")
			return UserResponse2Int
		else:
			print("Your number is not between 1 and 5.")
			return -1

# Program starts executing here. 
introduction()

number = -1 # The user has not yet enter a valid number between 1 and 5.
while (number == -1):
	number = getAValidNumberBetteen1And5()
	if (number == -1):
		print("Please try again.\n")

print("\nValid number enter. The number was: ")
print(number)


