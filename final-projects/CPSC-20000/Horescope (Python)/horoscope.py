#Armando Loera
#HoroscopeReader
#Proffesor Eric Pogue


from reformat import astroSigns, astroScope


print( '''
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                     GalicaCore
          Transcribing Our Universal Message
                    by Mandolorin Inc.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Do you know your Sign? Do you know what this Sign means when it comes to your past, present and future?
This program brings the messages from the stars to the screen on your computer with a few simple clicks. 
With the twelve signs and three points in time as options, there are numerous readings to be discovered.
Now, let us find your sign and see what your past, present or future have in store...



'''
)



#Choose desired point in time
signs = astroSigns()

timeframe = input('Let us begin..when would you like your horoscope? For yesterday, today or tomorrow? \n')
print('') 
print('')

#List of 12 possible ASTROsigns
print("Below are all the atrology options available...")

for sign in signs: 
    print(f' ~ {sign}')

#Choose your sign
print('NOTE: A quick guide is found by pressing the ENTER key for those who are not familiar with their astrology...\n')
selectedSign = input('Dont leave me hanging:')
print('')
print('')

#For those who do not know their astrological sign
BdaySigns = (
    'Aries = Mar 21- Apr19\n'
    'Taurus = Apr 20- May 20\n'
    'Gemini = May 21- Jun 20\n'
    'Cancer = Jun 21- Jul 22\n'
    'Leo = Jul 23- Aug 22\n'
    'Virgo = Aug 23- Sept 22\n'
    'Libra = Sept 23- Oct 22\n'
    'Scorpio = Oct 23- Nov 21\n'
    'Sagittarius = Nov 22- Dec 21\n'
    'Capricorn = Dec 22- Jan 19\n'
    'Aquarius = Jan 20- Feb 18\n'
    'Pisces = Feb 19- Mar-20\n'
)

print(BdaySigns)
print('')
print('Please review the list above and return to sign selection...\n')
print('')

#Returning to the astrology selection
print('Returning to Astro Selection List...')

for sign in signs: 
    print(f' ~ {sign}')
selectedSign = input('Final Selection:')


#Current Reading with selected time and sign
horoscopeDef = astroScope(selectedSign, timeframe)

print('\n')
print(horoscopeDef['horoscope'])