function weatherBalloon( cityID ) {
    var key = 'ea37c92ce3b093d49be4f02de69ff194';
    fetch('https://api.openweathermap.org/data/2.5/weather?id=' + cityID+ '&appid=' + key)  
    .then(function(resp) { return resp.json() }) // Convert data to json
    .then(function(data) {
      drawWeather(data);
      document.body.scrollTop = 0; //scroll to top
      document.documentElement.scrollTop = 0;  
      console.log(data);
    })
    .catch(function() {
      // catch any errors
    });
  }
  
function drawWeather( d ) {//put weather onto screen
    var celcius = Math.round(parseFloat(d.main.temp)-273.15);
	var fahrenheit = Math.round(((parseFloat(d.main.temp)-273.15)*1.8)+32); 
	
	document.getElementById('description').innerHTML = d.weather[0].description;
	document.getElementById('temp').innerHTML = fahrenheit + '&deg;';
    document.getElementById('location').innerHTML = d.name;

  }
