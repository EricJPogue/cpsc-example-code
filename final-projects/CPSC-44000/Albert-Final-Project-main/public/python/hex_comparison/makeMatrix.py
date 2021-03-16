#
# makeMatrix: Matrix file Writer
# Author: George Pappas
# Original Creation Date: October 6, 2020
# Version 1.0
#
# ParseCommandLine()
# ValidateFileRead()
# setKeyWordFile()
# setMatrixFileName()
# createMatrix()
#

# Import Declarations.
import argparse     # Python Standard Library - Parser for command-line options, arguments
import os           # Standard Library OS functions

# Constants.
MIN_WORD = 5    # Minimum word size in bytes

gl_args = None

#
# Name: ParseCommand() Function
#
# Desc: Process and Validate the command line arguments
#       use Python Standard Library module argparse
#
# Input: none
#
# Actions:
#           Uses the standard library argparse to process the command line
#
def ParseCommandLine():
    parser = argparse.ArgumentParser('Make Matrix')
    parser.add_argument('-k', '--keyWords', type = setKeyWordFile, required = True, help = "specify the file containing search words")
    parser.add_argument('-c', '--makeMatrix', type = setMatrixFileName, required = True, help = "specify to create a weighted matrix file")

    global gl_args
    gl_args = parser.parse_args()
    
    return
# End Parse Command Line =====================================

#
# Name: ValidateFileRead Function
#
# Desc: Function that will validate that a file exists and is readable
#
# Input: A file name with full path
#
# Actions:
#           if valid will return path
#
#           if invalid it will raise an ArgumentTypeError within argparse
#           which will inturn be reported by argparse to the user
#
def ValidateFileRead(theFile):
    # Validate the path is a valid
    if not os.path.exists(theFile):
        raise argparse.ArgumentTypeError('File does not exist')

    # Validate the path is readable
    if os.access(theFile, os.R_OK):
        return theFile
    else:
        raise argparse.ArgumentTypeError('File is not readable')
# End ValidateFileRead =====================================

#
# Name: setKeyWordFile Function
#
# Input: keyWord file name
#
# Actions:
#           Validates input file.
#           Creates global variable for keywords.
#
def setKeyWordFile(keyWordsFile):
    ValidateFileRead(keyWordsFile)
    global keyWords
    keyWords = keyWordsFile
    return
# End setKeyWordFile =====================================

#
# Name: setMatrixFileName Function
#
# Input: user-named matrix file name
#
# Actions:
#           Creates global variable for matrixFileName.
#
def setMatrixFileName(theMatrixFileName):
    global matrixFileName   # Creates global variable for file name.
    matrixFileName = theMatrixFileName
    return
# End setMatrixFileName =====================================

#
# Name: createMatrix Function
#
# Desc: Function will create and fill user-named matrix file.
#
# Actions:
#           Creates matrix file named by user.
#           Converts and fills key words into new file. 
#           Prints results to console.
#
def createMatrix():
    # Creates a user-named .mat file.
    matrixFile = open(matrixFileName + '.mat', 'w')
    print("\nCreated " + matrixFileName + ".mat\n")

    for word in wordSet: # For each word in the wordSet.
        if len(word) >= MIN_WORD:
            BASE = 96
            wordWeight = 0

            for i in range(4, 0, -1):   # Loops over character positions.
                charValue = ord(str(word[i])) - BASE
                shiftValue = (i-1)*8
                charWeight = charValue << shiftValue
                wordWeight = wordWeight | charWeight
            matrixFile.write("0x%08x\n" % wordWeight)
            print("PASSED: ", word, " :Saved to " + matrixFileName + ".mat as 0x%08x" % wordWeight)
        else:
            print("------: ", word)
                
    matrixFile.close()
    print('\n')
    print("Writing to " + matrixFileName + ".mat complete")
    print('\n')

    return
# End createMatrix =====================================

# Main Function.
if __name__ == '__main__':
    MAKEMATRIX_VERSION = '1.0'
    
    # Introduction statement.
    print("Starting MakeMatrix...")
    
    # Process the Command Line Arguments.
    ParseCommandLine()

    # Initializes sets as empty.
    weightedMatrix = set()
    wordSet = set()

    # Reads keyWords file.
    textFile = open(keyWords, 'r')
    for line in textFile:
        words = line.strip()
        wordSet.add(words)
    textFile.close()

    # Creates and filles matrix file.
    createMatrix()

    # Finishing statement.
    print("Program Terminated Normally")
# End Main Function =====================================
