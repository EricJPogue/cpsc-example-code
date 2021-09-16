import json
import urllib.request
import turtle

intro = ('''Welcome to OutOfThisWorld, this is an International Space Station tracker! Please use 
positive numbers for North and East lines of latitude and longitude! Use negative numbers for South 
and West lines of latitude and longitude. You may look up your latitude and longitude. Thank you for
using OutOfThisWorld!''')

print(intro)
url = 'http://api.open-notify.org/iss-now.json'
response = urllib.request.urlopen(url)
result = json.loads(response.read())

location = result['iss_position']
lat = float(location['latitude'])
lon = float(location['longitude'])
print('Latitude: ', lat)
print('Longitude: ', lon)

screen = turtle.Screen()
screen.setup(720,360)
screen.setworldcoordinates(-180, -90, 180, 90)
screen.bgpic('map.gif')

screen.register_shape('iss.gif')
iss = turtle.Turtle()
iss.shape('iss.gif')
iss.setheading(90)

iss.penup()
iss.goto(lon,lat)
iss.pendown()



#Chicago's location
#lat = 41.8781
#lon = -89.6298

lat = float(input('What is your latitude? '))
lon = float(input('what is your longitude? '))

location = turtle.Turtle()
location.penup()
location.color('red')
location.goto(lon, lat)
location.dot(5)
location.hideturtle()

url = 'http://api.open-notify.org/iss-pass.json?lat=' + str(lat) + '&lon=' + str(lon)
response = urllib.request.urlopen(url)
result = json.loads(response.read())


over = result['response'][1]['risetime']
print(over)
location.write('You are here!')

while True:
   screen.update()
