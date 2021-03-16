#
# p-search: Python Word Search
# Author: C. Hosmer
# Original Creation Date: August 2013
# Version 1.0
#
# Modifier: George Pappas
# Last Modified Date: October 6, 2020
# Version 1.1
#
# Simple p-search Python program
#
# Read in a list of search words
# Read a binary file into a bytearray
# Search the bytearray for occurrences of any specified search words
# Print a HEX/ ASCII display localizing the matching words
# Print out a list of possible words identified that didn't match
#
# Definition of a word. a word for this example is an uninterrupted sequence of
# 4 to 12 alpha characters

# Import Declarations.
import time     # Python Standard Library time functions
import _psearch # _psearch Support Function Module

# Main Function.
if __name__ == '__main__':
    PSEARCH_VERSION = '1.1'
    
    # Process the Command Line Arguments
    _psearch.ParseCommandLine()

    # Record the Starting Time
    startTime = time.time()

    # Perform Keyword Search
    _psearch.SearchWords()

    # Record the Ending Time
    endTime = time.time()
    duration = endTime - startTime
