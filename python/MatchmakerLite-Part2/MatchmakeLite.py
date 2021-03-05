# Eric Pogue
# Matchmaker Lite

# Constants
INTRODUCTION = '''
******************************************************
                    Matchmaker 1.0
          Helping you find luv since 2019
                    Cupidsoft, Inc.
******************************************************

This program figures out if you and I are meant to be.
You will answer 5 questions. To each question, answer 5
if you strongly agree, 4 if you agree, 3 if you neither
agree nor disagree, 2 if you disagree, and 1 if you
strongly disagree.

Our happiness depends on you. Don't let us down ...
'''

QUESTION = [
	'Iowa Hawkeye football rocks!',
	'European soccer is the greatest sport in the world!',
	'PHP is the best computer language.'
]

DESIRED_RESPONSE = [
	5, # strongly agree
	2, # disagree
	1  # strongly disagree
]

MAX_SCORE = 15

# Execution starts here.
import os
import time

os.system('clear')
print(INTRODUCTION)

response = []
compatibility = []

# Ask all questions.
for i in range(len(QUESTION)):
	userResponse = int(input(QUESTION[i]))

	# Todo: Validate response and ask question again if necessary.
	response.append(userResponse)

	questionCompatibility = 5 - abs(userResponse - DESIRED_RESPONSE[i])
	compatibility.append(questionCompatibility)

	# String formatting with parameters and placeholders.
	print("Question %d compatability: %d\n" % (i+1, questionCompatibility))

# Calculate total compatibility.
totalCompatibility = 0
for c in compatibility:
	totalCompatibility += c

# Convert totalCompatibility to a percentage.
totalCompatibility *= 100 / MAX_SCORE

print("Calculating compatibility score.")
time.sleep(2)
print("Total Compatibility: %d\n\n" % (totalCompatibility))

# Todo: Determine compatibility ranges.
