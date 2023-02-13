import requests

def astroSigns(): 
    return requests.get('http://sandipbgt.com/theastrologer/api/sunsigns').json()


def astroScope(sign, timeframe): 
    return requests.get(f'http://sandipbgt.com/theastrologer/api/horoscope/{sign}/{timeframe}').json()