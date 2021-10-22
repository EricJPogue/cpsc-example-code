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
	print("Introduction...")

def requestAValidNumberBetween1And5():
	UserResponse2String = str(input("Enter a number between 1 and 5.\n"))
	print("You entered: " + UserResponse2String)

	if not UserResponse2String.isnumeric():
		print("This is not a number!")
		return False
	else:
		# print("This a valid number")
		UserResponse2Int = int(UserResponse2String)
		if (UserResponse2Int < 1) or (UserResponse2Int > 5):
			print("\nThis is not a number between 1 and 5.")
			return False
		else:
			print("\nThis is a number between 1 and 5. Great job!")
			return True


# Program starts here. 
introduction()

userHasEnteredANumberBetween1And5 = False
while not userHasEnteredANumberBetween1And5:
	userHasEnteredANumberBetween1And5 = requestAValidNumberBetween1And5()
	print(userHasEnteredANumberBetween1And5)
	if not userHasEnteredANumberBetween1And5:
		print("Please try again.")


